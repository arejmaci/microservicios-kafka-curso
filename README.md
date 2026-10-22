# Event-Driven Microservices Architecture with Spring Boot & Apache Kafka

A production-ready reference architecture demonstrating the design and implementation of event-driven distributed microservices using modern Java, Spring Boot 4, Spring Cloud Stream, and Apache Kafka.

---

## 🏛️ Architecture & System Design

This system leverages an **Event-Driven Architecture (EDA)** combined with **CQRS (Command Query Responsibility Segregation)** principles to ensure high throughput, fault tolerance, and loose coupling between domain services.

```mermaid
graph TD
    Client[Client / Postman] -->|HTTP REST Requests| API[products-api Layer]
    API -->|Commands| CMD[product-command Service]
    CMD -->|Produce Events| Kafka[Apache Kafka Broker]
    Kafka -->|Consume Events| Consumers[Downstream Consumers / Services]
    KafkaUI[Kafka UI Web Console] -.->|Monitor Topics & Messages| Kafka
```

### Key Architectural Patterns & Features
* **Event-Driven Messaging:** Asynchronous event streaming powered by **Spring Cloud Stream** and **Apache Kafka**, decoupling domain operations and ensuring scalability.
* **CQRS Pattern:** Separation of command operations (`product-command`) from read/REST entry points (`products-api`) for optimal performance and clean layer boundaries.
* **Clean Architecture & DTOs:** Strict boundary separation between domain entities and external interfaces using **Data Transfer Objects (DTOs)** and validation layers.
* **ORM & Relational Persistence:** Data persistence and mapping managed through **Spring Data JPA** and **Hibernate**.
* **Observability & Management:** Real-time stream auditing, topic inspection, and consumer group tracking integrated via **Kafka UI**.
* **Containerized Infrastructure:** One-click environment provisioning with **Docker & Docker Compose**.

---

## 🛠️ Technology Stack

| Category | Technology / Framework |
| :--- | :--- |
| **Language** | Java 17 / 21 |
| **Core Framework** | Spring Boot 3.x, Spring Framework |
| **Messaging & Streaming** | Apache Kafka, Spring Cloud Stream |
| **Monitoring & GUI** | Kafka UI |
| **Persistence & ORM** | Spring Data JPA, Hibernate, Relational DBs |
| **DevOps & Tooling** | Docker, Docker Compose, Maven, Postman |

---

## 📁 Project Structure

```text
├── product-command     # Domain microservice handling write commands & publishing Kafka events
├── products-api        # REST API layer exposing controllers, request validation, and DTO mappings
├── docker-compose.yml  # Local infrastructure stack (Kafka broker, Zookeeper/KRaft, Kafka UI)
└── README.md           # Technical documentation and architecture blueprint
```

---

## 🚀 Getting Started

### Prerequisites

* **Java Development Kit (JDK):** Version 17 or higher
* **Build Tool:** Maven 3.8+
* **Container Runtime:** Docker Desktop / Docker Engine & Docker Compose

### Local Infrastructure Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/arejmaci/spring-kafka-event-driven-architecture.git
   cd spring-kafka-event-driven-architecture
   ```

2. **Spin up the messaging infrastructure:**
   ```bash
   docker-compose up -d
   ```
   *This starts the Apache Kafka broker along with Kafka UI for message management.*

3. **Access Kafka UI:**
   Open your browser and navigate to `http://localhost:8080` (or your configured port) to inspect Kafka topics and active brokers.

4. **Build and test the application modules:**
   ```bash
   mvn clean install
   ```

---

## 🤝 Contributing

Contributions, feedback, and issue reports are welcome. Feel free to open a pull request or submit an issue.

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.
