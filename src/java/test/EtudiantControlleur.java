package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import annotation.Controleur;
import annotation.GetHttp;
import annotation.InputParam;
import annotation.PostHttp;
import annotation.UrlMapping;
import modele.Etudiant;
import utilitaire.ModelView;

@Controleur
public class EtudiantControlleur {
    @UrlMapping(url="/hello")
    public String Hello(){
        return "manao ahoana";
    }
    static List<Etudiant> etudiants = new ArrayList<Etudiant>(

    List.of(
        new Etudiant(1,"rakoto","beloha"),
        new Etudiant(2,"rabe","misaina"),
        new Etudiant(3,"rasoa ","ketaka")
    )
    );
    @UrlMapping(url="/informatique")
    public ModelView viewInformatique(){
        ModelView mv = new ModelView();
        mv.setView("test.jsp");
        mv.addObject("listeEtudiant",etudiants);
        mv.addObject("nomPersonne","Fsc mozika");
        return mv;
    }
    @UrlMapping(url="/etudiant/{id}")
    public String getDetails(int id){
        if(id == 0){
            return "Aucun id fourni";
        }
        StringBuilder builder = new StringBuilder();
        for(Etudiant et: etudiants){
            if(et.getId()==id){
                builder.append("<strong>id:</strong>"+et.getId()+"\n");
                builder.append("<strong>nom:</strong>"+et.getNom()+"\n");
                builder.append("<strong>prenoms:</strong>"+et.getPrenoms()+"\n");
                break;
            }
        }
        return builder.toString();
    }
    @UrlMapping(url="/form_etudiant")
    public ModelView formEtudiant(){
        ModelView mv= new ModelView();
        mv.setView("form-etudiant.jsp");
        mv.addObject("listeEtudiant", this.etudiants);
        return mv;
    }
    @UrlMapping(url="/etudiants")
    public String addEtudiant(String nom, String prenoms){
        int lastId = this.etudiants.size();
        int currentId = lastId+1;
        Etudiant e = new Etudiant(currentId,nom,prenoms);
        this.etudiants.add(e);
        return "etudiant ajoute avec succes";
    }
    @UrlMapping(url = "/recherche_etudiant")
    public ModelView formRechercheEtudiant(){
        ModelView mv = new ModelView();
        mv.setView("recherche_etudiant.jsp");
        return mv; 
    }
    @UrlMapping(url="/etudiants_info")
    public String getInfoEtudiants(String nom, @InputParam(paramName = "identifiant") int id ){
        
        for(Etudiant et: etudiants){
            if(et.getNom().equals(nom) && et.getId() == id){
                
                return "info etudiant: {nom: "+nom+"; identifiant: "+id+" }";
            } 
        }
        
            return "etudiant non trouve";
        
    }
    @UrlMapping(url="/etudiants/{id}/{nom}/{prenoms}")
    public String afficherInfoEtudiant(int id,String nom, String prenoms){
        for(Etudiant et: etudiants){
            System.out.println("ahona hoe"+nom+" ; "+id);
            if(et.getNom().equals(nom) && et.getId() == id){
                return "info etudiant: {nom: "+nom+"+prenoms:"+prenoms+ "; identifiant: "+id+" }";
            } 
        }
        return "etudiant non trouve";
    }
    @GetHttp(url="/etudiants")
    public String  getAllEtudiants(){
        StringBuilder builder = new StringBuilder();
        for(Etudiant et: etudiants){
            builder.append("id: "+et.getId()+"\n");
            builder.append("nom: "+et.getNom()+"\n");
            builder.append("prenoms: "+et.getPrenoms()+"\n");
            builder.append("------------------\n");
        }
        return builder.toString();
    }
    @PostHttp(url="/etudiants")
    public String creerEtudiant(String nom ,Map<String,Object> objects){
        List<String> chaines  = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        builder.append("POST no mamaly \n");
        for(Map.Entry<String,Object> entry: objects.entrySet()){
            builder.append(entry.getKey()+" "+ entry.getValue());
        }
        // int lastId = this.etudiants.size();
        // int currentId = lastId+1;
        // Etudiant e = new Etudiant(currentId,nom,prenoms);
        // this.etudiants.add(e);
        // builder.append("etudiant added with success");
        return builder.toString();
    }
    

}

