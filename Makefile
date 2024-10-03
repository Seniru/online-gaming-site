JDBC_JAR_PATH=src/main/webapp/lib/mysql-connector-java-8.0.16.jar
TOMCAT_LIB_PATH=/usr/share/tomcat9/lib/servlet-api.jar

build: clean
	mkdir -p build/WEB-INF/classes
	mkdir -p build/WEB-INF/lib
	javac -cp $(TOMCAT_LIB_PATH):$(JDBC_JAR_PATH) -d build/WEB-INF/classes src/main/java/com/oop/*/*.java
	cp -r src/main/webapp/* build/
	cp .env build/
	cp $(JDBC_JAR_PATH) build/WEB-INF/lib/
	cd build && jar -cvf ../online-gaming.war *
	cd ..

deploy:
	sudo mv online-gaming.war /var/lib/tomcat9/webapps

clean:
	rm -rf build