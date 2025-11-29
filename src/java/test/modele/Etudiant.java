package test.modele;

public class Etudiant {
    private int id;
    private String nom;
    private String prenoms;
    public Etudiant() {
    }
    public Etudiant(int id, String nom, String prenoms) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenoms() {
        return prenoms;
    }
    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }
}
