package uri.dam.tresper.models;

public class Partit {


    public EquipElement getEquip1() {
        return equip1;
    }

    public EquipElement getEquip2() {
        return equip2;
    }

    public String getHora() {
        return hora;
    }

    public String getPista() {
        return pista;
    }

    public int getPunts1() {
        return punts1;
    }

    public int getPunts2() {
        return punts2;
    }


    public int getQ() {
        return q.quartInteger;
    }



    public String getCrono() {
        return crono;
    }


    ///////////////
    EquipElement equip1, equip2;

    String hora, pista;
    int punts1, punts2;

    enum quart {
        PRIMER(1), SEGON(2), TERCER(3), QUART(4);

        private final int quartInteger;

        quart(int quartInteger) {
            this.quartInteger = quartInteger;
        }
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
