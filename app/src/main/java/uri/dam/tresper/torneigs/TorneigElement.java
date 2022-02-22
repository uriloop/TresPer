package uri.dam.tresper.torneigs;

public class TorneigElement {

    String nomTorneig;
    String descripcio;
    String diaIhora;
    String imatgeCartell;
    String mapaGoogle;



    public TorneigElement(String nomTorneig, String descripcio,String diaIhora,String imatgeCartell,String mapaGoogle) {
        this.nomTorneig = nomTorneig;
        this.descripcio = descripcio;
        this.diaIhora=diaIhora;
        this.imatgeCartell = imatgeCartell;
        this.mapaGoogle = mapaGoogle;
    }

    public String getNomTorneig() {
        return nomTorneig;
    }

    public String getDiaIhora() {
        return diaIhora;
    }

    public String getImatgeCartell() {
        return imatgeCartell;
    }

    public String getMapaGoogle() {
        return mapaGoogle;
    }
}