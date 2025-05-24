#!/bin/bash

# Build the JAR files
echo "Building JAR files..."
./gradlew clean build -x test

# Rebuild the Docker images
echo "Rebuilding Docker images for development..."
docker compose -f docker-compose.yml build --no-cache

# Start the containers
echo "Starting containers in development mode..."
docker compose -f docker-compose.yml up -d

echo "Services are running!"