package uri.dam.tresper.personal;

import android.content.res.Configuration;
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

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentPersonalBinding;
import uri.dam.tresper.models.Partit;
import uri.dam.tresper.models.TorneigElement;
import uri.dam.tresper.models.TorneigsViewModel;
import uri.dam.tresper.partits.ClassiTorneigFragment;


public class PersonalFragment extends Fragment {

    NavController navController;
    RecyclerView recyclerView;
    private FragmentPersonalBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        InscritAdapter inscritAdapter = new InscritAdapter();
        recyclerView = binding.recyclerInscrit;
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);

        binding.recyclerInscrit.setAdapter(inscritAdapter);
        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

      /*  Glide.with(getContext()).load(torneigsViewModel.getFonsPerfil())
                .centerInside()
                .into(binding.imatgeFonsPerfil);
        Glide.with(getContext()).load(torneigsViewModel.getImatgePerfil())
                .centerInside()
                .into(binding.imatgePerfilUser);*/

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {

        }





    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentPersonalBinding.inflate(inflater,container,false);
     /*   final FoldingCell fc = (FoldingCell) binding.foldingCell;
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });
final FoldingCell fc2 = (FoldingCell) binding.foldingCell2;
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc2.toggle(false);
            }
        });
*/


        View root = binding.getRoot();
        return root;
    }


    class InscritViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderInscritBinding binding;

        public InscritViewHolder(uri.dam.tresper.databinding.ViewholderInscritBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


    class InscritAdapter extends RecyclerView.Adapter<PersonalFragment.InscritViewHolder> {

        List<TorneigElement> torneigsInscritList;


        @NonNull
        @Override
        public PersonalFragment.InscritViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            return new PersonalFragment.InscritViewHolder(uri.dam.tresper.databinding.ViewholderInscritBinding.inflate(getLayoutInflater(), parent, false));
        }

        public TorneigElement obtenirTorneigsInscrit(int posicion) {
            return torneigsInscritList.get(posicion);
        }


        @Override
        public void onBindViewHolder(@NonNull PersonalFragment.InscritViewHolder holder, int position) {

            TorneigElement torneigElement = torneigsInscritList.get(position);





            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Aki -> Seleccionar el torneig corresponent al viewmodel i viatjar al fragment torneigInfo

                }
            });



        }

        @Override
        public int getItemCount() {
            return torneigsInscritList != null ? torneigsInscritList.size() : 0;
        }

        public void establecerListaInscrito(List<TorneigElement> torneigsInscritList) {
            this.torneigsInscritList = torneigsInscritList;
            notifyDataSetChanged();
        }
    }

}