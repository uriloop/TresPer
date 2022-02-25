package uri.dam.tresper.torneigs;

import java.util.ArrayList;
import java.util.List;

import uri.dam.tresper.equips.EquipElement;
import uri.dam.tresper.equips.User;

public class RepositoriTorneigs  {


    List<TorneigElement> torneigsList = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<TorneigElement> torneigsList);
    }

    List<String> imatges= new ArrayList<>();
    List<EquipElement> equips= new ArrayList<>();
    List<User> users = new ArrayList<>();

    RepositoriTorneigs(){

        users.add(new User("john doe","https://upload.wikimedia.org/wikipedia/commons/5/5c/1_marc_gasol_toronto_raptors_2019_%28cropped%29.jpg"));
        users.add(new User("john doe","https://img.europapress.es/fotoweb/fotonoticia_20210223172852_420_v2.jpg"));

        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        imatges.add("https://estaticos-cdn.prensaiberica.es/clip/7f0678cc-1065-49c3-9ec1-756c9ed5a824_source-aspect-ratio_default_0.jpg");
        imatges.add("https://arenysbasquet.cat/wp-content/gallery/historia/image3.jpg");
        imatges.add("https://estaticos-cdn.prensaiberica.es/clip/ff636f64-9508-4c79-a530-254d2b80a250_source-aspect-ratio_default_0.jpg");


        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d889.0126907850679!2d2.20228085303543!3d41.4550515915349!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sca!2ses!4v1645404884800!5m2!1sca!2ses","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));

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