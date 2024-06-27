Homework.
Compulsory:
1. Install PostgreSQL database on your laptop.
2. Create a database (my_ticket_service_db), and public schema
3. Create 2 tables: User (id, name, creation_date) and Ticket (id, user_id, ticket_type, creation_date).
   Remember about sequences, primary and foreign keys. It will also be good to create custom type in the DB for
   a ticket type (create type ticket_type as enum (DAY, 'WEEK', 'MONTH', ‘YEAR’);
4. Add JDBC and PostgreSQL driver support to your project via Maven/Gradle.
5. Using plain SQL and JDBC, create a DAO class that will be able to:
   Save Tickets and Users,
   Fetch Tickets by ID and user ID and Users by ID, 
   Update Tickets type, 
   Delete Users by ID and their tickets (if any).
6. *** Add translation support. With SAVEPOINT in case of User and Ticket tables simultaneous update.
7. Recommended: Complete 12 lessons on SQL Bolt: https://sqlbolt.com/lesson/introduction
   
A Postgres schema allows for multiple schemas to exist within a single database, 
each with its own set of tables and other objects. 
A Postgres database is the highest level of organization, containing all the schemas, tables, and other objects