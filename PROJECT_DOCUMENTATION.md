# Know Your Campus - Project Documentation

> **Version:** 2.0 | **Last Updated:** February 18, 2026
> **Domain:** [https://knowyourcampus.in](https://knowyourcampus.in)
> **Status:** Production Ready

---

## Table of Contents

1. [Project Overview](#1-project-overview)
2. [Technology Stack](#2-technology-stack)
3. [Project Structure](#3-project-structure)
4. [Backend Architecture](#4-backend-architecture)
   - [Entities & Database Schema](#41-entities--database-schema)
   - [Repositories](#42-repositories)
   - [Services](#43-services)
   - [Controllers & API Endpoints](#44-controllers--api-endpoints)
5. [Frontend Architecture](#5-frontend-architecture)
   - [Pages](#51-pages)
   - [Components](#52-components)
   - [Services (API Layer)](#53-services-api-layer)
   - [Context Providers](#54-context-providers)
6. [Authentication & Security](#6-authentication--security)
7. [Database Configuration](#7-database-configuration)
8. [API Reference](#8-api-reference)
9. [Deployment Guide](#9-deployment-guide)
10. [AWS & Monitoring](#10-aws--monitoring)
11. [Data Seeding](#11-data-seeding)
12. [SEO Strategy](#12-seo-strategy)
13. [Environment Variables & Configuration](#13-environment-variables--configuration)
14. [Development Setup](#14-development-setup)
15. [Feature Highlights](#15-feature-highlights)

---

## 1. Project Overview

**Know Your Campus** is a full-stack **College Discovery and Admission Management Platform** targeting Indian students. It helps students:

- Browse and search colleges with advanced filtering
- View detailed college information (courses, fees, seat availability, cutoffs)
- Compare colleges side by side
- Read and write verified reviews
- Submit admission inquiry leads

The platform also includes a **complete admin panel** for managing colleges, courses, leads, reviews, notifications, and viewing analytics.

### Target Audience

| Role | Description |
|------|-------------|
| **Students** | Browse colleges, compare options, read reviews, submit admission inquiries |
| **Admin** | Manage all data, moderate reviews, track leads, view analytics dashboard |

---

## 2. Technology Stack

### Backend

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21 | Programming language |
| Spring Boot | 3.2.1 | Application framework |
| Spring Security | 6.2 | Authentication & authorization |
| Spring Data JPA | 3.2.1 | Database ORM |
| Hibernate | 6.4 | JPA implementation |
| MySQL | 8.x | Relational database |
| JJWT | 0.12.3 | JWT token generation/validation |
| Lombok | Latest | Boilerplate code reduction |
| Spring Boot Actuator | 3.2.1 | Health checks & metrics |
| Micrometer CloudWatch2 | Latest | AWS metrics export |
| Logback AWS Appender | 1.6.0 | CloudWatch log streaming |
| Maven | Latest | Build tool |

### Frontend

| Technology | Version | Purpose |
|------------|---------|---------|
| React | 18.2 | UI framework |
| Vite | 4.5 | Build tool & dev server |
| Tailwind CSS | 3.3 | Utility-first styling |
| Framer Motion | 12.x | Animations |
| React Router DOM | 6.20 | Client-side routing |
| React Hook Form | 7.x | Form management |
| Axios | 1.6 | HTTP client |
| React Hot Toast | 2.6 | Notifications |
| React Icons | 4.12 | Icon library |
| React Helmet Async | 2.0 | SEO meta tags |
| React YouTube | 10.1 | YouTube embed player |

### Infrastructure

| Technology | Purpose |
|------------|---------|
| Nginx | Reverse proxy & static file server |
| Let's Encrypt | SSL/TLS certificates |
| Vercel | Frontend hosting |
| Railway / AWS EC2 | Backend hosting |
| AWS CloudWatch | Logs & metrics monitoring |

---

## 3. Project Structure

```
knowyourcampus/
│
├── backend/                                    # Spring Boot Backend
│   ├── pom.xml                                 # Maven dependencies
│   └── src/main/
│       ├── java/com/knowyourcampus/
│       │   ├── KnowYourCampusApplication.java  # Main entry point
│       │   ├── config/                         # Seeders
│       │   │   ├── DataSeeder.java
│       │   │   ├── BhopalCollegeSeeder.java
│       │   │   └── MPCollegeSeeder.java
│       │   ├── controller/                     # REST Controllers (12)
│       │   │   ├── AuthController.java
│       │   │   ├── CollegeController.java
│       │   │   ├── CourseController.java
│       │   │   ├── FeeStructureController.java
│       │   │   ├── SeatMatrixController.java
│       │   │   ├── CutoffController.java
│       │   │   ├── CollegeReviewController.java
│       │   │   ├── StudentLeadController.java
│       │   │   ├── NotificationController.java
│       │   │   ├── PageTrackingController.java
│       │   │   └── AnalyticsController.java
│       │   ├── dto/                            # Data Transfer Objects
│       │   ├── entity/                         # JPA Entities (9)
│       │   │   ├── AdminUser.java
│       │   │   ├── College.java
│       │   │   ├── Course.java
│       │   │   ├── FeeStructure.java
│       │   │   ├── SeatMatrix.java
│       │   │   ├── Cutoff.java
│       │   │   ├── CollegeReview.java
│       │   │   ├── StudentLead.java
│       │   │   ├── Notification.java
│       │   │   └── PageTracking.java
│       │   ├── exception/                      # Global exception handling
│       │   │   └── GlobalExceptionHandler.java
│       │   ├── repository/                     # Spring Data Repositories (10)
│       │   ├── security/                       # JWT Security
│       │   │   ├── SecurityConfig.java
│       │   │   ├── JwtUtil.java
│       │   │   └── JwtAuthenticationFilter.java
│       │   └── service/                        # Business Logic (12)
│       └── resources/
│           ├── application.properties          # App configuration
│           └── logback-spring.xml              # Logging config
│
├── frontend/                                   # React Frontend
│   ├── package.json                            # NPM dependencies
│   ├── vite.config.js                          # Vite configuration
│   ├── tailwind.config.js                      # Tailwind CSS config
│   ├── vercel.json                             # Vercel deployment config
│   ├── public/
│   │   └── sitemap.xml                         # SEO sitemap
│   └── src/
│       ├── App.jsx                             # Root component & routing
│       ├── main.jsx                            # React entry point
│       ├── index.css                           # Global styles
│       ├── context/                            # React Context providers
│       │   ├── AuthContext.jsx
│       │   └── ThemeContext.jsx
│       ├── services/                           # API service layer
│       │   ├── api.js
│       │   ├── collegeService.js
│       │   ├── reviewService.js
│       │   ├── leadService.js
│       │   ├── analyticsService.js
│       │   └── notificationService.js
│       ├── pages/                              # Page components
│       │   ├── Home.jsx
│       │   ├── Colleges.jsx
│       │   ├── CollegeDetails.jsx
│       │   ├── CompareColleges.jsx
│       │   ├── AdmissionForm.jsx
│       │   ├── Contact.jsx
│       │   ├── Login.jsx
│       │   └── admin/
│       │       ├── AdminDashboard.jsx
│       │       ├── AnalyticsDashboard.jsx
│       │       ├── ManageColleges.jsx
│       │       ├── ManageCourses.jsx
│       │       ├── ManageNotifications.jsx
│       │       └── ManageReviews.jsx
│       └── components/                         # Reusable components
│           ├── Navbar.jsx
│           ├── Footer.jsx
│           ├── CollegeCard.jsx
│           ├── FilterPanel.jsx
│           ├── SearchBar.jsx
│           ├── EnhancedSearch.jsx
│           ├── ReviewsList.jsx
│           ├── WriteReviewForm.jsx
│           ├── StarRating.jsx
│           ├── ExamNotificationBar.jsx
│           ├── ProtectedRoute.jsx
│           ├── SEO.jsx
│           ├── WhatsAppButton.jsx
│           ├── AnimatedBackground.jsx
│           ├── AnimatedCounter.jsx
│           ├── LoadingSpinner.jsx
│           ├── ScrollToTop.jsx
│           ├── AdmissionCTA.jsx
│           ├── FAQ.jsx
│           ├── Testimonials.jsx
│           ├── TopRecruiters.jsx
│           ├── BlogPreview.jsx
│           ├── HowItWorks.jsx
│           ├── StreamCategory.jsx
│           └── Newsletter.jsx
│
├── nginx.conf                                  # Production Nginx config
├── setup-server.sh                             # Server setup script
├── seed_colleges.sql                           # SQL seed data
└── fix.sql                                     # SQL fix scripts
```

---

## 4. Backend Architecture

The backend follows a **layered architecture** pattern:

```
Request → Controller → Service → Repository → Database
                ↓
            DTO/Entity mapping
```

### 4.1 Entities & Database Schema

#### Entity Relationship Diagram

```
┌──────────────┐       ┌──────────────┐       ┌──────────────────┐
│  AdminUser   │       │   College    │──1:N──│     Course       │
│──────────────│       │──────────────│       │──────────────────│
│ id           │       │ id           │       │ id               │
│ email (UK)   │       │ name         │       │ college_id (FK)  │
│ password     │       │ type (ENUM)  │       │ name             │
│ fullName     │       │ city         │       │ specialization   │
│ role         │       │ state        │       │ degree (ENUM)    │
│ active       │       │ naacRating   │       │ durationYears    │
└──────────────┘       │ admissionOpen│       │ eligibility      │
                       │ logoUrl      │       │ active           │
                       │ bannerUrl    │       └───────┬──────────┘
                       │ facilities   │               │
                       │ affiliatedTo │          ┌────┼────┐
                       │ established  │          │    │    │
                       └──────┬───────┘          │    │    │
                              │            ┌─────┴┐ ┌┴────┴──┐ ┌──────────┐
                              │            │ Fee  │ │  Seat  │ │  Cutoff  │
                         1:N  │            │Struct│ │ Matrix │ │          │
                              │            │──────│ │────────│ │──────────│
                       ┌──────┴───────┐    │course│ │course  │ │course    │
                       │CollegeReview │    │(FK)  │ │(FK)    │ │(FK)      │
                       │──────────────│    │year  │ │category│ │category  │
                       │ college (FK) │    │tuition│ │total   │ │year      │
                       │ studentName  │    │hostel│ │avail.  │ │round     │
                       │ studentEmail │    │total │ │year    │ │percentage│
                       │ rating (1-5) │    └──────┘ └────────┘ │rank      │
                       │ reviewTitle  │                        │examType  │
                       │ reviewText   │                        └──────────┘
                       │ approved     │
                       │ verified     │
                       └──────────────┘

┌──────────────┐    ┌──────────────┐    ┌──────────────┐
│ StudentLead  │    │ Notification │    │ PageTracking │
│──────────────│    │──────────────│    │──────────────│
│ studentName  │    │ text         │    │ pagePath     │
│ mobile       │    │ link         │    │ pageTitle    │
│ email        │    │ isUrgent     │    │ collegeId    │
│ city, state  │    │ isActive     │    │ courseId     │
│ course       │    │ eventDate    │    │ ipAddress    │
│ collegeId    │    └──────────────┘    │ sessionId    │
│ leadSource   │                        │ userAgent    │
│ status (ENUM)│                        │ referrer     │
│ ipAddress    │                        └──────────────┘
│ sessionId    │
└──────────────┘
```

#### Detailed Entity Definitions

**AdminUser**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key, Auto-generated |
| email | String | Unique, Not Null |
| password | String | BCrypt encoded |
| fullName | String | |
| role | String | Default: "ADMIN" |
| active | Boolean | Default: true |

**College**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key, Auto-generated |
| name | String | Not Null |
| type | Enum | GOVERNMENT, PRIVATE |
| city | String | |
| state | String | |
| naacRating | String | A++, A+, A, B++, B+, B, C |
| admissionOpen | Boolean | |
| logoUrl | String | |
| bannerUrl | String | |
| facilities | String | Comma-separated |
| affiliatedTo | String | University affiliation |
| establishedYear | Integer | |
| courses | List\<Course\> | OneToMany, Cascade ALL |

**Course**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key, Auto-generated |
| college | College | ManyToOne (FK) |
| name | String | Not Null |
| specialization | String | |
| degree | Enum | UG, PG, DIPLOMA |
| durationYears | Integer | |
| eligibility | String | |
| active | Boolean | Default: true |

**FeeStructure**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| course | Course | ManyToOne (FK) |
| academicYear | String | e.g., "2025-26" |
| tuitionFee | Double | |
| hostelFee | Double | |
| transportFee | Double | |
| libraryFee | Double | |
| labFee | Double | |
| otherFees | Double | |
| totalFee | Double | Computed |
| feeType | String | |

**SeatMatrix**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| course | Course | ManyToOne (FK) |
| category | Enum | GENERAL, OBC, SC, ST, EWS |
| totalSeats | Integer | |
| availableSeats | Integer | |
| academicYear | String | |

**Cutoff**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| course | Course | ManyToOne (FK) |
| category | Enum | GENERAL, OBC, SC, ST, EWS |
| academicYear | String | |
| round | Integer | Counseling round number |
| cutoffPercentage | Double | |
| cutoffRank | Integer | |
| examType | Enum | JEE, NEET, CAT, MAT, GATE, etc. |

**CollegeReview**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| college | College | ManyToOne (FK) |
| studentName | String | |
| studentEmail | String | |
| rating | Integer | 1-5 |
| reviewTitle | String | |
| reviewText | String | @Column(length=2000) |
| course | String | Course studied |
| batchYear | String | |
| verified | Boolean | Default: false |
| approved | Boolean | Default: false |

**StudentLead**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| studentName | String | Not Null |
| mobile | String | Not Null |
| email | String | |
| city | String | |
| state | String | |
| interestedCourse | String | |
| interestedSpecialization | String | |
| collegeId | Long | Reference (not FK) |
| leadSource | String | e.g., "WEBSITE" |
| status | Enum | NEW, CONTACTED, QUALIFIED, CONVERTED, LOST |
| ipAddress | String | Auto-captured |
| sessionId | String | Auto-captured |
| remarks | String | Admin notes |

**Notification**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| text | String | Notification message |
| link | String | Optional URL |
| isUrgent | Boolean | |
| isActive | Boolean | |
| eventDate | LocalDate | |

**PageTracking**
| Field | Type | Constraints |
|-------|------|-------------|
| id | Long | Primary Key |
| pagePath | String | URL path visited |
| pageTitle | String | |
| collegeId | Long | If college page |
| courseId | Long | If course page |
| ipAddress | String | |
| sessionId | String | |
| userAgent | String | |
| referrer | String | |

---

### 4.2 Repositories

| Repository | Key Custom Queries |
|---|---|
| `AdminUserRepository` | `findByEmail()`, `existsByEmail()` |
| `CollegeRepository` | `searchColleges()` - LIKE search on name/city/state; `filterColleges()` - multi-param JPQL filter (type, city, state, NAAC, admissionOpen) |
| `CourseRepository` | `findActiveByCollegeId()`, `searchCourses()`, `findByCollegeAndNameAndSpecialization()` |
| `CollegeReviewRepository` | `findByCollegeIdAndApprovedTrue()`, `getAverageRatingByCollegeId()`, `countByCollegeIdAndApprovedTrue()`, `findByApprovedFalse()` |
| `StudentLeadRepository` | `findRecentLeads()`, `countByCollegeId()`, `countByStatus()`, `findAllOrderByCreatedAtDesc()` |
| `PageTrackingRepository` | `findMostViewedColleges()` - GROUP BY with count, `countVisitsSince()` |
| `FeeStructureRepository` | Standard Spring Data JPA |
| `SeatMatrixRepository` | Standard Spring Data JPA |
| `CutoffRepository` | Standard Spring Data JPA |
| `NotificationRepository` | Standard Spring Data JPA |

---

### 4.3 Services

| Service | Responsibilities |
|---|---|
| `AuthService` | Admin login authentication, JWT token generation |
| `CustomUserDetailsService` | `UserDetailsService` implementation, loads admin by email |
| `CollegeService` | Full CRUD, search, multi-filter (type/city/state/NAAC/admission) |
| `CourseService` | Full CRUD, active course lookups, search by name/specialization |
| `FeeStructureService` | CRUD for fee structures linked to courses |
| `SeatMatrixService` | CRUD for seat availability by category/year |
| `CutoffService` | CRUD for cutoff data (exam/round/category) |
| `CollegeReviewService` | Public review submission, admin moderation (approve/reject/delete), average rating calculation |
| `StudentLeadService` | Lead capture from public form, CRM-style status lifecycle management |
| `NotificationService` | Manage exam/admission notification banners |
| `PageTrackingService` | Track page visits, aggregate view counts per college |
| `AnalyticsService` | Dashboard data aggregation (total counts, top colleges, lead breakdown) |

---

### 4.4 Controllers & API Endpoints

All endpoints are prefixed with `/api` (via `server.servlet.context-path`).

#### AuthController (`/api/auth`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/login` | Public | Admin login, returns JWT token |

#### CollegeController (`/api/colleges`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/` | Public | Get all colleges |
| GET | `/{id}` | Public | Get college by ID |
| GET | `/search?query=` | Public | Search colleges by name/city/state |
| GET | `/filter?type=&city=&state=&naac=&admissionOpen=` | Public | Advanced filter |
| POST | `/` | Admin | Create a new college |
| PUT | `/{id}` | Admin | Update college |
| DELETE | `/{id}` | Admin | Delete college |

#### CourseController (`/api/courses`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/` | Public | Get all courses |
| GET | `/{id}` | Public | Get course by ID |
| GET | `/college/{collegeId}` | Public | Get courses by college |
| GET | `/college/{collegeId}/active` | Public | Get active courses only |
| GET | `/search?query=` | Public | Search courses |
| POST | `/` | Admin | Create course |
| PUT | `/{id}` | Admin | Update course |
| DELETE | `/{id}` | Admin | Delete course |

#### FeeStructureController (`/api/fees`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/course/{courseId}` | Public | Get fees for a course |
| POST | `/` | Admin | Create fee structure |
| PUT | `/{id}` | Admin | Update fee structure |
| DELETE | `/{id}` | Admin | Delete fee structure |

#### SeatMatrixController (`/api/seats`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/course/{courseId}` | Public | Get seat matrix for a course |
| POST | `/` | Admin | Create seat entry |
| PUT | `/{id}` | Admin | Update seat entry |
| DELETE | `/{id}` | Admin | Delete seat entry |

#### CutoffController (`/api/cutoffs`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/course/{courseId}` | Public | Get cutoffs for a course |
| POST | `/` | Admin | Create cutoff |
| PUT | `/{id}` | Admin | Update cutoff |
| DELETE | `/{id}` | Admin | Delete cutoff |

#### CollegeReviewController (`/api/reviews`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/college/{collegeId}` | Public | Get approved reviews for a college |
| GET | `/college/{collegeId}/stats` | Public | Get review stats (avg rating, count) |
| POST | `/` | Public | Submit a new review |
| GET | `/` | Admin | Get all reviews |
| GET | `/pending` | Admin | Get pending (unapproved) reviews |
| PUT | `/{id}/approve` | Admin | Approve a review |
| PUT | `/{id}` | Admin | Update a review |
| DELETE | `/{id}` | Admin | Delete a review |

#### StudentLeadController (`/api/leads`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/submit` | Public | Submit admission inquiry |
| GET | `/` | Admin | Get all leads |
| GET | `/{id}` | Admin | Get lead by ID |
| GET | `/status/{status}` | Admin | Filter leads by status |
| GET | `/college/{collegeId}` | Admin | Get leads for a college |
| PUT | `/{id}/status` | Admin | Update lead status |

#### NotificationController (`/api/notifications`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/active` | Public | Get active notifications |
| GET | `/` | Admin | Get all notifications |
| POST | `/` | Admin | Create notification |
| PUT | `/{id}/toggle` | Admin | Toggle notification active status |
| DELETE | `/{id}` | Admin | Delete notification |

#### PageTrackingController (`/api/tracking`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/` | Public | Track a page visit |
| GET | `/college/{id}/views` | Public | Get view count for a college |

#### AnalyticsController (`/api/analytics`)
| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| GET | `/dashboard` | Admin | Full dashboard data (counts, charts, top colleges) |

---

## 5. Frontend Architecture

### Routing Structure

```
/                       → Home (landing page)
/colleges               → College listing with filters
/college/:id            → College detail page
/compare                → College comparison tool
/admission              → Admission inquiry form
/contact                → Contact page
/login                  → Admin login

/admin                  → Admin Dashboard (protected)
/admin/colleges         → Manage Colleges (protected)
/admin/courses          → Manage Courses (protected)
/admin/reviews          → Manage Reviews (protected)
/admin/notifications    → Manage Notifications (protected)
/admin/analytics        → Analytics Dashboard (protected)
```

### Layout Structure

```
Public Pages:
┌─────────────────────────────────────┐
│ ExamNotificationBar (scrolling)     │
├─────────────────────────────────────┤
│ Navbar                              │
├─────────────────────────────────────┤
│ AnimatedBackground                  │
│ ┌─────────────────────────────────┐ │
│ │        Page Content             │ │
│ └─────────────────────────────────┘ │
├─────────────────────────────────────┤
│ Footer                              │
├─────────────────────────────────────┤
│ WhatsAppButton (floating)           │
└─────────────────────────────────────┘

Admin Pages:
┌─────────────────────────────────────┐
│ AdminDashboard (sidebar + content)  │
│ ┌────────┬──────────────────────┐   │
│ │Sidebar │  Admin Page Content  │   │
│ │        │                      │   │
│ └────────┴──────────────────────┘   │
└─────────────────────────────────────┘
```

### 5.1 Pages

| Page | Route | Description |
|------|-------|-------------|
| `Home.jsx` | `/` | Landing page with hero, search, stream categories, how it works, testimonials, FAQ, newsletter |
| `Colleges.jsx` | `/colleges` | Browse colleges with FilterPanel, search, sorting, pagination |
| `CollegeDetails.jsx` | `/college/:id` | Full college view: info, courses, fees, seats, cutoffs, reviews, admission CTA |
| `CompareColleges.jsx` | `/compare` | Side-by-side comparison of 2-3 colleges |
| `AdmissionForm.jsx` | `/admission` | Lead generation form (React Hook Form) |
| `Contact.jsx` | `/contact` | Contact information |
| `Login.jsx` | `/login` | Admin login form |
| **Admin Pages** | | |
| `AdminDashboard.jsx` | `/admin` | Shell layout with sidebar navigation |
| `AnalyticsDashboard.jsx` | `/admin/analytics` | Charts, counts, top colleges, lead breakdown |
| `ManageColleges.jsx` | `/admin/colleges` | CRUD table for colleges |
| `ManageCourses.jsx` | `/admin/courses` | CRUD for courses + fees + seats + cutoffs |
| `ManageReviews.jsx` | `/admin/reviews` | Review moderation (approve/reject/delete) |
| `ManageNotifications.jsx` | `/admin/notifications` | Notification banner management |

### 5.2 Components

| Component | Purpose |
|---|---|
| `Navbar.jsx` | Main navigation bar with responsive mobile menu |
| `Footer.jsx` | Site footer with links and branding |
| `CollegeCard.jsx` | College card in listing/search results |
| `FilterPanel.jsx` | Advanced filter sidebar (type, city, state, NAAC, admission status) |
| `SearchBar.jsx` | Simple search input |
| `EnhancedSearch.jsx` | Enhanced search with suggestions |
| `ReviewsList.jsx` | Display approved reviews with ratings |
| `WriteReviewForm.jsx` | Public review submission form |
| `StarRating.jsx` | Interactive star rating component |
| `ExamNotificationBar.jsx` | Scrolling ticker with active notifications |
| `ProtectedRoute.jsx` | Route guard - redirects to login if unauthenticated |
| `SEO.jsx` | React Helmet wrapper for dynamic meta tags |
| `WhatsAppButton.jsx` | Floating WhatsApp contact button |
| `AnimatedBackground.jsx` | Decorative animated background |
| `AnimatedCounter.jsx` | Number counter animation (stats section) |
| `LoadingSpinner.jsx` | Loading state indicator |
| `ScrollToTop.jsx` | Scroll restoration on route change |
| `AdmissionCTA.jsx` | Call-to-action banner for admissions |
| `FAQ.jsx` | Frequently asked questions accordion |
| `Testimonials.jsx` | Student testimonial carousel |
| `TopRecruiters.jsx` | Recruiter logos section |
| `BlogPreview.jsx` | Blog/article preview cards |
| `HowItWorks.jsx` | Step-by-step guide section |
| `StreamCategory.jsx` | Stream/discipline category cards |
| `Newsletter.jsx` | Newsletter subscription form |

### 5.3 Services (API Layer)

**`api.js`** - Axios instance configuration:
- Base URL: `/api`
- Request interceptor: Attaches JWT token from localStorage as `Authorization: Bearer <token>`
- Response interceptor: On 401/403, clears token and redirects to `/login`

**`collegeService.js`** - College data operations:
- `getAllColleges()`, `getCollegeById(id)`, `searchColleges(query)`
- `filterColleges(params)`, `createCollege()`, `updateCollege()`, `deleteCollege()`
- Course operations: `getCoursesByCollege()`, `createCourse()`, `updateCourse()`, `deleteCourse()`
- Fee operations: `getFeesByCourse()`, `createFee()`, `updateFee()`, `deleteFee()`
- Seat operations: `getSeatsByCourse()`, `createSeat()`, `updateSeat()`, `deleteSeat()`
- Cutoff operations: `getCutoffsByCourse()`, `createCutoff()`, `updateCutoff()`, `deleteCutoff()`

**`reviewService.js`** - Review operations:
- Public: `getReviewsByCollege()`, `getReviewStats()`, `submitReview()`
- Admin: `getAllReviews()`, `getPendingReviews()`, `approveReview()`, `deleteReview()`

**`leadService.js`** - Lead management:
- Public: `submitLead()`
- Admin: `getAllLeads()`, `getLeadsByStatus()`, `updateLeadStatus()`

**`analyticsService.js`** - Analytics & auth:
- `getDashboardData()`, `trackPageVisit()`, `getCollegeViews()`
- `login(credentials)`

**`notificationService.js`** - Notification management:
- Public: `getActiveNotifications()`
- Admin: `getAllNotifications()`, `createNotification()`, `toggleNotification()`, `deleteNotification()`

### 5.4 Context Providers

**`AuthContext.jsx`**
- Stores JWT token and user info in `localStorage`
- Provides `login()`, `logout()`, `isAuthenticated`, `user` to all components
- Initializes from localStorage on app load

**`ThemeContext.jsx`**
- Dark/light mode toggle
- Persists preference in `localStorage`
- Uses Tailwind CSS `class` strategy (`dark` class on `<html>`)

---

## 6. Authentication & Security

### Authentication Flow

```
1. Admin submits email + password to POST /api/auth/login
                    │
2. AuthService authenticates via Spring AuthenticationManager
                    │
3. CustomUserDetailsService loads user from DB
                    │
4. On success, JwtUtil generates signed HS256 JWT (24h expiry)
                    │
5. JWT returned to frontend, stored in localStorage
                    │
6. Frontend Axios interceptor attaches "Authorization: Bearer <token>"
                    │
7. JwtAuthenticationFilter validates JWT on every request
                    │
8. On valid token, SecurityContext is populated → request proceeds
```

### Public Endpoints (No Authentication Required)

```
POST   /api/auth/login
GET    /api/colleges/**
GET    /api/courses/**
GET    /api/seats/**
GET    /api/fees/**
GET    /api/cutoffs/**
POST   /api/leads/submit
POST   /api/tracking/
GET    /api/tracking/**
GET    /api/notifications/active
GET    /api/reviews/college/**
POST   /api/reviews
GET    /api/actuator/**
```

### Protected Endpoints (JWT Required)

All other endpoints require a valid JWT token in the `Authorization` header.

### Security Configuration

| Setting | Value |
|---------|-------|
| Password Encoding | BCrypt |
| JWT Algorithm | HS256 |
| JWT Expiry | 24 hours (86400000 ms) |
| Session Management | Stateless |
| CSRF | Disabled (stateless API) |
| CORS | Configured for allowed origins |

### CORS Allowed Origins

```
http://localhost:5173    (Vite dev server)
http://localhost:5174    (Vite alt port)
http://localhost:3000    (React dev server)
https://knowyourcampus.in
https://www.knowyourcampus.in
```

### Default Admin Accounts (Seeded)

| Email | Password | Role |
|-------|----------|------|
| admin@knowyourcampus.com | Admin@123 | ADMIN |
| princesulekhiya@gmail.com | Prince@123 | ADMIN |

> **Note:** Change these credentials in production environments.

---

## 7. Database Configuration

### Development (Local)

```properties
Database:      MySQL 8.x
Host:          localhost
Port:          3306
Database Name: knowyourcampus (auto-created)
DDL Strategy:  update (auto-migrate schema)
SQL Logging:   Enabled
```

### Connection URL

```
jdbc:mysql://localhost:3306/knowyourcampus?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
```

### Tables (Auto-generated by Hibernate)

| Table Name | Entity |
|---|---|
| `admin_users` | AdminUser |
| `colleges` | College |
| `courses` | Course |
| `fee_structure` | FeeStructure |
| `seat_matrix` | SeatMatrix |
| `cutoffs` | Cutoff |
| `college_reviews` | CollegeReview |
| `student_leads` | StudentLead |
| `notifications` | Notification |
| `page_tracking` | PageTracking |

---

## 8. API Reference

### Example: Login

**Request:**
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "admin@knowyourcampus.com",
  "password": "Admin@123"
}
```

**Response (200 OK):**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "email": "admin@knowyourcampus.com",
  "fullName": "Admin",
  "role": "ADMIN"
}
```

### Example: Get All Colleges

**Request:**
```http
GET /api/colleges
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Rajiv Gandhi Proudyogiki Vishwavidyalaya",
    "type": "GOVERNMENT",
    "city": "Bhopal",
    "state": "Madhya Pradesh",
    "naacRating": "A+",
    "admissionOpen": true,
    "logoUrl": "https://...",
    "bannerUrl": "https://...",
    "facilities": "Library, Hostel, Sports, Wi-Fi",
    "affiliatedTo": "UGC",
    "establishedYear": 1998,
    "courses": [...]
  }
]
```

### Example: Submit Lead

**Request:**
```http
POST /api/leads/submit
Content-Type: application/json

{
  "studentName": "Rahul Sharma",
  "mobile": "9876543210",
  "email": "rahul@example.com",
  "city": "Bhopal",
  "state": "Madhya Pradesh",
  "interestedCourse": "B.Tech",
  "interestedSpecialization": "Computer Science",
  "collegeId": 1,
  "leadSource": "WEBSITE"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "studentName": "Rahul Sharma",
  "status": "NEW",
  "createdAt": "2026-02-18T10:30:00"
}
```

### Example: Filter Colleges

**Request:**
```http
GET /api/colleges/filter?type=GOVERNMENT&state=Madhya Pradesh&naac=A+&admissionOpen=true
```

### Example: Submit Review

**Request:**
```http
POST /api/reviews
Content-Type: application/json

{
  "collegeId": 1,
  "studentName": "Priya Singh",
  "studentEmail": "priya@example.com",
  "rating": 4,
  "reviewTitle": "Great Campus",
  "reviewText": "Amazing faculty and great placement support.",
  "course": "B.Tech CSE",
  "batchYear": "2024"
}
```

### Lead Status Lifecycle

```
NEW → CONTACTED → QUALIFIED → CONVERTED
                            → LOST
```

---

## 9. Deployment Guide

### Architecture Overview

```
┌──────────────────┐       ┌─────────────────────┐
│   Vercel CDN     │       │   AWS EC2 / Railway  │
│   (Frontend)     │       │   (Backend)          │
│                  │       │                      │
│  React SPA       │──────→│  Spring Boot API     │
│  Static Assets   │ HTTPS │  Port 8080/8081      │
└──────────────────┘       │                      │
                           │  ┌────────────────┐  │
                           │  │  MySQL 8.x     │  │
                           │  │  (RDS/Railway)  │  │
                           │  └────────────────┘  │
                           └─────────────────────┘
                                     │
                           ┌─────────┴──────────┐
                           │  AWS CloudWatch     │
                           │  (Logs + Metrics)   │
                           └────────────────────┘
```

### Frontend Deployment (Vercel)

1. Connect repository to Vercel
2. Configuration from `vercel.json`:
   - Build: `npm run build`
   - Output: `dist/`
   - Framework: Vite
   - SPA rewrite: All routes → `/index.html`
   - Security headers configured

### Backend Deployment

**Build:**
```bash
cd backend
mvn clean package -DskipTests
```

**Run:**
```bash
java -jar target/knowyourcampus-backend-1.0.0.jar --spring.profiles.active=prod
```

### Nginx Configuration (Production)

The `nginx.conf` handles:
- HTTP → HTTPS redirect (port 80 → 443)
- SSL termination with Let's Encrypt certificates
- Static frontend files from `/var/www/html`
- API proxy: `/api` → `http://localhost:8080`
- Upload file serving from `/opt/knowyourcampus/uploads`
- Security headers (HSTS, X-Frame-Options, X-Content-Type-Options, X-XSS-Protection)

### SSL Setup

```bash
sudo certbot --nginx -d knowyourcampus.in -d www.knowyourcampus.in
```

---

## 10. AWS & Monitoring

### Spring Boot Actuator

Actuator endpoints are enabled and publicly accessible at `/api/actuator/`.

### CloudWatch Logs (Production Only)

- **Appender:** `ca.pjer.logback.AwsLogsAppender`
- **Log Group:** `KnowYourCampus-Logs`
- **Log Stream:** `Backend-Stream`
- **Region:** `ap-south-1` (Mumbai)
- **Retention:** 7 days
- **Batching:** 50 events, 5-second flush interval

Configuration in `logback-spring.xml` (active only with `prod` Spring profile).

### CloudWatch Metrics

- **Registry:** `micrometer-registry-cloudwatch2`
- **Status:** Disabled locally (`management.metrics.export.cloudwatch.enabled=false`)
- **Enabled in production** via profile-specific configuration

---

## 11. Data Seeding

Three `CommandLineRunner` seeders run automatically on application startup:

| Seeder | Scope | Data |
|--------|-------|------|
| `DataSeeder` | Global | Admin users + core Bhopal colleges |
| `BhopalCollegeSeeder` | Bhopal | Additional Bhopal city colleges |
| `MPCollegeSeeder` | Madhya Pradesh | Colleges across MP cities (Indore, Gwalior, Jabalpur, Ujjain, Rewa, Sagar, etc.) |

All seeders are **idempotent** - they check for existing data before inserting to prevent duplicate entries on restart.

### Seed Data Includes

For each college:
- College details (name, type, city, state, NAAC, facilities)
- Courses (B.Tech, MBA, BCA, MCA, etc.)
- Fee structures per course
- Seat matrix by category (General, OBC, SC, ST, EWS)
- Cutoff data by exam type and round

---

## 12. SEO Strategy

### Implementation

- **React Helmet Async:** Dynamic `<title>`, `<meta description>`, Open Graph tags per page
- **SEO Component:** Reusable `<SEO>` wrapper for consistent meta tag management
- **Sitemap:** `public/sitemap.xml` for search engine crawling
- **Security Headers:** Via Vercel config and Nginx

### SEO-Optimized Pages

| Page | Title Pattern | Description |
|------|---------------|-------------|
| Home | "Know Your Campus - Find Best Colleges in India" | Landing page meta |
| Colleges | "Browse Colleges - Know Your Campus" | Listing page meta |
| College Detail | "{College Name} - Know Your Campus" | Dynamic per-college meta |
| Compare | "Compare Colleges - Know Your Campus" | Comparison tool meta |

---

## 13. Environment Variables & Configuration

### Backend (`application.properties`)

| Property | Description | Default |
|----------|-------------|---------|
| `server.port` | Application port | `8081` |
| `server.servlet.context-path` | API base path | `/api` |
| `spring.datasource.url` | MySQL connection URL | `localhost:3306/knowyourcampus` |
| `spring.datasource.username` | DB username | `root` |
| `spring.datasource.password` | DB password | *(configured)* |
| `spring.jpa.hibernate.ddl-auto` | Schema strategy | `update` |
| `jwt.secret` | JWT signing key (256-bit) | *(configured)* |
| `jwt.expiration` | JWT token TTL (ms) | `86400000` (24h) |
| `cors.allowed.origins` | Allowed CORS origins | `localhost:5173,localhost:3000` |
| `management.metrics.export.cloudwatch.enabled` | CloudWatch metrics | `false` |

### Frontend

| Variable | Description |
|----------|-------------|
| API Base URL | Configured in `api.js` via Axios baseURL |
| Vite proxy | Dev server proxies `/api` to backend |

---

## 14. Development Setup

### Prerequisites

- **Java 21** (JDK)
- **Maven** (latest)
- **Node.js** 18+ and **npm**
- **MySQL 8.x**

### Backend Setup

```bash
# 1. Clone repository
git clone <repository-url>
cd collageweb/backend

# 2. Configure database (MySQL must be running)
# Edit src/main/resources/application.properties if needed

# 3. Build and run
mvn spring-boot:run

# Backend starts at http://localhost:8081/api
```

### Frontend Setup

```bash
# 1. Navigate to frontend
cd collageweb/frontend

# 2. Install dependencies
npm install

# 3. Start dev server
npm run dev

# Frontend starts at http://localhost:5173
```

### Quick Verification

1. Backend health: `GET http://localhost:8081/api/actuator/health`
2. Frontend: Open `http://localhost:5173` in browser
3. Admin login: Use `admin@knowyourcampus.com` / `Admin@123`
4. Check colleges: `GET http://localhost:8081/api/colleges`

---

## 15. Feature Highlights

### 1. College Discovery
- Browse all colleges with card-based UI
- Advanced filtering: type, city, state, NAAC rating, admission status
- Full-text search across college names, cities, and states
- Animated UI with Framer Motion

### 2. College Comparison Tool
- Select 2-3 colleges for side-by-side comparison
- Compare courses, fees, seats, cutoffs, ratings

### 3. Detailed College Pages
- Full info: about, facilities, courses, fees, seat matrix, cutoffs
- Review section with star ratings
- Admission CTA with lead capture

### 4. Review & Rating System
- Students submit reviews with 1-5 star ratings
- Admin moderation (approve/reject) before public display
- Average rating calculation per college
- Verified badge support

### 5. Lead Management (CRM)
- Public admission inquiry form
- Lead lifecycle: `NEW → CONTACTED → QUALIFIED → CONVERTED/LOST`
- Admin can filter, view details, add remarks, update status
- Auto-capture IP and session for tracking

### 6. Analytics Dashboard
- Total colleges, courses, leads, page views
- Top viewed colleges
- Lead status breakdown
- Recent leads overview

### 7. Notification System
- Scrolling ticker bar for exam dates and admission alerts
- Admin-managed: create, toggle, delete notifications
- Urgency flag for important notifications

### 8. Dark Mode
- Full dark mode via Tailwind CSS class strategy
- Toggle in navigation bar
- Persisted in localStorage

### 9. Page View Tracking
- Every page visit tracked with metadata
- Session ID, IP, user agent, referrer
- Aggregated into college popularity metrics

### 10. SEO Optimized
- Dynamic meta tags per page
- Sitemap for search engines
- Security headers
- Clean URLs with React Router

---

## Appendix: Quick Reference Commands

| Task | Command |
|------|---------|
| Start backend | `cd backend && mvn spring-boot:run` |
| Start frontend | `cd frontend && npm run dev` |
| Build backend JAR | `cd backend && mvn clean package -DskipTests` |
| Build frontend | `cd frontend && npm run build` |
| Run backend JAR | `java -jar backend/target/knowyourcampus-backend-1.0.0.jar` |
| Run with prod profile | `java -jar backend/target/*.jar --spring.profiles.active=prod` |

---

*This documentation was generated for Know Your Campus v2.0 - February 2026*
