package uri.dam.tresper.torneigs;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TorneigsViewModel extends AndroidViewModel {

    RepositoriTorneigs repositoriTorneigs;

    MutableLiveData<List<TorneigElement>> listTorneigsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<TorneigElement> torneigSeleccionat = new MutableLiveData<>();

    public TorneigsViewModel(@NonNull Application application) {
        super(application);
        repositoriTorneigs = new RepositoriTorneigs();

        listTorneigsMutableLiveData.setValue(repositoriTorneigs.obtener());
    }

    public MutableLiveData<List<TorneigElement>> obtener(){
        return listTorneigsMutableLiveData;
    }
    void seleccionar(TorneigElement torneigElement){
        torneigSeleccionat.setValue(torneigElement);
    }

    MutableLiveData<TorneigElement> seleccionado(){
        return torneigSeleccionat;
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
