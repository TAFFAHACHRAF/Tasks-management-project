
#  Application de gestion et de planification des projets.


L’objectif de ce projet est le développement d’une application en JAVA pour gérer les projets d’une entreprise. Cette application va permettre de gérer les tâches du projets,les ressources, et affiche la planification dans un diagramme de Gantt.

### Cette application va avoir deux types d’utilisateurs :

- Responsable de projet :

    1) Gérer ses informations personnelles.
    2) Ajouter, modifier ou supprimer les comptes utilisateurs
    3) Ajouter, modifier ou supprimer une tâche.
    4) Affecter des ressources humaines (intervenant) et matérielles à un tâche.
    5) Planifier et visualiser dans un diagramme de Gantt les tâches du projet.
    6) Importer et exporter toutes les données de l'application.

- Intervenant :

    1) Gérer ses informations personnelles.
    2) Afficher ses ordres de travail.
    3) Modifier l’état d’une tâche.
    4) Recevoir une notification (Email et SMS).
    
    
### Design
![alt text](macbook-pro-mockup.png)
### La structure du projet
 ``` bash
28 directories, 60 files
@TAFFAHACHRAF ➜ /workspaces/Tasks-management-project (main) $ tree
.
├── Application
│   ├── Database
│   │   └── tasks-management.sql
│   ├── JAVA FX.iml
│   ├── mysql-connector-java-8.0.30.jar
│   ├── out
│   │   └── production
│   │       └── JAVA FX
│   │           ├── enset
│   │           │   └── ma
│   │           │       └── jdbc
│   │           │           ├── dao
│   │           │           │   ├── Dao.class
│   │           │           │   ├── entities
│   │           │           │   │   └── Produit.class
│   │           │           │   ├── ProduitDaoImpl.class
│   │           │           │   └── SingletonConnexionDB.class
│   │           │           ├── presentation
│   │           │           │   └── Main.class
│   │           │           └── services
│   │           │               ├── ProduitServices.class
│   │           │               └── ProduitsServicesImpl.class
│   │           └── project
│   │               └── tasks_management
│   │                   ├── dao
│   │                   │   ├── CompteImpl.class
│   │                   │   ├── CompteInterface.class
│   │                   │   ├── Dao.class
│   │                   │   ├── entities
│   │                   │   │   ├── Compte.class
│   │                   │   │   ├── Diagramme.class
│   │                   │   │   ├── Intervenent.class
│   │                   │   │   ├── Materiel.class
│   │                   │   │   ├── Notification.class
│   │                   │   │   ├── OrderDeTravail.class
│   │                   │   │   ├── Projet.class
│   │                   │   │   ├── Responsable.class
│   │                   │   │   ├── Task.class
│   │                   │   │   └── User.class
│   │                   │   ├── IntervenentImpl.class
│   │                   │   ├── IntervenentInterface.class
│   │                   │   ├── SingletonConnexionDB.class
│   │                   │   └── Test.class
│   │                   └── presentation
│   │                       └── Main.class
│   ├── src
│   │   └── project
│   │       └── tasks_management
│   │           ├── dao
│   │           │   ├── abdelmalek
│   │           │   │   ├── MaterialDAO.java
│   │           │   │   ├── materialDmpl.java
│   │           │   │   ├── ProjetDAO.java
│   │           │   │   ├── ProjetDmpl.java
│   │           │   │   ├── TaskDAO.java
│   │           │   │   ├── TaskDmpl.java
│   │           │   │   ├── UserDAO.java
│   │           │   │   └── UserDmpl.java
│   │           │   ├── CompteImpl.java
│   │           │   ├── CompteInterface.java
│   │           │   ├── Dao.java
│   │           │   ├── entities
│   │           │   │   ├── Compte.java
│   │           │   │   ├── Diagramme.java
│   │           │   │   ├── Intervenent.java
│   │           │   │   ├── Materiel.java
│   │           │   │   ├── Notification.java
│   │           │   │   ├── OrderDeTravail.java
│   │           │   │   ├── Projet.java
│   │           │   │   ├── Responsable.java
│   │           │   │   ├── Task.java
│   │           │   │   └── User.java
│   │           │   ├── IntervenentImpl.java
│   │           │   ├── IntervenentInterface.java
│   │           │   ├── SingletonConnexionDB.java
│   │           │   └── Test.java
│   │           └── presentation
│   │               └── Main.java
│   └── tasks-management.sql
├── Conception
│   └── UML
│       ├── Diagramme de cas d'utilisation.pdf
│       ├── Diagramme de contexte.pdf
│       └── rapport-java-poo-taffah-ennani.pdf
├── Planning
│   └── java-reunion-1.txt
├── README.md
└── Specifications
    └── Specifications.pdf
```


