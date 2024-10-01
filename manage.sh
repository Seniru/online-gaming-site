#! /bin/bash

function init_db() {
	echo Initializing database...
	sql=""
	for file in `ls -A db`
	do
		sql="$sql-- $file\n"
		sql="$sql`cat ./db/$file`\n\n"
	done

	printf "%b" "$sql" > temp.sql
	
	sudo mysql -u root -p -e "ALTER USER 'root'@'localhost' IDENTIFIED BY '';"
	echo Creating database...
    sudo mysql -u $DB_USER -p $DB_PASSWORD -h $DB_HOST -e "CREATE DATABASE IF NOT EXISTS ${DB_NAME};" < temp.sql
	echo Initializing database...
	sudo mysql -u $DB_USER -p $DB_PASSWORD -h $DB_HOST $DB_NAME < temp.sql
	# echo Database created!

	rm temp.sql

}


# Load environment variables from .env file
if [ -f .env ]; then
    export $(cat .env | xargs)
fi


if [ -z $1 ] || [ $1 = "start" ]; then
	sh /usr/share/tomcat9/bin/catalina.sh start
	if command -v mariadbd >/dev/null 2>&1; then
    	if pgrep -x "mariadbd" > /dev/null; then
        	echo "MariaDB is already running."
    	else
        	echo "Starting MariaDB..."
        	sudo service mariadb start
    	fi
	elif command -v mysqld >/dev/null 2>&1; then
    	if pgrep -x "mysqld" > /dev/null; then
        	echo "MySQL is already running."
    	else
        	echo "Starting MySQL..."
        	sudo service mysql start
		fi
    fi
elif [ $1 = "init-db" ]; then
	init_db
elif [ $1 = "drop-db" ]; then
	sudo mysql -u $DB_USER -p$DB_PASSWORD -h $DB_HOST -e "DROP DATABASE IF EXISTS ${DB_NAME};"
fi


