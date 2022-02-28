package uri.dam.tresper.torneigs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import uri.dam.tresper.models.ClassiElement;
import uri.dam.tresper.models.EquipElement;
import uri.dam.tresper.models.Partit;
import uri.dam.tresper.models.RepositoriTorneigs;
import uri.dam.tresper.models.TorneigElement;
import uri.dam.tresper.models.User;

public class TorneigsViewModel extends AndroidViewModel {

    RepositoriTorneigs repositoriTorneigs;
    public TorneigElement torneigElement;

    MutableLiveData<List<TorneigElement>> listTorneigsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<TorneigElement> torneigSeleccionat = new MutableLiveData<>();
    ClassiElement classi;

    public TorneigsViewModel(@NonNull Application application) {
        super(application);
        repositoriTorneigs = new RepositoriTorneigs();

        listTorneigsMutableLiveData.setValue(repositoriTorneigs.obtener());
        listEquipsMutableLiveData.setValue(repositoriTorneigs.obtenerEquipos());
        listUsersMutableLiveData.setValue(repositoriTorneigs.obtenerUsers());
        classi=repositoriTorneigs.obtenerClassi();

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

    public MutableLiveData<TorneigElement> seleccionat() {
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



    ///////////   PARTITS


    Partit partitElement;

    public Partit getPartitElement() {
        return partitElement;
    }

    MutableLiveData<Integer> ronda= new MutableLiveData<>();


    MutableLiveData<List<Partit>> listPartitsMutableLiveData = new MutableLiveData<>();

    MutableLiveData<Partit> partitSeleccionat = new MutableLiveData<>();


    public MutableLiveData<List<Partit>> obtenerPartidos(MutableLiveData<Integer> ronda) {
        this.ronda=ronda;
        listPartitsMutableLiveData.setValue( classi.getRondes().get(ronda.getValue()-1).getPartits());
        return listPartitsMutableLiveData;
    }



    public void seleccionarPartit(Partit partitElement) {
        partitSeleccionat.setValue(partitElement);
        this.partitElement=partitElement;
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