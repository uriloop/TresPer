package uri.dam.tresper;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.TimeUtils;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

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
        TextView recuperaPassword= binding.forgetPasswd;

        binding.forgetPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperaPassword.setOnClickListener(new View.OnClickListener() {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

                    @Override
                    public void onClick(View view) {
                        alert.setTitle("Recuperar contrassenya");
                        alert.setMessage("Introdueix el teu email");

// Set an EditText view to get user input
                        final EditText input = new EditText(getContext());
                        alert.setView(input);

                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                recuperarContrasenaGoogle(view,input);
                            }
                        });

                        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // Canceled.
                            }
                        });

                        alert.show();

                    }
                });
            }
        });

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

        binding.buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int noEsMail = 0;
                noEsMail = 0;
                String email = binding.editTextEmailAddress.getText().toString();
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) == '@') noEsMail = 1;
                }


                if (binding.editTextEmailAddress.getText().length() < 1) {
                    binding.editTextEmailAddress.setError("Requerit!");
                    Snackbar.make(view, "Completa els camps per entrar", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();
                } else if (noEsMail == 0) {
                    Snackbar.make(view, "Format del mail incorrecte", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();
                }
                //mostrar error doble;
                else if (binding.editTextPassword.getText().length() < 1) {
                    Snackbar.make(view, "Introdueix el password", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();
                    binding.editTextPassword.setError("Requerit!");
                } else {

                    binding.progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            getActivity().finish();
                            startActivity(new Intent(getActivity(), AppActivity.class));
                        }
                    }, 1700);
                }
            }
        });
    }

    private void recuperarContrasenaGoogle(View view,EditText input) {

        Snackbar.make(view, "S'ha enviat un email de recuperació a:\n "+input.getText().toString(), Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();


    }


}