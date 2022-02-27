package uri.dam.tresper.equips;

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
