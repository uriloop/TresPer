package uri.dam.tresper.equips;

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
import uri.dam.tresper.databinding.FragmentEquipBinding;

import uri.dam.tresper.models.User;
import uri.dam.tresper.torneigs.TorneigsViewModel;


public class EquipFragment extends Fragment {

    NavController navController;
    RecyclerView recyclerView;
    private FragmentEquipBinding binding;
    TorneigsViewModel torneigsViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);
        navController = Navigation.findNavController(view);
        EquipAdapter equipAdapter = new EquipAdapter();
        recyclerView = binding.recyclerUsers;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
           // binding.progressBar.setPadding(0,300,0,0);
        }else{
           // binding.progressBar.setPadding(0,150,0,0);
            binding.equipImatge.setMinimumHeight(300);
            binding.equipImatge.setMaxHeight(300);
         /*   binding.equipImatge.setScaleX(0.5f);
            binding.equipImatge.setScaleY(0.5f);*/
        }


        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this.getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.CENTER);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        recyclerView.setLayoutManager(layoutManager);

        torneigsViewModel.obtenerUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                equipAdapter.establecerLista(users);

            }
        });

        binding.recyclerUsers.setAdapter(equipAdapter);


    }

    class EquipViewHolder extends RecyclerView.ViewHolder {
        private final uri.dam.tresper.databinding.ViewholderUserBinding binding;

        public EquipViewHolder(uri.dam.tresper.databinding.ViewholderUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }


    class EquipAdapter extends RecyclerView.Adapter<EquipFragment.EquipViewHolder> {

        List<User> usersElementList;


        @NonNull
        @Override
        public EquipFragment.EquipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            return new EquipFragment.EquipViewHolder(uri.dam.tresper.databinding.ViewholderUserBinding.inflate(getLayoutInflater(), parent, false));
        }

        public User obtenirUser(int posicion) {
            return usersElementList.get(posicion);
        }


        @Override
        public void onBindViewHolder(@NonNull EquipFragment.EquipViewHolder holder, int position) {

            User userElement = usersElementList.get(position);



            binding.nomEquipView.setText(torneigsViewModel.getEquipElement().getNom());
            binding.descripcioEquipView.setText(torneigsViewModel.getEquipElement().getDescripcio());
            Glide.with(getContext()).load(torneigsViewModel.getEquipElement().getImatge())
                    .centerInside()
                    .into(binding.equipImatge);

            holder.binding.nomUser.setText(userElement.getNom());
            Glide.with(getContext()).load(userElement.getImatge())
                    .centerInside()
                    .into(holder.binding.imatgeUser);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.recyclerUsers.setVisibility(View.GONE);
                    binding.equipImatge.setVisibility(View.GONE);
                    binding.viewTitolHeader.setVisibility(View.GONE);
                    binding.descripcioEquipView.setVisibility(View.GONE);
                    binding.barraSeparadora.setVisibility(View.GONE);



                    new Handler().postDelayed(new Runnable() {   // delay per a simular la carrega i que es vegi la progressBar
                        @Override
                        public void run() {
                            torneigsViewModel.seleccionarUser(userElement);
                            NavHostFragment.findNavController(EquipFragment.this)
                                    .navigate(R.id.action_go_to_perfil);
                        }
                    }, 500);
                }
            });


        }

        @Override
        public int getItemCount() {
            return usersElementList != null ? usersElementList.size() : 0;
        }

        public void establecerLista(List<User> usersElementList) {
            this.usersElementList = usersElementList;
            notifyDataSetChanged();
        }
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEquipBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }
}