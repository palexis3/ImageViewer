package com.example.palexis3.imageviewer.source;

import android.util.Log;

import com.example.palexis3.imageviewer.model.Business;
import com.example.palexis3.imageviewer.model.BusinessResponse;
import com.example.palexis3.imageviewer.source.remote.APIInterface;
import com.example.palexis3.imageviewer.source.remote.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements RepositoryContract {
    private final String TAG = Repository.class.getName();
    private APIInterface apiInterface = null;
    private static final String API_KEY = "RG-VSiIYJ0pxHWuhpGsMwcaIY_5ZiGSl6klXCLXehLJ46dNhEcnfs0mHpkx2Yt4rgag7SSjldY4tBL2Ohu3uZ6u3LLs-XiAOOiSwOgTUBZpceuFBLD_Nny-DjvhyWXYx";


    @Override
    public void getBusinessesList(final OnFinishedListener onFinishedListener) {
        if(apiInterface == null) {
            apiInterface = ApiClient.getClient().create(APIInterface.class);
        }
        String location = "San Francisco";
        Call<BusinessResponse> call = apiInterface.getBusinesses(location, "Bearer " + API_KEY);
        call.enqueue(new Callback<BusinessResponse>() {
            @Override
            public void onResponse(Call<BusinessResponse> call, Response<BusinessResponse> response) {
                List<Business> businessList = response.body().getBusinesses();
                Log.d(TAG, "Number of businesses received" + businessList.size());
                onFinishedListener.onFinished(businessList);
            }

            @Override
            public void onFailure(Call<BusinessResponse> call, Throwable t) {
                Log.d(TAG, "Error with getting businesses");
                onFinishedListener.onFailure(t);
            }
        });
    }
}
