package uri.dam.tresper.torneigs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentMostraTorneigBinding;

public class MostraTorneigFragment extends Fragment {
    TorneigsViewModel torneigsViewModel;
    FragmentMostraTorneigBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        torneigsViewModel.seleccionat().observe(getViewLifecycleOwner(), new Observer<TorneigElement>() {
            @Override
            public void onChanged(TorneigElement torneigElement) {
                binding.nomTorneig.setText(torneigElement.nombre);
                binding.imatgeTorneig.setText(torneigElement.descripcion);
                binding.valoracion.setRating(torneigElement.valoracion);


            }
        });
    }
}