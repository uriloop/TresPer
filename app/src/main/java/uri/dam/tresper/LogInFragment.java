package uri.dam.tresper;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.TimeUtils;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import uri.dam.tresper.databinding.FragmentLogInBinding;


public class LogInFragment extends Fragment {

    private FragmentLogInBinding binding;
    ViewGroup views;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        views = container;
        System.out.println(container.getChildCount());

        binding = FragmentLogInBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* retorna al valor inicial VISIBLE als views
        try{

            binding.progressBar.setVisibility(View.GONE);
        }catch (Exception e){}
        for (int i = 0; i < views.getChildCount(); i++) {
            try{views.getChildAt(i).setVisibility(View.VISIBLE);}catch (Exception e){}
        }*/

        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LogInFragment.this)
                        .navigate(R.id.action_log_in_to_register);
            }
        });

        binding.google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Akí canvi d'activitat

/*
                binding.progressBar.setVisibility(View.VISIBLE);
                for (int i = 0; i < views.getChildCount(); i++) {
                    if (views.getChildAt(i).getId() != R.id.root_layout) {
                        views.getChildAt(i).setVisibility(View.GONE);
                    }else{

                    }
                }
                */


                binding.progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                    @Override
                    public void run() {
                        getActivity().finish();
                        startActivity(new Intent(getActivity(), AppActivity.class));
                       /* for (int i = 0; i < views.getChildCount(); i++) {
                            views.getChildAt(i).setVisibility(View.VISIBLE);
                        }
                        binding.progressBar.setVisibility(View.GONE); */
                    }
                }, 1700);

            }
        });
    }


}