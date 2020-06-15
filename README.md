Put login info in "application.properties" file under src/main/resources:

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

## Spring DATASOURCE
spring.datasource.url = jdbc:mysql://localhost:3306/fashion?serverTimezone=America/New_York&useSSL=false
spring.datasource.username = root
spring.datasource.password = password


## Hibernate Properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
