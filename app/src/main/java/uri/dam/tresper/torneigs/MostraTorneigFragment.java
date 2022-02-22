package uri.dam.tresper.torneigs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uri.dam.tresper.LogInFragment;
import uri.dam.tresper.R;
import uri.dam.tresper.databinding.ActivityMainBinding;
import uri.dam.tresper.databinding.FragmentMostraTorneigBinding;


public class MostraTorneigFragment extends Fragment {
    TorneigsViewModel torneigsViewModel;
    FragmentMostraTorneigBinding binding;
    private AppBarConfiguration appBarConfiguration;

    NavController navController;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMostraTorneigBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navController = Navigation.findNavController(this.getActivity(), R.id.nav_host_fragment_content_torneigs);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this.getActivity(), navController, appBarConfiguration);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonClassi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MostraTorneigFragment.this)
                        .navigate(R.id.action_go_classi);
            }
        });
        binding.buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MostraTorneigFragment.this)
                        .navigate(R.id.action_go_info);
            }
        });
        binding.buttonEquips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MostraTorneigFragment.this)
                        .navigate(R.id.action_go_equips);
            }
        });
    }
}