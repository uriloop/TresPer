package uri.dam.tresper.torneigs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import uri.dam.tresper.equips.EquipElement;
import uri.dam.tresper.equips.User;

public class TorneigsViewModel extends AndroidViewModel {

    RepositoriTorneigs repositoriTorneigs;
    TorneigElement torneigElement;

    MutableLiveData<List<TorneigElement>> listTorneigsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<TorneigElement> torneigSeleccionat = new MutableLiveData<>();

    public TorneigsViewModel(@NonNull Application application) {
        super(application);
        repositoriTorneigs = new RepositoriTorneigs();

        listTorneigsMutableLiveData.setValue(repositoriTorneigs.obtener());
        listEquipsMutableLiveData.setValue(repositoriTorneigs.obtenerEquipos());
        listUsersMutableLiveData.setValue(repositoriTorneigs.obtenerUsers());

    }

    public MutableLiveData<List<TorneigElement>> obtener() {
        return listTorneigsMutableLiveData;
    }


    public void seleccionar(TorneigElement torneigElement) {
        torneigSeleccionat.setValue(torneigElement);
        this.torneigElement=torneigElement;

        //listEquipsMutableLiveData.setValue(torneigElement.getEquipsParticipants());
    }

    public TorneigElement getTorneigElement() {
        return torneigElement;
    }

    MutableLiveData<TorneigElement> seleccionat() {
        return torneigSeleccionat;
    }



/////   equips


    public EquipElement getEquipElement() {
        return equipElement;
    }

    MutableLiveData<List<EquipElement>> listEquipsMutableLiveData = new MutableLiveData<>();

    MutableLiveData<EquipElement> equipSeleccionat = new MutableLiveData<>();
    EquipElement equipElement;

    public MutableLiveData<List<EquipElement>> obtenerEquipos() {
        return listEquipsMutableLiveData;
    }

    public void seleccionarEquip(EquipElement equipElement) {
        equipSeleccionat.setValue(equipElement);
        this.equipElement=equipElement;
    }

////////////////////////////   users


    MutableLiveData<List<User>> listUsersMutableLiveData = new MutableLiveData<>();

    MutableLiveData<User> userSeleccionat = new MutableLiveData<>();
    User user;

    public MutableLiveData<List<User>> obtenerUsers() {
        return listUsersMutableLiveData;
    }







/// per viatjar-hi

    public void seleccionarUser(User userElement) {
        userSeleccionat.setValue(userElement);
        this.user=userElement;
    }




    /*void insertar(TorneigElement torneigElement){
        repositoriTorneigs.insertar(torneigElement, new RepositoriTorneigs.Callback() {
            @Override
            public void cuandoFinalice(List<TorneigElement> torneigsList) {
                listTorneigsMutableLiveData.setValue(torneigsList);
            }
        });
    }*/

   /* void eliminar(TorneigElement torneigElement){
        repositoriTorneigs.eliminar(torneigElement, new RepositoriTorneigs.Callback() {
            @Override
            public void cuandoFinalice(List<TorneigElement> torneigsList) {
                listTorneigsMutableLiveData.setValue(torneigsList);
            }
        });
    }
*/
/*    void actualizar(TorneigElement torneigElement, float valoracion){
        repositoriTorneigs.actualizar(torneigElement, valoracion, new RepositoriTorneigs.Callback() {
            @Override
            public void cuandoFinalice(List<TorneigElement> torneigsList) {
                listTorneigsMutableLiveData.setValue(torneigsList);
            }
        });
    }*/
}