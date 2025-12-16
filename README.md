# ?? Enterprise Real-Time Communication Platform

A high-performance, distributed chat application architected with **Spring Boot**, **Redis Pub/Sub**, and **WebSockets**. Designed to scale horizontally across multiple server instances while maintaining real-time state synchronization.

## ?? Architecture
This project implements a **Stateless Architecture**:
1.  **Client:** Connects via WebSocket (SockJS + STOMP).
2.  **Server:** Spring Boot handles the connection but holds no message state.
3.  **Broker:** Redis acts as the message backbone, broadcasting events to all subscribed server instances.

## ?? Tech Stack
*   **Backend:** Java 17, Spring Boot 3.2
*   **Message Broker:** Redis (Pub/Sub)
*   **Protocol:** WebSockets (STOMP)
*   **Frontend:** HTML5, CSS3 (Dark Mode), Vanilla JS
*   **Build Tool:** Maven

## ? Key Features
*   **Distributed Messaging:** Users on Server A (Port 8080) can chat seamlessly with users on Server B (Port 8081).
*   **Real-Time Latency:** < 50ms message delivery.
*   **Modern UI:** Dark mode interface with dynamic message bubbles and login overlay.
*   **Docker Ready:** Includes configuration for containerized Redis.

## ?? How to Run Locally

### Prerequisites
*   Java 17+
*   Redis (Running on port 6379)

### 1. Start Redis
\\\ash
docker run --name redis-chat -p 6379:6379 -d redis
\\\

### 2. Build the Project
\\\ash
mvn clean package -DskipTests
\\\

### 3. Run the Application
\\\ash
java -jar target/rtc-1.0.0.jar --server.port=8080
\\\
Access the app at: http://localhost:8080

## ?? Screenshots
*(Add your screenshots here)*

## ?? License
MIT
