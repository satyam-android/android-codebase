package com.example.codebase.repositores;

import androidx.lifecycle.MutableLiveData;

import com.example.codebase.pojo.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlacesRepository {

    private static NicePlacesRepository nicePlacesRepository;
    private ArrayList<NicePlace> nicePlacesList = new ArrayList<>();

    private NicePlacesRepository() {

    }

    public static NicePlacesRepository getInstance() {
        if (nicePlacesRepository == null)
            nicePlacesRepository = new NicePlacesRepository();
        return nicePlacesRepository;
    }


    public MutableLiveData<List<NicePlace>> getNicePlacesList() {
        // This method should call Network or DataBase to fetch data, Here for demo it is generated locally
        setNicePlaces();

        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(nicePlacesList);
        return data;
    }

    private void setNicePlaces() {
        nicePlacesList.add(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India"));
        nicePlacesList.add(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India 2"));
        nicePlacesList.add(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India 3"));
        nicePlacesList.add(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India 4"));
        nicePlacesList.add(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India 5"));
        nicePlacesList.add(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India 6"));
    }
}
