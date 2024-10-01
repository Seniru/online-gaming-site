# Use a base image
FROM ubuntu:22.04

# Install basic tools
RUN apt-get update && \
    apt-get install -y \
    build-essential \
    curl \
    git \
    sudo \
    gnupg \
    lsb-release \
    wget \
    && rm -rf /var/lib/apt/lists/*

# Install OpenJDK 11
RUN apt-get update && \
    apt-get install -y openjdk-11-jre openjdk-11-jdk && \
    rm -rf /var/lib/apt/lists/*

# Install Tomcat directly from Apache
# Create necessary directories for Tomcat
RUN mkdir -p /var/lib/tomcat9 && \
    mkdir -p /usr/share/tomcat9

# Install Tomcat directly from Apache
RUN curl -O https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.95/bin/apache-tomcat-9.0.95.tar.gz && \
    tar -xvzf apache-tomcat-9.0.95.tar.gz -C /usr/share/tomcat9 && \
    mv /usr/share/tomcat9/apache-tomcat-9.0.95/* /usr/share/tomcat9/ && \
    rm -rf /usr/share/tomcat9/apache-tomcat-9.0.95 && \
    rm apache-tomcat-9.0.95.tar.gz

# Copy and move appropriate directories to the desired locations
RUN cp -r /usr/share/tomcat9/conf /var/lib/tomcat9/ && \
    cp -r /usr/share/tomcat9/lib /var/lib/tomcat9/ && \
    cp -r /usr/share/tomcat9/logs /var/lib/tomcat9/ && \
    mv /usr/share/tomcat9/webapps /var/lib/tomcat9/ && \
    mv /usr/share/tomcat9/work /var/lib/tomcat9/ && \
    cp -r /usr/share/tomcat9/bin /var/lib/tomcat9

# Install mysql
RUN apt-get update && \
    apt-get install -y mariadb-server mariadb-client
# Clean up
RUN rm -rf mysql-apt-config_0.8.22-1_all.deb mysql-8.0.30-1ubuntu20.04_amd64.deb-bundle.tar

# Initialize database
RUN service mariadb start
#RUN mysql -u root -p -e "ALTER USER 'root'@'localhost' IDENTIFIED BY '';"

# Set environment variables
ENV CATALINA_HOME=/var/lib/tomcat9
ENV CATALINA_BASE=/var/lib/tomcat9
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat in the foreground
CMD ["sh", "/usr/share/tomcat9/bin/catalina.sh", "start"]
