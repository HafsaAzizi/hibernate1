# hibernate-project

## Développement d'Applications Hibernate - Gestion de Produits, Stocks et Projets

Ce dépôt contient plusieurs projets conçus avec le framework Hibernate, qui permet la persistance des données dans des applications Java. Chaque projet aborde un problème distinct, allant de la gestion des produits à la gestion des stocks et des projets.

## Présentation des Projets

### 1. H1 : Système de Gestion des Produits
Ce projet facilite la gestion d'une collection de produits, permettant d'ajouter, de supprimer, de modifier et de consulter les produits dans une base de données MySQL.

#### Caractéristiques :
- Ajouter un nouveau produit
- Lister tous les produits disponibles
- Modifier ou supprimer un produit existant
- Rechercher des produits selon divers critères

#### Étapes à Suivre :
- Créer une base de données MySQL nommée **H1**.
- Inclure les dépendances Hibernate-JPA et MySQL dans le projet.
- Configurer Hibernate avec le fichier `hibernate.cfg.xml` et définir l'entité `Produit` dans le package `ma.projet.entity`.
- Utiliser le service `ProduitService` pour gérer les opérations CRUD sur les produits.

## Structure de la Base de Données :
![image](https://github.com/user-attachments/assets/b5ddaf4d-38f4-4c9b-9b64-430835e34435)

### 2. Ex2 : Gestion des Stocks d'un Magasin
Ce projet est conçu pour gérer le stock de produits d'un magasin, permettant de suivre les produits disponibles, les commandes et les différentes catégories de produits.

#### Caractéristiques :
- Afficher les produits selon leur catégorie
- Gérer les commandes et les détails des lignes de commande
- Filtrer les produits par date de commande ou prix

## Structure de la Base de Données :
![image](https://github.com/user-attachments/assets/11259482-14bb-4a1f-940a-25a7bc9cf720)

### 3. Ex3 : Système de Gestion de Projets
Ce projet représente une application destinée à la gestion de projets dans un cadre de bureau d'études. Il permet de suivre l'avancement des tâches, les employés impliqués et les coûts associés.

#### Caractéristiques :
- Suivre les tâches réalisées par les employés
- Afficher la liste des projets avec leurs tâches
- Évaluer le coût global d'un projet

#### Étapes à Suivre :
- Créer les entités nécessaires dans `ma.projet.classes`.
- Configurer Hibernate via `hibernate.cfg.xml`.
- Utiliser les services `ProjetService`, `TacheService`, et `EmployeService` pour manipuler les données des projets.

## Structure de la Base de Données :
![image](https://github.com/user-attachments/assets/163737b5-53e0-4532-9646-160eca54b14a)

### 4. Projet de Rendu : Gestion de l'État Civil
Ce projet permet de gérer l'état civil des citoyens d'une province en s'appuyant sur Hibernate pour la persistance des données. Il propose des fonctionnalités pour enregistrer les hommes, les femmes et les mariages.

#### Caractéristiques :
- Enregistrement des informations des citoyens : hommes et femmes.
- Suivi des mariages : gestion des mariages réussis et échoués.
- Suivi des enfants : gestion des enfants d'un couple.

## Architecture du Projet :
- **Couche de Persistance :**
  - Entités : `Homme`, `Femme`, et `Mariage` dans le package `ma.projet.beans`.
  - Configuration : `hibernate.cfg.xml` pour la connexion à la base de données MySQL.
  - Classe utilitaire : `HibernateUtil` pour gérer la session Hibernate.

- **Couche de Services :**
  - Services : `HommeService`, `FemmeService`, et `MariageService`.
  - Fonctionnalités : Affichage des épouses d'un homme, calcul du nombre d'enfants d'une femme, liste des femmes mariées plusieurs fois.

## Programme de Test :
- Générer des données pour tester les fonctionnalités (10 femmes et 5 hommes).
- Afficher les résultats des requêtes effectuées.

## Structure de la Base de Données :
![image](https://github.com/user-attachments/assets/4317bc5a-d0be-44d3-ac52-ad03c22ed461)

## Configuration de Hibernate
Chaque projet intègre un fichier de configuration `hibernate.cfg.xml` qui définit les paramètres de la base de données et la gestion des entités :

```xml
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/H1</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="show_sql">true</property>
    </session-factory>
</hibernate-configuration>
```

##Prérequis


Avant d'exécuter les projets, assurez-vous d'avoir les éléments suivants installés et configurés :

--JDK 8 ou supérieur : Assurez-vous d'avoir installé une version appropriée du JDK pour faire fonctionner Hibernate.

--MySQL : Une installation de MySQL est nécessaire pour stocker les données des projets. Créez les bases de données mentionnées (H1, etc.).

--Hibernate-JPA et MySQL JDBC Driver : Les bibliothèques Hibernate et le driver JDBC de MySQL sont indispensables pour permettre la communication entre Java et la base de 
    données MySQL. Hibernate peut être installé via Maven ou en ajoutant les fichiers JAR nécessaires au classpath du projet.

--IDE Supportant Java : Utilisez un IDE comme NetBeans, Eclipse ou IntelliJ IDEA pour gérer et exécuter les projets.

