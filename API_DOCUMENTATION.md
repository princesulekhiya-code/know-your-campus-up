# API Documentation - Know Your Campus

## Base URL
```
Development: http://localhost:8080/api
Production: https://api.yourdomain.com/api
```

## Authentication

### Admin Login
**POST** `/auth/login`

Request:
```json
{
  "email": "admin@knowyourcampus.com",
  "password": "Admin@123"
}
```

Response:
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "email": "admin@knowyourcampus.com",
  "fullName": "System Administrator",
  "role": "ADMIN"
}
```

For protected endpoints, include token in header:
```
Authorization: Bearer <token>
```

---

## Colleges

### Get All Colleges
**GET** `/colleges`

Query Parameters:
- `type` (optional): GOVERNMENT | PRIVATE
- `city` (optional): City name
- `state` (optional): State name
- `naacRating` (optional): A++, A+, A, B++, B+, B
- `admissionOpen` (optional): true | false

Response:
```json
[
  {
    "id": 1,
    "name": "Indian Institute of Technology Delhi",
    "description": "IIT Delhi is one of the premier...",
    "type": "GOVERNMENT",
    "city": "New Delhi",
    "state": "Delhi",
    "naacRating": "A++",
    "admissionOpen": true,
    "establishedYear": 1961,
    ...
  }
]
```

### Get College by ID
**GET** `/colleges/{id}`

Response: Single college object

### Search Colleges
**GET** `/colleges/search?q={query}`

Searches in name, city, and state fields.

### Create College (Admin)
**POST** `/colleges`

Request:
```json
{
  "name": "College Name",
  "description": "Description",
  "type": "GOVERNMENT",
  "city": "City",
  "state": "State",
  "address": "Full address",
  "phone": "1234567890",
  "email": "college@example.com",
  "naacRating": "A+",
  "admissionOpen": true
}
```

### Update College (Admin)
**PUT** `/colleges/{id}`

### Delete College (Admin)
**DELETE** `/colleges/{id}`

---

## Courses

### Get Courses by College
**GET** `/courses/college/{collegeId}`

Response:
```json
[
  {
    "id": 1,
    "name": "B.Tech",
    "specialization": "Computer Science",
    "degree": "UG",
    "durationYears": 4,
    "description": "Bachelor of Technology...",
    "eligibility": "JEE Advanced qualified",
    "active": true
  }
]
```

### Create Course (Admin)
**POST** `/courses`

### Update Course (Admin)
**PUT** `/courses/{id}`

### Delete Course (Admin)
**DELETE** `/courses/{id}`

---

## Seat Matrix

### Get Seats by Course
**GET** `/seats/course/{courseId}`

Response:
```json
[
  {
    "id": 1,
    "category": "GENERAL",
    "totalSeats": 50,
    "availableSeats": 10,
    "academicYear": "2026-27"
  }
]
```

### Update Seats (Admin)
**PUT** `/seats/{id}`

---

## Fee Structure

### Get Fees by Course
**GET** `/fees/course/{courseId}`

Response:
```json
[
  {
    "id": 1,
    "academicYear": "2026-27",
    "tuitionFee": 200000,
    "hostelFee": 50000,
    "transportFee": 0,
    "libraryFee": 5000,
    "labFee": 10000,
    "otherFees": 10000,
    "totalFee": 275000,
    "feeType": "PER_YEAR"
  }
]
```

### Update Fees (Admin)
**PUT** `/fees/{id}`

---

## Cutoffs

### Get Cutoffs by Course
**GET** `/cutoffs/course/{courseId}`

Response:
```json
[
  {
    "id": 1,
    "category": "GENERAL",
    "academicYear": "2023-2024",
    "round": "Round 1",
    "cutoffPercentage": 99.5,
    "cutoffRank": 150,
    "examType": "JEE Advanced"
  }
]
```

---

## Student Leads

### Submit Lead
**POST** `/leads/submit`

Request:
```json
{
  "studentName": "John Doe",
  "mobile": "9876543210",
  "email": "john@example.com",
  "city": "Mumbai",
  "state": "Maharashtra",
  "interestedCourse": "B.Tech",
  "interestedSpecialization": "Computer Science",
  "collegeId": 1,
  "collegeName": "IIT Delhi",
  "message": "Interested in admission",
  "leadSource": "ADMISSION_FORM"
}
```

Response:
```json
{
  "id": 1,
  "studentName": "John Doe",
  "status": "NEW",
  "createdAt": "2026-01-04T22:00:00"
}
```

### Get All Leads (Admin)
**GET** `/leads`

### Get Leads by Status (Admin)
**GET** `/leads/status/{status}`

Status: NEW, CONTACTED, QUALIFIED, CONVERTED, LOST

### Get Leads by College (Admin)
**GET** `/leads/college/{collegeId}`

### Update Lead Status (Admin)
**PUT** `/leads/{id}/status?status=CONTACTED&remarks=Called student`

---

## Analytics

### Get Dashboard Data (Admin)
**GET** `/analytics/dashboard`

Response:
```json
{
  "totalColleges": 10,
  "totalCourses": 15,
  "totalLeads": 50,
  "newLeadsToday": 5,
  "totalPageViews": 1000,
  "pageViewsToday": 100,
  "leadsByStatus": {
    "NEW": 20,
    "CONTACTED": 15,
    "QUALIFIED": 10,
    "CONVERTED": 5
  },
  "mostViewedColleges": {
    "IIT Delhi": 150,
    "AIIMS Delhi": 120
  }
}
```

---

## Page Tracking

### Track Page Visit
**POST** `/tracking`

Request:
```json
{
  "pagePath": "/colleges/1",
  "pageTitle": "IIT Delhi",
  "collegeId": 1,
  "sessionId": "session_123",
  "referrer": "https://google.com"
}
```

### Get College View Count
**GET** `/tracking/college/{collegeId}/views`

Response:
```json
150
```

---

## Error Responses

All endpoints return standard error format:

```json
{
  "timestamp": "2026-01-04T22:00:00",
  "message": "Error description",
  "path": "/api/colleges/999"
}
```

HTTP Status Codes:
- `200` - Success
- `201` - Created
- `400` - Bad Request
- `401` - Unauthorized
- `404` - Not Found
- `500` - Internal Server Error

---

## Rate Limiting

Currently no rate limiting implemented. Consider adding in production.

## CORS

Allowed origins configured in backend:
- http://localhost:5173
- http://localhost:3000
- Add production domain in `SecurityConfig.java`

---

For support: princesulekhiya2004@gmail.com
