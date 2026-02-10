#!/bin/bash

# =================================================================
#  EC2 SERVER SETUP SCRIPT - KNOWYOURCAMPUS
#  Installs: Java 17, Nginx, Certbot (SSL)
# =================================================================

echo "🚀 Starting Server Setup..."

# 1. Update Server
echo "📦 Updating System..."
sudo apt update && sudo apt upgrade -y

# 2. Install Java 17 (Required for Backend)
echo "☕ Installing Java 17..."
sudo apt install openjdk-17-jdk -y
java -version

# 3. Install Nginx (Required for Frontend)
echo "🌐 Installing Nginx..."
sudo apt install nginx -y

# 4. Install Certbot (Required for HTTPS/SSL)
echo "🔒 Installing Certbot..."
sudo apt install certbot python3-certbot-nginx -y

# 5. Create Project Directories
echo "📁 Creating Directories..."
sudo mkdir -p /var/www/html
sudo mkdir -p /opt/knowyourcampus

# 6. Set Permissions (Make 'ubuntu' user owner)
echo "🔑 Setting Permissions..."
sudo chown -R ubuntu:ubuntu /var/www/html
sudo chown -R ubuntu:ubuntu /opt/knowyourcampus

# 7. Create Systemd Service for Spring Boot
echo "⚙️ Creating Backend Service..."
sudo bash -c 'cat > /etc/systemd/system/knowyourcampus.service <<EOF
[Unit]
Description=Know Your Campus Backend
After=network.target

[Service]
Type=simple
User=ubuntu
WorkingDirectory=/opt/knowyourcampus
ExecStart=/usr/bin/java -jar /opt/knowyourcampus/app.jar --spring.profiles.active=prod
Restart=on-failure
RestartSec=10

[Install]
WantedBy=multi-user.target
EOF'

# 8. Reload & Enable Services
echo "🔄 Reloading Services..."
sudo systemctl daemon-reload
sudo systemctl enable knowyourcampus
sudo systemctl enable nginx

echo "✅ Server Setup Complete! Ready for Deployment."
