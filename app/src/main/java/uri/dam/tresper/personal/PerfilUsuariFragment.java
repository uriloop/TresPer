package uri.dam.tresper.personal;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import uri.dam.tresper.databinding.FragmentPerfilUsuariBinding;
import uri.dam.tresper.models.TorneigsViewModel;


public class PerfilUsuariFragment extends Fragment {



    NavController navController;
    private FragmentPerfilUsuariBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        binding.nomUserTextview.setText(torneigsViewModel.getUser().getNom());
        Glide.with(getContext()).load(torneigsViewModel.getUser().getImatge())
                .centerInside()
                .into(binding.imatgePerfilUser);
        Glide.with(getContext()).load(torneigsViewModel.getUser().getImatge())
                .centerInside()
                .into(binding.imatgeFonsPerfil);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {

        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPerfilUsuariBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}