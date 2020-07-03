package com.example.codebase.viewmodels;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.codebase.pojo.NicePlace;
import com.example.codebase.repositores.NicePlacesRepository;

import java.util.List;

public class RecyclerFragmentViewModel extends ViewModel {

    MutableLiveData<List<NicePlace>> mNicePlaces;
    NicePlacesRepository nicePlacesRepository;
    MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public void initialize() {
        if (mNicePlaces != null)
            return;
        else {
            nicePlacesRepository = NicePlacesRepository.getInstance();
            mNicePlaces = nicePlacesRepository.getNicePlacesList();
        }
    }

    public void addNicePlace(NicePlace nicePlace) {
        isUpdating.setValue(true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<NicePlace> places = mNicePlaces.getValue();
                places.add(nicePlace);
                mNicePlaces.postValue(places);
                isUpdating.postValue(false);
            }
        }, 5000);
    }

    public LiveData<List<NicePlace>> getPlacesData() {
        return mNicePlaces;
    }


    public LiveData<Boolean> getUpdateStatus(){
        return isUpdating;
    }
}
