package uri.dam.tresper.torneigs;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.MarginPageTransformer;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentInfoTorneigBinding;
import uri.dam.tresper.databinding.FragmentTorneigViewPagerBinding;
import uri.dam.tresper.equips.EquipsTorneigFragment;
import uri.dam.tresper.partits.ClassiTorneigFragment;
import uri.dam.tresper.torneigs.InfoTorneigFragment;

public class TorneigViewPagerFragment extends Fragment {

    private FragmentTorneigViewPagerBinding binding;

NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.floatingFrameSencer.setVisibility(View.GONE);
        binding.tabLayout.setElevation(30.0f);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

binding.tabLayout.setMinimumHeight(50);

        }else{

            binding.tabLayout.setMinimumHeight(50);


        }

/*
        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.avis_inscripcions_completes, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);


        binding.floatingMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupWindow pw = popupWindow;


                *//*pw.setWidth(400);
                pw.setHeight(180);*//*

                pw.showAtLocation(binding.getRoot(), Gravity.CENTER, 0, 0);
                pw.update();
                new Handler().postDelayed(new Runnable() {   // delay


                    @Override
                    public void run() {
                        pw.dismiss();
                    }
                }, 2000);

            }
        });*/



        ///////  aKI EL VIEWPAGER NORMAL AMB ELS TABS SENSE LLIBRERIA
        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new InfoTorneigFragment();
                    case 1:
                        return new EquipsTorneigFragment();
                    case 2:
                        return new ClassiTorneigFragment();
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });



        navController = Navigation.findNavController(view);   // treure si s'utilitza view pager (només dels fragments entre els que viatja. És el fragment actual el que ha de tenir les accions associades en el navgraph)




        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: default:
                        tab.setText("Informació");
                        break;
                    case 1:
                        tab.setText("Equips");
                        break;
                    case 2:
                        tab.setText("Partits");
                        break;
                }
            }
        }).attach();


    }


    MaterialViewPager mViewPager;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentTorneigViewPagerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }



}