# Know Your Campus - Education Discovery & Admission Platform

A complete, production-ready education discovery and admission platform built with **React + Vite + Tailwind CSS** (frontend) and **Spring Boot + MySQL** (backend).

## 🚀 Features

### For Students
- **Browse & Search**: Search colleges by name, city, state, or course
- **Advanced Filters**: Filter by type (Govt/Private), NAAC rating, admission status, fees
- **College Details**: Comprehensive information including courses, fees, seats, cutoffs
- **Compare Colleges**: Side-by-side comparison of up to 3 colleges
- **Admission Form**: Submit admission enquiries with lead tracking
- **YouTube Integration**: Watch college reviews and admission tips
- **Dark/Light Mode**: Seamless theme switching
- **Responsive Design**: Works perfectly on mobile, tablet, and desktop

### For Admins
- **Dashboard Analytics**: Real-time stats on colleges, courses, leads, and page views
- **Lead Management**: Track all student enquiries with status updates
- **College Management**: Full CRUD operations for colleges, courses, fees, and seats
- **Analytics**: View most viewed colleges, lead conversion rates
- **Secure Authentication**: JWT-based admin login

## 📁 Project Structure

```
collageweb/
├── backend/                          # Spring Boot Backend
│   ├── src/main/java/com/knowyourcampus/
│   │   ├── entity/                   # JPA Entities (8 models)
│   │   ├── repository/               # Spring Data JPA Repositories
│   │   ├── service/                  # Business Logic Layer
│   │   ├── controller/               # REST API Controllers
│   │   ├── security/                 # JWT & Spring Security
│   │   ├── dto/                      # Data Transfer Objects
│   │   ├── exception/                # Global Exception Handling
│   │   └── config/                   # Configuration & Data Seeder
│   ├── src/main/resources/
│   │   └── application.properties    # Database & JWT Config
│   └── pom.xml                       # Maven Dependencies
│
└── frontend/                         # React + Vite Frontend
    ├── src/
    │   ├── components/               # Reusable Components
    │   │   ├── Navbar.jsx
    │   │   ├── Footer.jsx
    │   │   ├── CollegeCard.jsx
    │   │   ├── SearchBar.jsx
    │   │   ├── FilterPanel.jsx
    │   │   ├── AdmissionCTA.jsx
    │   │   └── LoadingSpinner.jsx
    │   ├── pages/                    # Page Components
    │   │   ├── Home.jsx
    │   │   ├── Colleges.jsx
    │   │   ├── CollegeDetails.jsx
    │   │   ├── CompareColleges.jsx
    │   │   ├── AdmissionForm.jsx
    │   │   ├── Contact.jsx
    │   │   ├── Login.jsx
    │   │   └── admin/AdminDashboard.jsx
    │   ├── context/                  # React Context
    │   │   ├── AuthContext.jsx
    │   │   └── ThemeContext.jsx
    │   ├── services/                 # API Services
    │   │   ├── api.js
    │   │   ├── collegeService.js
    │   │   ├── leadService.js
    │   │   └── analyticsService.js
    │   ├── utils/                    # Utilities
    │   │   └── tracking.js
    │   ├── App.jsx
    │   ├── main.jsx
    │   └── index.css
    ├── package.json
    ├── vite.config.js
    └── tailwind.config.js
```

## 🛠️ Tech Stack

### Frontend
- **React 18** - UI Library
- **Vite** - Build Tool
- **Tailwind CSS 3** - Styling
- **React Router DOM 6** - Routing
- **Axios** - HTTP Client
- **React Icons** - Icons

### Backend
- **Java 21** - Programming Language
- **Spring Boot 3.2.1** - Framework
- **Spring Data JPA** - ORM
- **Spring Security** - Authentication
- **JWT (jjwt 0.12.3)** - Token-based Auth
- **MySQL 8.0** - Database
- **Lombok** - Boilerplate Reduction
- **Maven** - Build Tool

## 📦 Installation & Setup

### Prerequisites
- **Java 21** or higher
- **Node.js 18** or higher
- **MySQL 8.0** or higher
- **Maven 3.6** or higher

### Backend Setup

1. **Navigate to backend directory**:
   ```bash
   cd backend
   ```

2. **Configure Database**:
   - Ensure MySQL is running on `localhost:3306`
   - The application will auto-create the database `knowyourcampus`
   - Update `src/main/resources/application.properties` if needed:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/knowyourcampus?createDatabaseIfNotExist=true
     spring.datasource.username=root
     spring.datasource.password=Prince@123
     ```

3. **Build and Run**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Backend will start on**: `http://localhost:8080`

5. **Default Admin Credentials**:
   - Email: `admin@knowyourcampus.com`
   - Password: `Admin@123`

### Frontend Setup

1. **Navigate to frontend directory**:
   ```bash
   cd frontend
   ```

2. **Install Dependencies**:
   ```bash
   npm install
   ```

3. **Start Development Server**:
   ```bash
   npm run dev
   ```

4. **Frontend will start on**: `http://localhost:5173`

## 🎯 API Endpoints

### Public Endpoints
```
GET    /api/colleges                    - List all colleges (with filters)
GET    /api/colleges/{id}               - Get college details
GET    /api/colleges/search?q={query}   - Search colleges
GET    /api/courses/college/{id}        - Get courses by college
GET    /api/seats/course/{id}           - Get seat matrix
GET    /api/fees/course/{id}            - Get fee structure
GET    /api/cutoffs/course/{id}         - Get cutoff data
POST   /api/leads/submit                - Submit student lead
POST   /api/tracking                    - Track page visit
```

### Protected Endpoints (Admin Only)
```
POST   /api/auth/login                  - Admin login
POST   /api/colleges                    - Create college
PUT    /api/colleges/{id}               - Update college
DELETE /api/colleges/{id}               - Delete college
POST   /api/courses                     - Create course
PUT    /api/courses/{id}                - Update course
DELETE /api/courses/{id}                - Delete course
PUT    /api/seats/{id}                  - Update seats
PUT    /api/fees/{id}                   - Update fees
GET    /api/leads                       - Get all leads
GET    /api/analytics/dashboard         - Get dashboard data
```

## 📊 Database Schema

The application uses 8 main tables:
- **admin_users** - Admin authentication
- **colleges** - College master data
- **courses** - Courses offered
- **seat_matrix** - Available seats
- **fee_structure** - Fee details
- **cutoffs** - Previous year cutoffs
- **student_leads** - Lead tracking
- **page_tracking** - Analytics

## 🎨 Features Showcase

### Student Features
1. **Home Page**: Hero section, stats, featured colleges, YouTube section
2. **College Listing**: Search, filters, pagination
3. **College Details**: Complete info, courses, fees, seats, cutoffs, admission CTAs
4. **Compare**: Side-by-side comparison of colleges
5. **Admission Form**: Multi-step form with validation
6. **Contact**: Contact form with details

### Admin Features
1. **Dashboard**: Real-time analytics and stats
2. **Lead Management**: View and track all student enquiries
3. **Analytics**: Most viewed colleges, lead conversion rates
4. **Secure Login**: JWT-based authentication

## 📱 Contact Information

- **Phone**: 9009536046
- **Email**: princesulekhiya2004@gmail.com
- **YouTube**: https://youtube.com/@princesulekhiya

## 🔒 Security

- JWT-based authentication
- BCrypt password encryption
- CORS configuration
- Protected admin routes
- Input validation

## 🚀 Production Deployment

### Backend
```bash
cd backend
mvn clean package
java -jar target/knowyourcampus-backend-1.0.0.jar
```

### Frontend
```bash
cd frontend
npm run build
# Deploy 'dist' folder to Vercel, Netlify, or any static host
```

## 📝 Sample Data

The application comes pre-seeded with:
- **10 Colleges**: IIT Delhi, AIIMS Delhi, SRCC, Amity, Manipal, NIT Trichy, IIM Ahmedabad, Jadavpur, LPU
- **15+ Courses**: B.Tech, MBBS, MBA, B.Com, BBA, etc.
- **Seat Matrix**: Category-wise seat allocation
- **Fee Structures**: Detailed fee breakdown
- **Cutoff Data**: Previous year cutoffs

## 🎯 Future Enhancements

- Integration with government education APIs
- Payment gateway for application fees
- Document upload for admissions
- Email notifications
- SMS integration
- Advanced analytics with charts
- Mobile app (React Native)

## 📄 License

This project is built for educational purposes.

## 👨‍💻 Developer

Built with ❤️ for students across India

---

**Know Your Campus** - Find Your Dream College Today!
#   k n o w - y o u r - c a m p u s  
 