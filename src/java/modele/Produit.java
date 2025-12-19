package modele;

import java.util.List;

public class Produit {
    public String nom;
    public List<String> categories;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<String> getCategories() {
        return categories;
    }
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
