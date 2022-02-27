package uri.dam.tresper.models;

public class User {

    String nom, imatge;

    public User(String nom, String imatge) {
        this.nom = nom;
        this.imatge = imatge;
    }

    public String getNom() {
        return nom;
    }

    public String getImatge() {
        return imatge;
    }
}
