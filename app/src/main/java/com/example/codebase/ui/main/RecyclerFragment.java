package com.example.codebase.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codebase.MainActivity;
import com.example.codebase.R;
import com.example.codebase.adapters.NicePlacesAdapter;
import com.example.codebase.callbacks.ListItemClick;
import com.example.codebase.pojo.NicePlace;
import com.example.codebase.viewmodels.RecyclerFragmentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecyclerFragment extends Fragment implements ListItemClick {


    RecyclerView listView;
    View fragmentView;
    FloatingActionButton fabAddButton;
    RecyclerFragmentViewModel fragmentViewModel;
    NicePlacesAdapter nicePlacesAdapter;
    RecyclerView recyclerView;


    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        listView = fragmentView.findViewById(R.id.list);
        fabAddButton = fragmentView.findViewById(R.id.fab_add);
        recyclerView = fragmentView.findViewById(R.id.list);
        ((MainActivity) getActivity()).showAppBar("List Data");
        ((MainActivity) getActivity()).setCurrentFragment(this);
        fabAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentViewModel.addNicePlace(new NicePlace("http://i.redd.it/qn7f9oqu7o501.jpg", "India "+fragmentViewModel.getPlacesData().getValue().size()));
            }
        });

        return fragmentView;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentViewModel = ViewModelProviders.of(this).get(RecyclerFragmentViewModel.class);
        fragmentViewModel.initialize();
        fragmentViewModel.getPlacesData().observe(getActivity(), new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                nicePlacesAdapter.notifyDataSetChanged();
            }
        });
        fragmentViewModel.getUpdateStatus().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    ((MainActivity) getActivity()).showGlobalProgressBar("List is Loading");
               else ((MainActivity) getActivity()).hideGlobalProgressBar();

            }
        });
        initRecyclerView();
    }

    public void initRecyclerView() {
        nicePlacesAdapter = new NicePlacesAdapter(fragmentViewModel.getPlacesData().getValue(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(nicePlacesAdapter);

    }

    public void showProgressBar() {

    }


    public void hideProgressBar() {

    }


    @Override
    public void onListItemClick(int position) {
        Toast.makeText(getContext(),"List position "+position,Toast.LENGTH_SHORT).show();
    }
}
