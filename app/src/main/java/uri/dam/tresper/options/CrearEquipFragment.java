package uri.dam.tresper.options;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentCrearEquipBinding;


public class CrearEquipFragment extends Fragment {

    NavController navController;

    private FragmentCrearEquipBinding binding;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        navController = Navigation.findNavController(view);


        binding.crearEquipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CrearEquipFragment.this)
                        .navigate(R.id.action_go_to_personal);
            }
        });


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentCrearEquipBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}