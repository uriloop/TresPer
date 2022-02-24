package uri.dam.tresper.torneigs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentInfoTorneigBinding;
import uri.dam.tresper.databinding.FragmentTorneigsBinding;


public class InfoTorneigFragment extends Fragment {

    NavController navController;

    private FragmentInfoTorneigBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        binding.equipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoTorneigFragment.this)
                        .navigate(R.id.action_go_to_equips);
            }
        });
        binding.partitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoTorneigFragment.this)
                        .navigate(R.id.action_go_to_classi);
            }
        });


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentInfoTorneigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


}