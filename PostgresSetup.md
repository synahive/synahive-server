#Start the PostgreSQL service
sudo service postgresql start
#Connect to the service
sudo sudo -u postgres psql
#Create a PostgreSQL database
#Make sure you have logged into the PostgreSQL terminal and then you can just run:

sudo sudo -u postgres psql
postgres=# CREATE DATABASE "groceries";
#List all databases
sudo sudo -u postgres psql
postgres=# \list
#Connecting with your language of choice
#First you must set a password for the postgres user.

sudo sudo -u postgres psql
postgres-# \password postgres
#Enter new password:
#Then you can connect with username "postgres" and the password you set. Here's an example in PHP:

<?php
$link = pg_connect("host=localhost dbname=groceries user=postgres password=cloud9isawesome");
?>

#Note:
#The DATABASE_URL for the Heroku Postgres add-on follows the below convention
postgres://<username>:<password>@<host>:<port>/<dbname>
#However the Postgres JDBC driver uses the following convention:
jdbc:postgresql://<host>:<port>/<dbname>?user=<username>&password=<password>
#Notice the additional ql at the end of the URL scheme. Due to this difference, for Postgres, you may need to hardcode the scheme to postgresql in your Java class or your Spring XML configuration.