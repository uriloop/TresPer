package uri.dam.tresper.models;

import java.util.ArrayList;
import java.util.List;

public class EquipElement {

    List<User> participants= new ArrayList<>();
    String nom, descripcio, imatge;
    User creador;

    public EquipElement(String nom, String descripcio, User creador, String imatge, List<User> users) {

        this.nom= nom;
        this.descripcio= descripcio;
        this.creador= creador;
        this.imatge= imatge;
        for (User user:
             users) {
            participants.add(user);
        }


    }

    public List<User> getParticipants() {
        return participants;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getImatge() {
        return imatge;
    }

    public User getCreador() {
        return creador;
    }
}
