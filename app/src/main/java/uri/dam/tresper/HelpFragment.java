package uri.dam.tresper;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uri.dam.tresper.databinding.FragmentHelpBinding;
import uri.dam.tresper.databinding.FragmentTorneigsBinding;


public class HelpFragment extends Fragment {




   FragmentHelpBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentHelpBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().getFragmentManager().popBackStack();
    }


}