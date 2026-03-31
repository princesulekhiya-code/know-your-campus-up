# MySQL to Supabase (PostgreSQL) Migration Guide

> **Project:** Know Your Campus  
> **Date:** March 29, 2026  
> **Migration:** MySQL (localhost) → Supabase PostgreSQL (Cloud)

---

## Overview

इस migration में backend database को local MySQL से **Supabase PostgreSQL** (cloud-hosted) पर shift किया गया। Supabase free tier use हो रहा है।

### Supabase Project Details

| Property | Value |
|----------|-------|
| **Project Name** | collage |
| **Project URL** | `https://rlukiinxhenznsrbkurk.supabase.co` |
| **Region** | Northeast Asia (Seoul) - `ap-northeast-2` |
| **Plan** | Free (Nano) |
| **Database** | PostgreSQL |

---

## Changes Summary

### 1. `pom.xml` — Driver Change

MySQL driver हटाया, PostgreSQL driver add किया।

**Before:**
```xml
<!-- MySQL Driver -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

**After:**
```xml
<!-- PostgreSQL Driver (Supabase) -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

### 2. `application.properties` — Local Dev Config

**Before (MySQL):**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/knowyourcampus?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=Prince@123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

**After (Supabase PostgreSQL via Pooler):**
```properties
spring.datasource.url=jdbc:postgresql://aws-0-ap-northeast-2.pooler.supabase.com:6543/postgres?sslmode=require&prepareThreshold=0&connectTimeout=30&socketTimeout=60
spring.datasource.username=postgres.rlukiinxhenznsrbkurk
spring.datasource.password=Prince@123321@
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.hikari.connection-timeout=60000
spring.datasource.hikari.maximum-pool-size=5

# dialect auto-detected by Hibernate (no explicit dialect needed)
```

**Key parameters explained:**

| Parameter | Purpose |
|-----------|---------|
| `sslmode=require` | Supabase requires SSL connections |
| `prepareThreshold=0` | Supabase Pooler (PgBouncer) transaction mode compatibility |
| `connectTimeout=30` | 30 sec connection timeout (Seoul region latency) |
| `socketTimeout=60` | 60 sec socket timeout |
| `hikari.connection-timeout=60000` | HikariCP pool 60 sec timeout |
| `hikari.maximum-pool-size=5` | Free tier ke liye limited pool |

---

### 3. `application-prod.properties` — Production Config

**Before (MySQL):**
```properties
spring.datasource.url=jdbc:mysql://${DB_HOST:localhost}:3306/${DB_NAME:knowyourcampus}?useSSL=true&requireSSL=false&serverTimezone=Asia/Kolkata
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:password}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**After (Supabase PostgreSQL via Pooler):**
```properties
spring.datasource.url=jdbc:postgresql://${DB_HOST:aws-0-ap-northeast-2.pooler.supabase.com}:6543/${DB_NAME:postgres}?sslmode=require&prepareThreshold=0
spring.datasource.username=${DB_USERNAME:postgres.rlukiinxhenznsrbkurk}
spring.datasource.password=${DB_PASSWORD:Prince@123321@}
spring.datasource.driver-class-name=org.postgresql.Driver

# dialect auto-detected by Hibernate
```

---

### 4. `.github/workflows/deploy-aws.yml` — CI/CD Update

`.env.prod` file generation में `DB_NAME` update किया:

**Before:**
```yaml
echo "DB_NAME=knowyourcampus" >> .env.prod
```

**After:**
```yaml
echo "DB_NAME=postgres" >> .env.prod
```

---

### 5. JPA Entities — No Changes Required

सभी entities generic JPA annotations use करती हैं (`@Entity`, `@Table`, `@Column`, `@GeneratedValue`) — कोई MySQL-specific code नहीं था, इसलिए entities में कोई change नहीं लगा।

---

## Connection Types — Direct vs Pooler

### Direct Connection (Port 5432)
```
Host: db.rlukiinxhenznsrbkurk.supabase.co
Port: 5432
Username: postgres
```
- Network/firewall port 5432 block कर सकता है
- Long-running connections के लिए best

### Pooler Connection (Port 6543) ← Currently Used
```
Host: aws-0-ap-northeast-2.pooler.supabase.com
Port: 6543
Username: postgres.rlukiinxhenznsrbkurk
```
- PgBouncer-based connection pooling
- Firewall-friendly port
- `prepareThreshold=0` ज़रूरी है (transaction mode)

---

## Errors Encountered & Fixes

### Error 1: Password Authentication Failed
```
PSQLException: FATAL: password authentication failed for user "postgres.rlukiinxhenznsrbkurk"
```
**Fix:** Correct password set किया (`Prince@123321@`)

### Error 2: Connection Timed Out (Port 5432)
```
PSQLException: Connection to db.rlukiinxhenznsrbkurk.supabase.co:5432 refused
java.net.ConnectException: Connection timed out
```
**Fix:** Direct connection (port 5432) से Pooler connection (port 6543) पर switch किया। ISP/firewall port 5432 block कर रहा था।

### Error 3: Cannot Determine Hibernate Dialect
```
Unable to determine Dialect without JDBC metadata
```
**Fix:** Connection timeout बढ़ाया और pooler URL use किया ताकि Hibernate successfully connect हो सके और dialect auto-detect कर सके।

---

## How to Verify

### 1. Backend Start करो
IntelliJ में `KnowYourCampusApplication` run करो। Console में देखो:
```
HikariPool-1 - Starting...
HikariPool-1 - Start completed.
Tomcat started on port 8081
```

### 2. Supabase Dashboard Check करो
- https://supabase.com/dashboard/project/rlukiinxhenznsrbkurk
- **Table Editor** section में tables verify करो
- Hibernate `ddl-auto=update` automatically tables create करेगा

### 3. API Test करो
```bash
# Health check
curl http://localhost:8081/api/actuator/health

# Colleges list
curl http://localhost:8081/api/colleges
```

### 4. Frontend Test करो
```bash
cd frontend
npm run dev
# Open http://localhost:5173
```

---

## File Changes Summary

| File | Change |
|------|--------|
| `backend/pom.xml` | `mysql-connector-j` → `postgresql` |
| `backend/src/main/resources/application.properties` | MySQL → Supabase Pooler config |
| `backend/src/main/resources/application-prod.properties` | MySQL → Supabase Pooler config (env vars) |
| `.github/workflows/deploy-aws.yml` | `DB_NAME=knowyourcampus` → `DB_NAME=postgres` |
| `backend/src/main/java/.../entity/*` | No changes needed |

---

## Important Notes

- **Free Tier Limits:** Supabase free tier has limited connections — `maximum-pool-size=5` recommended
- **Region Latency:** Project Seoul region में है, India se connect करने पर ~200-400ms latency expected
- **SSL Required:** Supabase हमेशा SSL require करता है — `sslmode=require` हटाना मत
- **Pooler Mode:** `prepareThreshold=0` हमेशा रखो जब pooler use करो (PgBouncer transaction mode)
