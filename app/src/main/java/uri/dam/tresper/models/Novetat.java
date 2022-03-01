package uri.dam.tresper.models;

public class Novetat {



    String titol, imatge, textImatge, text, tipus;

    public String getTitol() {
        return titol;
    }

    public String getImatge() {
        return imatge;
    }

    public String getTextImatge() {
        return textImatge;
    }

    public String getTipus() {
        return tipus;
    }

    public String getText() {
        return text;
    }

    public Novetat(String titol, String imatge, String textImatge, String text, String tipus) {
        this.titol = titol;
        this.imatge = imatge;
        this.textImatge = textImatge;
        this.text = text;
        this.tipus=tipus;
    }
}
