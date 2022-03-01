package uri.dam.tresper.personal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentClassiTorneigBinding;
import uri.dam.tresper.databinding.FragmentPersonalBinding;
import uri.dam.tresper.databinding.FragmentPersonalTorneigsBinding;
import uri.dam.tresper.torneigs.TorneigsViewModel;


public class PersonalTorneigsFragment extends Fragment {

    NavController navController;
    RecyclerView recyclerView;
    private FragmentPersonalTorneigsBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);


        binding.adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PersonalTorneigsFragment.this)
                        .navigate(R.id.action_go_to_personal_admin);
            }
        });
        binding.novetatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PersonalTorneigsFragment.this)
                        .navigate(R.id.action_go_to_personal_novetats);
            }
        });



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentPersonalTorneigsBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }
}