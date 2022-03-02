package uri.dam.tresper.partits;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentClassiTorneigBinding;
import uri.dam.tresper.models.Partit;
import uri.dam.tresper.models.TorneigsViewModel;


public class ClassiTorneigFragment extends Fragment {

    NavController navController;

    private FragmentClassiTorneigBinding binding;
    TorneigsViewModel torneigsViewModel;


    RecyclerView recyclerView;
    MutableLiveData<Integer> ronda = new MutableLiveData<>();
    String rondaText;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ronda.setValue(1);





        PartitAdapter partitAdapter = new PartitAdapter();
        recyclerView = binding.recyclerPartits;
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);


        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);


      /*  binding.rondaNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ronda<2){
                    ronda++;
                    partitAdapter.establecerLista();
                }
            }
        });*/

        torneigsViewModel.obtenerPartidos(ronda).observe(getViewLifecycleOwner(), new Observer<List<Partit>>() {
            @Override
            public void onChanged(List<Partit> partits) {
                partitAdapter.establecerLista(partits);
                rondaText = String.valueOf(ronda.getValue());

            }
        });

        binding.rondaNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ronda.setValue(ronda.getValue() + 1);
                    rondaText = String.valueOf(ronda.getValue());
                } catch (Exception e) {
                }
            }
        });
        binding.rondaPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ronda.setValue(ronda.getValue() - 1);
                    rondaText = String.valueOf(ronda.getValue());
                } catch (Exception e) {
                }
            }
        });

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {
            binding.imatgeView.setMinimumHeight(300);
            binding.imatgeView.setMaxHeight(300);
         /*   binding.equipImatge.setScaleX(0.5f);
            binding.equipImatge.setScaleY(0.5f);*/
        }

        binding.recyclerPartits.setAdapter(partitAdapter);


        Glide.with(getContext()).load(torneigsViewModel.torneigElement.getImatgeCartell())
                .centerInside()
                .into(binding.imatgeView);
        binding.nomTorneig.setText(torneigsViewModel.seleccionat().getValue().getNomTorneig());

        binding.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ClassiTorneigFragment.this)
                        .navigate(R.id.action_go_to_Info);
            }
        });
        binding.equipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ClassiTorneigFragment.this)
                        .navigate(R.id.action_go_to_equips);
            }
        });

    }

    class PartitViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderPartitBinding binding;

        public PartitViewHolder(uri.dam.tresper.databinding.ViewholderPartitBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


    class PartitAdapter extends RecyclerView.Adapter<ClassiTorneigFragment.PartitViewHolder> {

        List<Partit> partitsElementList;


        @NonNull
        @Override
        public ClassiTorneigFragment.PartitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            return new ClassiTorneigFragment.PartitViewHolder(uri.dam.tresper.databinding.ViewholderPartitBinding.inflate(getLayoutInflater(), parent, false));
        }

        public Partit obtenirPartit(int posicion) {
            return partitsElementList.get(posicion);
        }


        @Override
        public void onBindViewHolder(@NonNull ClassiTorneigFragment.PartitViewHolder holder, int position) {

            Partit partitElement = partitsElementList.get(position);


            holder.binding.scoreboardLayout.setMinHeight(340);
            holder.binding.frameLayoutpunts1.setVisibility(View.GONE);
            holder.binding.frameLayoutpunts2.setVisibility(View.GONE);
            holder.binding.cronoFrame.setVisibility(View.GONE);
            holder.binding.quartFrame.setVisibility(View.GONE);
            holder.binding.vs.setVisibility(View.GONE);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.binding.quartFrame.getVisibility()==View.VISIBLE){
                        holder.binding.frameLayoutpunts1.setVisibility(View.GONE);
                        holder.binding.frameLayoutpunts2.setVisibility(View.GONE);
                        holder.binding.cronoFrame.setVisibility(View.GONE);
                        holder.binding.quartFrame.setVisibility(View.GONE);
                        holder.binding.vs.setVisibility(View.GONE);
                        holder.binding.sombra1.setVisibility(View.VISIBLE);
                        holder.binding.sombra2.setVisibility(View.VISIBLE);
                        holder.binding.guest2.setTextColor(getResources().getColor(R.color.text_tronja_brillant));
                        holder.binding.home.setTextColor(getResources().getColor(R.color.text_tronja_brillant));

                    }else{
                        holder.binding.guest2.setTextColor(getResources().getColor(R.color.vermell_tauler));
                        holder.binding.home.setTextColor(getResources().getColor(R.color.vermell_tauler));

                        holder.binding.scoreboardLayout.setMinHeight(340);
                        holder.binding.frameLayoutpunts1.setVisibility(View.VISIBLE);
                        holder.binding.frameLayoutpunts2.setVisibility(View.VISIBLE);
                        holder.binding.cronoFrame.setVisibility(View.VISIBLE);
                        holder.binding.quartFrame.setVisibility(View.VISIBLE);
                        holder.binding.vs.setVisibility(View.VISIBLE);
                        holder.binding.sombra1.setVisibility(View.GONE);
                        holder.binding.sombra2.setVisibility(View.GONE);

                    }

                }
            });

            binding.rondaNum.setText(rondaText);
            try {
                holder.binding.pista.setText(partitElement.getPista().substring(0, 12));
            } catch (Exception e) {
                holder.binding.pista.setText(partitElement.getPista());
            }

            try {
                holder.binding.home.setText(partitElement.getEquip1().getNom().toUpperCase().substring(0, 12));
            } catch (Exception e) {
                holder.binding.home.setText(partitElement.getEquip1().getNom().toUpperCase());

            }
            try {
                holder.binding.guest2.setText(partitElement.getEquip2().getNom().toUpperCase().substring(0, 12));
            } catch (Exception e) {
                holder.binding.guest2.setText(partitElement.getEquip2().getNom().toUpperCase());

            }
            Glide.with(getContext()).load(partitElement.getEquip1().getImatge())
                    .centerInside()
                    .into(holder.binding.equip1Imatge);

            Glide.with(getContext()).load(partitElement.getEquip2().getImatge())
                    .centerInside()
                    .into(holder.binding.equip2Imatge);


            holder.binding.equip1Punts.setText(String.valueOf(partitElement.getPunts1()));
            holder.binding.equip2Punts.setText(String.valueOf(partitElement.getPunts2()));

            holder.binding.quartText.setText(String.valueOf(partitElement.getQ()));


   /*         binding.nomEquipView.setText(torneigsViewModel.getEquipElement().getNom());
            binding.descripcioEquipView.setText(torneigsViewModel.getEquipElement().getDescripcio());
            Glide.with(getContext()).load(torneigsViewModel.getEquipElement().getImatge())
                    .centerInside()
                    .into(binding.equipImatge);

            holder.binding.nomUser.setText(userElement.getNom());
            Glide.with(getContext()).load(userElement.getImatge())
                    .centerInside()
                    .into(holder.binding.imatgeUser);
*/

        }

        @Override
        public int getItemCount() {
            return partitsElementList != null ? partitsElementList.size() : 0;
        }

        public void establecerLista(List<Partit> partitsElementList) {
            this.partitsElementList = partitsElementList;
            notifyDataSetChanged();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentClassiTorneigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}