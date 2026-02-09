# 🌐 Hostinger Domain Purchase & Setup Guide

## 📋 Complete Guide for Custom Domain Setup

---

## 🎯 Step 1: Buy Domain from Hostinger

### **1.1 Choose Your Domain Name**

**Recommended Domain Names:**
- `knowyourcampus.com` ⭐ (Best - Professional)
- `knowyourcampus.in` (India-specific)
- `campusfinder.in`
- `collegeguide.in`
- `admissionhelp.in`

**Tips for Choosing:**
- ✅ Short and memorable
- ✅ Easy to spell
- ✅ Related to education/colleges
- ✅ .com or .in extension
- ❌ Avoid numbers and hyphens

### **1.2 Purchase from Hostinger**

1. **Go to Hostinger**: https://www.hostinger.in
2. **Search Domain**: Enter your desired domain name
3. **Check Availability**: See if it's available
4. **Select Domain**: Choose .com or .in
5. **Add to Cart**: Click "Add to Cart"
6. **Choose Duration**:
   - 1 year: ~₹699-999 (.com)
   - 1 year: ~₹399-599 (.in)
   - 2 years: Better discount
7. **Complete Payment**: UPI/Card/Net Banking
8. **Confirmation**: You'll receive email confirmation

**Expected Cost:**
- `.com` domain: ₹699-999/year
- `.in` domain: ₹399-599/year
- **Renewal**: Usually higher (₹999-1499/year)

---

## 🚀 Step 2: Deploy Website First

**Important**: पहले website deploy करें, फिर domain connect करें!

### **2.1 Deploy Backend to Railway**

1. Go to https://railway.app
2. Sign up with GitHub
3. Create new project from your repository
4. Add MySQL database
5. Deploy backend
6. **Copy Backend URL**: e.g., `https://knowyourcampus-production.up.railway.app`

### **2.2 Deploy Frontend to Vercel**

1. Go to https://vercel.com
2. Sign up with GitHub
3. Import your repository
4. Set root directory: `frontend`
5. Add environment variable:
   - `VITE_API_URL` = Your Railway backend URL
6. Deploy
7. **Copy Vercel URL**: e.g., `https://knowyourcampus.vercel.app`

---

## 🔗 Step 3: Connect Domain to Vercel

### **3.1 Add Domain in Vercel**

1. Go to Vercel Dashboard
2. Select your project
3. Go to **Settings** → **Domains**
4. Click **Add Domain**
5. Enter your domain: `knowyourcampus.com`
6. Click **Add**

Vercel will show you DNS records to add.

### **3.2 Get DNS Records from Vercel**

Vercel will provide these records:

**For Root Domain (knowyourcampus.com):**
```
Type: A
Name: @
Value: 76.76.21.21
```

**For WWW (www.knowyourcampus.com):**
```
Type: CNAME
Name: www
Value: cname.vercel-dns.com
```

---

## ⚙️ Step 4: Configure DNS in Hostinger

### **4.1 Access Hostinger DNS Management**

1. Login to Hostinger: https://hpanel.hostinger.in
2. Go to **Domains**
3. Click on your domain (knowyourcampus.com)
4. Click **DNS / Name Servers**
5. Click **Manage DNS Records**

### **4.2 Add DNS Records**

**Delete existing A records (if any)**

**Add New Records:**

#### **Record 1: Root Domain**
```
Type: A
Name: @ (or leave blank)
Points to: 76.76.21.21
TTL: 3600 (or Auto)
```

#### **Record 2: WWW Subdomain**
```
Type: CNAME
Name: www
Points to: cname.vercel-dns.com
TTL: 3600 (or Auto)
```

**Click Save/Add Record**

### **4.3 Verify Configuration**

In Hostinger, your DNS records should look like:

| Type | Name | Value | TTL |
|------|------|-------|-----|
| A | @ | 76.76.21.21 | 3600 |
| CNAME | www | cname.vercel-dns.com | 3600 |

---

## ⏰ Step 5: Wait for DNS Propagation

### **Propagation Time:**
- **Minimum**: 15 minutes
- **Average**: 1-2 hours
- **Maximum**: 24-48 hours

### **Check Propagation Status:**

**Option 1: Online Tool**
- Visit: https://www.whatsmydns.net/
- Enter: `knowyourcampus.com`
- Check if it shows Vercel IP

**Option 2: Command Line**
```bash
# Windows
nslookup knowyourcampus.com

# Should show: 76.76.21.21
```

---

## ✅ Step 6: Verify Domain in Vercel

### **6.1 Check Vercel Dashboard**

1. Go to Vercel → Your Project → Domains
2. Wait for verification
3. Status should change to: ✅ **Valid Configuration**

### **6.2 Test Your Domain**

1. Open browser
2. Visit: `https://knowyourcampus.com`
3. Your website should load! 🎉

**Also test:**
- `https://www.knowyourcampus.com`
- Both should work

---

## 🔐 Step 7: Enable HTTPS (Automatic)

Vercel automatically provides free SSL certificate:
- **Certificate**: Let's Encrypt (Free)
- **Renewal**: Automatic
- **HTTPS**: Enabled by default

**Verify HTTPS:**
1. Visit your domain
2. Check for 🔒 lock icon in browser
3. Click lock → Certificate should be valid

---

## 🎯 Step 8: Update Backend CORS

### **8.1 Add Domain to Railway**

1. Go to Railway Dashboard
2. Select your backend service
3. Go to **Variables**
4. Update `CORS_ORIGINS`:
   ```
   CORS_ORIGINS=https://knowyourcampus.com,https://www.knowyourcampus.com,https://*.vercel.app
   ```
5. Save and redeploy

---

## 📊 Step 9: Update SEO & Sitemap

### **9.1 Update Canonical URLs**

**File**: `frontend/index.html`

Replace:
```html
<link rel="canonical" href="https://knowyourcampus.com/" />
```

**File**: `frontend/public/sitemap.xml`

Replace all URLs:
```xml
<loc>https://knowyourcampus.com/</loc>
<loc>https://knowyourcampus.com/colleges</loc>
<!-- etc -->
```

### **9.2 Redeploy Frontend**

```bash
# Commit changes
git add .
git commit -m "Update domain to knowyourcampus.com"
git push

# Vercel will auto-deploy
```

---

## 🔍 Step 10: Submit to Google

### **10.1 Google Search Console**

1. Go to: https://search.google.com/search-console
2. Click **Add Property**
3. Enter: `https://knowyourcampus.com`
4. Verify ownership (DNS method):
   - Google will give you a TXT record
   - Add it in Hostinger DNS
   - Click Verify
5. Submit Sitemap:
   - Go to Sitemaps
   - Enter: `https://knowyourcampus.com/sitemap.xml`
   - Submit

### **10.2 Google Analytics (Optional)**

1. Go to: https://analytics.google.com
2. Create new property
3. Add tracking code to your website
4. Monitor traffic

---

## 📧 Step 11: Professional Email (Optional)

### **Option A: Hostinger Email (Paid)**
- Cost: ~₹99/month
- Email: `admin@knowyourcampus.com`

### **Option B: Google Workspace (Paid)**
- Cost: ~₹125/month per user
- Email: `admin@knowyourcampus.com`
- Includes Gmail, Drive, etc.

### **Option C: Free Alternatives**
- Zoho Mail: Free for 5 users
- Email: `admin@knowyourcampus.com`

---

## 🎊 Complete Setup Checklist

- [ ] Domain purchased from Hostinger
- [ ] Backend deployed to Railway
- [ ] Frontend deployed to Vercel
- [ ] DNS records added in Hostinger
- [ ] Domain verified in Vercel
- [ ] HTTPS enabled (automatic)
- [ ] CORS updated in backend
- [ ] SEO URLs updated
- [ ] Submitted to Google Search Console
- [ ] Sitemap submitted
- [ ] Website accessible on custom domain
- [ ] Email setup (optional)

---

## 💰 Total Cost Breakdown

### **One-Time Costs:**
| Item | Cost |
|------|------|
| Domain (.com) | ₹699-999/year |
| Domain (.in) | ₹399-599/year |

### **Monthly Costs:**
| Service | Cost |
|---------|------|
| Vercel | ₹0 (Free tier) |
| Railway | ₹0 (Free tier) |
| **Total** | **₹0/month** 🎉 |

### **Optional:**
| Service | Cost |
|---------|------|
| Professional Email | ₹99-125/month |
| Premium Hosting | ₹400-1000/month |

**Recommended Starting Cost:**
- Domain: ₹699/year (.com)
- Hosting: ₹0/month (Free tier)
- **Total First Year**: ~₹699 only! 🎉

---

## 🆘 Troubleshooting

### **Domain not working after 24 hours?**

**Check 1: DNS Records**
```bash
nslookup knowyourcampus.com
# Should show: 76.76.21.21
```

**Check 2: Vercel Status**
- Go to Vercel → Domains
- Should show: ✅ Valid Configuration

**Check 3: Clear DNS Cache**
```bash
# Windows
ipconfig /flushdns

# Mac/Linux
sudo dscacheutil -flushcache
```

### **HTTPS not working?**

- Wait 10-15 minutes after domain verification
- Vercel automatically provisions SSL
- Force HTTPS in Vercel settings

### **Website shows "Domain not found"?**

- Check DNS propagation: https://www.whatsmydns.net/
- Wait 1-2 hours
- Verify DNS records in Hostinger

---

## 📞 Support

### **Hostinger Support:**
- Live Chat: Available 24/7
- Email: support@hostinger.in
- Phone: Check Hostinger dashboard

### **Vercel Support:**
- Docs: https://vercel.com/docs
- Community: https://github.com/vercel/vercel/discussions

### **Railway Support:**
- Docs: https://docs.railway.app
- Discord: https://discord.gg/railway

---

## 🎯 Next Steps After Domain Setup

1. **Add Content**: Add more colleges to database
2. **SEO Optimization**: Write blog posts
3. **Social Media**: Create Facebook/Instagram pages
4. **Marketing**: Share with students
5. **Analytics**: Monitor Google Analytics
6. **Feedback**: Collect user feedback
7. **Improvements**: Regular updates

---

## 🎉 Success!

Once domain is connected:

**Your website will be live at:**
- 🌐 **https://knowyourcampus.com**
- 🌐 **https://www.knowyourcampus.com**

**Professional URLs:**
- Home: `https://knowyourcampus.com`
- Colleges: `https://knowyourcampus.com/colleges`
- Admin: `https://knowyourcampus.com/admin`

**Ready to dominate Google Search!** 🚀

---

**Questions?** Check troubleshooting section or contact support.

**Last Updated**: February 9, 2026  
**Estimated Setup Time**: 2-3 hours (including DNS propagation)  
**Difficulty**: Medium (step-by-step guide provided)
