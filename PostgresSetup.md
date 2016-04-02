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