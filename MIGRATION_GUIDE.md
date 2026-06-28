# Know Your Campus - Migration & Architecture Guide

This document provides a comprehensive overview of the migrated infrastructure, configuration settings, and codebase updates for **Know Your Campus**. Use this guide to manage, troubleshoot, and deploy changes to the application in the future.

---

## 🏗️ Current Architecture

The application has been successfully migrated from AWS Free Tier to a fully managed, high-performance, and cost-effective stack:

| Component | Platform | URL / Host | Description |
| :--- | :--- | :--- | :--- |
| **Frontend** | **Vercel** | [https://knowyourcampus.in](https://knowyourcampus.in) | Single Page Application (SPA) built with React + Vite. |
| **Backend** | **Render** | [https://knowyourcampus-backend.onrender.com](https://knowyourcampus-backend.onrender.com) | Spring Boot Java REST API running in a Docker container. |
| **Database** | **Supabase** | `aws-1-ap-northeast-2.pooler.supabase.com` | PostgreSQL Database with built-in connection pooling. |

---

## 🛠️ Codebase Modifications Made

Several updates were made to decouple the application from AWS and enable smooth local/production deployments.

### 1. Frontend API URL Configuration
* **File modified**: `frontend/src/services/api.js`
* **Change**: Changed hardcoded endpoints to use `import.meta.env.VITE_API_URL` with a fallback to `/api`. This allows Vercel to dynamically direct requests to Render.

### 2. AWS CloudWatch Removal (Logging)
* **File modified**: `backend/src/main/resources/logback-spring.xml`
* **Change**: Stripped out the `AwsLogsAppender` (`CLOUDWATCH`) in the `prod` profile. Render captures `stdout`/`stderr` logs automatically, eliminating the need for AWS-specific logging libraries.

### 3. AWS Metrics Disabling
* **File modified**: `backend/src/main/resources/application-prod.properties`
* **Change**: Set `management.metrics.export.cloudwatch.enabled=false`. This prevents the application context from crashing during startup on non-AWS environments.

### 4. Database Connection Parameterization
* **File modified**: `backend/src/main/resources/application-prod.properties`
* **Change**: Parameterized host, username, password, and port settings using placeholders with working default fallbacks to Supabase:
  ```properties
  spring.datasource.url=jdbc:postgresql://${DB_HOST:aws-1-ap-northeast-2.pooler.supabase.com}:${DB_PORT:5432}/${DB_NAME:postgres}?sslmode=require&prepareThreshold=0
  spring.datasource.username=${DB_USERNAME:postgres.rlukiinxhenznsrbkurk}
  spring.datasource.password=${DB_PASSWORD:Prince@123321@}
  ```

### 5. Dynamic CORS Origins Configuration
* **File modified**: `backend/src/main/java/com/knowyourcampus/security/SecurityConfig.java`
* **Change**: Replaced hardcoded origins inside `corsConfigurationSource()` with a dynamic parser that reads the `cors.allowed.origins` property. This allows origins configured via Render (`CORS_ORIGINS`) to be parsed dynamically.

---

## 🚀 Deployment & Configurations

Both Vercel and Render are integrated directly with your GitHub repository. **Pushing code to the `main` branch automatically triggers new builds and deployments on both platforms.**

### 1. Render Backend Configurations
In your Render Dashboard (`knowyourcampus-backend` Web Service), configure only these environment variables:

| Environment Variable | Value | Purpose |
| :--- | :--- | :--- |
| **`SPRING_PROFILES_ACTIVE`** | `prod` | Activates production database and logging profiles. |
| **`JWT_SECRET`** | `KnowYourCampus2026SecretKeyFor...` | Secret key for JWT generation. |
| **`CORS_ORIGINS`** | `https://know-your-campus-up.vercel.app,https://knowyourcampus.in,https://www.knowyourcampus.in` | Comma-separated list of frontends allowed to request the API. |

> [!NOTE]
> Database environment variables (`DB_HOST`, `DB_PORT`, etc.) are left blank in Render settings. The backend automatically falls back to the correct Supabase credentials configured in `application-prod.properties`.

---

### 2. Vercel Frontend Configurations
In your Vercel Project Dashboard (`know-your-campus-up`), configure this environment variable:

| Environment Variable | Value | Purpose |
| :--- | :--- | :--- |
| **`VITE_API_URL`** | `https://knowyourcampus-backend.onrender.com/api` | Directs React API calls to the Render backend service. |

---

### 3. DNS Configuration (Hostinger)
To link your custom domain `knowyourcampus.in` to the new Vercel frontend, verify that the following records are set in your **Hostinger DNS Zone Editor**:

| Type | Name | Value | TTL |
| :--- | :--- | :--- | :--- |
| **`A`** | `@` | `216.198.79.1` | `14400` |
| **`CNAME`** | `www` | *Your unique Vercel DNS string* (e.g., `267e9c7a5e0c2ae8.vercel-dns-017.com`) | `14400` |

*Make sure all old A/CNAME records pointing to the AWS EC2 instance are deleted.*

---

## 🔍 Future Troubleshooting Checklist

### 🔴 Problem: Frontend shows "No colleges found" (Backend Connection Error)
1. **Check if Supabase is Paused**:
   * Supabase automatically pauses inactive databases on the free tier after 1 week.
   * Go to [supabase.com/dashboard](https://supabase.com/dashboard) and check the status of the **`collage`** project.
   * If it says "Paused", click **`Restore`** and wait 2 minutes.
2. **Verify CORS Settings**:
   * Inspect the browser console (F12) for CORS blocking errors.
   * Check that your current domain is listed in the `CORS_ORIGINS` variable on Render.

### 🔴 Problem: Render Deployment Fails during Maven build / startup
1. Go to the **Logs** tab on Render.
2. If it says `port is already in use`, it means Render is running a blue-green deployment and it will resolve itself.
3. If it fails with `Unable to determine Dialect`, check your Supabase dashboard status to ensure the database is active and accepting connections.

---
*Created by Antigravity AI on 2026-06-28. Keep this guide in your project root for future reference.*
