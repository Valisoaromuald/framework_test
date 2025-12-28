package modele;

public class Meuble {
    public Meuble(String nom) {
        this.nom = nom;
    }

    public Meuble() {
    }

    String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
