package com.example.practica4.ui.stockShop;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.practica4.databinding.FragmentStockShopBinding;


public class StockShopFragment extends Fragment {

    private FragmentStockShopBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        StockShopViewModel stockShopViewModel =
                new ViewModelProvider(this).get(StockShopViewModel.class);

        binding = FragmentStockShopBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textStockShop;
        stockShopViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}