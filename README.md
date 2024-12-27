# DogFood Shop

A modern e-commerce application for dog food products built with Spring Boot 3.

## Features

- User authentication and authorization
- Product catalog with search and filtering
- Shopping cart functionality
- Admin dashboard for product management
- Responsive design

## Technologies

- Java 17
- Spring Boot 3.2.2
- Spring Security
- PostgreSQL
- Thymeleaf
- Bootstrap 5

## Getting Started

### Prerequisites

- JDK 17+
- PostgreSQL 15+
- Docker (optional)

### Database Setup

1. Start PostgreSQL:
```bash
docker-compose up -d
```

2. Create database:
```sql
CREATE DATABASE dogfood_shop;
```

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/[your-username]/dogfood-shop.git
```

2. Build and run:
```bash
./gradlew bootRun
```

3. Access the application at: `http://localhost:38880`

### Admin Account

Create an admin account at: `http://localhost:38880/admin/register`

## License

This project is open-source and available under the MIT License.
