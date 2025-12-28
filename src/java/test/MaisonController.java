package test;

import annotation.Controleur;
import annotation.GetHttp;
import annotation.PostHttp;
import modele.Maison;
import utilitaire.ModelView;

@Controleur
public class MaisonController {
    @GetHttp(url="/maisons/form")
    public ModelView renderForm(){
        ModelView mv = new ModelView();
        mv.setView("form_maison.jsp");
        return mv;
    }
    @PostHttp(url="/maisons")
    public ModelView showInfo(Maison m){
        ModelView mv = new ModelView();
        mv.setView("maison.jsp");
        System.out.println(m.getLocalisation());
        System.out.println(m.getAdresse());
        mv.addObject("localisation", m.getLocalisation());
        mv.addObject("adresse", m.getAdresse());
        mv.addObject("pieces",m.getPieces());
        return mv;
    }
}
