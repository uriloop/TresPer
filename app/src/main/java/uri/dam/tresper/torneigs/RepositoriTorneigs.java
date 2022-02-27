package uri.dam.tresper.torneigs;

import java.util.ArrayList;
import java.util.List;

import uri.dam.tresper.equips.EquipElement;
import uri.dam.tresper.equips.User;

public class RepositoriTorneigs  {


    List<TorneigElement> torneigsList = new ArrayList<>();

    public List<EquipElement> obtenerEquipos() {
        return equips;

    }



    public List<User> obtenerUsers() {

        return users;
    }

    interface Callback {
        void cuandoFinalice(List<TorneigElement> torneigsList);
    }

    List<String> imatges= new ArrayList<>();
    List<EquipElement> equips= new ArrayList<>();
    List<User> users = new ArrayList<>();

    RepositoriTorneigs(){


        users.add(new User("john doe","https://www.milenio.com/uploads/media/2021/03/19/michael-jordan-reuters-2.jpg"));
        users.add(new User("john doe","https://www.milenio.com/uploads/media/2021/03/19/michael-jordan-reuters-2.jpg"));
        users.add(new User("john doe","https://www.milenio.com/uploads/media/2021/03/19/michael-jordan-reuters-2.jpg"));
        users.add(new User("john doe","https://www.milenio.com/uploads/media/2021/03/19/michael-jordan-reuters-2.jpg"));

        users.add(new User("john doe","https://img.europapress.es/fotoweb/fotonoticia_20210223172852_420_v2.jpg"));
        users.add(new User("john doe","https://img.europapress.es/fotoweb/fotonoticia_20210223172852_420_v2.jpg"));

        equips.add(new EquipElement("The winners","El Club Bàsquet Santa Coloma (CBSC) és un club català de basquetbol de la ciutat de Santa Coloma de Gramenet.",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("The winners","Som els millors",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));

        imatges.add("https://estaticos-cdn.prensaiberica.es/clip/7f0678cc-1065-49c3-9ec1-756c9ed5a824_source-aspect-ratio_default_0.jpg");
        imatges.add("https://arenysbasquet.cat/wp-content/gallery/historia/image3.jpg");
        imatges.add("https://estaticos-cdn.prensaiberica.es/clip/ff636f64-9508-4c79-a530-254d2b80a250_source-aspect-ratio_default_0.jpg");


        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.viladetora.net/images/fotos/original/1535035518.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://basquetcentrecatolic.com/wp-content/uploads/2019/07/logo-5e-torneig-300x300.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Concretament el Club Bàsquet Adepaf Figueres, el Club Bàsquet Albera-Peralada i el Bàsquet Castelló organitzen  la primera edició del Torneig Nord, que portarà alguns dels millors clubs i equips de bàsquet formatiu nacional i europeu al nostre municipi. Barça, Penya, Valencia Basket, GEiEG UniGirona, Baloncesto Fuenlabrada, UE Mataró,Femení Sant Adrià… són alguns dels participants en categoria infantil, masculí i femení. El cartell promet i s’albira una competició d’alt nivell, en un torneig que neix amb la voluntat de consolidar-se i ser un referent en bàsquet formatiu, juntament amb el torneig mini, que es celebra la setmana següent i també forma part del Torneig Nord.El Torneig Nord comptarà amb dues seus, Peralada i Castelló d’Empúries s’alternaran en l’organització de partits i activitats d’aquesta cita inèdita a la comarca. Aquest torneig és un resultat més de la col.laboració, que ja des de fa anys el Club Bàsquet Adepaf Figueres, el Club Bàsquet Albera-Peralada i ja des de la temporada passada s’hi ha afegit el Bàsquet Castelló de treball conjunt entre els tres clubs per a fer accions i treballar plegats en benefici i promocionar el bàsquet a la nostra comarca.","10/02/2022","https://www.castello.cat/wp-content/uploads/2021/09/TORNEIG-NORD.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.sfericbasquet.cat/wp-content/uploads/2020/03/post-per-xarxes.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.elperiodic.com/archivos/imagenes/noticias/2021/12/03/cartel-torneo-invierno.jpeg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.elperiodic.com/archivos/imagenes/noticias/2021/12/03/cartel-torneo-invierno.jpeg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://pbs.twimg.com/profile_images/1320609357541888001/5KCOIu___400x400.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Sntk 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.basquetgironi.cat/wp-content/uploads/2018/08/ii-torneig-u13-vilafant.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));

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