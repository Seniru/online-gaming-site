# online-gaming-site
SLIIT university project featuring a online gaming site

# Environment setup
This project requires the following tools to run.

- Java 8+
- Apache Tomcat (preferred version 9)

You need to create a `.env` file with the following content
```env
DB_HOST="localhost"
DB_NAME="sampledb"
DB_USER="sampleuser"
DB_PASSWORD="samplepass"
```

For codespace users, the environment will be set up automatically.
Do `./manage.sh init-db` the first time you created a codespace container.
Do `./manage.sh start` each time you open codespace

# Building and deploying

```sh
# build
make

# deploy
make deploy

# clean the directory
make clean
```

