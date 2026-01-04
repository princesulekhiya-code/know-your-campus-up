# 🚀 Quick Start Guide - Know Your Campus

## Prerequisites Check

Before starting, ensure you have:
- ✅ Java 21 installed (`java -version`)
- ✅ Node.js 18+ installed (`node -v`)
- ✅ MySQL 8.0 running
- ✅ Maven installed (`mvn -v`)

## 5-Minute Setup

### Step 1: Start MySQL (1 minute)

Make sure MySQL is running with:
- **Host**: localhost:3306
- **Username**: root
- **Password**: Prince@123

The application will auto-create the `knowyourcampus` database.

### Step 2: Start Backend (2 minutes)

```bash
cd d:\collageweb\backend
mvn spring-boot:run
```

Wait for: `Started KnowYourCampusApplication in X seconds`

Backend is now running on: **http://localhost:8080**

### Step 3: Start Frontend (2 minutes)

Open a new terminal:

```bash
cd d:\collageweb\frontend
npm install
npm run dev
```

Frontend is now running on: **http://localhost:5173**

## 🎉 You're Ready!

### Access the Application

1. **Website**: http://localhost:5173
2. **Browse Colleges**: Click "Colleges" in navbar
3. **Try Search**: Search for "IIT" or "Delhi"
4. **Apply for Admission**: Click any college → "Apply for Admission"

### Access Admin Panel

1. Go to: http://localhost:5173/login
2. Login with:
   - **Email**: admin@knowyourcampus.com
   - **Password**: Admin@123
3. View dashboard with analytics and leads

## 📊 Sample Data Included

The platform comes pre-loaded with:
- ✅ 10 colleges (IIT Delhi, AIIMS, SRCC, etc.)
- ✅ 15+ courses
- ✅ Complete fee structures
- ✅ Seat availability
- ✅ Cutoff data

## 🧪 Test the Features

### For Students:
1. **Search**: Try searching "Delhi" or "Engineering"
2. **Filter**: Use filters for Government colleges or A++ rating
3. **View Details**: Click any college card
4. **Compare**: Add 2-3 colleges to compare
5. **Apply**: Submit an admission form
6. **Contact**: Fill the contact form

### For Admins:
1. **Login**: Use admin credentials
2. **Dashboard**: View real-time stats
3. **Leads**: Check the "Leads" tab
4. **Analytics**: See most viewed colleges

## 📱 Contact Information

Visible throughout the platform:
- **Phone**: 9009536046
- **Email**: princesulekhiya2004@gmail.com
- **YouTube**: @princesulekhiya

## 🎨 Try Dark Mode

Click the sun/moon icon in the navbar to toggle between light and dark themes!

## 📖 Need More Help?

- **Full Documentation**: See `README.md`
- **API Docs**: See `API_DOCUMENTATION.md`
- **Deployment**: See `DEPLOYMENT.md`
- **Walkthrough**: See `.gemini/antigravity/brain/.../walkthrough.md`

## 🐛 Troubleshooting

### Backend won't start?
- Check Java version: `java -version` (should be 21)
- Verify MySQL is running
- Check password in `application.properties`

### Frontend won't start?
- Check Node version: `node -v` (should be 18+)
- Delete `node_modules` and run `npm install` again
- Check if port 5173 is free

### Can't login to admin?
- Use exact credentials: admin@knowyourcampus.com / Admin@123
- Make sure backend is running
- Check browser console for errors

## 🎯 What to Try Next

1. **Add a College**: Login as admin → (Future: Add college form)
2. **Update Fees**: Modify fee structures
3. **Track Leads**: Submit forms and see them in admin panel
4. **Test Mobile**: Open on your phone (use your IP instead of localhost)
5. **Deploy**: Follow `DEPLOYMENT.md` to deploy online

## 📞 Support

Need help?
- Email: princesulekhiya2004@gmail.com
- Phone: 9009536046

---

**Enjoy building with Know Your Campus! 🎓**
