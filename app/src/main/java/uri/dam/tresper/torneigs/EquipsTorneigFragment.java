package uri.dam.tresper.torneigs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentEquipsTorneigBinding;
import uri.dam.tresper.databinding.FragmentInfoTorneigBinding;


public class EquipsTorneigFragment extends Fragment {

    NavController navController;

    private FragmentEquipsTorneigBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        binding.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EquipsTorneigFragment.this)
                        .navigate(R.id.action_go_to_Info);
            }
        });
        binding.partitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EquipsTorneigFragment.this)
                        .navigate(R.id.action_go_to_classi);
            }
        });

        ///////////////////////////////////////////////////







    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentEquipsTorneigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}