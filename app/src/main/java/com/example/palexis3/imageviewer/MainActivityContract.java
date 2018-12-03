package com.example.palexis3.imageviewer;

import com.example.palexis3.imageviewer.model.Business;

import java.util.List;

public interface MainActivityContract {

    interface View {
        void showBusinesses(List<Business> businessList);
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void loadBusinessData();
    }
}
