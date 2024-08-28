# Projet de Système Bancaire Interactif Basic

## Description du Projet

Ce projet est une application Java simple qui simule un système bancaire interactif. L'application permet aux utilisateurs de réaliser des dépôts, des retraits, et de consulter l'historique des transactions sur un compte d'épargne préexistant. L'application utilise plusieurs design patterns pour assurer une structure de code claire, extensible et maintenable.

## Fonctionnalités

- Effectuer des dépôts et des retraits.
- Consulter l'historique des transactions.
- Gestion des exceptions pour les opérations bancaires incorrectes.

## Structure du Projet

Le projet est organisé en plusieurs packages pour une meilleure modularité :

- **com.bank.account** : Contient les classes liées aux comptes bancaires, transactions et stratégies d'impression des relevés.
  - `BankAccount` : Classe abstraite représentant un compte bancaire générique.
  - `SavingsAccount` : Classe représentant un compte d'épargne.
  - `Transaction` : Classe représentant une transaction bancaire.
  - `AccountStatement` : Classe encapsulant la liste des transactions pour un compte.
  - `StatementPrinterStrategy` : Interface pour définir des stratégies d'impression de relevés.
  - `ConsoleStatementPrinter` : Implémentation concrète pour imprimer les relevés dans la console.

- **com.bank.exception** : Contient les classes d'exceptions personnalisées pour la gestion des erreurs.
  - `AccountNotFoundException` : Exception levée lorsqu'un compte n'est pas trouvé.
  - `InsufficientFundsException` : Exception levée lors d'un retrait avec des fonds insuffisants.
  - `InvalidAccountTypeException` : Exception levée pour un type de compte invalide.
  - `InvalidTransactionAmountException` : Exception levée pour un montant de transaction invalide.

- **com.bank.factory** : Contient la classe `AccountFactory` utilisée pour créer des instances de comptes bancaires.
  - `AccountFactory` : Fabrique pour créer des comptes bancaires en fonction de leur type.

- **com.bank.service** : Contient les services principaux pour la gestion des comptes et des transactions.
  - `AccountService` : Service Singleton pour la gestion des comptes.
  - `TransactionService` : Service pour gérer les dépôts, retraits et enregistrement des transactions.

- **com.bank.utils** : Contient des classes utilitaires.
  - `DateUtils` : Classe utilitaire pour formater les dates.

## Design Patterns Utilisés

### 1. **Pattern Factory**
Le pattern Factory est utilisé pour créer des instances de comptes bancaires (`AccountFactory`). Cela permet de centraliser la logique de création des objets et de rendre le code plus extensible. Si de nouveaux types de comptes sont ajoutés à l'avenir, ils peuvent être facilement intégrés en étendant cette fabrique.

### 2. **Pattern Strategy**
Le pattern Strategy est utilisé pour définir différentes stratégies d'impression des relevés de compte (`StatementPrinterStrategy`). Cela permet de changer facilement la manière dont les relevés sont imprimés sans modifier la logique principale de l'application. Par exemple, on peut imprimer les relevés dans la console ou les envoyer par e-mail en implémentant de nouvelles stratégies.

### 3. **Pattern Singleton**
Le pattern Singleton est utilisé dans la classe `AccountService` pour garantir qu'il n'existe qu'une seule instance de ce service dans toute l'application. Cela permet de gérer les comptes de manière centralisée et cohérente.


### Explication des Commandes :

- **Cloner le dépôt** :  `git clone https://github.com/Maazouz-Zouhair/simple-banking-api.git`
- **Configurer les dépendances Maven** : `mvn clean install`
- **Exécuter l'application** : `mvn exec:java` exécute la classe `Main` de l'application.
- **Exécuter les tests** : `mvn test`.


## Création de Comptes

Les comptes bancaires sont créés par programmation en utilisant la classe `AccountFactory`. 

