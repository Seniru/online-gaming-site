build: clean
	mkdir build
	javac -cp /usr/share/tomcat9/lib/servlet-api.jar -d build/WEB-INF/classes src/main/java/com/oop/*/*.java
	cp -r src/main/webapp/* build/
	cd build && jar -cvf ../online-gaming.war *
	cd ..

deploy:
	sudo mv online-gaming.war /var/lib/tomcat9/webapps

clean:
	rm -rf build