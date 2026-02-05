# 🎓 Know Your Campus - College Discovery Platform

**Version:** 2.0  
**Date:** January 24, 2026  
**Status:** Production Ready

---

## 📋 Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Installation & Setup](#installation--setup)
5. [Database Schema](#database-schema)
6. [API Endpoints](#api-endpoints)
7. [Admin Panel Guide](#admin-panel-guide)
8. [User Guide](#user-guide)
9. [Configuration](#configuration)
10. [Deployment](#deployment)

---

## 🎯 Project Overview

**Know Your Campus** is a comprehensive college discovery and admission management platform designed to help students find their ideal college and streamline the admission process.

### Key Capabilities:
- 🏫 Comprehensive college database with detailed information
- 📚 Course, fee, and seat matrix management
- ⭐ Student reviews and ratings system
- 📊 Admission cutoff tracking
- 💼 Lead generation and analytics
- 📱 Responsive design with dark mode support
- 🔐 Secure admin panel with JWT authentication

---

## ✨ Features

### **Public Features**
- ✅ **College Listing & Search** - Browse and search colleges by name, city, type
- ✅ **Detailed College Pages** - Complete information including:
  - About & Description
  - Facilities (Library, Labs, Hostel, etc.)
  - Contact Information (Phone, Email, Website)
  - NAAC Rating & Establishment Year
  - Admission Status
- ✅ **Course Information** - Degree programs with:
  - Specializations & Duration
  - Eligibility Criteria
  - Fee Structure (Academic year-wise)
  - Seat Matrix (Category-wise: GENERAL, OBC, SC, ST, EWS)
  - Admission Cutoffs (JEE, NEET, etc.)
- ✅ **Reviews & Ratings** ⭐
  - Star rating system (1-5)
  - Student testimonials
  - Course & batch year information
  - Verified student badges
- ✅ **College Comparison** - Side-by-side comparison tool
- ✅ **Admission Form** - Lead generation with tracking
- ✅ **Exam Notifications** - Scrolling ticker for important dates
- ✅ **WhatsApp Integration** - Quick connect button
- ✅ **Dark Mode** - Theme toggle support
- ✅ **Responsive Design** - Mobile, tablet, desktop optimized

### **Admin Panel Features**
- ✅ **Analytics Dashboard**
  - Total colleges, leads, page views
  - Recent lead tracking
  - Traffic analytics
- ✅ **Manage Colleges** - CRUD operations
- ✅ **Manage Courses** - Complete course management with:
  - Course CRUD
  - Fee Structure management
  - Seat Matrix configuration
  - Cutoff tracking
- ✅ **Manage Reviews** ⭐ (NEW!)
  - Review moderation
  - Approve/Reject functionality
  - View full review details
- ✅ **Manage Notifications** - Exam notification bar
- ✅ **Secure Authentication** - JWT-based login

---

## 🛠️ Technology Stack

### **Frontend**
- ⚛️ **React 18** - UI framework
- 🎨 **Tailwind CSS** - Styling
- 🎭 **Framer Motion** - Animations
- 📋 **React Hook Form** - Form management
- 🔔 **React Hot Toast** - Notifications
- 🎯 **React Router DOM** - Navigation
- 🌙 **Context API** - State management (Auth, Theme)
- ⚡ **Vite** - Build tool

### **Backend**
- ☕ **Java 21** - Programming language
- 🍃 **Spring Boot 3.2.1** - Framework
- 🔐 **Spring Security 6.2** - Authentication & Authorization
- 🗄️ **Spring Data JPA** - ORM
- 🔑 **JWT (JJWT 0.12.3)** - Token-based auth
- 🐬 **MySQL 8.x** - Database
- 📊 **Hibernate 6.4** - ORM implementation
- ✅ **Lombok** - Boilerplate reduction
- 🔥 **Spring DevTools** - Hot reload

---

## 🚀 Installation & Setup

### **Prerequisites**
- ✅ Java 21 or higher
- ✅ Node.js 18+ and npm
- ✅ MySQL 8.x
- ✅ Git

### **1. Clone Repository**
```bash
git clone https://github.com/yourusername/know-your-campus.git
cd know-your-campus
```

### **2. Database Setup**
```sql
-- Create database
CREATE DATABASE knowyourcampus_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create admin user
USE knowyourcampus_db;

INSERT INTO admin_users (email, password, full_name, role, active, created_at)
VALUES (
    'admin@knowyourcampus.com',
    '$2a$10$xKZWJz8e1YvLBPWvN9L6.eXxJlZNQQXKZVQZQXKZVQZQXKZVQZQXK', -- Password: Admin@123
    'System Administrator',
    'ADMIN',
    true,
    NOW()
);
```

### **3. Backend Setup**

**Configure Database Connection:**
```properties
# File: backend/src/main/resources/application.properties

spring.application.name=knowyourcampus-backend
server.port=8081
server.servlet.context-path=/api

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/knowyourcampus_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password_here
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# JWT Secret (Change this in production!)
jwt.secret=your-very-long-secret-key-min-256-bits-change-this-in-production
jwt.expiration=86400000
```

**Build and Run:**
```bash
cd backend
mvn clean install
mvn spring-boot:run

# Or use your IDE (IntelliJ IDEA / Eclipse)
```

**Backend will start on:** `http://localhost:8081/api`

### **4. Frontend Setup**

**Install Dependencies:**
```bash
cd frontend
npm install
```

**Configure API URL (if needed):**
```javascript
// File: frontend/src/services/api.js
const API_BASE_URL = 'http://localhost:8081/api'; // Already configured
```

**Start Development Server:**
```bash
npm run dev
```

**Frontend will start on:** `http://localhost:5174`

---

## 🗄️ Database Schema

### **Core Tables**

#### **1. colleges**
```sql
CREATE TABLE colleges (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50),                    -- Government, Private, Deemed
    city VARCHAR(100),
    state VARCHAR(100),
    address TEXT,
    pincode VARCHAR(10),
    established_year INT,
    naac_rating VARCHAR(10),             -- A++, A+, A, etc.
    affiliated_to VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(100),
    website VARCHAR(255),
    admission_open BOOLEAN DEFAULT false,
    logo_url TEXT,
    banner_url TEXT,
    description TEXT,
    facilities TEXT,                     -- JSON or comma-separated
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

#### **2. courses**
```sql
CREATE TABLE courses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    college_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,          -- B.Tech, M.Tech, MBA
    specialization VARCHAR(255),          -- Computer Science, Mechanical
    degree VARCHAR(50),                   -- UG, PG, Diploma
    duration_years INT,
    description TEXT,
    eligibility TEXT,
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (college_id) REFERENCES colleges(id) ON DELETE CASCADE
);
```

#### **3. fee_structures**
```sql
CREATE TABLE fee_structures (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id BIGINT NOT NULL,
    academic_year VARCHAR(20),            -- 2024-2025
    tuition_fee DECIMAL(12,2),
    hostel_fee DECIMAL(12,2),
    transport_fee DECIMAL(12,2),
    library_fee DECIMAL(12,2),
    lab_fee DECIMAL(12,2),
    other_fees DECIMAL(12,2),
    total_fee DECIMAL(12,2),
    fee_type VARCHAR(50),                 -- PER_YEAR, PER_SEMESTER
    remarks TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);
```

#### **4. seat_matrices**
```sql
CREATE TABLE seat_matrices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id BIGINT NOT NULL,
    academic_year VARCHAR(20),
    category VARCHAR(50),                 -- GENERAL, OBC, SC, ST, EWS
    total_seats INT,
    available_seats INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);
```

#### **5. cutoffs**
```sql
CREATE TABLE cutoffs (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id BIGINT NOT NULL,
    category VARCHAR(50),                 -- GENERAL, OBC, SC, ST, EWS
    academic_year VARCHAR(20),
    round VARCHAR(50),                    -- Round 1, Round 2, Final
    cutoff_percentage DECIMAL(5,2),
    cutoff_rank INT,
    exam_type VARCHAR(100),               -- JEE Main, NEET, CAT, GATE
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);
```

#### **6. college_reviews** ⭐ (NEW!)
```sql
CREATE TABLE college_reviews (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    college_id BIGINT NOT NULL,
    student_name VARCHAR(255) NOT NULL,
    student_email VARCHAR(255) NOT NULL,
    rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    review_title VARCHAR(255),
    review_text TEXT,
    course VARCHAR(255),                  -- Course studied
    batch_year VARCHAR(10),               -- e.g., 2020-2024
    verified BOOLEAN DEFAULT false,
    approved BOOLEAN DEFAULT false,       -- Admin moderation
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (college_id) REFERENCES colleges(id) ON DELETE CASCADE
);
```

#### **7. student_leads**
```sql
CREATE TABLE student_leads (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255),
    email VARCHAR(100),
    phone VARCHAR(20),
    city VARCHAR(100),
    state VARCHAR(100),
    interested_course VARCHAR(255),
    preferred_location TEXT,
    budget_range VARCHAR(50),
    exam_score VARCHAR(50),
    source VARCHAR(100),                  -- Form, WhatsApp, etc.
    status VARCHAR(50) DEFAULT 'NEW',
    created_at TIMESTAMP
);
```

#### **8. exam_notifications**
```sql
CREATE TABLE exam_notifications (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    exam_name VARCHAR(255),
    notification_text TEXT,
    exam_date DATE,
    important BOOLEAN DEFAULT false,
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMP
);
```

#### **9. admin_users**
```sql
CREATE TABLE admin_users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,       -- BCrypt hashed
    full_name VARCHAR(255),
    role VARCHAR(50) DEFAULT 'ADMIN',
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
```

---

## 🔌 API Endpoints

### **Base URL:** `http://localhost:8081/api`

### **Authentication**

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/auth/login` | Admin login | ❌ |
| POST | `/auth/register` | Register (disabled in prod) | ❌ |

**Login Request:**
```json
POST /api/auth/login
{
  "email": "admin@knowyourcampus.com",
  "password": "Admin@123"
}
```

**Response:**
```json
{
  "token": "eyJhbGc...",
  "email": "admin@knowyourcampus.com",
  "role": "ADMIN"
}
```

---

### **Colleges**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/colleges` | Get all colleges | ❌ |
| GET | `/colleges/{id}` | Get college by ID | ❌ |
| GET | `/colleges/search?q={query}` | Search colleges | ❌ |
| POST | `/colleges` | Create college | ✅ Admin |
| PUT | `/colleges/{id}` | Update college | ✅ Admin |
| DELETE | `/colleges/{id}` | Delete college | ✅ Admin |

---

### **Courses**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/courses/college/{collegeId}` | Get courses by college | ❌ |
| GET | `/courses/{id}` | Get course by ID | ❌ |
| POST | `/courses` | Create course | ✅ Admin |
| PUT | `/courses/{id}` | Update course | ✅ Admin |
| DELETE | `/courses/{id}` | Delete course | ✅ Admin |

---

### **Fee Structures**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/fees/course/{courseId}` | Get fees by course | ❌ |
| POST | `/fees` | Add fee structure | ✅ Admin |
| PUT | `/fees/{id}` | Update fee | ✅ Admin |
| DELETE | `/fees/{id}` | Delete fee | ✅ Admin |

---

### **Seat Matrices**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/seats/course/{courseId}` | Get seats by course | ❌ |
| POST | `/seats` | Add seat matrix | ✅ Admin |
| PUT | `/seats/{id}` | Update seats | ✅ Admin |
| DELETE | `/seats/{id}` | Delete seats | ✅ Admin |

---

### **Cutoffs**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/cutoffs/course/{courseId}` | Get cutoffs by course | ❌ |
| POST | `/cutoffs` | Add cutoff | ✅ Admin |
| PUT | `/cutoffs/{id}` | Update cutoff | ✅ Admin |
| DELETE | `/cutoffs/{id}` | Delete cutoff | ✅ Admin |

---

### **Reviews** ⭐ (NEW!)

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/reviews/college/{id}` | Get approved reviews | ❌ Public |
| GET | `/reviews/college/{id}/stats` | Get rating stats | ❌ Public |
| POST | `/reviews` | Submit review | ❌ Public |
| GET | `/reviews/admin/all` | Get all reviews | ✅ Admin |
| GET | `/reviews/admin/pending` | Get pending reviews | ✅ Admin |
| PUT | `/reviews/admin/{id}/approve` | Approve review | ✅ Admin |
| PUT | `/reviews/admin/{id}` | Update review | ✅ Admin |
| DELETE | `/reviews/admin/{id}` | Delete review | ✅ Admin |

---

### **Student Leads**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/leads` | Submit admission form | ❌ |
| GET | `/leads` | Get all leads | ✅ Admin |
| GET | `/leads/recent` | Get recent leads | ✅ Admin |

---

### **Analytics**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/analytics/dashboard` | Get dashboard stats | ✅ Admin |

---

### **Notifications**

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/notifications/active` | Get active notifications | ❌ |
| POST | `/notifications` | Create notification | ✅ Admin |
| PUT | `/notifications/{id}` | Update notification | ✅ Admin |
| DELETE | `/notifications/{id}` | Delete notification | ✅ Admin |

---

## 👨‍💼 Admin Panel Guide

### **Access Admin Panel**
```
URL: http://localhost:5174/admin
Email: admin@knowyourcampus.com
Password: Admin@123
```

### **Admin Features**

#### **1. Analytics Dashboard**
- View total colleges, leads, page views
- Recent lead submissions
- Quick stats overview

#### **2. Manage Colleges**
**Add New College:**
1. Click "Add New College"
2. Fill form:
   - Basic Info (Name, Type, City, State)
   - Contact (Phone, Email, Website)
   - Details (Description, Facilities, NAAC Rating)
   - Images (Logo URL, Banner URL)
3. Click "Create College"

**Edit College:**
1. Find college in list
2. Click ✏️ Edit icon
3. Update details
4. Save changes

#### **3. Manage Courses**
**Add Course to College:**
1. Select college from dropdown
2. Click "Add New Course"
3. Fill details:
   - Course Name (B.Tech, MBA, etc.)
   - Specialization
   - Degree Type (UG/PG)
   - Duration & Eligibility
4. Submit

**Add Fee Structure:**
1. Find course in table
2. Click 💰 Dollar icon
3. Enter fees:
   - Tuition, Hostel, Lab, etc.
   - Academic year
4. Save

**Add Seat Matrix:**
1. Click 👥 Users icon on course
2. Select category (GENERAL, OBC, SC, ST, EWS)
3. Enter total & available seats
4. Submit

**Add Cutoffs:**
1. Click 📈 Cutoff icon
2. Select:
   - Exam type (JEE, NEET, etc.)
   - Category
   - Round
3. Enter rank/percentage
4. Save

#### **4. Manage Reviews** ⭐ (NEW!)
**Review Moderation:**
1. Go to "Manage Reviews"
2. See tabs:
   - "All Reviews" - All submitted reviews
   - "Pending Approval" - Requires action

**Approve Review:**
1. Click ✅ Check icon
2. Review becomes visible to public

**View Full Review:**
1. Click 👁️ Eye icon
2. See complete details:
   - Student name, email
   - Course & batch
   - Full review text
   - Rating

**Delete Review:**
1. Click 🗑️ Trash icon
2. Confirm deletion
3. Review removed permanently

---

## 👨‍🎓 User Guide

### **For Students**

#### **1. Browse Colleges**
```
Visit: http://localhost:5174/colleges
```
- Search by name, city
- Filter by type (Government/Private)
- View college cards with ratings

#### **2. View College Details**
```
Click on any college card
```
**See:**
- ⭐ Average Rating & Review Count
- 📋 About & Description
- 🏗️ Facilities
- 📞 Contact Information
- 📚 Available Courses
- 📊 Fee Structures
- 🎓 Seat Availability
- 📈 Cutoffs (Previous years)
- 💬 Student Reviews

#### **3. Write a Review** ⭐
1. Scroll to "Student Reviews" section
2. Click "Write a Review"
3. Fill form:
   - Your Name & Email
   - Rating (1-5 stars)
   - Review Title
   - Detailed Review (min 50 chars)
   - Course & Batch (optional)
4. Submit
5. **Note:** Review will appear after admin approval

#### **4. Compare Colleges**
```
Visit: http://localhost:5174/compare
```
- Select 2-3 colleges
- See side-by-side comparison

#### **5. Submit Admission Form**
```
Click "Apply Now" or visit Contact page
```
- Fill your details
- Select interested course
- Submit for counselor callback

---

## ⚙️ Configuration

### **Backend Configuration**

**File:** `backend/src/main/resources/application.properties`

```properties
# Server
server.port=8081
server.servlet.context-path=/api

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/knowyourcampus_db
spring.datasource.username=root
spring.datasource.password=your_password

# JPA
spring.jpa.hibernate.ddl-auto=update  # Change to 'validate' in production
spring.jpa.show-sql=true              # Set to false in production

# JWT
jwt.secret=your-256-bit-secret-key-change-this
jwt.expiration=86400000               # 24 hours in milliseconds

# CORS (Optional - if frontend on different domain)
cors.allowed-origins=http://localhost:5174,https://yourdomain.com
```

### **Frontend Configuration**

**File:** `frontend/src/services/api.js`

```javascript
const API_BASE_URL = import.meta.env.VITE_API_URL || 'http://localhost:8081/api';
```

**Environment Variables:**
Create `.env` file in frontend folder:
```
VITE_API_URL=http://localhost:8081/api
```

---

## 🚀 Deployment

### **Production Checklist**

✅ **Backend:**
- [ ] Change `jwt.secret` to strong random key (256-bit)
- [ ] Set `spring.jpa.show-sql=false`
- [ ] Use environment variables for sensitive data
- [ ] Enable HTTPS
- [ ] Configure CORS for production domain
- [ ] Set `spring.jpa.hibernate.ddl-auto=validate`
- [ ] Set up database backups

✅ **Frontend:**
- [ ] Update `API_BASE_URL` to production backend
- [ ] Build production bundle: `npm run build`
- [ ] Enable CDN for assets
- [ ] Configure SSL certificate
- [ ] Set up domain DNS

✅ **Database:**
- [ ] Backup strategy
- [ ] Index optimization
- [ ] Security: Strong password, limited user privileges
- [ ] SSL connection (if required)

---

## 📊 Sample Data

### **College ID 10 - BIET Bhopal (Already Populated)**
- ✅ Full details (About, Facilities, Contact)
- ✅ 6 Engineering Courses
- ✅ Fee structures
- ✅ Seat matrices
- ✅ Ready for testing

**SQL File:** `backend/sample_data_college_10.sql`

---

## 🐛 Troubleshooting

### **Common Issues**

**1. Backend Won't Start**
```
Error: Cannot connect to database
Solution: Check MySQL is running
         Verify credentials in application.properties
```

**2. Frontend API Errors**
```
Error: CORS policy
Solution: Backend already configured with @CrossOrigin
         Check backend is running on port 8081
```

**3. JWT Token Expired**
```
Error: 401 Unauthorized
Solution: Login again from admin panel
         Token expires after 24 hours
```

**4. Review Not Appearing**
```
Issue: Submitted review not visible
Reason: Reviews need admin approval
Solution: Go to Admin → Manage Reviews → Approve
```

---

## 📞 Support

**For Issues/Questions:**
- GitHub Issues: [Project Repository]
- Email: admin@knowyourcampus.com
- Documentation: See `FEATURE_ROADMAP.md` and `REVIEWS_IMPLEMENTATION_GUIDE.md`

---

## 📝 License

© 2026 Know Your Campus. All Rights Reserved.

---

## 🎉 Credits

**Developed by:** Your Team Name  
**Technology Partner:** Spring Boot + React  
**Database:** MySQL  
**Deployment:** [Your Hosting Provider]

---

**Last Updated:** January 24, 2026  
**Version:** 2.0 - Reviews & Cutoffs Update