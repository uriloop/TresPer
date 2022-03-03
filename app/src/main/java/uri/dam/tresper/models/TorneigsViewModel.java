package uri.dam.tresper.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TorneigsViewModel extends AndroidViewModel {

    RepositoriTorneigs repositoriTorneigs;
    public TorneigElement torneigElement;

    MutableLiveData<List<TorneigElement>> listTorneigsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<TorneigElement> torneigSeleccionat = new MutableLiveData<>();
    ClassiElement classi;
    String fotoPerfilFons;
    List<TorneigElement> torneigElementList= new ArrayList<>();

    boolean inscritObert;

    public boolean isMissatgesObert() {
        return missatgesObert;
    }

    public void setMissatgesObert(boolean missatgesObert) {
        this.missatgesObert = missatgesObert;
    }

    boolean missatgesObert;

    public boolean isInvitacionsObert() {
        return invitacionsObert;
    }

    public void setInvitacionsObert(boolean invitacionsObert) {
        this.invitacionsObert = invitacionsObert;
    }

    boolean invitacionsObert;


    public boolean isAmicsObert() {
        return amicsObert;
    }

    public void setAmicsObert(boolean amicsObert) {
        this.amicsObert = amicsObert;
    }

    boolean amicsObert;

    public boolean isInscritObert() {
        return inscritObert;
    }

    public void setInscritObert(boolean inscritObert) {
        this.inscritObert = inscritObert;
    }

    public List<TorneigElement> getListTorneigs() {
        return torneigElementList;
    }

    public TorneigsViewModel(@NonNull Application application) {
        super(application);
        repositoriTorneigs = new RepositoriTorneigs();
torneigElementList=repositoriTorneigs.getTorneigsList();
        listTorneigsMutableLiveData.setValue(repositoriTorneigs.obtener());
        listEquipsMutableLiveData.setValue(repositoriTorneigs.obtenerEquipos());
        listUsersMutableLiveData.setValue(repositoriTorneigs.obtenerUsers());
        classi=repositoriTorneigs.obtenerClassi();
fotoPerfilFons= repositoriTorneigs.getFotoFonsPerfil();
listNovetatMutableLiveData.setValue(repositoriTorneigs.getNovetats());
inscritObert=false;
amicsObert=false;

    }

    public User getUser() {
        return user;
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


    ///// VARIAT


    public String getFonsPerfil() {
        return repositoriTorneigs.getFotoFonsPerfil();
    }


    /////////  NOVETATS
    Novetat novetat;

    public Novetat getNovetat() {
        return novetat;
    }




    MutableLiveData<List<Novetat>> listNovetatMutableLiveData = new MutableLiveData<>();

    MutableLiveData<Novetat> novetatSeleccionat = new MutableLiveData<>();


    public MutableLiveData<List<Novetat>> obtenerNovedades() {

        return listNovetatMutableLiveData;
    }



    public void seleccionarNovetat(Novetat novetat) {
        novetatSeleccionat.setValue(novetat);
        this.novetat=novetat;
    }

    public String getImatgePerfil() {
        return repositoriTorneigs.getFotoPerfil();
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