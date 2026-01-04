# Deployment Guide - Know Your Campus

## Prerequisites Checklist

- [ ] Java 21 installed
- [ ] Node.js 18+ installed
- [ ] MySQL 8.0 running
- [ ] Maven installed
- [ ] Git installed

## Quick Start (Development)

### Step 1: Start MySQL
Ensure MySQL is running on `localhost:3306` with:
- Username: `root`
- Password: `Prince@123`

### Step 2: Start Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
Backend will start on: http://localhost:8080

### Step 3: Start Frontend
```bash
cd frontend
npm install
npm run dev
```
Frontend will start on: http://localhost:5173

### Step 4: Access Application
- **Website**: http://localhost:5173
- **Admin Login**: http://localhost:5173/login
  - Email: admin@knowyourcampus.com
  - Password: Admin@123

## Production Deployment

### Backend Deployment (Spring Boot)

#### Option 1: JAR Deployment
```bash
cd backend
mvn clean package
java -jar target/knowyourcampus-backend-1.0.0.jar
```

#### Option 2: Docker
Create `Dockerfile` in backend:
```dockerfile
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/knowyourcampus-backend-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build and run:
```bash
docker build -t knowyourcampus-backend .
docker run -p 8080:8080 knowyourcampus-backend
```

#### Option 3: Cloud Platforms
- **Heroku**: Use Heroku Java buildpack
- **AWS Elastic Beanstalk**: Deploy JAR file
- **Google Cloud Run**: Deploy Docker container
- **Azure App Service**: Deploy JAR file

### Frontend Deployment (React + Vite)

#### Build for Production
```bash
cd frontend
npm run build
```
This creates a `dist` folder with optimized static files.

#### Option 1: Vercel (Recommended)
1. Install Vercel CLI: `npm i -g vercel`
2. Run: `vercel`
3. Follow prompts

#### Option 2: Netlify
1. Install Netlify CLI: `npm i -g netlify-cli`
2. Run: `netlify deploy --prod`
3. Drag and drop `dist` folder

#### Option 3: Traditional Hosting (Nginx)
```nginx
server {
    listen 80;
    server_name yourdomain.com;
    root /var/www/knowyourcampus/dist;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }

    location /api {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

### Database Setup (Production)

#### Option 1: MySQL on Cloud
- **AWS RDS**: Create MySQL instance
- **Google Cloud SQL**: Create MySQL database
- **Azure Database**: Create MySQL server

Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://your-cloud-db:3306/knowyourcampus
spring.datasource.username=your-username
spring.datasource.password=your-password
```

#### Option 2: Docker MySQL
```bash
docker run --name mysql-knowyourcampus \
  -e MYSQL_ROOT_PASSWORD=Prince@123 \
  -e MYSQL_DATABASE=knowyourcampus \
  -p 3306:3306 \
  -d mysql:8.0
```

## Environment Variables

### Backend (.env or application.properties)
```properties
# Database
DB_URL=jdbc:mysql://localhost:3306/knowyourcampus
DB_USERNAME=root
DB_PASSWORD=Prince@123

# JWT
JWT_SECRET=your-256-bit-secret-key-change-in-production
JWT_EXPIRATION=86400000

# CORS
CORS_ALLOWED_ORIGINS=https://yourdomain.com
```

### Frontend (.env)
```env
VITE_API_BASE_URL=https://api.yourdomain.com/api
```

## SSL/HTTPS Setup

### Using Let's Encrypt (Free)
```bash
sudo apt-get install certbot python3-certbot-nginx
sudo certbot --nginx -d yourdomain.com
```

## Monitoring & Logging

### Backend Logging
Update `application.properties`:
```properties
logging.level.com.knowyourcampus=INFO
logging.file.name=logs/application.log
```

### Frontend Analytics
Add Google Analytics to `index.html`:
```html
<!-- Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=GA_MEASUREMENT_ID"></script>
```

## Performance Optimization

### Backend
- Enable caching with Redis
- Use connection pooling
- Configure JVM heap size: `-Xmx2g -Xms1g`

### Frontend
- Already optimized with Vite
- Enable gzip compression in Nginx
- Use CDN for static assets

## Security Checklist

- [ ] Change default admin password
- [ ] Update JWT secret key
- [ ] Enable HTTPS
- [ ] Configure CORS properly
- [ ] Set up firewall rules
- [ ] Regular database backups
- [ ] Update dependencies regularly

## Backup Strategy

### Database Backup
```bash
# Daily backup
mysqldump -u root -p knowyourcampus > backup_$(date +%Y%m%d).sql

# Restore
mysql -u root -p knowyourcampus < backup_20260104.sql
```

### Automated Backups
Create cron job:
```bash
0 2 * * * /usr/bin/mysqldump -u root -pPrince@123 knowyourcampus > /backups/db_$(date +\%Y\%m\%d).sql
```

## Troubleshooting

### Backend won't start
- Check Java version: `java -version`
- Check MySQL connection
- Review logs in `logs/application.log`

### Frontend build fails
- Clear node_modules: `rm -rf node_modules && npm install`
- Check Node version: `node -v`

### Database connection issues
- Verify MySQL is running: `systemctl status mysql`
- Check credentials in application.properties
- Test connection: `mysql -u root -p`

## Scaling

### Horizontal Scaling
- Use load balancer (Nginx, HAProxy)
- Deploy multiple backend instances
- Use session management (Redis)

### Database Scaling
- Read replicas for read-heavy operations
- Database sharding for large datasets
- Connection pooling optimization

## Cost Optimization

### Free Tier Options
- **Frontend**: Vercel/Netlify (Free tier)
- **Backend**: Heroku (Free dyno) or Railway
- **Database**: AWS RDS Free Tier or PlanetScale

### Estimated Monthly Costs (Paid)
- **Frontend**: $0-20 (Vercel Pro)
- **Backend**: $25-50 (AWS EC2 t3.small)
- **Database**: $15-30 (AWS RDS db.t3.micro)
- **Total**: ~$40-100/month

## Support

For deployment issues:
- Email: princesulekhiya2004@gmail.com
- Phone: 9009536046

---

**Good luck with your deployment! 🚀**
