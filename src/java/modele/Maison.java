package modele;

import java.util.List;

public class Maison {
    public Maison(String localisation, String adresse, List<Piece> pieces, boolean avecParking) {
        this.localisation = localisation;
        this.adresse = adresse;
        this.pieces = pieces;
        // this.avecParking = avecParking;
    }
    public Maison() {
    }
    String localisation;
    String adresse;
    List<Piece> pieces;
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
    public List<Piece> getPieces() {
        return pieces;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    // public boolean isAvecParking() {
    //     return avecParking;
    // }
    // public void setAvecParking(boolean avecParking) {
    //     this.avecParking = avecParking;
    // }
}
