package com.example.practica4listacompra.ui.stockStore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StockStoreViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public StockStoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Stock Store fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}