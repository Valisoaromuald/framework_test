package test.controleur.dossier;

import annotation.Controleur;
import annotation.UrlMapping;

@Controleur
public class Controleur3 {
 @UrlMapping(url ="/hello")   
 public  String Greet(){
    return "salama";
}
}
