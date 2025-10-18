javac -cp lib/frontServlet.jar -d bin src/java/classes/*.java src/java/app/*.java
java -cp .:lib/frontServlet.jar:bin app.App