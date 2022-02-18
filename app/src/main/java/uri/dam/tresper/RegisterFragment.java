package uri.dam.tresper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import uri.dam.tresper.databinding.FragmentLogInBinding;
import uri.dam.tresper.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

        private FragmentRegisterBinding binding;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(RegisterFragment.this)
                        .navigate(R.id.action_to_logInFragment);
            }
/*            @Override
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
        });
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}