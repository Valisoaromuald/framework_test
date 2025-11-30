package modele;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import annotation.UrlMapping;
public class ClasseUrl {
    @UrlMapping(url="/home")
    public void home(){
    }
    @UrlMapping(url="/page-insertion")
    public void pageInsertion(){

    }
    @UrlMapping(url="/delete")
    public void supprimer(){
    }
    public Method[] getMethods(){
        Class<ClasseUrl> classe = ClasseUrl.class;
        Method[] methods = classe.getDeclaredMethods(); 
        return methods;
    }
}
