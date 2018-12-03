package com.example.palexis3.imageviewer.source;

import com.example.palexis3.imageviewer.model.Business;

import java.util.List;

public interface RepositoryContract {

    interface OnFinishedListener {
        void onFinished(List<Business> businessList);
        void onFailure(Throwable t);
    }

    void getBusinessesList(OnFinishedListener onFinishedListener);
}
