package com.example.practica4.ui.stockShop;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StockShopViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public StockShopViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Stock Store fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}