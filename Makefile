build: clean
	mkdir build
	javac -cp /usr/share/tomcat9/lib/servlet-api.jar -d build/WEB-INF/classes src/com/oop/*/*.java
	cp -r WebContent/* build/
	cd build && jar -cvf ../online-gaming.war *
	cd ..

deploy:
	sudo mv online-gaming.war /var/lib/tomcat9/webapps

clean:
	rm -rf build