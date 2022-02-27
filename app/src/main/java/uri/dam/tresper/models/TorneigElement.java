package uri.dam.tresper.models;

import java.util.List;

import uri.dam.tresper.models.EquipElement;

public class TorneigElement {


    String nomTorneig;
    String descripcio;
    String diaIhora;
    String imatgeCartell;
    String mapaGoogle;
    String localitzacio;
    String normes;
    String premis;
    String inscripcio;
    String horaris;
    List<String> imatgesTorneig;

    List<EquipElement> equipsParticipants;


    public TorneigElement(String nomTorneig, String descripcio,String diaIhora,String imatgeCartell,String mapaGoogle,String localitzacio,String premis, String inscripcio,String normes, List<String> imatges, List<EquipElement> equipsParticipants) {
               this.nomTorneig = nomTorneig;
        this.descripcio = descripcio;
        this.diaIhora=diaIhora;
        this.imatgeCartell = imatgeCartell;
        this.mapaGoogle = mapaGoogle;
        this.horaris= horaris;
        this.inscripcio=inscripcio;
        this.premis= premis;
        this.normes= normes;
        this.imatgesTorneig= imatges;
        this.localitzacio=localitzacio;

    }

    public String getLocalitzacio() {
        return localitzacio;
    }

    public String getNormes() {
        return normes;
    }

    public String getPremis() {
        return premis;
    }

    public String getInscripcio() {
        return inscripcio;
    }

    public String getHoraris() {
        return horaris;
    }

    public List<String> getImatgesTorneig() {
        return imatgesTorneig;
    }

    public List<EquipElement> getEquipsParticipants() {
        return equipsParticipants;
    }

    public String getDescripcio() {
        return descripcio;
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