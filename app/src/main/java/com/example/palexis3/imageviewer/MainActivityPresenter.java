package com.example.palexis3.imageviewer;

import com.example.palexis3.imageviewer.model.Business;
import com.example.palexis3.imageviewer.source.Repository;
import com.example.palexis3.imageviewer.source.RepositoryContract;

import java.util.List;

public class MainActivityPresenter implements MainActivityContract.Presenter, RepositoryContract.OnFinishedListener {

    private Repository repository;
    private MainActivityContract.View view;

    public MainActivityPresenter(Repository repository, MainActivityContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void loadBusinessData() {
        if(view != null) {
            view.showProgress();
        }
        repository.getBusinessesList(this);
    }

    @Override
    public void onFailure(Throwable t) {

    }

    @Override
    public void onFinished(List<Business> businessList) {
        if(view != null) {
            view.hideProgress();
        }
        view.showBusinesses(businessList);
    }
}
