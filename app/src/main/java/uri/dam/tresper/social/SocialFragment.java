package uri.dam.tresper.social;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentPersonalAdminBinding;
import uri.dam.tresper.databinding.FragmentSocialBinding;
import uri.dam.tresper.models.Novetat;
import uri.dam.tresper.models.TorneigElement;
import uri.dam.tresper.torneigs.TorneigsFragment;
import uri.dam.tresper.torneigs.TorneigsViewModel;


public class SocialFragment extends Fragment {

    NavController navController;
    private FragmentSocialBinding binding;
    RecyclerView recyclerView;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        recyclerView= binding.recyclerNovetats;
FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);

        recyclerView.setLayoutManager(layoutManager);

        NovetatsAdapter novetatsAdapter = new NovetatsAdapter();
        binding.recyclerNovetats.setAdapter(novetatsAdapter);
        /*CardSliderLayoutManager csLayoutManager=new CardSliderLayoutManager(getContext());
        recyclerView.setLayoutManager(csLayoutManager);
        new CardSnapHelper().attachToRecyclerView(recyclerView);*/



        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);

        torneigsViewModel.obtenerNovedades().observe(getViewLifecycleOwner(), new Observer<List<Novetat>>() {
            @Override
            public void onChanged(List<Novetat> novetatList) {
                novetatsAdapter.establecerLista(novetatList);
            }
        });



        Spinner spinner = (Spinner) binding.spinner;
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        binding.spinner.setPopupBackgroundResource(R.color.background);


        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView myImageView;
                switch (i) {
                    case 4:
                        myImageView = (ImageView) binding.iconoBusqueda;
                        myImageView.setImageResource(R.drawable.team);
                        break;
                    case 1:
                        myImageView = (ImageView) binding.iconoBusqueda;
                        myImageView.setImageResource(R.drawable.estrella_icon);
                        break;
                    case 2:
                        myImageView = (ImageView) binding.iconoBusqueda;
                        myImageView.setImageResource(R.drawable.cor_vermell_icon);
                        break;
                    case 3:
                        myImageView = (ImageView) binding.iconoBusqueda;
                        myImageView.setImageResource(R.drawable.pilota2d);
                        break;
                    case 0:
                        myImageView = (ImageView) binding.iconoBusqueda;
                        myImageView.setImageResource(R.drawable.home_icon_color);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSocialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    class NovetatViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderNovetatBinding binding;

        public NovetatViewHolder(uri.dam.tresper.databinding.ViewholderNovetatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    class NovetatsAdapter extends RecyclerView.Adapter<SocialFragment.NovetatViewHolder> {

        List<Novetat> novetatsList;

        @NonNull
        @Override
        public SocialFragment.NovetatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SocialFragment.NovetatViewHolder(uri.dam.tresper.databinding.ViewholderNovetatBinding.inflate(getLayoutInflater(), parent, false));
        }

        public Novetat obtenirNovetat(int posicion) {
            return novetatsList.get(posicion);
        }

        @Override
        public void onBindViewHolder(@NonNull SocialFragment.NovetatViewHolder holder, int position) {

            Novetat novetat = novetatsList.get(position);

            ImageView myImageView;

            switch(novetat.getTipus()){

                case "NOU_TORNEIG" :
                    myImageView = (ImageView) holder.binding.iconoNovetat;
                    myImageView.setImageResource(R.drawable.trofeu_color);
                    break;
                case "MP" :
                    myImageView = (ImageView) holder.binding.iconoNovetat;
                    myImageView.setImageResource(R.drawable.new_message_not_seen);
                    break;
                case "NOTICIA" :
                    myImageView = (ImageView) holder.binding.iconoNovetat;
                    myImageView.setImageResource(R.drawable.home_icon_color);
                    break;

                case "RECORDATORI_AUTO" :
                    myImageView = (ImageView) holder.binding.iconoNovetat;
                    myImageView.setImageResource(R.drawable.bell_icon);
                    break;

                case "NOVA_AMISTAT" :
                    myImageView = (ImageView) holder.binding.iconoNovetat;
                    myImageView.setImageResource(R.drawable.cor_vermell_icon);
                    break;


            }
            holder.binding.textCard.setText(novetat.getText());
            holder.binding.titolCard.setText(novetat.getTitol());
            holder.binding.nomUserTextview.setText(novetat.getTextImatge());

            Glide.with(getContext()).load(novetat.getImatge())
                    .centerInside()
                    .into(holder.binding.imatgeCard);

            /*holder.itemView
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            binding.progressBar.setVisibility(View.VISIBLE);
                            binding.recyclerView.setVisibility(View.GONE);


                            new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                                @Override
                                public void run() {


                                    torneigsViewModel.seleccionarNovetat(novetat);
                                    NavHostFragment.findNavController(SocialFragment.this)
                                            .navigate(R.id.action_go_to_Info);
                                }
                            }, 250);
                        }
                    });*/

        }

        @Override
        public int getItemCount() {
            return novetatsList != null ? novetatsList.size() : 0;
        }

        public void establecerLista(List<Novetat> novetatsList) {
            this.novetatsList = novetatsList;
            notifyDataSetChanged();
        }
    }


}