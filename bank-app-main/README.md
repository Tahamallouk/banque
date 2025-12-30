# TP 8 — Microservices Architecture avec Spring Cloud (Bank App)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.8-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-blue)
![Java](https://img.shields.io/badge/Java-17-orange)
![Build](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Status-Working-success)
![Architecture](https://img.shields.io/badge/Architecture-Microservices-success)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

Projet du **TP 8 – Architecture Microservices avec Spring Cloud**.  
Cette application simule un **système bancaire distribué** basé sur **Spring Boot & Spring Cloud**, intégrant :

- **Service Discovery (Eureka)**
- **Configuration centralisée (Config Server + Git)**
- **API Gateway**
- **Microservices métier (Customer & Account)**
- **Communication inter-services (OpenFeign)**
- **Tolérance aux pannes (Resilience4J – Circuit Breaker)**

---

## 📌 Sommaire

1. [Fonctionnalités](#-fonctionnalités)
2. [Stack technique](#-stack-technique)
3. [Architecture globale](#-architecture-globale)
4. [Microservices](#-microservices)
5. [Ports & URLs](#-ports--urls)
6. [Démarrage rapide](#-démarrage-rapide)
7. [Tests & démonstrations](#-tests--démonstrations)
8. [Screenshots officiels](#-screenshots-officiels)
9. [Auteurs](#-auteurs)
10. [Licence](#-licence)

---

## ✅ Fonctionnalités

### 🧩 Architecture Microservices
- Découverte automatique des services via **Eureka**
- Routage dynamique via **Spring Cloud Gateway**
- Configuration externalisée via **Spring Cloud Config**
- Chargement dynamique des configs (`/actuator/refresh`)

### 🏦 Services métier
- **Customer Service**
    - Gestion des clients
    - Base H2 en mémoire
- **Account Service**
    - Gestion des comptes bancaires
    - Appel distant vers Customer Service
    - Circuit Breaker avec **fallback**

### 🛡️ Résilience
- **Resilience4J Circuit Breaker**
- Fallback automatique si un service est indisponible
- Message : `Source not available`

---

## 🛠️ Stack technique

| Technologie | Version |
|------------|---------|
| Java | 17 |
| Spring Boot | 3.5.8 |
| Spring Cloud | 2025.0.0 |
| Maven | ✅ |
| Eureka Server | ✅ |
| Spring Cloud Config | ✅ |
| Spring Cloud Gateway | ✅ |
| OpenFeign | ✅ |
| Resilience4J | ✅ |
| Spring Data JPA | ✅ |
| H2 Database | ✅ |

---

## 🏗️ Architecture globale
```
bank-app/
├── discovery-service/ # Eureka Server
├── config-service/ # Spring Cloud Config Server
├── gateway-service/ # API Gateway
├── customer-service/ # Microservice Client
├── account-service/ # Microservice Compte
└── README.md
```


### Architecture logique

```
Client
│
▼
API Gateway (9999)
│
├── CUSTOMER-SERVICE (8084)
└── ACCOUNT-SERVICE (8083)
│
└── OpenFeign → CUSTOMER-SERVICE
```


---

## 🧩 Microservices

| Service | Rôle |
|-------|------|
| discovery-service | Service Registry (Eureka) |
| config-service | Configuration centralisée (Git) |
| gateway-service | Point d’entrée unique |
| customer-service | Gestion des clients |
| account-service | Gestion des comptes + Feign + Circuit Breaker |

---

## 🌐 Ports & URLs

| Service | Port | URL |
|------|------|-----|
| Eureka Server | 8761 | http://localhost:8761 |
| Config Server | 8888 | http://localhost:8888 |
| Gateway | 9999 | http://localhost:9999 |
| Customer Service | 8084 | http://localhost:8084 |
| Account Service | 8083 | http://localhost:8083 |

---

## 🚀 Démarrage rapide

### 1️⃣ Prérequis

✅ Java **17**  
✅ Maven  
✅ IntelliJ IDEA / VS Code  
✅ Git



### 2️⃣ Ordre de démarrage (IMPORTANT)

Démarrer **dans cet ordre exact** :

1. `discovery-service`
2. `config-service`
3. `gateway-service`
4. `customer-service`
5. `account-service`

---

## 🔗 Tests & démonstrations

### Tests directs

- Customers  
  👉 http://localhost:8084/customers

- Accounts  
  👉 http://localhost:8083/api/accounts



### Tests via Gateway (MAJUSCULE OBLIGATOIRE)

- Customers  
  👉 http://localhost:9999/CUSTOMER-SERVICE/customers

- Accounts  
  👉 http://localhost:9999/ACCOUNT-SERVICE/api/accounts

---

### Test Circuit Breaker (Resilience4J)

1. **Arrêter `customer-service`**
2. Appeler :
  👉 http://localhost:9999/ACCOUNT-SERVICE/api/accounts/{id}


➡️ Résultat :
```
{
  "firstName": "Source not available",
  "lastName": "Source Not available"
}
```

### Test Refresh Config (Spring Cloud Config)

1. Modifier customer-service.properties dans msa-bank-config
2. Exécuter :

POST http://localhost:8084/actuator/refresh

3. Vérifier :

GET http://localhost:8084/configTest

---





## 👥 Auteurs

Mallouk Mohammed Taha<br/>
Étudiants Ingénieurs — MIAGE<br/>
Implémentation complète de l’architecture micro-services<br/>
Spring Boot · Spring Cloud · Eureka · Gateway · Config · Feign · Resilience4J <br/>

---

## 📄 Licence

✅ Projet sous licence MIT.<br/>
Libre d’utilisation, modification et distribution à des fins pédagogiques.<br/>

© 2025 — Mallouk Mohammed Taha<br/>

---

