#Audit 28/11/2018
This document contains the audit of the quality of the XXX mystery game project. The actors are Bourguignon Maxime, Jacobi Jordan, Simon Christophe and Vanneste Jean.

## Documentation :
* Par rapport à la description du projet, il est plus facile d'utiliser une base de données plutôt que des fichiers JSON locaux.
Une base de données relationnelle pourrait être une bonne idée pour une évolution future. Dans ce cas-ci, le JSON permet d'avoir une souplesse lors du développement et de ne pas alourdir le code avec un ORM (qui soit dit en passant ralentirait la vitesse d'éxécution).
* Explanation on the usser use of the frontend project (+)
* No explanation on the backend structure and fonctionnality (-)
* No explanation about the .jar (architecture) (-)

### Technical issues
* The version of java used is specified: OpenJDK8. (+)
* The used libraries are specified and their version too. (+)
* The file .jar (backend) must be very strong. (~)

### IDE

* Doc only with Inttellij IDEA CE (-)
%Il aurait été utile de réaliser une doc pour le compiler autrement.%


### Diagrams
* Utilisation de design pattern justifiée et argumentée donc très utile pour reprendre le code de l'équipe précédente. (+)

#### User case diagram
* cases must begin with verb (-)
* Case: "Play game" is unclear ? Maybe a canva could be usefull. (-)

#### Class diagram
Très bon diagramme où transparaissent bien les designs patterns utilisés.
Dans une optique de facilité en cas de changement d'équipe, une homogénéité de langage pourraît faciliter le transfert (commentaires et annotations en français alors que le code est en anglais).

## Quality criteria:

### Conventions

* 2: ambiguous notation - space or not between brackets & curly braces (-)
Duplication présente dans le riddle.java -> utilisation de variables tableaux et boucle
* main method to run the application can't match the conventions / Camelcase Uppercase (-)

### Tests

* Must have a lot of test for backend, because file .jar (~)
Goals ? Reached ?
To add tests !

### Jenkins modules/Metrics

* PMD: duplication check (only on the backend part) (-)
* Cobertura: Code coverage (+)
* % Comment module ? (-)
    * No comment Main.java
    * Not all classes are commented or JavaDoc'd
    * No check for the JavaDoc
    * Checkstyles ?

## Git Log
?
## Security

* Passwords are stored w/o encryption -> Hash ! (-)
* file .jar (~)

## Taches à faire

* faire fonctionner PMD
* Correct Javadoc
* Creer les 2 autres modes de jeux

## Reflexion

* une seule interface (GUI) qui accepte différents types de jeux (isl sont très similaires)
* Avec 2 tests -> 62% couverture de code :O -> jenkind dis 30%
* test intelligents ??
