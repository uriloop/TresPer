package uri.dam.tresper;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uri.dam.tresper.databinding.FragmentFirstBinding;
import uri.dam.tresper.databinding.FragmentLogInBinding;


public class LogInFragment extends Fragment {

    private FragmentLogInBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLogInBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                startActivity(new Intent(getActivity(), AppActivity.class));

            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}