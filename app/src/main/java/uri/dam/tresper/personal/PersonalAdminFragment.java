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

import com.bumptech.glide.Glide;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentPersonalAdminBinding;
import uri.dam.tresper.databinding.FragmentPersonalBinding;
import uri.dam.tresper.torneigs.TorneigsViewModel;


public class PersonalAdminFragment extends Fragment {


    NavController navController;
    RecyclerView recyclerView;
    private FragmentPersonalAdminBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        Glide.with(getContext()).load(torneigsViewModel.getFonsPerfil())
                .centerInside()
                .into(binding.imatgeFonsPerfil);
        Glide.with(getContext()).load(torneigsViewModel.getEquipElement().getCreador().getImatge())
                .centerInside()
                .into(binding.imatgePerfilUser);

        binding.novetatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PersonalAdminFragment.this)
                        .navigate(R.id.action_go_to_personal_novetats);
            }
        });
        binding.torneigsPersonalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PersonalAdminFragment.this)
                        .navigate(R.id.action_go_to_personal_torneigs);
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
        binding= FragmentPersonalAdminBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;    }
}