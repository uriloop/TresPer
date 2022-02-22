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
import uri.dam.tresper.databinding.FragmentHelpBinding;
import uri.dam.tresper.databinding.FragmentMostraTorneigBinding;

public class MostraTorneigFragment extends Fragment {
    TorneigsViewModel torneigsViewModel;
    FragmentMostraTorneigBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentMostraTorneigBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_mostra_torneig, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().getFragmentManager().popBackStack();
    }
}