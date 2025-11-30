package test;

import annotation.Controleur;
import annotation.UrlMapping;

@Controleur
public class Test3 {
    @UrlMapping(url="/goodbye")
    public String goodBye(){
        return "mandrapihaona";
    }
}
