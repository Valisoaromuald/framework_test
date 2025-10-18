package app;

import classes.ClasseUrl;
import java.lang.reflect.Method;

import annotation.UrlMapping;

public class App {
    public static void main(String[] args) {
        try {
            ClasseUrl classeUrl = new ClasseUrl();
            Method[] methods =  classeUrl.getMethods();
            for(Method method:methods){
                if(method.isAnnotationPresent(UrlMapping.class)){
                    UrlMapping mapping = method.getAnnotation(UrlMapping.class);
                    Method m  = UrlMapping.class.getMethod("url");
                    Object valeur = m.invoke(mapping);
                    System.out.println("url: "+valeur);
    
                }
            }
        } catch (Exception e) {
            System.out.println("erreur : "+e.getMessage());
            e.printStackTrace();
        }
    }
}