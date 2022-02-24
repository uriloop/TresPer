package uri.dam.tresper.torneigs;

import java.util.ArrayList;
import java.util.List;

public class RepositoriTorneigs  {


    List<TorneigElement> torneigsList = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<TorneigElement> torneigsList);
    }

    RepositoriTorneigs(){
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("Best Tournament", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://images.cdn3.stockunlimited.net/preview1300/basketball-championship-label_1992421.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("3x3 BDN", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://mutua.org/wp-content/uploads/2019/07/AAFF-T_CartellTorneigBasquet_LaM%C3%BAtuaKids_4-728x1030.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("KRF 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.tgnbasquet.com/wp-content/uploads/A5E05187-E1C3-459F-AEE6-1C17FF8199A6-610x400.jpeg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("7 de 3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://previews.123rf.com/images/squarelogo/squarelogo1302/squarelogo130200003/17675855-torneo-de-baloncesto-gr%C3%A1fico.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));

    }

    public List<TorneigElement> obtener() {
        return torneigsList;
    }

   /* void insertar(TorneigElement torneigElement, Callback callback){
        torneigsList.add(torneigElement);
        callback.cuandoFinalice(torneigsList);
    }
    void eliminar(TorneigElement torneigElement, Callback callback) {
        torneigsList.remove(torneigElement);
        callback.cuandoFinalice(torneigsList);
    }
    void actualizar(TorneigElement torneigElement, float valoracion, Callback callback) {
        *//*elemento.valoracion = valoracion;*//*
        callback.cuandoFinalice(torneigsList);
    }
*/


}