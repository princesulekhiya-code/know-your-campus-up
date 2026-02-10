#!/bin/bash

# Domain Setup Script for knowyourcampus.in
# This script configures the domain and SSL certificate

set -e

DOMAIN="knowyourcampus.in"
WWW_DOMAIN="www.knowyourcampus.in"
EMAIL="princesulekhiya@gmail.com"

echo "🌐 Setting up domain: $DOMAIN"

# Step 1: Update Nginx configuration
echo "📝 Updating Nginx configuration..."
sudo cp nginx.conf /etc/nginx/sites-available/default

# Test Nginx configuration
echo "✅ Testing Nginx configuration..."
sudo nginx -t

# Reload Nginx
echo "🔄 Reloading Nginx..."
sudo systemctl reload nginx

echo "✅ Nginx configuration updated successfully!"

# Step 2: Install Certbot (if not already installed)
echo "📦 Installing Certbot..."
sudo apt update
sudo apt install -y certbot python3-certbot-nginx

# Step 3: Obtain SSL Certificate
echo "🔐 Obtaining SSL certificate from Let's Encrypt..."
echo "⚠️  Make sure DNS is already pointing to this server!"
read -p "Press Enter to continue or Ctrl+C to cancel..."

sudo certbot --nginx \
    -d $DOMAIN \
    -d $WWW_DOMAIN \
    --non-interactive \
    --agree-tos \
    --email $EMAIL \
    --redirect

echo "✅ SSL certificate installed successfully!"

# Step 4: Test auto-renewal
echo "🔄 Testing certificate auto-renewal..."
sudo certbot renew --dry-run

echo ""
echo "🎉 Domain setup complete!"
echo ""
echo "Your site is now available at:"
echo "  - https://$DOMAIN"
echo "  - https://$WWW_DOMAIN"
echo ""
echo "SSL certificate will auto-renew before expiration."
