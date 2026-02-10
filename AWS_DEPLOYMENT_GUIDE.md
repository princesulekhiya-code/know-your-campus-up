# 🚀 AWS Deployment Guide with GitHub Actions CI/CD

## 📋 Overview

This guide will help you deploy **Know Your Campus** to AWS with automatic deployment using GitHub Actions.

**Architecture:**
```
GitHub Push → GitHub Actions → AWS EC2 (Backend) + S3 (Frontend)
```

---

## ⏱️ Total Time: ~45 minutes

---

## 🎯 Step 1: AWS RDS MySQL Database (15 min)

### 1.1 Create RDS Instance

1. Go to **AWS Console** → **RDS**
2. Click **Create database**
3. Choose:
   - **Engine:** MySQL
   - **Version:** 8.0.35
   - **Template:** Free tier
   - **DB instance identifier:** `knowyourcampus-db`
   - **Master username:** `admin`
   - **Master password:** `YourStrongPassword123!` (save this!)
   - **DB instance class:** `db.t3.micro` (Free tier)
   - **Storage:** 20 GB
   - **Public access:** Yes (for now)
   - **VPC security group:** Create new → `knowyourcampus-db-sg`
   - **Initial database name:** `knowyourcampus`

4. Click **Create database**
5. Wait 5-10 minutes for creation

### 1.2 Configure Security Group

1. Go to **EC2** → **Security Groups**
2. Find `knowyourcampus-db-sg`
3. **Inbound rules** → **Edit**
4. Add rule:
   - **Type:** MySQL/Aurora
   - **Port:** 3306
   - **Source:** Anywhere (0.0.0.0/0) - ⚠️ Change this later to EC2 security group
5. Save

### 1.3 Get Connection Details

1. Go to **RDS** → **Databases** → `knowyourcampus-db`
2. Copy **Endpoint** (e.g., `knowyourcampus-db.xxxxx.ap-south-1.rds.amazonaws.com`)
3. Save this for later!

---

## 🖥️ Step 2: AWS EC2 Instance for Backend (20 min)

### 2.1 Launch EC2 Instance

1. Go to **EC2** → **Launch Instance**
2. Configure:
   - **Name:** `knowyourcampus-backend`
   - **AMI:** Ubuntu Server 22.04 LTS (Free tier eligible)
   - **Instance type:** `t2.micro` (Free tier)
   - **Key pair:** Create new → `knowyourcampus-key.pem` (Download and save!)
   - **Network settings:**
     - Allow SSH (port 22)
     - Allow HTTP (port 80)
     - Allow HTTPS (port 443)
     - Allow Custom TCP (port 8080) - for Spring Boot
   - **Storage:** 8 GB (Free tier)

3. Click **Launch instance**
4. Wait 2-3 minutes

### 2.2 Connect to EC2

```bash
# Windows (PowerShell)
ssh -i "knowyourcampus-key.pem" ubuntu@<EC2-PUBLIC-IP>

# If permission error:
icacls "knowyourcampus-key.pem" /inheritance:r
icacls "knowyourcampus-key.pem" /grant:r "%username%:R"
```

### 2.3 Install Java 17

```bash
# Update system
sudo apt update && sudo apt upgrade -y

# Install Java 17
sudo apt install openjdk-17-jdk -y

# Verify
java -version
```

### 2.4 Create Application Directory

```bash
# Create app directory
sudo mkdir -p /opt/knowyourcampus
sudo chown ubuntu:ubuntu /opt/knowyourcampus

# Create systemd service
sudo nano /etc/systemd/system/knowyourcampus.service
```

**Paste this:**
```ini
[Unit]
Description=Know Your Campus Backend
After=network.target

[Service]
Type=simple
User=ubuntu
WorkingDirectory=/opt/knowyourcampus
ExecStart=/usr/bin/java -jar /opt/knowyourcampus/app.jar
Restart=on-failure
RestartSec=10

Environment="SPRING_PROFILES_ACTIVE=prod"
Environment="DB_HOST=<YOUR-RDS-ENDPOINT>"
Environment="DB_NAME=knowyourcampus"
Environment="DB_USERNAME=admin"
Environment="DB_PASSWORD=<YOUR-DB-PASSWORD>"
Environment="JWT_SECRET=your-super-secret-jwt-key-change-this-in-production"

[Install]
WantedBy=multi-user.target
```

**Save:** Ctrl+X → Y → Enter

```bash
# Enable and start service
sudo systemctl daemon-reload
sudo systemctl enable knowyourcampus
```

---

## 📦 Step 3: AWS S3 + CloudFront for Frontend (10 min)

### 3.1 Create S3 Bucket

1. Go to **S3** → **Create bucket**
2. Configure:
   - **Bucket name:** `knowyourcampus-frontend` (must be globally unique)
   - **Region:** ap-south-1 (Mumbai)
   - **Block all public access:** ❌ Uncheck
   - **Acknowledge:** ✅ Check
3. Click **Create bucket**

### 3.2 Enable Static Website Hosting

1. Go to bucket → **Properties**
2. Scroll to **Static website hosting**
3. Click **Edit**
4. Enable:
   - **Index document:** `index.html`
   - **Error document:** `index.html` (for React Router)
5. Save

### 3.3 Add Bucket Policy

1. Go to **Permissions** → **Bucket policy**
2. Paste:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadGetObject",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::knowyourcampus-frontend/*"
    }
  ]
}
```

3. Save

### 3.4 Create CloudFront Distribution

1. Go to **CloudFront** → **Create distribution**
2. Configure:
   - **Origin domain:** Select your S3 bucket
   - **Origin access:** Public
   - **Viewer protocol policy:** Redirect HTTP to HTTPS
   - **Allowed HTTP methods:** GET, HEAD, OPTIONS
   - **Cache policy:** CachingOptimized
   - **Default root object:** `index.html`
3. Click **Create distribution**
4. Wait 5-10 minutes for deployment
5. Copy **Distribution domain name** (e.g., `d111111abcdef8.cloudfront.net`)

---

## 🔐 Step 4: GitHub Secrets Setup (5 min)

Go to your GitHub repository → **Settings** → **Secrets and variables** → **Actions** → **New repository secret**

Add these secrets:

| Secret Name | Value | Example |
|-------------|-------|---------|
| `AWS_ACCESS_KEY_ID` | Your AWS access key | `AKIAIOSFODNN7EXAMPLE` |
| `AWS_SECRET_ACCESS_KEY` | Your AWS secret key | `wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY` |
| `EC2_SSH_KEY` | Content of `knowyourcampus-key.pem` | `-----BEGIN RSA PRIVATE KEY-----...` |
| `EC2_HOST` | EC2 public IP | `13.126.45.67` |
| `EC2_USER` | SSH username | `ubuntu` |
| `S3_BUCKET_NAME` | S3 bucket name | `knowyourcampus-frontend` |
| `CLOUDFRONT_DISTRIBUTION_ID` | CloudFront ID | `E1234567890ABC` |
| `CLOUDFRONT_DOMAIN` | CloudFront domain | `d111111abcdef8.cloudfront.net` |
| `VITE_API_URL` | Backend API URL | `http://<EC2-IP>:8080/api` |

---

## 🚀 Step 5: Deploy!

### 5.1 Push to GitHub

```bash
cd d:\collageweb
git add .
git commit -m "Add AWS deployment with GitHub Actions"
git push origin main
```

### 5.2 Watch Deployment

1. Go to GitHub repository → **Actions**
2. Watch the workflow run
3. Wait 5-10 minutes

### 5.3 Test Deployment

**Frontend:** `https://<cloudfront-domain>`  
**Backend:** `http://<ec2-ip>:8080/api/colleges`

---

## ✅ Success Checklist

- [ ] RDS MySQL database running
- [ ] EC2 instance running
- [ ] S3 bucket created
- [ ] CloudFront distribution deployed
- [ ] GitHub Actions workflow successful
- [ ] Frontend accessible via CloudFront
- [ ] Backend API responding
- [ ] Database connected

---

## 🎉 Automatic Deployment Working!

**Now whenever you:**
```bash
git add .
git commit -m "Your changes"
git push
```

**GitHub Actions will automatically:**
1. ✅ Build backend JAR
2. ✅ Deploy to EC2
3. ✅ Build frontend
4. ✅ Deploy to S3
5. ✅ Invalidate CloudFront cache

**Your website updates in ~5 minutes!** 🚀

---

## 💰 Cost Estimate

**Free Tier (First 12 months):**
- EC2 t2.micro: FREE (750 hrs/month)
- RDS db.t3.micro: FREE (750 hrs/month)
- S3: FREE (5GB storage)
- CloudFront: FREE (50GB transfer)
- **Total: ~₹40/month** (Route 53 DNS only)

**After Free Tier:**
- ~₹1500-2000/month

---

## 🆘 Troubleshooting

### Backend not starting?
```bash
ssh -i knowyourcampus-key.pem ubuntu@<EC2-IP>
sudo journalctl -u knowyourcampus -f
```

### Frontend not loading?
- Check CloudFront distribution status
- Verify S3 bucket policy
- Check browser console for errors

### Database connection failed?
- Verify RDS security group allows EC2
- Check DB credentials in systemd service
- Test connection: `mysql -h <RDS-ENDPOINT> -u admin -p`

---

## 📞 Support

- **AWS Support:** https://console.aws.amazon.com/support
- **GitHub Actions Logs:** Repository → Actions tab
- **CloudWatch Logs:** AWS Console → CloudWatch

**Happy Deploying!** 🎊
