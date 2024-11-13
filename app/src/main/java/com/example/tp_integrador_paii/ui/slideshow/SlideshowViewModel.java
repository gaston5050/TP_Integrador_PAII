package com.example.tp_integrador_paii.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> mBtnUpload;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
        mBtnUpload = new MutableLiveData<>();
        mBtnUpload.setValue("Sincronizar cambio valor contructor");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setTextValue(String text) {
        mText.setValue(text);
    }

    public LiveData<String> getBtnUpload() {
        return mBtnUpload;
    }

    public void setBtnUploadValue(String text) {
        mBtnUpload.setValue(text);
    }
}