package uri.dam.tresper;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import uri.dam.tresper.databinding.FragmentLogInBinding;
import uri.dam.tresper.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    int noEsMail;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noEsMail = 0;
                String email = binding.editTextEmailAddress.getText().toString();
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i)=='@')noEsMail=1;
                }


                if (binding.editTextEmailAddress.getText().length() < 1 ) {
                    binding.editTextEmailAddress.setError("Required.");
                    Snackbar.make(view, "Completa els camps per registrar-te", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();
                } else if (noEsMail==0) {
                    Snackbar.make(view, "Format del mail incorrecte", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();

                }

                else if (binding.editTextPassword.getText().length() < 1) {
                    Snackbar.make(view, "Introdueix un nou password", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();
                    binding.editTextPassword.setError("Requerit!");
                }
                else if (binding.editTextPassword2.getText().length() < 1) {
                    Snackbar.make(view, "Repeteix el password", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();
                    binding.editTextPassword2.setError("Requerit!");
                } else {

                    binding.progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            NavHostFragment.findNavController(RegisterFragment.this)
                                    .navigate(R.id.action_to_logInFragment);
                            Snackbar.make(view, "T'has registrat amb l'email " + binding.editTextEmailAddress.getText() + "\nBenvingut !!!", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.white, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();

                        }
                    }, 1700);
                }


            }

        });
    }


/*        dins de onViewCreated    @Override
            public void onClick(View view) {

                EditText passw1= view.findViewById(R.id.editTextPassword);
                EditText passw2= view.findViewById(R.id.editTextPassword2);
                EditText email=view.findViewById(R.id.editTextEmailAddress);
                boolean arrova= false;
                if( TextUtils.isEmpty(email.getText())){
                    Toast.makeText(getContext(),"Email is required",Toast.LENGTH_SHORT);
                    email.setError( "Email is required!" );
                }else if (!TextUtils.isEmpty(email.getText())){
                    for (int i = 0; i < email.getText().length(); i++) {
                        if (email.getText().charAt(i)=='@'){
                            arrova=true;

                        }
                    }
                }
                if(TextUtils.isEmpty(passw1.getText())){
                    Toast.makeText(getContext(),"Password is required",Toast.LENGTH_SHORT);
                    email.setError( "Password is required!" );
                }else if(TextUtils.isEmpty((passw2.getText()))&&TextUtils.isEmpty(passw1.getText())){
                    Toast.makeText(getContext(),"Repeat the password",Toast.LENGTH_SHORT);
                    email.setError( "Repeat!" );
                }else{
                    if (arrova){
                        Toast.makeText(getContext(), "Sign in SUCCESS", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(RegisterFragment.this)
                                .navigate(R.id.action_to_logInFragment);
                    }
                }
            }*/


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}