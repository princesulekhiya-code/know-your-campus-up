# Know Your Campus - AWS Deployment Guide

## 🚀 Complete Deployment Documentation

This guide documents the complete deployment process of the Know Your Campus application on AWS EC2 with RDS MySQL database.

---

## 📋 Table of Contents

1. [Infrastructure Setup](#infrastructure-setup)
2. [Backend Deployment](#backend-deployment)
3. [Frontend Deployment](#frontend-deployment)
4. [Database Configuration](#database-configuration)
5. [CI/CD Pipeline](#cicd-pipeline)
6. [Domain Configuration](#domain-configuration)
7. [Troubleshooting](#troubleshooting)

---

## 🏗️ Infrastructure Setup

### AWS Resources Created

#### 1. EC2 Instance
- **Instance Type**: t2.micro (Free Tier)
- **AMI**: Ubuntu 24.04 LTS
- **Region**: ap-south-1 (Mumbai)
- **Public IP**: 43.205.141.253
- **Storage**: 8GB gp3

#### 2. RDS MySQL Database
- **Engine**: MySQL 8.0.45
- **Instance Class**: db.t3.micro
- **Storage**: 20GB gp3
- **Endpoint**: `database-knowyourcampus.c14cm62c24f5.ap-south-1.rds.amazonaws.com`
- **Port**: 3306
- **Database Name**: knowyourcampus

#### 3. Security Groups

**EC2 Security Group:**
```
Inbound Rules:
- SSH (22): Your IP
- HTTP (80): 0.0.0.0/0
- HTTPS (443): 0.0.0.0/0
- Custom TCP (8080): EC2 Security Group (for backend)

Outbound Rules:
- All traffic: 0.0.0.0/0
```

**RDS Security Group:**
```
Inbound Rules:
- MySQL (3306): EC2 Security Group

Outbound Rules:
- All traffic: 0.0.0.0/0
```

---

## 🔧 Backend Deployment

### Server Setup

#### 1. Install Java 21
```bash
sudo apt update
sudo apt install -y openjdk-21-jdk
java -version
```

#### 2. Create Application Directory
```bash
sudo mkdir -p /opt/knowyourcampus
sudo chown ubuntu:ubuntu /opt/knowyourcampus
```

#### 3. Environment Configuration
Create `/opt/knowyourcampus/.env`:
```env
DB_HOST=database-knowyourcampus.c14cm62c24f5.ap-south-1.rds.amazonaws.com
DB_NAME=knowyourcampus
DB_USERNAME=admin
DB_PASSWORD=prince123prince
JWT_SECRET=my-very-sooper-secret-key-that-is-very-long-and-secure
CORS_ORIGINS=*
SERVER_SERVLET_CONTEXT_PATH=/api
MANAGEMENT_ENDPOINTS_WEB_EXPOSURE_INCLUDE=health,info,metrics,mappings
```

#### 4. Systemd Service Configuration
Create `/etc/systemd/system/knowyourcampus.service`:
```ini
[Unit]
Description=Know Your Campus Backend
After=network.target

[Service]
Type=simple
User=ubuntu
WorkingDirectory=/opt/knowyourcampus
EnvironmentFile=/opt/knowyourcampus/.env
ExecStart=/usr/bin/java -jar /opt/knowyourcampus/app.jar --spring.profiles.active=prod
Restart=on-failure
RestartSec=10

[Install]
WantedBy=multi-user.target
```

#### 5. Enable and Start Service
```bash
sudo systemctl daemon-reload
sudo systemctl enable knowyourcampus
sudo systemctl start knowyourcampus
sudo systemctl status knowyourcampus
```

### Application Configuration

#### application-prod.properties
```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/api

# Database Configuration
spring.datasource.url=jdbc:mysql://${DB_HOST}:3306/${DB_NAME}?useSSL=true&requireSSL=false
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false

# JWT Configuration
jwt.secret=${JWT_SECRET}
jwt.expiration=86400000

# CORS Configuration
cors.allowed.origins=${CORS_ORIGINS}
```

---

## 🎨 Frontend Deployment

### Nginx Setup

#### 1. Install Nginx
```bash
sudo apt install -y nginx
```

#### 2. Configure Nginx
Create `/etc/nginx/sites-available/default`:
```nginx
server {
    listen 80;
    server_name _;  # Will be updated to knowyourcampus.in

    # Frontend: Serve React Static Files
    location / {
        root /var/www/html;
        index index.html index.htm;
        try_files $uri $uri/ /index.html;
    }

    # Backend: Proxy API Requests to Spring Boot
    location /api {
        proxy_pass http://localhost:8080;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection 'upgrade';
        proxy_set_header Host $host;
        proxy_cache_bypass $http_upgrade;
    }

    # Optional: Serve Uploaded Images
    location /uploads {
        alias /opt/knowyourcampus/uploads;
    }
}
```

#### 3. Deploy Frontend
```bash
# Frontend files are deployed to /var/www/html via GitHub Actions
sudo chown -R www-data:www-data /var/www/html
sudo chmod -R 755 /var/www/html
```

#### 4. Restart Nginx
```bash
sudo systemctl restart nginx
sudo systemctl status nginx
```

---

## 🗄️ Database Configuration

### Initial Setup

#### 1. Create Database
```bash
mysql -h database-knowyourcampus.c14cm62c24f5.ap-south-1.rds.amazonaws.com \
  -u admin -pprince123prince \
  -e "CREATE DATABASE IF NOT EXISTS knowyourcampus;"
```

#### 2. Verify Connection
```bash
mysql -h database-knowyourcampus.c14cm62c24f5.ap-south-1.rds.amazonaws.com \
  -u admin -pprince123prince \
  -e "SHOW DATABASES;"
```

### Data Seeding

The application automatically seeds:
- **Admin Users**: 
  - `admin@knowyourcampus.com` / `Admin@123`
  - `princesulekhiya@gmail.com` / `Pince@123`
- **Sample Colleges**: 10 top colleges (IITs, NITs, Private)

---

## 🔄 CI/CD Pipeline

### GitHub Actions Workflow

File: `.github/workflows/deploy-aws.yml`

**Triggers:**
- Push to `main` branch
- Manual workflow dispatch

**Steps:**
1. **Build Backend**
   - Maven clean package
   - Skip tests for faster deployment

2. **Build Frontend**
   - npm install
   - npm run build
   - Create tarball of dist folder

3. **Deploy to EC2**
   - Copy JAR to `/opt/knowyourcampus/app.jar`
   - Copy frontend build to `/var/www/html`
   - Copy nginx config
   - Restart services

**Secrets Required:**
- `EC2_HOST`: 43.205.141.253
- `EC2_USER`: ubuntu
- `EC2_SSH_KEY`: Private key content

---

## 🌐 Domain Configuration

### Domain: knowyourcampus.in

#### Step 1: DNS Configuration

Add these DNS records in your domain provider:

```
Type: A
Name: @
Value: 43.205.141.253
TTL: 3600

Type: A
Name: www
Value: 43.205.141.253
TTL: 3600
```

#### Step 2: Update Nginx Configuration

```nginx
server {
    listen 80;
    server_name knowyourcampus.in www.knowyourcampus.in;
    
    # ... rest of configuration
}
```

#### Step 3: Install SSL Certificate (Let's Encrypt)

```bash
# Install Certbot
sudo apt install -y certbot python3-certbot-nginx

# Obtain SSL Certificate
sudo certbot --nginx -d knowyourcampus.in -d www.knowyourcampus.in

# Auto-renewal is configured automatically
sudo certbot renew --dry-run
```

After SSL installation, Nginx will automatically redirect HTTP to HTTPS.

---

## 🐛 Troubleshooting

### Common Issues and Solutions

#### 1. Backend Not Starting
```bash
# Check logs
sudo journalctl -u knowyourcampus.service -n 50 --no-pager

# Check if port 8080 is in use
sudo netstat -tulpn | grep 8080

# Restart service
sudo systemctl restart knowyourcampus
```

#### 2. Database Connection Failed
```bash
# Test connection from EC2
mysql -h database-knowyourcampus.c14cm62c24f5.ap-south-1.rds.amazonaws.com \
  -u admin -pprince123prince

# Check security group rules
# Ensure EC2 security group is allowed in RDS security group
```

#### 3. 404 Errors on API Calls
```bash
# Verify context path
curl http://localhost:8080/api/colleges

# Check Nginx proxy configuration
sudo nginx -t
sudo systemctl reload nginx
```

#### 4. LazyInitializationException
**Solution**: Add `@JsonIgnore` to lazy-loaded collections in entities.

```java
@OneToMany(mappedBy = "college")
@JsonIgnore
private List<Course> courses;
```

#### 5. Frontend Not Loading
```bash
# Check Nginx status
sudo systemctl status nginx

# Verify files exist
ls -la /var/www/html

# Check Nginx error logs
sudo tail -f /var/log/nginx/error.log
```

---

## 📊 Monitoring and Logs

### Application Logs
```bash
# View real-time logs
sudo journalctl -u knowyourcampus.service -f

# View last 100 lines
sudo journalctl -u knowyourcampus.service -n 100 --no-pager
```

### Nginx Logs
```bash
# Access logs
sudo tail -f /var/log/nginx/access.log

# Error logs
sudo tail -f /var/log/nginx/error.log
```

### Database Logs
```bash
# Connect to database
mysql -h database-knowyourcampus.c14cm62c24f5.ap-south-1.rds.amazonaws.com \
  -u admin -pprince123prince knowyourcampus

# Check tables
SHOW TABLES;

# Check data
SELECT COUNT(*) FROM colleges;
SELECT email, role FROM admin_users;
```

---

## 🔐 Security Best Practices

1. **SSH Access**: Use key-based authentication only
2. **Database**: Use strong passwords, restrict access to EC2 security group
3. **Environment Variables**: Never commit `.env` files to Git
4. **SSL Certificate**: Always use HTTPS in production
5. **Firewall**: Restrict SSH access to specific IPs
6. **Regular Updates**: Keep system packages updated

```bash
sudo apt update && sudo apt upgrade -y
```

---

## 📞 Support

**Admin Credentials:**
- Email: princesulekhiya@gmail.com
- Password: Pince@123

**Live Application:**
- Current: http://43.205.141.253
- Domain: https://knowyourcampus.in (after DNS propagation)

**GitHub Repository:**
- https://github.com/princesulekhiya-code/know-your-campus-up

---

## ✅ Deployment Checklist

- [x] EC2 instance created and configured
- [x] RDS MySQL database created
- [x] Security groups configured
- [x] Java 21 installed
- [x] Backend deployed and running
- [x] Frontend deployed to Nginx
- [x] Database seeded with sample data
- [x] Admin users created
- [x] GitHub Actions CI/CD configured
- [ ] Domain DNS configured (knowyourcampus.in)
- [ ] SSL certificate installed
- [ ] Production testing completed

---

**Last Updated**: February 10, 2026
**Deployed By**: Prince Sulekhiya
**Status**: ✅ Production Ready
