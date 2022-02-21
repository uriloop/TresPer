package uri.dam.tresper.torneigs;

import java.util.ArrayList;
import java.util.List;

public class RepositoriTorneigs  {


    List<TorneigElement> torneigsList = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<TorneigElement> torneigsList);
    }

    RepositoriTorneigs(){
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022 a partir de les 6","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022 a partir de les 6","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022 a partir de les 6","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022 a partir de les 6","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022 a partir de les 6","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses"));

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
