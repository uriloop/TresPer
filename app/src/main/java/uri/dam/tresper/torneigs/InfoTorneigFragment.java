package uri.dam.tresper.torneigs;

import android.content.Context;
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

import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.HorizontalScrollView;

import com.bumptech.glide.Glide;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.List;

import uri.dam.tresper.R;
import uri.dam.tresper.databinding.FragmentInfoTorneigBinding;
import uri.dam.tresper.databinding.FragmentTorneigsBinding;


public class InfoTorneigFragment extends Fragment {

    NavController navController;

    private FragmentInfoTorneigBinding binding;
    TorneigsViewModel torneigsViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        FlexboxLayout flexBox = binding.flexBox;
        /*flexBox.setFlexDirection(FlexDirection.ROW);
        flexBox.setJustifyContent(JustifyContent.SPACE_AROUND);
        flexBox.setAlignItems(AlignItems.CENTER);
        flexBox.setFlexWrap(FlexWrap.WRAP);*/
        navController = Navigation.findNavController(view);
        torneigsViewModel = new ViewModelProvider(requireActivity()).get(TorneigsViewModel.class);

        binding.nomTorneig.setText(torneigsViewModel.seleccionat().getValue().getNomTorneig());
        binding.textBenvinguda.setText(torneigsViewModel.seleccionat().getValue().getDescripcio());
        binding.textData.setText(torneigsViewModel.seleccionat().getValue().getDiaIhora());
       /* binding.mapa.setText(torneigsViewModel.seleccionat().getValue().getDiaIhora());*/

/*
        binding.webView.loadDataWithBaseURL(null, "<iframe src=\"https://www.google.com/maps/embed?pb=!4v1645763192800!6m8!1m7!1s8S_phpY9th7ILk73H-Xhdg!2m2!1d41.45588230455805!2d2.201101338185295!3f133.03038376116046!4f1.182737709026739!5f0.7820865974627469\" width=\"600\" height=\"450\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\"></iframe>", "text/html", "utf-8", null);
*/

        Glide.with(getContext()).load(torneigsViewModel.seleccionat().getValue().getImatgeCartell())
                .centerInside()
                .into(binding.fotoTorneig);

        Glide.with(getContext()).load("https://www.google.es/maps/@41.4558823,2.2011013,3a,75y,133.03h,91.18t/data=!3m6!1e1!3m4!1s8S_phpY9th7ILk73H-Xhdg!2e0!7i16384!8i8192")
                .centerInside()
                .into(binding.mapa);

        binding.equipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoTorneigFragment.this)
                        .navigate(R.id.action_go_to_equips);
            }
        });
        binding.partitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoTorneigFragment.this)
                        .navigate(R.id.action_go_to_classi);
            }
        });



    }
    WebView myBrowser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentInfoTorneigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


}