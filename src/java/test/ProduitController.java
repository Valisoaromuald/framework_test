package test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import annotation.Controleur;
import annotation.GetHttp;
import annotation.PostHttp;
import utilitaire.ModelView;

@Controleur
public class ProduitController {
    @GetHttp(url="/produit")
    public ModelView renderForm(){
        ModelView mv = new ModelView();
        mv.setView("fiche_produit.jsp");
        return mv;
    }
    @PostHttp(url="/produit")
    public ModelView ficheProduit(Map<String,Object> maps,MapSession){
        ModelView mv  = new ModelView();
        mv.setView("fiche_produit.jsp");
        for(Map.Entry<String ,Object> entry: maps.entrySet()){
            mv.addObject(entry.getKey(),entry.getValue());
        }
        return mv;
        }
}
