package uri.dam.tresper.torneigs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import uri.dam.tresper.R;

import uri.dam.tresper.databinding.FragmentMapaTorneigsBinding;
import uri.dam.tresper.models.TorneigElement;
import uri.dam.tresper.models.TorneigsViewModel;

public class MapaTorneigsFragment extends Fragment {

    FragmentMapaTorneigsBinding binding;
    TorneigsViewModel torneigsViewModel;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            List<TorneigElement> torneigsList = torneigsViewModel.getListTorneigs();
            LatLng pos = null;
            for (int i = 0; i < torneigsList.size(); i++) {
                pos = new LatLng(torneigsList.get(i).getLatLong()[0], torneigsList.get(i).getLatLong()[1]);


                googleMap.addMarker(new MarkerOptions().position(pos).title(torneigsList.get(i).getNomTorneig()));


            }
           /* googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(@NonNull Marker marker) {
                    for (TorneigElement torneig :
                            torneigsList) {
                        if (marker.getTitle().equals(torneig.getNomTorneig())){
                            NavHostFragment.findNavController(MapaTorneigsFragment.this)
                                    .navigate(R.id.action_go_to_equips);
                        }
                    }
                }
            });*/

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
            googleMap.getUiSettings().setCompassEnabled(true);



        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);


        binding = FragmentMapaTorneigsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapaTorneigs);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }


    }
}