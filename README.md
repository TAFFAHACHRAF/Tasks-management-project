
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
    
    
### La structure du projet
 ``` bash
├───.idea
├───out
│   └───production
│       └───JAVA FX
│           └───project
│               └───tasks_management
│                   ├───dao
│                   │   ├───intervenant
│                   │   ├───materiel
│                   │   ├───notification
│                   │   ├───order_de_travail
│                   │   ├───projet
│                   │   ├───responsable
│                   │   └───task
│                   ├───entities
│                   └───presentation
└───src
    └───project
        └───tasks_management
            ├───dao
            │   ├───intervenant
            │   ├───materiel
            │   ├───notification
            │   ├───order_de_travail
            │   ├───projet
            │   ├───responsable
            │   └───task
            ├───entities
            ├───presentation
            └───services
                ├───intervenant
                ├───materiel
                ├───notification
                ├───order_de_travail
                ├───projet
                ├───responsable
                └───task
```


