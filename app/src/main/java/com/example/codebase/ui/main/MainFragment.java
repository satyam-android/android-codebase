package com.example.codebase.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.codebase.MainActivity;
import com.example.codebase.R;
import com.example.codebase.viewmodels.MainFragmentModel;

public class MainFragment extends Fragment {

    private MainFragmentModel mViewModel;
    ListView listView;
    ProgressBar progressBar;
    View fragmentView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentView=inflater.inflate(R.layout.main_fragment,container,false);
        listView=fragmentView.findViewById(R.id.list);
        progressBar=fragmentView.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        ((MainActivity) getActivity()).showAppBar("List Data");


        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainFragmentModel.class);
        mViewModel.getItemList().observe(getActivity(),shoppingList-> {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    shoppingList);
            // 6
            listView.setAdapter(adapter);
            // 7
            progressBar.setVisibility(View.GONE);
        });
        // TODO: Use the ViewModel
    }

}