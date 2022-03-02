package uri.dam.tresper.equips;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentEquipsTorneigBinding;
import uri.dam.tresper.models.EquipElement;
import uri.dam.tresper.models.TorneigsViewModel;


public class EquipsTorneigFragment extends Fragment {

    NavController navController;
        RecyclerView recyclerView;
    private FragmentEquipsTorneigBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);
        EquipsAdapter equipsAdapter = new EquipsAdapter();
        recyclerView = binding.recyclerEquips;

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);

        Glide.with(getContext()).load(torneigsViewModel.torneigElement.getImatgeCartell())
                .centerInside()
                .into(binding.fotoFonsMur);


        binding.recyclerEquips.setAdapter(equipsAdapter);


        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.avis_inscripcions_completes, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);


        binding.floatingMaps.setOnClickListener(new View.OnClickListener() {
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


        torneigsViewModel.obtenerEquipos().observe(getViewLifecycleOwner(), new Observer<List<EquipElement>>() {
            @Override
            public void onChanged(List<EquipElement> equipElementList) {
                equipsAdapter.establecerLista(equipElementList);
            }
        });

        binding.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EquipsTorneigFragment.this)
                        .navigate(R.id.action_go_to_Info);
            }
        });
        binding.partitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(EquipsTorneigFragment.this)
                        .navigate(R.id.action_go_to_classi);
            }
        });

        ///////////////////////////////////////////////////







    }

    class EquipViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderEquipBinding binding;

        public EquipViewHolder(uri.dam.tresper.databinding.ViewholderEquipBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


    class EquipsAdapter extends RecyclerView.Adapter<EquipsTorneigFragment.EquipViewHolder> {

        List<EquipElement> equipElementList;



        @NonNull
        @Override
        public EquipsTorneigFragment.EquipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            return new EquipsTorneigFragment.EquipViewHolder(uri.dam.tresper.databinding.ViewholderEquipBinding.inflate(getLayoutInflater(), parent, false));
        }

        public EquipElement obtenirEquip(int posicion){
            return equipElementList.get(posicion);
        }



        @Override
        public void onBindViewHolder(@NonNull EquipsTorneigFragment.EquipViewHolder holder, int position) {

            EquipElement equipElement = equipElementList.get(position);

            holder.binding.nomEquipView.setText(equipElement.getNom());
            Glide.with(getContext()).load(equipElement.getImatge())
                    .centerInside()
                    .into(holder.binding.imatgeView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.recyclerEquips.setVisibility(View.GONE);
                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            torneigsViewModel.seleccionarEquip(equipElement);
                            NavHostFragment.findNavController(EquipsTorneigFragment.this)
                                    .navigate(R.id.action_go_to_participants);
                        }
                    }, 500);
                }
            });



        }

        @Override
        public int getItemCount() {
            return equipElementList != null ? equipElementList.size() : 0;
        }

        public void establecerLista(List<EquipElement> equipElementList){
            this.equipElementList = equipElementList;
            notifyDataSetChanged();
        }
    }





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEquipsTorneigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

}