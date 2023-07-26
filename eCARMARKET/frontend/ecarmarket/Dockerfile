# Use an official Node.js runtime as the base image
FROM node:14 as build-stage

# Set the working directory inside the container
WORKDIR /app

# Copy the package.json and package-lock.json files to the working directory
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the entire project to the working directory
COPY . .

# Build the Vue.js application
RUN npm run build

# Use a smaller Node.js base image for the production stage
FROM node:14-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built files from the build-stage to the current working directory
COPY --from=build-stage /app/dist ./dist

# Install a simple HTTP server to serve the static content
RUN npm install -g http-server

# Set the command to start the server
CMD ["http-server", "./dist"]