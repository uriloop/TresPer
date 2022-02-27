package uri.dam.tresper.torneigs;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentTorneigsBinding;

public class TorneigsFragment extends Fragment {

    NavController navController;

    private FragmentTorneigsBinding binding;
    TorneigsViewModel torneigsViewModel;
    RecyclerView recyclerView;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = binding.recyclerView;
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);

        recyclerView.setLayoutManager(layoutManager);

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
            holder.binding.llocTorneigView.setText(torneigElement.getLocalitzacio());

            holder.binding.dataView.setText(torneigElement.getDiaIhora());
            Glide.with(getContext()).load(torneigElement.getImatgeCartell())
                    .centerInside()
                    .into(holder.binding.cartellView);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.recyclerView.setVisibility(View.GONE);
                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            torneigsViewModel.seleccionar(torneigElement);
                            NavHostFragment.findNavController(TorneigsFragment.this)
                                    .navigate(R.id.action_go_to_Info);
                        }
                    }, 500);
                }
            });
            /*
            holder.binding.cartellView.load(torneigElement.getDiaIhora());
*/
            //Per anar a l'item
/*
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    torneigsViewModel.seleccionar(torneigElement);
                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            getActivity().finish();
                            startActivity(new Intent(getActivity(), AppActivity.class));
                        }
                    }, 1700);
                }
            });*/
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