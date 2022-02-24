package uri.dam.tresper.equips;

import java.util.ArrayList;
import java.util.List;

import uri.dam.tresper.torneigs.TorneigElement;

public class RepositoriEquips {


    List<EquipElement> equipsList = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<EquipElement> torneigsList);
    }

    RepositoriEquips(){
        equipsList.add(new EquipElement("The Winners", "Los mejores sin dudarlo. ","uriloop","https://brandemia.org/sites/default/files/sites/default/files/milwaukee_bucks_logo_nuevo_logo.png","user1","user2","user3"));
        equipsList.add(new EquipElement("The Winners", "Los mejores sin dudarlo. ","uriloop","https://brandemia.org/sites/default/files/sites/default/files/milwaukee_bucks_logo_nuevo_logo.png","user1","user2","user3"));
        equipsList.add(new EquipElement("The Winners", "Los mejores sin dudarlo. ","uriloop","https://brandemia.org/sites/default/files/sites/default/files/milwaukee_bucks_logo_nuevo_logo.png","user1","user2","user3"));
        equipsList.add(new EquipElement("The Winners", "Los mejores sin dudarlo. ","uriloop","https://brandemia.org/sites/default/files/sites/default/files/milwaukee_bucks_logo_nuevo_logo.png","user1","user2","user3"));
        equipsList.add(new EquipElement("The Winners", "Los mejores sin dudarlo. ","uriloop","https://brandemia.org/sites/default/files/sites/default/files/milwaukee_bucks_logo_nuevo_logo.png","user1","user2","user3"));

    }

    public List<EquipElement> obtener() {
        return equipsList;
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

