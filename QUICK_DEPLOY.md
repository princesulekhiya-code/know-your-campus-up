# Quick Deployment Script for Know Your Campus

## Prerequisites
- Git installed
- GitHub account
- Vercel account (free)
- Railway account (free)

## Step-by-Step Deployment

### 1. Push to GitHub (if not already done)

```bash
# Initialize git (if not done)
cd d:\collageweb
git init
git add .
git commit -m "Initial commit - Ready for deployment"

# Create GitHub repository and push
# Go to github.com and create new repository
git remote add origin https://github.com/YOUR_USERNAME/knowyourcampus.git
git branch -M main
git push -u origin main
```

### 2. Deploy Backend to Railway

**Option A: Using Railway Dashboard (Easiest)**

1. Go to https://railway.app
2. Sign up with GitHub
3. Click "New Project"
4. Select "Deploy from GitHub repo"
5. Choose your `knowyourcampus` repository
6. Railway will detect Spring Boot automatically
7. Click "Add variables" and add:
   ```
   SPRING_PROFILES_ACTIVE=prod
   JWT_SECRET=YourVerySecretKeyHere123456789
   ```
8. Click "Deploy"
9. Wait for deployment (5-10 minutes)
10. Copy your backend URL (e.g., `https://knowyourcampus-production.up.railway.app`)

**Add MySQL Database:**
1. In Railway project, click "New"
2. Select "Database" → "MySQL"
3. Railway will auto-configure connection
4. Your backend will automatically connect

### 3. Deploy Frontend to Vercel

**Option A: Using Vercel Dashboard (Easiest)**

1. Go to https://vercel.com
2. Sign up with GitHub
3. Click "New Project"
4. Import your `knowyourcampus` repository
5. Configure:
   - **Root Directory**: `frontend`
   - **Framework Preset**: Vite
   - **Build Command**: `npm run build`
   - **Output Directory**: `dist`
6. Add Environment Variable:
   - Name: `VITE_API_URL`
   - Value: `https://your-railway-backend-url.railway.app/api`
7. Click "Deploy"
8. Wait for deployment (2-3 minutes)
9. Your site is live! 🎉

**Option B: Using Vercel CLI**

```bash
# Install Vercel CLI
npm install -g vercel

# Login
vercel login

# Deploy
cd frontend
vercel

# Follow prompts:
# - Link to existing project? No
# - Project name: knowyourcampus
# - Directory: ./
# - Override settings? No

# Set environment variable
vercel env add VITE_API_URL production
# Enter your Railway backend URL

# Deploy to production
vercel --prod
```

### 4. Update CORS in Backend

After getting your Vercel URL, update CORS:

1. Go to Railway dashboard
2. Click on your backend service
3. Go to "Variables"
4. Add:
   ```
   CORS_ORIGINS=https://your-app.vercel.app,https://*.vercel.app
   ```
5. Redeploy

### 5. Test Your Deployment

Visit your Vercel URL and test:
- [ ] Homepage loads
- [ ] Search works
- [ ] College listings display
- [ ] Filters work
- [ ] Forms submit
- [ ] Admin login works

### 6. Custom Domain (Optional)

**For Vercel:**
1. Go to Project Settings → Domains
2. Add your custom domain
3. Update DNS records as instructed

**For Railway:**
1. Go to Service Settings
2. Click "Generate Domain"
3. Or add custom domain

### 7. Submit to Google Search Console

1. Go to https://search.google.com/search-console
2. Add property: `https://your-app.vercel.app`
3. Verify ownership
4. Submit sitemap: `https://your-app.vercel.app/sitemap.xml`

## Troubleshooting

### Frontend shows "Network Error"
- Check if VITE_API_URL is correct
- Verify backend is running on Railway
- Check CORS settings

### Backend won't start
- Check Railway logs
- Verify database connection
- Check environment variables

### Database connection failed
- Ensure MySQL plugin is added in Railway
- Check if DATABASE_URL is set
- Verify credentials

## Monitoring

- **Vercel**: https://vercel.com/dashboard
- **Railway**: https://railway.app/dashboard
- **Logs**: Check Railway logs for backend errors

## Cost

- **Vercel**: Free (100GB bandwidth/month)
- **Railway**: Free ($5 credit/month, ~500 hours)
- **Total**: $0/month for starting! 🎉

## Next Steps

1. Add custom domain
2. Set up Google Analytics
3. Monitor performance
4. Add more colleges
5. Promote your website!

---

**Need help? Check:**
- DEPLOYMENT_GUIDE.md (detailed guide)
- Vercel Docs: https://vercel.com/docs
- Railway Docs: https://docs.railway.app

**Your website will be live in ~15 minutes!** 🚀
