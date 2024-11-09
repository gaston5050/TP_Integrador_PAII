package com.example.tp_integrador_paii.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> mRadioGroupP1;
    private final MutableLiveData<String> mRbSiRadioGroupP1;
    private final MutableLiveData<String> mRbNoRadioGroupP1;
    private final MutableLiveData<String> mSpinnerP2;
    private final MutableLiveData<String> mSpinnerP3;
    private final MutableLiveData<String> mSpinnerP4;
    private final MutableLiveData<String> mSpinnerP5;
    private final MutableLiveData<String> mRadioGroupP6;
    private final MutableLiveData<String> mRbSiRadioGroupP6;
    private final MutableLiveData<String> mRbNoRadioGroupP6;
    private final MutableLiveData<String> mSpinnerP7;
    private final MutableLiveData<String> mSpinnerP8;
    private final MutableLiveData<String> mSpinnerP9;
    private final MutableLiveData<String> mSpinnerP10;
    private final MutableLiveData<String> mSpinnerP11;
    private final MutableLiveData<String> mSpinnerP12;
    private final MutableLiveData<String> mBtnFin;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        mRadioGroupP1 = new MutableLiveData<>();
        mRbSiRadioGroupP1 = new MutableLiveData<>();
        mRbNoRadioGroupP1 = new MutableLiveData<>();
        mSpinnerP2 = new MutableLiveData<>();
        mSpinnerP3 = new MutableLiveData<>();
        mSpinnerP4 = new MutableLiveData<>();
        mSpinnerP5 = new MutableLiveData<>();
        mRadioGroupP6 = new MutableLiveData<>();
        mRbSiRadioGroupP6 = new MutableLiveData<>();
        mRbNoRadioGroupP6 = new MutableLiveData<>();
        mSpinnerP7 = new MutableLiveData<>();
        mSpinnerP8 = new MutableLiveData<>();
        mSpinnerP9 = new MutableLiveData<>();
        mSpinnerP10 = new MutableLiveData<>();
        mSpinnerP11 = new MutableLiveData<>();
        mSpinnerP12 = new MutableLiveData<>();
        mBtnFin = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<String> getRadioGroupP1() {
        return mRadioGroupP1;
    }

    public LiveData<String> getRbSiRadioGroupP1() {
        return mRbSiRadioGroupP1;
    }

    public LiveData<String> getRbNoRadioGroupP1() {
        return mRbNoRadioGroupP1;
    }

    public LiveData<String> getSpinnerP2() {
        return mSpinnerP2;
    }

    public LiveData<String> getSpinnerP3() {
        return mSpinnerP3;
    }

    public LiveData<String> getSpinnerP4() {
        return mSpinnerP4;
    }

    public LiveData<String> getSpinnerP5() {
        return mSpinnerP5;
    }

    public LiveData<String> getRadioGroupP6() {
        return mRadioGroupP6;
    }

    public LiveData<String> getRbSiRadioGroupP6() {
        return mRbSiRadioGroupP6;
    }

    public LiveData<String> getRbNoRadioGroupP6() {
        return mRbNoRadioGroupP6;
    }

    public LiveData<String> getSpinnerP7() {
        return mSpinnerP7;
    }

    public LiveData<String> getSpinnerP8() {
        return mSpinnerP8;
    }

    public LiveData<String> getSpinnerP9() {
        return mSpinnerP9;
    }

    public LiveData<String> getSpinnerP10() {
        return mSpinnerP10;
    }

    public LiveData<String> getSpinnerP11() {
        return mSpinnerP11;
    }

    public LiveData<String> getSpinnerP12() {
        return mSpinnerP12;
    }

    public LiveData<String> getBtnFin() {
        return mBtnFin;
    }

}