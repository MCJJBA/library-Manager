# library management application
## Loan Management Application  
### Microservices-Based Architecture

**Author:** Mouad Chafiki  

---

## Abstract

This project presents the design and implementation of a **loan management application** based on a **microservices architecture**. The system is developed using **Spring Boot** and **Spring Cloud**, with **MySQL** for data persistence and **Apache Kafka** for asynchronous, event-driven communication. The application is containerized using **Docker** to ensure portability and ease of deployment.

---

## 1. System Overview

The application manages users, books, and loan operations in a distributed environment. Each business domain is implemented as an independent microservice, allowing improved scalability, maintainability, and fault tolerance. Service discovery and request routing are handled through dedicated infrastructure components.

---

## 2. Architecture

### 2.1 Microservices Description

1. **Eureka Server** (Port 8761)  
   - Acts as a service registry and discovery server.  

2. **API Gateway** (Port 9999)  
   - Serves as the single entry point for client requests.  
   - Dynamically routes requests to internal microservices.

3. **User Service** (Port 8082)  
   - Manages user-related operations.  
   - Database: MySQL (`db_user`).

4. **Book Service** (Port 8081)  
   - Handles book management functionalities.  
   - Database: MySQL (`db_book`).

5. **Loan Service** (Port 8085)  
   - Responsible for creating and managing loan records.  
   - Database: MySQL (`db_emprunter`).  
   - Publishes events to Apache Kafka upon loan creation.

6. **Notification Service** (Port 8086)  
   - Consumes Kafka events.  
   - Processes asynchronous notifications and outputs them via logs.

---

## 3. Infrastructure Components

- **MySQL**: Three independent database instances (`db_user`, `db_book`, `db_emprunter`).  
- **Apache Kafka**: Enables asynchronous, event-driven communication.  
- **Zookeeper**: Manages Kafka coordination and configuration.

---
## 4. Kafka Flow
When a loan is created, the `emprunt-service` publishes an event to the `emprunt-created` topic. The `notification-service` consumes this event and displays a notification in the logs.
### 4.1 Event Format
```json
{
  "empruntId": 1,
  "userId": 3,
  "bookId": 5,
  "eventType": "EMPRUNT_CREATED",
  "timestamp": "2025-01-01T14:00:00"
}
```

## 5. Deployment

### 5.1 Prerequisites

- Docker  
- Docker Compose  

### 5.2 Application Startup

The system can be deployed using Docker Compose with the following command:

```bash
docker-compose up --build
