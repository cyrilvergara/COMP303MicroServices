# Eureka Microservices

## Overview

Eureka Microservices is a collection of microservices built using Spring Boot, designed to demonstrate the use of microservices architecture with service discovery using Eureka. The project consists of several services, including Account Service, Dashboard, Fees Service, Order Service, and a Eureka Server for service registration and discovery.

## Services

### 1. Account Service

- **Description**: Manages user accounts and transactions.
- **Endpoints**:
  - `POST /api/transactions`: Create a new transaction.
  - `GET /api/transactions`: Retrieve all transactions.

### 2. Dashboard

- **Description**: Provides a web interface to interact with the microservices.
- **Endpoints**:
  - `GET /`: Displays the dashboard with tabs for Orders, Transactions, and Fees.
  - `POST /placeOrder`: Places a new order.

### 3. Fees Service

- **Description**: Manages fees associated with transactions.
- **Endpoints**:
  - `POST /api/fees`: Create a new fee.
  - `GET /api/fees`: Retrieve all fees.

### 4. Order Service

- **Description**: Manages orders placed by users.
- **Endpoints**:
  - `POST /api/orders`: Create a new order.
  - `GET /api/orders`: Retrieve all orders.
  - `GET /api/orders/{id}`: Retrieve an order by ID.
  - `GET /api/orders/symbol/{stockSymbol}`: Retrieve orders by stock symbol.
  - `GET /api/orders/account/{account}`: Retrieve orders by account.

### 5. Eureka Server

- **Description**: Acts as a service registry for microservices.
- **Endpoints**:
  - `GET /eureka/apps`: Retrieve registered services.

## Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Cloud 2024.0.1
- MongoDB (for data storage)
- WebFlux (for reactive programming)
- Thymeleaf (for the web interface)

## Getting Started

### Prerequisites

- Java 21
- Maven
- MongoDB

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/EurekaMicroservices.git
   cd EurekaMicroservices
   ```

2. Navigate to each service directory and run:

   ```bash
   mvn clean install
   ```

3. Start the Eureka Server:

   ```bash
   cd Server
   mvn spring-boot:run
   ```

4. Start the other services (AccountService, Dashboard, FeesService, OrderService) in separate terminals:

   ```bash
   cd AccountService
   mvn spring-boot:run
   ```

   Repeat for Dashboard, FeesService, and OrderService.

5. Access the Dashboard at `http://localhost:8080`.
