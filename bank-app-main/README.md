# TP 8 — Architecture Microservices avec Spring Cloud (Bank Application)

Ce projet correspond au **TP 8 consacré à l’architecture microservices**.  
Il met en œuvre une **application bancaire distribuée** basée sur **Spring Boot** et **Spring Cloud**, illustrant les principes fondamentaux des systèmes microservices modernes.

L’application intègre :
- La découverte automatique des services
- La configuration centralisée
- Une passerelle API unique
- Des microservices métier indépendants
- La communication inter-services
- La gestion de la tolérance aux pannes

---

## 📌 Sommaire
1. Fonctionnalités principales  
2. Environnement technique  
3. Organisation de l’architecture  
4. Microservices implémentés  
5. Ports et points d’accès  
6. Lancement du projet  
7. Scénarios de test  
8. Auteur  
9. Licence  

---

## ✅ Fonctionnalités principales

### 🧩 Architecture Microservices
- Enregistrement et découverte des services via **Eureka**
- Routage centralisé des requêtes via **Spring Cloud Gateway**
- Externalisation de la configuration avec **Spring Cloud Config**
- Rafraîchissement dynamique de la configuration (`/actuator/refresh`)

### 🏦 Services métier
- **Customer Service**
  - Gestion des données clients
  - Base de données H2 en mémoire
- **Account Service**
  - Gestion des comptes bancaires
  - Communication REST avec Customer Service
  - Circuit Breaker avec mécanisme de repli

### 🛡️ Tolérance aux pannes
- Mise en œuvre de **Resilience4J**
- Activation automatique d’un fallback en cas d’indisponibilité
- Message retourné : `Source not available`

---

## 🛠️ Environnement technique

| Technologie | Version |
|------------|--------|
| Java | 17 |
| Spring Boot | 3.5.8 |
| Spring Cloud | 2025.0.0 |
| Maven | ✔ |
| Eureka Server | ✔ |
| Spring Cloud Config | ✔ |
| Spring Cloud Gateway | ✔ |
| OpenFeign | ✔ |
| Resilience4J | ✔ |
| Spring Data JPA | ✔ |
| H2 Database | ✔ |

---

## 🏗️ Organisation de l’architecture

bank-app/
├── discovery-service/ # Serveur Eureka
├── config-service/ # Configuration centralisée
├── gateway-service/ # API Gateway
├── customer-service/ # Microservice Client
├── account-service/ # Microservice Compte
└── README.md

shell
Copy code

### Logique de communication
Client
│
▼
API Gateway (9999)
│
├── CUSTOMER-SERVICE (8084)
└── ACCOUNT-SERVICE (8083)
│
└── OpenFeign → CUSTOMER-SERVICE

yaml
Copy code

---

## 🧩 Microservices implémentés

| Service | Description |
|-------|------------|
| discovery-service | Registre des services |
| config-service | Configuration centralisée via Git |
| gateway-service | Point d’entrée unique |
| customer-service | Gestion des clients |
| account-service | Gestion des comptes + Feign + Circuit Breaker |

---

## 🌐 Ports et points d’accès

| Service | Port | URL |
|------|------|-----|
| Eureka Server | 8761 | http://localhost:8761 |
| Config Server | 8888 | http://localhost:8888 |
| API Gateway | 9999 | http://localhost:9999 |
| Customer Service | 8084 | http://localhost:8084 |
| Account Service | 8083 | http://localhost:8083 |

---

## 🚀 Lancement du projet

### Prérequis
- Java 17  
- Maven  
- Git  
- IntelliJ IDEA ou VS Code  

### Ordre de démarrage recommandé
1. discovery-service  
2. config-service  
3. gateway-service  
4. customer-service  
5. account-service  

---

## 🔎 Scénarios de test

### Accès direct aux services
- Clients :  
  http://localhost:8084/customers  
- Comptes :  
  http://localhost:8083/api/accounts  

### Accès via la Gateway
- Clients :  
  http://localhost:9999/CUSTOMER-SERVICE/customers  
- Comptes :  
  http://localhost:9999/ACCOUNT-SERVICE/api/accounts  

### Test du Circuit Breaker
1. Arrêter `customer-service`
2. Appeler :
http://localhost:9999/ACCOUNT-SERVICE/api/accounts/{id}

css
Copy code
3. Résultat attendu :
```json
{
  "firstName": "Source not available",
  "lastName": "Source not available"
}
Rafraîchissement de la configuration
Modifier customer-service.properties

Exécuter :

bash
Copy code
POST http://localhost:8084/actuator/refresh
Vérifier :

bash
Copy code
GET http://localhost:8084/configTest
👤 Auteur
Mohammed Taha Mallouk
Étudiant Ingénieur — MIAGE
Projet académique : Architecture Microservices avec Spring Boot & Spring Cloud

📄 Licence
Projet sous licence MIT.
Utilisation, modification et diffusion autorisées à des fins pédagogiques.

© 2025 — Mohammed Taha Mallouk

yaml
Copy code

---

Si tu veux une **version encore plus simple**, ou une **version spéciale rapport / soutenance**, je peu
