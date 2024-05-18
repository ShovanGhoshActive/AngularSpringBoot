# Spring Angular Demo Project

This project is a demonstration of integrating Angular frontend with Spring Boot backend, providing a seamless full-stack development experience tailored to your specific requirements.

## Project Overview

The project consists of two main modules:

- **Angular Frontend**: A modern web application built with Angular framework, providing a user-friendly interface for managing a list of names.
- **Spring Boot Backend**: A robust backend built with Spring Boot, serving RESTful APIs to handle CRUD operations on the list of names.

## Prerequisites

Before running this project, ensure you have the following software installed:

- **Java Development Kit (JDK)**: Version 17 or above.
- **Node.js**: Required for Angular development.
- **Maven**: Dependency management and build tool for Java projects.

## Setup

Follow these steps to set up and run the project locally:

1. **Clone the Repository**: 
   ```bash
   git clone https://github.com/ShovanGhoshActive/AngularSpringBoot.git
   cd AngularSpringBoot
   ```

2. **Backend Setup**:
   - Navigate to the `springbackend` directory:
     ```bash
     cd springbackend
     ```
   - Run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```

3. **Frontend Setup**:
   - Navigate to the `angular-frontend` directory:
     ```bash
     cd ../angular-frontend
     ```
   - Install dependencies:
     ```bash
     npm install
     ```
   - Build the Angular application:
     ```bash
     npm run build
     ```

4. **Access the Application**:
   - Once both backend and frontend are running, access the application at [http://localhost:8080](http://localhost:8080).

## Usage

- **Add Names**: Enter a name in the provided input field and click "Submit" to add it to the list.
- **Delete Names**: Click the "Delete" button next to a name to remove it from the list.
- **View Names**: The list of names is displayed in a table format, showing the names along with corresponding delete buttons.
- **Backend APIs**: Backend APIs are available for CRUD operations on names. Refer to the backend code for API endpoints and usage.

## Customization

 Here's how you can customize it further:

- **UI Customization**: Feel free to modify the Angular frontend to match your desired aesthetics and user experience. You can adjust colors, layouts, and components to align with your branding or design preferences.
- **Backend Logic**: If additional functionality beyond CRUD operations is required, the Spring Boot backend can be extended accordingly. Whether it's implementing validation rules, integrating with external services, or enhancing security measures, the backend architecture is designed to accommodate diverse requirements.

## Technologies Used

- **Spring Boot**: For building robust and scalable Java applications.
- **Angular**: A modern and powerful frontend framework for building single-page applications.
- **Maven**: Dependency management and build automation tool for Java projects.
- **Node.js**: JavaScript runtime environment for building scalable network applications.

