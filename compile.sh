javac -cp lib/frontServlet.jar -parameters -d bin $(find src/java -name "*.java") 
java -cp bin:lib/frontServlet.jar app.App
