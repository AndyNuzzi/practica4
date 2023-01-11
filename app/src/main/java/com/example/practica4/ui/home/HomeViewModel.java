package com.example.practica4.ui.home;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practica4.DataLoader;
import com.example.practica4.Earing;


public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mName, mDesc; // mImg;
    private Earing earing = DataLoader.getEaringFromDB();


    public HomeViewModel() {
        mName = new MutableLiveData<>();
        mDesc = new MutableLiveData<>();
       // mImg = new MutableLiveData<>();

        mName.setValue(earing.getName());
        mDesc.setValue(earing.getDescription());
       // mImg.setValue(earing.getImageResource());


    }

    public LiveData<String> getText() {
        return mName;
    }
}