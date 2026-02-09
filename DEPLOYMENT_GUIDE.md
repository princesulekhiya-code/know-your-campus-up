# Complete Deployment Guide - Know Your Campus

## 🎯 Overview

This guide will help you deploy:
1. **Frontend (React + Vite)** → Vercel (Free)
2. **Backend (Spring Boot)** → Railway (Free tier)
3. **Database (MySQL)** → Railway (Free tier)

---

## 📦 Part 1: Backend Deployment (Railway)

### Step 1.1: Prepare Backend for Production

1. **Update application.properties for production**
   - File: `backend/src/main/resources/application.properties`
   - Add production profile

2. **Create Dockerfile for Backend**
   ```dockerfile
   FROM openjdk:21-jdk-slim
   WORKDIR /app
   COPY target/*.jar app.jar
   EXPOSE 8081
   ENTRYPOINT ["java", "-jar", "app.jar"]
   ```

### Step 1.2: Deploy to Railway

1. **Sign up**: Go to https://railway.app
2. **Create New Project** → Deploy from GitHub
3. **Connect Repository**: Link your GitHub repo
4. **Add MySQL Database**:
   - Click "New" → Database → MySQL
   - Railway will provide connection details
5. **Configure Environment Variables**:
   ```
   SPRING_DATASOURCE_URL=jdbc:mysql://[railway-mysql-host]:3306/railway
   SPRING_DATASOURCE_USERNAME=[from railway]
   SPRING_DATASOURCE_PASSWORD=[from railway]
   JWT_SECRET=YourSecretKeyHere
   ```
6. **Deploy**: Railway will auto-deploy
7. **Get Backend URL**: e.g., `https://your-app.railway.app`

---

## 🌐 Part 2: Frontend Deployment (Vercel)

### Step 2.1: Update API Base URL

Update `frontend/src/services/api.js`:
```javascript
const api = axios.create({
    baseURL: import.meta.env.VITE_API_URL || '/api',
    // ...
});
```

Create `.env.production`:
```
VITE_API_URL=https://your-backend.railway.app/api
```

### Step 2.2: Deploy to Vercel

**Option A: Using Vercel CLI**
```bash
cd frontend
npm install -g vercel
vercel login
vercel
```

**Option B: Using Vercel Dashboard**
1. Go to https://vercel.com
2. Sign up with GitHub
3. Click "New Project"
4. Import your GitHub repository
5. Configure:
   - **Framework Preset**: Vite
   - **Root Directory**: frontend
   - **Build Command**: npm run build
   - **Output Directory**: dist
6. Add Environment Variables:
   - `VITE_API_URL` = Your Railway backend URL
7. Click "Deploy"

---

## 🔧 Part 3: Configuration Updates

### 3.1: Update CORS in Backend

File: `backend/src/main/java/com/knowyourcampus/security/SecurityConfig.java`

Add your Vercel domain to CORS:
```java
@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList(
        "http://localhost:5173",
        "https://your-app.vercel.app"  // Add this
    ));
    // ...
}
```

### 3.2: Update Canonical URLs

File: `frontend/index.html`

Replace `https://knowyourcampus.com/` with your actual Vercel URL.

---

## 🗄️ Part 4: Database Migration

### Option A: Use Railway MySQL (Recommended)
- Railway provides free MySQL
- Auto-configured connection
- Automatic backups

### Option B: Use External MySQL
- **PlanetScale** (Free tier)
- **AWS RDS** (Paid)
- **DigitalOcean** (Paid)

---

## 🚀 Part 5: Post-Deployment

### 5.1: Test Your Deployment
1. Visit your Vercel URL
2. Test search functionality
3. Test college listings
4. Test admin login
5. Check console for errors

### 5.2: Submit to Google
1. **Google Search Console**: https://search.google.com/search-console
2. Add your Vercel domain
3. Submit sitemap: `https://your-app.vercel.app/sitemap.xml`

### 5.3: Monitor
- **Vercel Analytics**: Built-in
- **Railway Logs**: Check backend logs
- **Google Analytics**: Add tracking code

---

## 💰 Cost Breakdown

### Free Tier (Recommended for Starting)
- **Vercel**: Free (Hobby plan)
  - Unlimited deployments
  - 100GB bandwidth/month
  - Automatic HTTPS
  
- **Railway**: Free ($5 credit/month)
  - Backend + MySQL
  - 500 hours/month
  - 1GB RAM

### Paid Options (When You Grow)
- **Vercel Pro**: $20/month
- **Railway Pro**: $20/month
- **Custom Domain**: $10-15/year

---

## 🔐 Security Checklist

- [ ] Change JWT secret in production
- [ ] Update database password
- [ ] Enable HTTPS (auto on Vercel/Railway)
- [ ] Add rate limiting
- [ ] Configure CORS properly
- [ ] Remove console.logs from production
- [ ] Enable security headers

---

## 🐛 Troubleshooting

### Frontend not connecting to Backend?
- Check CORS settings
- Verify API URL in .env.production
- Check browser console for errors

### Backend not starting?
- Check Railway logs
- Verify database connection
- Check environment variables

### Database connection failed?
- Verify credentials
- Check if Railway MySQL is running
- Test connection string

---

## 📞 Support Resources

- **Vercel Docs**: https://vercel.com/docs
- **Railway Docs**: https://docs.railway.app
- **Vite Deployment**: https://vitejs.dev/guide/static-deploy.html
- **Spring Boot Deployment**: https://spring.io/guides/gs/spring-boot-docker/

---

## 🎉 Success Checklist

After deployment, verify:
- [ ] Frontend loads on Vercel URL
- [ ] Backend API responds
- [ ] Database connected
- [ ] Search works
- [ ] College listings load
- [ ] Images display
- [ ] Forms submit
- [ ] Admin panel accessible
- [ ] Mobile responsive
- [ ] HTTPS enabled

---

**Your website will be live at:**
- Frontend: `https://your-app.vercel.app`
- Backend: `https://your-app.railway.app`

**Ready to deploy? Let's start!** 🚀
