package test;

import java.util.List;

import annotation.Controleur;
import annotation.GetHttp;
import annotation.InputParam;
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
    public ModelView showInfo(Maison maison,@InputParam(paramName="lieux")String[] localisations,List<Maison[]> maisons){
        ModelView mv = new ModelView();
        mv.setView("maison.jsp");
        System.out.println(maison.getLocalisation());
        System.out.println(maison.getAdresse());
        // System.out.println("zany e:"+maisons.get(0).getLocalisation());
        mv.addObject("localisation", maison.getLocalisation());
        mv.addObject("adresse", maison.getAdresse());
        mv.addObject("pieces",maison.getPieces());
        mv.addObject("maisons",maisons);
        return mv;
    }
}
