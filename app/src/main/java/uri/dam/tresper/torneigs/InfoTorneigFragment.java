package uri.dam.tresper.torneigs;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.FlexboxLayout;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentInfoTorneigBinding;
import uri.dam.tresper.models.TorneigsViewModel;


public class InfoTorneigFragment extends Fragment {

    NavController navController;

    private FragmentInfoTorneigBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        // navController = Navigation.findNavController(view);   // treure si s'utilitza view pager

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);


        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.avis_inscripcions_completes, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);


        binding.inscripcioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupWindow pw = popupWindow;


                /*pw.setWidth(400);
                pw.setHeight(180);*/

                pw.showAtLocation(binding.getRoot(), Gravity.CENTER, 0, 0);
                pw.update();
                new Handler().postDelayed(new Runnable() {   // delay


                    @Override
                    public void run() {
                        pw.dismiss();
                    }
                }, 2000);

            }
        });



        binding.nomTorneig.setText(torneigsViewModel.seleccionat().getValue().getNomTorneig());
        binding.textBenvinguda.setText(torneigsViewModel.seleccionat().getValue().getDescripcio());
         binding.textNormes.setText(torneigsViewModel.seleccionat().getValue().getNormes());
         binding.textHoraris.setText(torneigsViewModel.seleccionat().getValue().getHoraris());
        binding.textInscripcio.setText(torneigsViewModel.seleccionat().getValue().getInscripcio());
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {
            binding.fotoTorneig.setMinimumHeight(300);
            binding.fotoTorneig.setMaxHeight(300);
         /*   binding.equipImatge.setScaleX(0.5f);
            binding.equipImatge.setScaleY(0.5f);*/
        }

/*        binding.fotoTorneig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.fotoTorneig.getMaxHeight()==600||binding.fotoTorneig.getMinimumHeight()==600||binding.fotoTorneig.getMaxHeight()==800||binding.fotoTorneig.getMinimumHeight()==800){
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                        binding.fotoTorneig.setMinimumHeight(400);
                        binding.fotoTorneig.setMaxHeight(400);
                    }else{
                        binding.fotoTorneig.setMinimumHeight(300);
                        binding.fotoTorneig.setMaxHeight(300);
         *//*   binding.equipImatge.setScaleX(0.5f);
            binding.equipImatge.setScaleY(0.5f);*//*
                    }
                }else{
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                        binding.fotoTorneig.setMinimumHeight(800);
                        binding.fotoTorneig.setMaxHeight(800);
                    }else {
                        binding.fotoTorneig.setMinimumHeight(600);
                        binding.fotoTorneig.setMaxHeight(600);
                    }

                }
            }
        });*/

binding.normesFiba.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        binding.normesFiba.setBackground(getResources().getDrawable(R.color.psts_background_tab_pressed_ripple, getActivity().getTheme()));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiba.basketball/es/3x3/rules"));
                startActivity(browserIntent);
            }
        },50);


    }
});

        Glide.with(getContext()).load(torneigsViewModel.seleccionat().getValue().getImatgeCartell())
                .centerInside()
                .into(binding.fotoTorneig);

        /*Glide.with(getContext()).load("https://www.google.es/maps/@41.4558823,2.2011013,3a,75y,133.03h,91.18t/data=!3m6!1e1!3m4!1s8S_phpY9th7ILk73H-Xhdg!2e0!7i16384!8i8192")
                .centerInside()
                .into(binding.mapa);*/

/*
        binding.equipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoTorneigFragment.this)
                        .navigate(R.id.action_go_to_equips);
            }
        });
*/
/*
        binding.partitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoTorneigFragment.this)
                        .navigate(R.id.action_go_to_classi);
            }
        });
*/
        View popupView2 = LayoutInflater.from(getActivity()).inflate(R.layout.imatge_torneig, null);
        final PopupWindow popupWindow2 = new PopupWindow(popupView2, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        binding.fotoTorneig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupWindow pw = popupWindow2;

                pw.setClippingEnabled(true);


                pw.showAtLocation(binding.getRoot(), Gravity.CENTER, 0, 0);
                pw.update();
            }
        });









    }

    WebView myBrowser;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentInfoTorneigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


}