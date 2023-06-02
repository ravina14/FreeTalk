package com.example.freetalk.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freetalk.Response.ResponseFreeTalk;

public class AppViewModel extends ViewModel {

    public MutableLiveData<ResponseFreeTalk> responseData;

    public LiveData<ResponseFreeTalk> getFreeTalkData() {
        return responseData;
    }

    public void setFreeTalkData(ResponseFreeTalk freeTalkData) {
        responseData = new MutableLiveData<>();
        if (freeTalkData != null){
            responseData.setValue(freeTalkData);
        }

    }
    
}
