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
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentPerfilUsuariBinding;
import uri.dam.tresper.equips.EquipsTorneigFragment;
import uri.dam.tresper.models.TorneigElement;
import uri.dam.tresper.models.TorneigsViewModel;
import uri.dam.tresper.models.User;


public class PerfilUsuariFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView recyclerViewAmics;
    RecyclerView recyclerViewInvitacio;

    NavController navController;
    private FragmentPerfilUsuariBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PerfilUsuariFragment.AmicAdapter amicAdapter = new PerfilUsuariFragment.AmicAdapter();
        //  InvitacioAdapter invitacioAdapter= new InvitacioAdapter();
        recyclerViewInvitacio = binding.recyclerInvitacio;
        recyclerViewAmics = binding.recyclerAmics;
        FlexboxLayoutManager layoutManagerInvitacio = new FlexboxLayoutManager(this.getContext());
        layoutManagerInvitacio.setFlexDirection(FlexDirection.ROW);
        layoutManagerInvitacio.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManagerInvitacio.setAlignItems(AlignItems.STRETCH);
        layoutManagerInvitacio.setFlexWrap(FlexWrap.WRAP);
        recyclerViewInvitacio.setLayoutManager(layoutManagerInvitacio);


        PerfilUsuariFragment.InscritAdapter inscritAdapter = new PerfilUsuariFragment.InscritAdapter();
        recyclerView = binding.recyclerInscrit;
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        FlexboxLayoutManager layoutManagerAmics = new FlexboxLayoutManager(this.getContext());
        layoutManagerAmics.setFlexDirection(FlexDirection.ROW);
        layoutManagerAmics.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManagerAmics.setAlignItems(AlignItems.STRETCH);
        layoutManagerAmics.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAmics.setLayoutManager(layoutManagerAmics);
        binding.recyclerInscrit.setAdapter(inscritAdapter);
        binding.recyclerAmics.setAdapter(amicAdapter);
        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);
        binding.recyclerInscrit.setAdapter(inscritAdapter);
        binding.nomUserTextview.setText(torneigsViewModel.getUser().getNom());
        Glide.with(getContext()).load(torneigsViewModel.getUser().getImatge())
                .centerInside()
                .into(binding.imatgePerfilUser);
        Glide.with(getContext()).load(torneigsViewModel.getUser().getImatge())
                .centerInside()
                .into(binding.imatgeFonsPerfil);
        binding.inscritButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                torneigsViewModel.setInscritObert(!torneigsViewModel.isInscritObert());
                if (torneigsViewModel.isInscritObert()) {
                    binding.recyclerInscrit.setVisibility(View.GONE);
                } else {
                    binding.recyclerInscrit.setVisibility(View.VISIBLE);


                    binding.missatgesNoImplementats.setVisibility(View.GONE);
                    binding.senseInvitacions.setVisibility(View.GONE);
                    binding.recyclerAmics.setVisibility(View.GONE);
                    binding.iconMissatgesConstruccio.setVisibility(View.GONE);

                }
            }
        });
        binding.inscritButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                torneigsViewModel.setInscritObert(!torneigsViewModel.isInscritObert());
                if (torneigsViewModel.isInscritObert()) {
                    binding.recyclerInscrit.setVisibility(View.GONE);
                } else {
                    binding.recyclerInscrit.setVisibility(View.VISIBLE);


                    binding.missatgesNoImplementats.setVisibility(View.GONE);
                    binding.senseInvitacions.setVisibility(View.GONE);
                    binding.recyclerAmics.setVisibility(View.GONE);
                    binding.iconMissatgesConstruccio.setVisibility(View.GONE);

                }
            }
        });

        binding.invitacionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                torneigsViewModel.setInvitacionsObert(!torneigsViewModel.isInvitacionsObert());
                if (torneigsViewModel.isInvitacionsObert()) {
                    binding.senseInvitacions.setVisibility(View.GONE);
                } else {
                    binding.senseInvitacions.setVisibility(View.VISIBLE);
                    binding.missatgesNoImplementats.setVisibility(View.GONE);
                    binding.recyclerInscrit.setVisibility(View.GONE);

                    binding.recyclerAmics.setVisibility(View.GONE);

                    binding.iconMissatgesConstruccio.setVisibility(View.GONE);
                }
            }
        });
        binding.amicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                torneigsViewModel.setAmicsObert(!torneigsViewModel.isAmicsObert());
                if (torneigsViewModel.isAmicsObert()) {
                    binding.recyclerAmics.setVisibility(View.GONE);
                } else {
                    binding.recyclerAmics.setVisibility(View.VISIBLE);
                    binding.missatgesNoImplementats.setVisibility(View.GONE);
                    binding.senseInvitacions.setVisibility(View.GONE);

                    binding.recyclerInscrit.setVisibility(View.GONE);

                    binding.iconMissatgesConstruccio.setVisibility(View.GONE);
                }
            }
        });
        binding.perfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "S'ha enviat una petició d'amistat a l'usuari : "+torneigsViewModel.getUser().getNom(), Snackbar.LENGTH_LONG).setBackgroundTint(getResources().getColor(R.color.tab_no_pulsat, getActivity().getTheme())).setActionTextColor(getResources().getColor(R.color.teal_200, getActivity().getTheme())).setTextColor(getResources().getColor(R.color.black, getActivity().getTheme())).setDuration(2000).show();

                binding.perfilButton.setVisibility(View.GONE);
            }
        });

        View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.avis_chat_en_construccio, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        binding.missatgesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                torneigsViewModel.setMissatgesObert(!torneigsViewModel.isMissatgesObert());
                if (torneigsViewModel.isMissatgesObert()) {
                    binding.missatgesNoImplementats.setVisibility(View.GONE);
                    binding.iconMissatgesConstruccio.setVisibility(View.GONE);
                } else {

                    binding.missatgesNoImplementats.setVisibility(View.VISIBLE);
                    binding.iconMissatgesConstruccio.setVisibility(View.VISIBLE);    /// Posar a visible per a mostrar l'icone de construccio


                    binding.recyclerInscrit.setVisibility(View.GONE);
                    binding.senseInvitacions.setVisibility(View.GONE);
                    binding.recyclerAmics.setVisibility(View.GONE);


                }
            }
        });


        torneigsViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<TorneigElement>>() {
            @Override
            public void onChanged(List<TorneigElement> torneigElementList) {
                inscritAdapter.establecerListaInscrito(torneigElementList);
            }
        });
        torneigsViewModel.obtenerUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> amicsList) {
                amicAdapter.establecerListaAmigos(amicsList);
            }
        });


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {

        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPerfilUsuariBinding.inflate(inflater, container, false);
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


    class InscritAdapter extends RecyclerView.Adapter<PerfilUsuariFragment.InscritViewHolder> {

        List<TorneigElement> torneigsInscritList;


        @NonNull
        @Override
        public PerfilUsuariFragment.InscritViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            return new PerfilUsuariFragment.InscritViewHolder(uri.dam.tresper.databinding.ViewholderInscritBinding.inflate(getLayoutInflater(), parent, false));
        }

        public TorneigElement obtenirTorneigsInscrit(int posicion) {
            return torneigsInscritList.get(posicion);
        }


        @Override
        public void onBindViewHolder(@NonNull PerfilUsuariFragment.InscritViewHolder holder, int position) {

            TorneigElement torneigElement = torneigsInscritList.get(position);

            holder.binding.nomUserTextview.setText(torneigElement.getNomTorneig());
            holder.binding.nomUserTextview2.setText(torneigElement.getLocalitzacio());


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Aki -> Seleccionar el torneig corresponent al viewmodel i viatjar al fragment torneigInfo

                    torneigsViewModel.seleccionar(torneigElement);
                    NavHostFragment.findNavController(PerfilUsuariFragment.this)
                            .navigate(R.id.action_go_to_Info);

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


    /////    AMICS

    class AmicViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderAmicBinding binding;

        public AmicViewHolder(uri.dam.tresper.databinding.ViewholderAmicBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


    class AmicAdapter extends RecyclerView.Adapter<PerfilUsuariFragment.AmicViewHolder> {

        List<User> amicsList;


        @NonNull
        @Override
        public PerfilUsuariFragment.AmicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            return new PerfilUsuariFragment.AmicViewHolder(uri.dam.tresper.databinding.ViewholderAmicBinding.inflate(getLayoutInflater(), parent, false));
        }

        public User obtenerAmigos(int posicion) {
            return amicsList.get(posicion);
        }


        @Override
        public void onBindViewHolder(@NonNull PerfilUsuariFragment.AmicViewHolder holder, int position) {

            User user = amicsList.get(position);

            holder.binding.nomUser.setText(user.getNom());

            Glide.with(getContext()).load(user.getImatge())
                    .centerInside()
                    .into(holder.binding.imatgeUser);
            holder.binding.missatgeIconAmics.setOnClickListener(new View.OnClickListener() {


                View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.avis_chat_en_construccio, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

                @Override
                public void onClick(View view) {
                    PopupWindow pw = popupWindow;

          /*      pw.setWidth(400);
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

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Aki -> Seleccionar el torneig corresponent al viewmodel i viatjar al fragment torneigInfo

                    binding.missatgesButton.setVisibility(View.GONE);
                    binding.inscritButton.setVisibility(View.GONE);
                    binding.invitacionsButton.setVisibility(View.GONE);
                    binding.amicsButton.setVisibility(View.GONE);
                     binding.perfilButton.setVisibility(View.GONE);

                    binding.progressBar.setVisibility(View.VISIBLE);


                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            torneigsViewModel.seleccionarUser(user);
                            Glide.with(getContext()).load(torneigsViewModel.getUser().getImatge())
                                    .centerInside()
                                    .into(binding.imatgePerfilUser);
                            Glide.with(getContext()).load(torneigsViewModel.getUser().getImatge())
                                    .centerInside()
                                    .into(binding.imatgeFonsPerfil);
                            binding.nomUserTextview.setText(user.getNom());


                            binding.progressBar.setVisibility(View.GONE);
                            binding.missatgesButton.setVisibility(View.VISIBLE);
                            binding.inscritButton.setVisibility(View.VISIBLE);
                            binding.invitacionsButton.setVisibility(View.VISIBLE);
                            binding.amicsButton.setVisibility(View.VISIBLE);
                            binding.perfilButton.setVisibility(View.VISIBLE);
                        }
                    }, 500);  // el tiempo en milisegundos

                }
            });


        }

        @Override
        public int getItemCount() {
            return amicsList != null ? amicsList.size() : 0;
        }

        public void establecerListaAmigos(List<User> amicsList) {
            this.amicsList = amicsList;
            notifyDataSetChanged();
        }
    }
}