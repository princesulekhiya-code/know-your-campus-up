# DNS Configuration Guide for knowyourcampus.in

## 🌐 Domain Setup Instructions

### Step 1: Configure DNS Records

Login to your domain registrar (where you bought knowyourcampus.in) and add these DNS records:

#### A Records (Required)

| Type | Name | Value | TTL |
|------|------|-------|-----|
| A | @ | 43.205.141.253 | 3600 |
| A | www | 43.205.141.253 | 3600 |

**Explanation:**
- `@` represents the root domain (knowyourcampus.in)
- `www` is for www.knowyourcampus.in
- `43.205.141.253` is your EC2 instance public IP
- `3600` seconds (1 hour) is the TTL (Time To Live)

### Step 2: Wait for DNS Propagation

DNS changes can take anywhere from **5 minutes to 48 hours** to propagate globally.

**Check DNS propagation:**
```bash
# Check if DNS is pointing to your server
nslookup knowyourcampus.in
nslookup www.knowyourcampus.in

# Or use online tools:
# https://dnschecker.org
# https://www.whatsmydns.net
```

Expected output:
```
Server:  dns.google
Address:  8.8.8.8

Name:    knowyourcampus.in
Address:  43.205.141.253
```

### Step 3: Deploy Updated Nginx Configuration

Once DNS is propagating, update the server configuration:

```bash
# SSH into your EC2 instance
ssh -i knowyourcampus-key.pem ubuntu@43.205.141.253

# Upload the new nginx.conf
# (This will be done via GitHub Actions or manually)

# Copy nginx config
sudo cp nginx.conf /etc/nginx/sites-available/default

# Test configuration
sudo nginx -t

# Reload Nginx
sudo systemctl reload nginx
```

### Step 4: Install SSL Certificate

After DNS is fully propagated (verify with nslookup), install SSL:

```bash
# SSH into your EC2 instance
ssh -i knowyourcampus-key.pem ubuntu@43.205.141.253

# Run the domain setup script
chmod +x setup-domain.sh
sudo ./setup-domain.sh
```

**Or manually:**

```bash
# Install Certbot
sudo apt update
sudo apt install -y certbot python3-certbot-nginx

# Obtain certificate
sudo certbot --nginx -d knowyourcampus.in -d www.knowyourcampus.in

# Follow the prompts:
# - Enter email: princesulekhiya@gmail.com
# - Agree to terms: Yes
# - Redirect HTTP to HTTPS: Yes (option 2)
```

### Step 5: Verify Setup

After SSL installation:

1. **Test HTTP redirect:**
   ```bash
   curl -I http://knowyourcampus.in
   # Should return 301 redirect to https://
   ```

2. **Test HTTPS:**
   ```bash
   curl -I https://knowyourcampus.in
   # Should return 200 OK
   ```

3. **Visit in browser:**
   - https://knowyourcampus.in
   - https://www.knowyourcampus.in

4. **Check SSL certificate:**
   - Click the padlock icon in browser
   - Should show "Let's Encrypt" certificate
   - Valid for 90 days (auto-renews)

### Step 6: Update Frontend Configuration (if needed)

If your frontend has hardcoded API URLs, update them:

**Before:**
```javascript
const API_URL = 'http://43.205.141.253/api';
```

**After:**
```javascript
const API_URL = '/api'; // Relative URL (recommended)
// or
const API_URL = 'https://knowyourcampus.in/api';
```

---

## 🔧 Common DNS Providers

### GoDaddy
1. Login to GoDaddy
2. Go to "My Products" → "DNS"
3. Click "Manage DNS"
4. Add A records as shown above

### Namecheap
1. Login to Namecheap
2. Go to "Domain List" → Click "Manage"
3. Go to "Advanced DNS"
4. Add A records as shown above

### Cloudflare
1. Login to Cloudflare
2. Select your domain
3. Go to "DNS" tab
4. Add A records as shown above
5. **Important**: Set Proxy status to "DNS only" (gray cloud) initially

### Hostinger
1. Login to Hostinger
2. Go to "Domains" → Select domain
3. Click "DNS / Nameservers"
4. Add A records as shown above

---

## 🐛 Troubleshooting

### DNS not propagating?
- Wait longer (up to 48 hours)
- Clear your DNS cache:
  ```bash
  # Windows
  ipconfig /flushdns
  
  # Mac/Linux
  sudo dscacheutil -flushcache
  ```

### SSL certificate fails?
- Ensure DNS is fully propagated first
- Check that ports 80 and 443 are open in EC2 security group
- Verify Nginx is running: `sudo systemctl status nginx`

### "Connection not secure" warning?
- SSL certificate might not be installed yet
- Run: `sudo certbot --nginx -d knowyourcampus.in -d www.knowyourcampus.in`

### Website shows Nginx default page?
- Frontend files might not be deployed
- Check: `ls -la /var/www/html`
- Redeploy via GitHub Actions

---

## 📋 Quick Reference

**Your EC2 IP:** 43.205.141.253
**Your Domain:** knowyourcampus.in
**Nameservers:** (Check with your domain provider)

**DNS Records to Add:**
```
A @ 43.205.141.253
A www 43.205.141.253
```

**After DNS propagates, run:**
```bash
sudo ./setup-domain.sh
```

---

## ✅ Checklist

- [ ] DNS A records added for @ and www
- [ ] DNS propagation verified (nslookup)
- [ ] Nginx configuration updated with domain name
- [ ] SSL certificate installed via Certbot
- [ ] HTTP to HTTPS redirect working
- [ ] Website accessible at https://knowyourcampus.in
- [ ] API endpoints working via domain
- [ ] SSL auto-renewal configured

---

**Need Help?**
- Check DNS: https://dnschecker.org
- Test SSL: https://www.ssllabs.com/ssltest/
- Nginx docs: https://nginx.org/en/docs/
- Certbot docs: https://certbot.eff.org/

**Last Updated:** February 10, 2026
