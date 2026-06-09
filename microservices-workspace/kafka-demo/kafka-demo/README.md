# Kafka Demo — Order Service & Pickup Service

## Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                        Apache Kafka                             │
│                                                                 │
│   Topic: new-orders          Topic: order-status-updates       │
│   ──────────────────         ────────────────────────────      │
└────────┬───────────────────────────────┬────────────────────────┘
         │                               │
         ▼  consumes                     ▼  consumes
┌─────────────────┐             ┌─────────────────────┐
│  Pickup Service │             │    Order Service     │
│  (port: 8082)   │             │    (port: 8081)      │
│                 │  publishes  │                      │
│  PickupConsumer │────────────►│  OrderConsumer       │
│                 │  status     │                      │
└─────────────────┘  updates    └──────────┬───────────┘
                                           │ publishes
                                           ▼ new orders
                                     REST: POST /api/orders
```

### Flow
1. **Client** → `POST /api/orders` → **Order Service**
2. **Order Service** publishes to `new-orders` topic
3. **Pickup Service** consumes from `new-orders` → processes → publishes status to `order-status-updates`
4. **Order Service** consumes from `order-status-updates` → updates order state

---

## Project Structure

```
kafka-demo/
├── docker-compose.yml           # Kafka + Zookeeper + Kafka UI
├── order-service/
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/demo/order/
│       │   ├── OrderServiceApplication.java
│       │   ├── config/KafkaConfig.java      ← Producer + Consumer beans
│       │   ├── model/Order.java
│       │   └── consumer/
│       │       ├── OrderConsumer.java        ← Listens: order-status-updates
│       │       └── OrderProducer.java        ← REST API + publishes: new-orders
│       └── resources/application.yml
└── pickup-service/
    ├── pom.xml
    └── src/main/
        ├── java/com/demo/pickup/
        │   ├── PickupServiceApplication.java
        │   ├── config/KafkaConfig.java       ← Producer + Consumer beans
        │   ├── model/Order.java
        │   └── consumer/
        │       └── PickupConsumer.java        ← Listens: new-orders
        │                                        Publishes: order-status-updates
        └── resources/application.yml
```

---

## Running the Project

### Step 1 — Start Kafka
```bash
docker-compose up -d
```
Kafka UI available at: http://localhost:8080

### Step 2 — Start Order Service
```bash
cd order-service
mvn spring-boot:run
# Starts on port 8081
```

### Step 3 — Start Pickup Service
```bash
cd pickup-service
mvn spring-boot:run
# Starts on port 8082
```

### Step 4 — Place an Order
```bash
curl -X POST http://localhost:8081/api/orders \
  -H "Content-Type: application/json" \
  -d '{
    "customerName": "Rahul Sharma",
    "item": "Laptop",
    "quantity": 1,
    "price": 75000.00
  }'
```

### Expected Console Output

**Order Service:**
```
Order abc-123 published → topic=new-orders partition=0 offset=0
```

**Pickup Service:**
```
=== Pickup Service Received New Order ===
Order ID  : abc-123
Customer  : Rahul Sharma
Item      : Laptop x1 @ ₹75000.0
=========================================
Status update published → orderId=abc-123 status=CONFIRMED offset=0
Status update published → orderId=abc-123 status=DISPATCHED offset=1
```

**Order Service (after status update):**
```
=== Order Service Received Status Update ===
Order ID  : abc-123
New Status: CONFIRMED
Order abc-123 confirmed. Notifying customer.
```

---

## Kafka Topics

| Topic                  | Producer         | Consumer         |
|------------------------|------------------|------------------|
| `new-orders`           | Order Service    | Pickup Service   |
| `order-status-updates` | Pickup Service   | Order Service    |

## Order Statuses
`PLACED` → `CONFIRMED` → `DISPATCHED` → `DELIVERED`
