# CESI Java
Réalisation d'une application de gestion de classes en JavaFX

# Developers
Groupe n°5 :
* Alexis POUPELIN
* Guillaume M'BALI
* Mansour OZDAMIROV

# Dependencies
* JDK > 11 
* Java FX SDK > 14 : https://openjfx.io/
* Maven
* Database (JDBC compatible)

# Install 
* Clone the project : `git clone https://github.com/DevEkode/cesi_java`.
* Open the project folder with your IDE (IntelliJ or Eclipse).
* Setup your JDK and JavaFX SDK.
* Sync maven dependencies.
* Create a new database and use the sql script `Bdd_creation.sql` to create the database structure.
* copy `db.properties.example` into `db.properties`.
* edit the `db.properties` to match your database config.
* edit the run configuration `RUN PROJECT` VM options to match your JavaFX SDK location
    * example : `--module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls,javafx.fxml`
* run the project with `RUN PROJECT`.

# Use the application
You can use default account to test the application :

Administrator account :  
* login : `pierre.dupond`
* mdp : `azerty`

Student account :
* login : `amaury.lacroix`
* mdp : `azerty`


