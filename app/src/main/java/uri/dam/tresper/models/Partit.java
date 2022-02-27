package uri.dam.tresper.models;

import uri.dam.tresper.models.EquipElement;

public class Partit {


    EquipElement equip1, equip2;

    String hora, pista;
    int punts1, punts2;

    enum quart {
        PRIMER, SEGON, TERCER, QUART
    }

    quart q;
    String crono;

    public Partit(EquipElement equip1, EquipElement equip2, String hora, String pista, int punts1, int punts2, quart q, String crono) {
        this.equip1 = equip1;
        this.equip2 = equip2;
        this.hora = hora;
        this.pista = pista;
        this.punts1 = punts1;
        this.punts2 = punts2;
        this.q = q;
        this.crono = crono;
    }
}
