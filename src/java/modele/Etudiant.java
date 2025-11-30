package modele;

public class Etudiant {
    public Etudiant(Integer id,String nom, String prenoms) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
    }
    public Etudiant() {
    }
    public Integer id;
    public String nom;
    public String prenoms;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
