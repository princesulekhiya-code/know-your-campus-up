# 🚀 GitHub Auto-Deployment Setup Guide

## 🎯 Overview

यह setup करने के बाद:
```
Code change करें → Git push करें → Automatic deployment! ✨
```

**No manual work needed!** 🎉

---

## ✅ **How It Works:**

```
1. आप code में changes करते हैं
   ↓
2. Git commit और push करते हैं
   ↓
3. GitHub repository update होती है
   ↓
4. Vercel automatically frontend deploy करता है
   ↓
5. Railway automatically backend deploy करता है
   ↓
6. Website automatically update हो जाती है! 🎊
```

**Total Time**: 2-5 minutes (automatic)

---

## 📦 **Step 1: GitHub Repository Setup**

### **1.1 Create GitHub Repository**

```bash
# Terminal में run करें:
cd d:\collageweb

# Git initialize (if not done)
git init

# All files add करें
git add .

# First commit
git commit -m "Initial commit - Know Your Campus"

# GitHub पर repository बनाएं
# Go to: https://github.com/new
# Repository name: know-your-campus
# Public या Private (your choice)
# Create repository

# Remote add करें (GitHub से URL copy करें)
git remote add origin https://github.com/YOUR_USERNAME/know-your-campus.git

# Push करें
git branch -M main
git push -u origin main
```

---

## 🔧 **Step 2: Vercel Auto-Deployment Setup**

### **2.1 Connect Vercel to GitHub**

1. **Go to Vercel**: https://vercel.com
2. **Sign up with GitHub** (important!)
3. **Import Project**:
   - Click "New Project"
   - Select your GitHub repository
   - Vercel will ask for permissions
   - Grant access

### **2.2 Configure Vercel**

```
Framework Preset: Vite
Root Directory: frontend
Build Command: npm run build
Output Directory: dist

Environment Variables:
- VITE_API_URL = [Your Railway backend URL]
```

### **2.3 Deploy**

- Click "Deploy"
- Vercel will build and deploy
- **Auto-deployment is now ACTIVE!** ✅

### **2.4 How Auto-Deployment Works:**

```
आप code change करें:
frontend/src/pages/Home.jsx

Git push करें:
git add .
git commit -m "Updated homepage"
git push

Vercel automatically:
1. Detects push
2. Pulls latest code
3. Builds project
4. Deploys to production
5. Updates website

Time: 2-3 minutes (automatic)
```

---

## 🚂 **Step 3: Railway Auto-Deployment Setup**

### **3.1 Connect Railway to GitHub**

1. **Go to Railway**: https://railway.app
2. **Sign up with GitHub** (important!)
3. **New Project**:
   - Click "New Project"
   - Select "Deploy from GitHub repo"
   - Choose your repository
   - Railway will ask for permissions
   - Grant access

### **3.2 Configure Railway**

Railway automatically detects Spring Boot!

**Environment Variables:**
```
SPRING_PROFILES_ACTIVE=prod
JWT_SECRET=YourSecretKeyHere123456789
```

**Add MySQL Database:**
- Click "New" → "Database" → "MySQL"
- Railway auto-configures connection

### **3.3 Deploy**

- Railway automatically builds and deploys
- **Auto-deployment is now ACTIVE!** ✅

### **3.4 How Auto-Deployment Works:**

```
आप code change करें:
backend/src/main/java/com/knowyourcampus/controller/CollegeController.java

Git push करें:
git add .
git commit -m "Added new API endpoint"
git push

Railway automatically:
1. Detects push
2. Pulls latest code
3. Builds with Maven
4. Deploys to production
5. Restarts service

Time: 3-5 minutes (automatic)
```

---

## 🎯 **Step 4: GitHub Actions (Optional - Advanced)**

यदि आप और भी control चाहते हैं, तो GitHub Actions use करें:

### **4.1 Create Workflow File**

```bash
# Create directory
mkdir -p .github/workflows

# Create workflow file
# File: .github/workflows/deploy.yml
```

### **4.2 Frontend Deployment Workflow**

Create file: `.github/workflows/deploy-frontend.yml`

```yaml
name: Deploy Frontend to Vercel

on:
  push:
    branches:
      - main
    paths:
      - 'frontend/**'

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Setup Node.js
        uses: actions/setup-node@v3
        with:
          node-version: '18'
      
      - name: Install dependencies
        working-directory: ./frontend
        run: npm install
      
      - name: Build
        working-directory: ./frontend
        run: npm run build
        env:
          VITE_API_URL: ${{ secrets.VITE_API_URL }}
      
      - name: Deploy to Vercel
        uses: amondnet/vercel-action@v20
        with:
          vercel-token: ${{ secrets.VERCEL_TOKEN }}
          vercel-org-id: ${{ secrets.VERCEL_ORG_ID }}
          vercel-project-id: ${{ secrets.VERCEL_PROJECT_ID }}
          working-directory: ./frontend
```

### **4.3 Backend Deployment Workflow**

Create file: `.github/workflows/deploy-backend.yml`

```yaml
name: Deploy Backend to Railway

on:
  push:
    branches:
      - main
    paths:
      - 'backend/**'

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Setup Java
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
      
      - name: Build with Maven
        working-directory: ./backend
        run: mvn clean package -DskipTests
      
      - name: Deploy to Railway
        uses: bervProject/railway-deploy@main
        with:
          railway_token: ${{ secrets.RAILWAY_TOKEN }}
          service: ${{ secrets.RAILWAY_SERVICE_ID }}
```

---

## 🔐 **Step 5: Setup Secrets (for GitHub Actions)**

### **5.1 Get Vercel Tokens**

```bash
# Install Vercel CLI
npm install -g vercel

# Login
vercel login

# Get tokens
vercel whoami
```

### **5.2 Get Railway Tokens**

1. Go to Railway Dashboard
2. Project Settings → Tokens
3. Generate new token
4. Copy token

### **5.3 Add Secrets to GitHub**

1. Go to GitHub repository
2. Settings → Secrets and variables → Actions
3. Add secrets:
   - `VERCEL_TOKEN`
   - `VERCEL_ORG_ID`
   - `VERCEL_PROJECT_ID`
   - `RAILWAY_TOKEN`
   - `RAILWAY_SERVICE_ID`
   - `VITE_API_URL`

---

## 🎊 **Step 6: Test Auto-Deployment**

### **6.1 Make a Small Change**

```bash
# Edit a file
# Example: frontend/src/pages/Home.jsx
# Change heading text

# Commit and push
git add .
git commit -m "Test auto-deployment"
git push
```

### **6.2 Watch Deployment**

**Vercel:**
- Go to Vercel dashboard
- See deployment in progress
- Wait 2-3 minutes
- Check website - updated! ✅

**Railway:**
- Go to Railway dashboard
- See deployment in progress
- Wait 3-5 minutes
- Check API - updated! ✅

---

## 📊 **Deployment Status Monitoring**

### **Vercel Dashboard:**
```
https://vercel.com/dashboard
- See all deployments
- View logs
- Check build status
- Preview deployments
```

### **Railway Dashboard:**
```
https://railway.app/dashboard
- See all deployments
- View logs
- Check service status
- Monitor resources
```

### **GitHub Actions:**
```
https://github.com/YOUR_USERNAME/know-your-campus/actions
- See workflow runs
- View logs
- Check status
```

---

## ✅ **Benefits of Auto-Deployment:**

| Feature | Manual Deployment | Auto-Deployment |
|---------|------------------|-----------------|
| **Time** | 15-30 min | 2-5 min |
| **Effort** | High | Zero |
| **Errors** | Possible | Minimal |
| **Rollback** | Manual | Automatic |
| **Testing** | Manual | Can automate |
| **Updates** | Slow | Instant |

---

## 🎯 **Workflow Examples:**

### **Example 1: Fix a Bug**
```bash
# 1. Fix bug in code
vim frontend/src/components/SearchBar.jsx

# 2. Commit
git add .
git commit -m "Fixed search bug"

# 3. Push
git push

# 4. Automatic deployment! ✨
# Website updates in 2-3 minutes
```

### **Example 2: Add New Feature**
```bash
# 1. Add new feature
vim backend/src/main/java/com/knowyourcampus/controller/NewController.java

# 2. Commit
git add .
git commit -m "Added new feature"

# 3. Push
git push

# 4. Automatic deployment! ✨
# API updates in 3-5 minutes
```

### **Example 3: Update Content**
```bash
# 1. Update homepage text
vim frontend/src/pages/Home.jsx

# 2. Commit
git add .
git commit -m "Updated homepage content"

# 3. Push
git push

# 4. Automatic deployment! ✨
# Changes live in 2 minutes
```

---

## 🔄 **Rollback (if needed):**

### **Vercel Rollback:**
```
1. Go to Vercel dashboard
2. Deployments tab
3. Find previous working deployment
4. Click "Promote to Production"
5. Done! Rolled back in seconds
```

### **Railway Rollback:**
```
1. Go to Railway dashboard
2. Deployments tab
3. Find previous working deployment
4. Click "Redeploy"
5. Done! Rolled back in minutes
```

### **Git Rollback:**
```bash
# Revert last commit
git revert HEAD
git push

# Auto-deployment will deploy previous version
```

---

## 📧 **Deployment Notifications (Optional):**

### **Email Notifications:**
- Vercel sends email on deployment
- Railway sends email on deployment
- GitHub Actions can send notifications

### **Slack/Discord Integration:**
- Connect Vercel to Slack
- Connect Railway to Discord
- Get instant deployment updates

---

## 🎊 **Summary:**

### **Simple Setup (Recommended):**
```
✅ Push code to GitHub
✅ Connect Vercel to GitHub (auto-deploy frontend)
✅ Connect Railway to GitHub (auto-deploy backend)
✅ Done! Automatic deployment active
```

### **Advanced Setup (Optional):**
```
✅ Add GitHub Actions workflows
✅ Add automated testing
✅ Add deployment notifications
✅ Add rollback automation
```

---

## 🚀 **Final Workflow:**

```
Developer (You)
    ↓
Write Code
    ↓
Git Commit & Push
    ↓
GitHub Repository
    ↓
    ├─→ Vercel (Frontend)
    │   ├─ Build
    │   ├─ Test
    │   └─ Deploy → Live Website ✨
    │
    └─→ Railway (Backend)
        ├─ Build
        ├─ Test
        └─ Deploy → Live API ✨

Total Time: 2-5 minutes (automatic)
Manual Work: Zero ✅
```

---

## 🎯 **Next Steps:**

1. **Push code to GitHub** (if not done)
2. **Connect Vercel** to GitHub repo
3. **Connect Railway** to GitHub repo
4. **Make a test change** and push
5. **Watch automatic deployment!** 🎉

---

**Auto-deployment setup करने के बाद, आप बस code लिखें और push करें - बाकी automatic!** 🚀

**Questions? Check the guides or let me know!**
