package uri.dam.tresper.options;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentHelpBinding;
import uri.dam.tresper.databinding.FragmentRegisterBinding;
import uri.dam.tresper.torneigs.InfoTorneigFragment;

public class HelpFragment extends Fragment {




   FragmentHelpBinding binding;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.faqsLayout.setVisibility(View.GONE);

binding.faq1.setHeadingBackGround(R.color.background);
binding.faq2.setHeadingBackGround(R.color.background);
binding.faq3.setHeadingBackGround(R.color.background);
binding.faq4.setHeadingBackGround(R.color.background);
binding.faq5.setHeadingBackGround(R.color.background);
binding.faq1.setBodyBackGround(R.color.background);
binding.faq2.setBodyBackGround(R.color.background);
binding.faq3.setBodyBackGround(R.color.background);
binding.faq4.setBodyBackGround(R.color.background);
binding.faq5.setBodyBackGround(R.color.background);

        binding.faqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (binding.faqsLayout.getVisibility()== View.VISIBLE){
                    binding.faqButton.setText("FAQs");
                }else{
                    binding.faqButton.setText("Hide");
                    binding.progressBar.setVisibility(View.VISIBLE);

                }



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar.setVisibility(View.GONE);

                        if (binding.faqsLayout.getVisibility()== View.VISIBLE){
                            binding.faqsLayout.setVisibility(View.GONE);

                        }else {
                            binding.faqsLayout.setVisibility(View.VISIBLE);

                        }

                    }
                },100);
            }
        });
        binding.enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
binding.progressBar2.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar2.setVisibility(View.GONE);
                        Snackbar.make(view, "S'ha enviat el missatge correctament. Et respondrem en la major brevetat.", Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.tab_no_pulsat, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();

                        binding.assumpteEdit.setText("");
                        binding.emailEdit.setText("");
                        binding.missatgeEdit.setText("");
                        binding.nomEdit.setText("");
                    }
                },1000);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHelpBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().getFragmentManager().popBackStack();
    }


}