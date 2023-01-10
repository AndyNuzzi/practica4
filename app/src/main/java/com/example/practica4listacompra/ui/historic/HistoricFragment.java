package com.example.practica4listacompra.ui.historic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.practica4listacompra.databinding.FragmentHistoricBinding;

public class HistoricFragment extends Fragment {

    private FragmentHistoricBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoricViewModel historicViewModel =
                new ViewModelProvider(this).get(HistoricViewModel.class);

        binding = FragmentHistoricBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHistoric;
        historicViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}