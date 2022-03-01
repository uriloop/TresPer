package uri.dam.tresper.models;

import java.util.ArrayList;
import java.util.List;

public class RepositoriTorneigs  {


    List<TorneigElement> torneigsList = new ArrayList<>();

    public List<EquipElement> obtenerEquipos() {
        return equips;

    }



    public List<User> obtenerUsers() {

        return users;
    }

    public ClassiElement obtenerClassi() {

        return classi;
    }

    public String getFotoFonsPerfil() {
        String urlFotoFonsperfil="https://as1.ftcdn.net/v2/jpg/02/77/95/04/1000_F_277950498_PrtIbgrtxoiyD9vkGNsYOqIwWNQeF8mV.jpg" ;
        return  urlFotoFonsperfil;
    }

    public String getFotoPerfil() {
        return  "https://robertorico.es/wp-content/uploads/2016/11/12-400x600.jpg";
    }

    interface Callback {
        void cuandoFinalice(List<TorneigElement> torneigsList);
    }

    List<String> imatges= new ArrayList<>();
    List<EquipElement> equips= new ArrayList<>();
    List<User> users = new ArrayList<>();
    ClassiElement classi;
    List<Novetat> novetats;

    public RepositoriTorneigs(){




        users.add(new User("Shaki_93","https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"));
        users.add(new User("brian_lopez","https://library.sportingnews.com/2021-08/kobe-bryant-getty-022720-ftrjpg_133gft6g4mxsu1jg75nkkmcln6.jpg"));
        users.add(new User("riki_bcn","https://robertorico.es/wp-content/uploads/2016/11/12-400x600.jpg"));
        users.add(new User("noPain","https://www.milenio.com/uploads/media/2021/03/19/michael-jordan-reuters-2.jpg"));

        users.add(new User("julia_bskt","https://cdn4.sportngin.com/attachments/news_article/a291-135350011/blake__2__thumb.png"));
        users.add(new User("gasoil","https://img.europapress.es/fotoweb/fotonoticia_20210223172852_420_v2.jpg"));

        equips.add(new EquipElement("The future team","El Club Bàsquet Santa Coloma (CBSC) és un club català de basquetbol de la ciutat de Santa Coloma de Gramenet.",new User("uriloop", "https://meridiano.net/fotos_meridiano/16451037451325344105.jpg"),"https://cdn5.f-cdn.com/contestentries/1538916/27211451/5d2f59fbd6e6b_thumb900.jpg",users));
        equips.add(new EquipElement("Sharks","El basquetbol, popularment conegut com a bàsquet, és un esport practicat entre dos equips de cinc jugadors en joc cadascun, que cerquen d'introduir una pilota dins de la cistella defensada per l'equip contrari, amb l'objectiu d'aconseguir més punts que l'adversari, tot respectant les regles del joc.\n" +
                "\n" +
                "El bàsquet va néixer als Estats Units l'any 1891, inventat per James Naismith,[1] professor d'educació física de la YMCA",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://previews.123rf.com/images/pixelogan/pixelogan1802/pixelogan180200050/95825930-vecteur-de-logo-d-%C3%A9quipe-de-basket-ball-de-requin.jpg",users));
        equips.add(new EquipElement("Draft Grmnt","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://www.gramenet.cat/fileadmin/user_upload/draftexp.jpg",users));
        equips.add(new EquipElement("The masters","El basquetbol, popularment conegut com a bàsquet, és un esport practicat entre dos equips de cinc jugadors en joc cadascun, que cerquen d'introduir una pilota dins de la cistella defensada per l'equip contrari, amb l'objectiu d'aconseguir més punts que l'adversari, tot respectant les regles del joc.\n" +
                "\n" +
                "El bàsquet va néixer als Estats Units l'any 1891, inventat per James Naismith,[1] professor d'educació física de la YMCA",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://www.nicepng.com/png/detail/141-1416028_master-basketball-logo-de-equipo-de-los-baloncesto.png",users));
        equips.add(new EquipElement("FustaDura team","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://i.pinimg.com/originals/f3/79/38/f379385c99470dc84fbbdaf5f89fa4f1.png",users));
        equips.add(new EquipElement("Gigantes","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://sites.google.com/site/basketfansvenezuela/_/rsrc/1470332658307/liga-profesional-de-baloncesto/gigan.jpg",users));
        equips.add(new EquipElement("Waves team","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://1757140519.rsc.cdn77.org/blog/wp-content/uploads/sites/4/2019/03/0007_t_iowa-waves-logo_8.png",users));
        equips.add(new EquipElement("Santos sant Luis","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://imagenes.milenio.com/uj9lbMgYIFa7n4Ba9HeNWHc8VGE=/0x530/https://www.milenio.com/uploads/media/2015/10/21/logo-equipo-santos-san-luis.png",users));
        equips.add(new EquipElement("SNTK team","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://www.viasona.cat/imatges/clubsesportius/club-basquet-santa-coloma-escut.jpg",users));
        equips.add(new EquipElement("SNTK team","El basquetbol, popularment conegut com a bàsquet, és un esport practicat entre dos equips de cinc jugadors en joc cadascun, que cerquen d'introduir una pilota dins de la cistella defensada per l'equip contrari, amb l'objectiu d'aconseguir més punts que l'adversari, tot respectant les regles del joc.\n" +
                "\n" +
                "El bàsquet va néixer als Estats Units l'any 1891, inventat per James Naismith,[1] professor d'educació física de la YMCA",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://www.viasona.cat/imatges/clubsesportius/club-basquet-santa-coloma-escut.jpg",users));
        equips.add(new EquipElement("SNTK team","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://www.viasona.cat/imatges/clubsesportius/club-basquet-santa-coloma-escut.jpg",users));
        equips.add(new EquipElement("SNTK team","Som els millors",new User("uriloop", "https://elgurudelbasket.com/wp-content/uploads/2021/12/shaq-play-button-1.jpg"),"https://www.viasona.cat/imatges/clubsesportius/club-basquet-santa-coloma-escut.jpg",users));

        imatges.add("https://estaticos-cdn.prensaiberica.es/clip/7f0678cc-1065-49c3-9ec1-756c9ed5a824_source-aspect-ratio_default_0.jpg");
        imatges.add("https://arenysbasquet.cat/wp-content/gallery/historia/image3.jpg");
        imatges.add("https://estaticos-cdn.prensaiberica.es/clip/ff636f64-9508-4c79-a530-254d2b80a250_source-aspect-ratio_default_0.jpg");


        torneigsList.add(new TorneigElement("Torà 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.viladetora.net/images/fotos/original/1535035518.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Torneig Nord", "Concretament el Club Bàsquet Adepaf Figueres, el Club Bàsquet Albera-Peralada i el Bàsquet Castelló organitzen  la primera edició del Torneig Nord, que portarà alguns dels millors clubs i equips de bàsquet formatiu nacional i europeu al nostre municipi. Barça, Penya, Valencia Basket, GEiEG UniGirona, Baloncesto Fuenlabrada, UE Mataró,Femení Sant Adrià… són alguns dels participants en categoria infantil, masculí i femení. El cartell promet i s’albira una competició d’alt nivell, en un torneig que neix amb la voluntat de consolidar-se i ser un referent en bàsquet formatiu, juntament amb el torneig mini, que es celebra la setmana següent i també forma part del Torneig Nord.El Torneig Nord comptarà amb dues seus, Peralada i Castelló d’Empúries s’alternaran en l’organització de partits i activitats d’aquesta cita inèdita a la comarca. Aquest torneig és un resultat més de la col.laboració, que ja des de fa anys el Club Bàsquet Adepaf Figueres, el Club Bàsquet Albera-Peralada i ja des de la temporada passada s’hi ha afegit el Bàsquet Castelló de treball conjunt entre els tres clubs per a fer accions i treballar plegats en benefici i promocionar el bàsquet a la nostra comarca.","10/02/2022","https://www.castello.cat/wp-content/uploads/2021/09/TORNEIG-NORD.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Basquet na RUA", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.pontecesures.net/wp-content/uploads/2012/09/CARTEL-3X3-2012-web1.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("27é Torneig Terrassa", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.sfericbasquet.cat/wp-content/uploads/2020/03/post-per-xarxes.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("XI torneig d'hivern", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.elperiodic.com/archivos/imagenes/noticias/2021/12/03/cartel-torneo-invierno.jpeg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("Paracuellos de Jarama", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://deporticket.blob.core.windows.net/deporticket/21-cartel/210613-torneo-baloncesto-3x3-cartel.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("V Ktòlic", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://basquetcentrecatolic.com/wp-content/uploads/2019/07/logo-5e-torneig-300x300.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("El Olivar 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://pbs.twimg.com/profile_images/1320609357541888001/5KCOIu___400x400.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));
        torneigsList.add(new TorneigElement("U13 3x3", "Es un átomo con moléculas, aquella sustancia que no puede ser descompuesta mediante una reacción químicas y, ensus isótopos.","10/02/2022","https://www.basquetgironi.cat/wp-content/uploads/2018/08/ii-torneig-u13-vilafant.jpg","-Not Found-","C/Victor Hugo nº45, Santa Coloma de Gramenet, a l'institut Puig Castellar","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots","A part de molta diversio, els guanyadors s'emportaran una samarreta d’obsequi, l’entrada a la piscina del recinte i altres premis per a tots",imatges,equips));


        novetats= new ArrayList<>();
        novetats.add(new Novetat("AVÍS IMPORTANT","https://robertorico.es/wp-content/uploads/2016/11/12-400x600.jpg","SNTK 3x3","EL torneig SNTK 3x3 queda anulat degut al temporal recent que ha deixat desperfectes al camp.","NOTICIA"));
        novetats.add(new Novetat("Nou torneig a la vista!","https://www.sfericbasquet.cat/wp-content/uploads/2020/03/post-per-xarxes.jpg","Torneig Sntk","Hi ha un nou torneig creat fes-li una ullada ;)","NOU_TORNEIG"));
        novetats.add(new Novetat("Ens apuntem?!","https://robertorico.es/wp-content/uploads/2016/11/12-400x600.jpg","jugon_90","Eiii! és el cap de setmana que entra, ja som 2 endevina qui...","MP"));
        novetats.add(new Novetat("Recordatori inscripció","https://pbs.twimg.com/media/DU3oWNgU8AEZXWW.jpg","BasquetBot"," 1d 21h 10m  Queda molt poc per a que comenci el torneig, no facis tard ;) ","RECORDATORI_AUTO"));
        novetats.add(new Novetat("Tens un nou amic","https://pbs.twimg.com/media/DU3oWNgU8AEZXWW.jpg","BasquetBot","En jugon_90 t'ha afegit a la seva llista d'amics ;)","NOVA_AMISTAT"));
        novetats.add(new Novetat("Nou torneig a la vista!","https://www.sfericbasquet.cat/wp-content/uploads/2020/03/post-per-xarxes.jpg","Torneig Sntk","Hi ha un nou torneig creat fes-li una ullada ;)","NOU_TORNEIG"));
        novetats.add(new Novetat("Ens apuntem?!","https://robertorico.es/wp-content/uploads/2016/11/12-400x600.jpg","jugon_90","Eiii! és el cap de setmana que entra, ja som 2 endevina qui...","MP"));
        novetats.add(new Novetat("Recordatori inscripció","https://pbs.twimg.com/media/DU3oWNgU8AEZXWW.jpg","BasquetBot"," 1d 21h 10m  Queda molt poc per a que comenci el torneig, no facis tard ;) ","RECORDATORI_AUTO"));
        novetats.add(new Novetat("Tens un nou amic","https://pbs.twimg.com/media/DU3oWNgU8AEZXWW.jpg","BasquetBot","En jugon_90 t'ha afegit a la seva llista d'amics ;)","NOVA_AMISTAT"));


        List<Partit> partits= new ArrayList<>();
        partits.add(new Partit(equips.get(0), equips.get(1),"10:00","p. central",0,0, Partit.quart.SEGON,"2:10" ));
        partits.add(new Partit(equips.get(2), equips.get(3),"10:00","pista 2",0,0, Partit.quart.TERCER,"2:44" ));
        partits.add(new Partit(equips.get(4), equips.get(5),"10:15","p. central",0,0, Partit.quart.PRIMER,"3:00" ));
        partits.add(new Partit(equips.get(6), equips.get(7),"10:15","pista 2",0,0, Partit.quart.PRIMER,"3:00" ));
        partits.add(new Partit(equips.get(8), equips.get(9),"10:30","p. central",0,0, Partit.quart.PRIMER,"3:00" ));
        partits.add(new Partit(equips.get(10), equips.get(11),"10:30","pista 2",0,0, Partit.quart.PRIMER,"3:00" ));
        List<Ronda> rondes=new ArrayList<>();
        rondes.add(new Ronda(partits));
                classi= new ClassiElement(rondes);

    }

    public List<Novetat> getNovetats() {
        return novetats;
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