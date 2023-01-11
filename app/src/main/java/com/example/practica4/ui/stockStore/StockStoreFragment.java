package com.example.practica4.ui.stockStore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.practica4.databinding.FragmentStockStoreBinding;

public class StockStoreFragment extends Fragment {

    private FragmentStockStoreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StockStoreViewModel stockStoreViewModel =
                new ViewModelProvider(this).get(StockStoreViewModel.class);

        binding = FragmentStockStoreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStockStore;
        stockStoreViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}