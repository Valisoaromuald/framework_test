package modele;

public class Piece {
    public Piece(String designation, Meuble[] meubles) {
        this.designation = designation;
        this.meubles = meubles;
    }
    public Piece() {
    }
    String designation;
    Meuble[] meubles;
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Meuble[] getMeubles() {
        return meubles;
    }
    public void setMeubles(Meuble[] meubles) {
        this.meubles = meubles;
    }
}
