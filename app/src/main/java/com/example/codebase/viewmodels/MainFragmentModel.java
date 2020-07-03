package com.example.codebase.viewmodels;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainFragmentModel extends ViewModel {

    MutableLiveData<List<String>> itemList;

    public MutableLiveData<List<String>> getItemList() {
        if (itemList == null) {
            itemList = new MutableLiveData();
            loadItemList();
        }
        return itemList;
    }

    private void loadItemList() {
        Handler handler = new Handler();

        handler.postDelayed(() -> {
            List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("Bread");
            shoppingListSample.add("Bananas");
            shoppingListSample.add("Peanut Butter");
            shoppingListSample.add("Eggs");
            shoppingListSample.add("Chicken breasts");
            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));
            itemList.setValue(shoppingListSample);
        }, 5000);


    }

}
