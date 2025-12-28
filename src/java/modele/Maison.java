package modele;

public class Maison {
    public Maison(String localisation, String adresse, Piece[] pieces, boolean avecParking) {
        this.localisation = localisation;
        this.adresse = adresse;
        this.pieces = pieces;
        // this.avecParking = avecParking;
    }
    public Maison() {
    }
    String localisation;
    String adresse;
    Piece[] pieces;
    // boolean avecParking;
    public String getLocalisation() {
        return localisation;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public Piece[] getPieces() {
        return pieces;
    }
    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }
    // public boolean isAvecParking() {
    //     return avecParking;
    // }
    // public void setAvecParking(boolean avecParking) {
    //     this.avecParking = avecParking;
    // }
}
