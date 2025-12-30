# TP 8 — Architecture Microservices avec Spring Cloud (Bank Application)

Ce projet correspond au **TP 8 dédié à l’architecture microservices**.  
Il consiste à développer une **application bancaire distribuée** basée sur **Spring Boot** et **Spring Cloud**, illustrant les principaux mécanismes des systèmes microservices modernes.

L’application intègre notamment :
- La découverte automatique des services
- La configuration centralisée
- Une passerelle API unique
- Des microservices métier indépendants
- La communication inter-services
- La gestion de la résilience et des pannes

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
- Routage centralisé des requêtes par **Spring Cloud Gateway**
- Externalisation de la configuration avec **Spring Cloud Config**
- Rafraîchissement dynamique de la configuration (`/actuator/refresh`)

### 🏦 Services métier
- **Customer Service**
  - Gestion des informations clients
  - Base de données H2 en mémoire
- **Account Service**
  - Gestion des comptes bancaires
  - Appels REST vers le service client
  - Protection par Circuit Breaker avec mécanisme de repli

### 🛡️ Tolérance aux pannes
- Mise en œuvre de **Resilience4J**
- Activation automatique d’un fallback en cas d’échec
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

