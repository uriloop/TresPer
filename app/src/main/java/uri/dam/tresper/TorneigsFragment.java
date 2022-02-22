package uri.dam.tresper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

import uri.dam.tresper.databinding.FragmentTorneigsBinding;
import uri.dam.tresper.torneigs.TorneigElement;
import uri.dam.tresper.torneigs.TorneigsViewModel;

public class TorneigsFragment extends Fragment {

    NavController navController;

    private FragmentTorneigsBinding binding;

    TorneigsViewModel torneigsViewModel;
    RecyclerView recyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = binding.recyclerView;


        TorneigsAdapter torneigsAdapter = new TorneigsAdapter();
        binding.recyclerView.setAdapter(torneigsAdapter);
        /*CardSliderLayoutManager csLayoutManager=new CardSliderLayoutManager(getContext());



        recyclerView.setLayoutManager(csLayoutManager);
        new CardSnapHelper().attachToRecyclerView(recyclerView);*/



        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        torneigsViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<TorneigElement>>() {
            @Override
            public void onChanged(List<TorneigElement> torneigElementList) {
                torneigsAdapter.establecerLista(torneigElementList);
            }
        });

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentTorneigsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    class TorneigViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderTorneigBinding binding;

        public TorneigViewHolder(uri.dam.tresper.databinding.ViewholderTorneigBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    ////////////////////////////////

    class TorneigsAdapter extends RecyclerView.Adapter<TorneigViewHolder> {

        List<TorneigElement> torneigElementList;

        @NonNull
        @Override
        public TorneigViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TorneigViewHolder(uri.dam.tresper.databinding.ViewholderTorneigBinding.inflate(getLayoutInflater(), parent, false));
        }

        public TorneigElement obtenirTorneig(int posicion){
            return torneigElementList.get(posicion);
        }

        @Override
        public void onBindViewHolder(@NonNull TorneigViewHolder holder, int position) {

            TorneigElement torneigElement = torneigElementList.get(position);

            holder.binding.nomTorneigView.setText(torneigElement.getNomTorneig());
            holder.binding.dataView.setText(torneigElement.getDiaIhora());
            Glide.with(getContext()).load(torneigElement.getImatgeCartell())
                    .centerInside()
                    .into(holder.binding.cartellView);
            /*
            holder.binding.cartellView.load(torneigElement.getDiaIhora());

*/
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    torneigsViewModel.seleccionar(torneigElement);
                    navController.navigate(R.id.action_go_to_mostra_torneig);
                }
            });
        }

        @Override
        public int getItemCount() {
            return torneigElementList != null ? torneigElementList.size() : 0;
        }

        public void establecerLista(List<TorneigElement> torneigElementList){
            this.torneigElementList = torneigElementList;
            notifyDataSetChanged();
        }
    }



}