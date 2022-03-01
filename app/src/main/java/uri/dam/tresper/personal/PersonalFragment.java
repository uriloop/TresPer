package uri.dam.tresper.personal;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

import uri.dam.tresper.R;

import uri.dam.tresper.databinding.FragmentPersonalAdminBinding;
import uri.dam.tresper.databinding.FragmentPersonalBinding;
import uri.dam.tresper.equips.EquipsTorneigFragment;
import uri.dam.tresper.models.Novetat;
import uri.dam.tresper.models.RepositoriTorneigs;
import uri.dam.tresper.models.User;
import uri.dam.tresper.torneigs.TorneigsViewModel;


public class PersonalFragment extends Fragment {

    NavController navController;
    RecyclerView recyclerView;
    private FragmentPersonalBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        Glide.with(getContext()).load(torneigsViewModel.getFonsPerfil())
                .centerInside()
                .into(binding.imatgeFonsPerfil);
        Glide.with(getContext()).load(torneigsViewModel.getImatgePerfil())
                .centerInside()
                .into(binding.imatgePerfilUser);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {

        }

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);


       /* binding.adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PersonalFragment.this)
                        .navigate(R.id.action_go_to_personal_admin);
            }
        });
        binding.torneigsPersonalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PersonalFragment.this)
                        .navigate(R.id.action_go_to_personal_torneigs);
            }
        });*/



    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentPersonalBinding.inflate(inflater,container,false);
     /*   final FoldingCell fc = (FoldingCell) binding.foldingCell;
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });
final FoldingCell fc2 = (FoldingCell) binding.foldingCell2;
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc2.toggle(false);
            }
        });
*/


        View root = binding.getRoot();
        return root;
    }
}