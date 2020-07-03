package com.example.codebase.utils;

import android.util.Log;

import androidx.fragment.app.Fragment;

public class AppFragmentManager {
    private static final String TAG = "AppFragmentManager";
    private static AppFragmentManager appFragmentManager;
     private AppFragmentManager(){
         
     }

     public static AppFragmentManager getInstance(){
         if(appFragmentManager==null)
             appFragmentManager=new AppFragmentManager();
         return appFragmentManager;
     }
     
    public void addFragment(Fragment fragment){
        Log.d(TAG, "addFragment: ");
    }


    public void replaceFragment(Fragment fragment){

    }

    public void removeFragment(){
        Log.d(TAG, "removeFragment: ");
    }
}
