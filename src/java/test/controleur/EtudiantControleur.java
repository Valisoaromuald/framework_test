package test.controleur;

import java.util.ArrayList;
import java.util.List;

import annotation.Controleur;
import annotation.UrlMapping;
import test.modele.Etudiant;

@Controleur
public class EtudiantControleur { 
    private static List<Etudiant> etudiants = new ArrayList<>(
    List.of(
        new Etudiant(1, "rakoto", "beloha"),
        new Etudiant(2, "randria", "mahasosotra")
    )
);
    @UrlMapping(url="/etudiant/{id}")
    public String  getEtudiantById(int id){
        Etudiant etu = null;
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i< etudiants.size();i++){
            if(etudiants.get(i).getId() == id){
                etu = etudiants.get(i);
            }
        }
        if(etu != null){
            builder.append("id: "+etu.getId());
            builder.append("nom: "+etu.getNom());
            builder.append("prenoms: "+etu.getPrenoms());
        }
        else{
            builder.append("l'etudiant n'existe pas");
        }
        return builder.toString();
    }
}
