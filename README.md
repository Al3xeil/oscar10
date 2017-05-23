#### Under Construction #### Not usable

# oscar10
Competence-Rating System with Spring and Angular 2/4

spring Project:
- You need first a Mysql Database -> You just need to create a new SCHEMA and then modify the informations in the application.properties file (spring.datasource....) for the IP-adress and the credentials of the user on the DB.
- For the Kata -> Either get the VM provided and run it on Virtual Box, or modify the IP adress (spring.datasource.url=jdbc:mysql://xxx.xxx.xxx.xxx:3306/oscar10DB) to connect to the database of the Host in the internal Network.
- run with Maven command: clean spring-boot:run
- If your database is new, spring already created at that point all tables from the defined @Entity of the project (nothing to do further)
- If your database is new and empty, you'll need to import informations in it -> execute .sql in your database (Mysql Workbench for Windows )
- You should be able to call the REST point with Postman or any REST-Client and with the Basic Authentification (username: Darksilvi; password: password) with a GET request at the URL: http://localhost:8080/competence

Angular Project:
- Install nodejs (npm come with it)
- Install cli -> npm install -g @angular/cli
- in the Folder -> npm install (dl all node_modules)
- ng serve
