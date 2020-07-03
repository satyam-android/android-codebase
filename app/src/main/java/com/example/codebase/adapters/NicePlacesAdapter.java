package com.example.codebase.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.codebase.R;
import com.example.codebase.callbacks.ListItemClick;
import com.example.codebase.pojo.NicePlace;

import java.util.List;

public class NicePlacesAdapter  extends RecyclerView.Adapter<NicePlacesAdapter.NicePlaceViewHolder>{

    List<NicePlace> nicePlaceList;
    ListItemClick listItemClick;

    public NicePlacesAdapter(List<NicePlace> nicePlaceList,ListItemClick listItemClick){
        this.nicePlaceList=nicePlaceList;
        this.listItemClick=listItemClick;
    }

    @NonNull
    @Override
    public NicePlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View listItemView=layoutInflater.inflate(R.layout.nice_places_row,parent,false);
        NicePlaceViewHolder placeholder=new NicePlaceViewHolder(listItemView);
        return placeholder;
    }

    @Override
    public void onBindViewHolder(@NonNull NicePlaceViewHolder holder, int position) {

        holder.tvPlaceDescription.setText(nicePlaceList.get(position).getPlaceDesc());
        Glide.with(holder.itemView.getContext()).load(nicePlaceList.get(position).getImagePath()).into(holder.ivPlaceImage);
        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItemClick.onListItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nicePlaceList.size();
    }


    class NicePlaceViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout layoutMain;
        ImageView ivPlaceImage;
        TextView tvPlaceDescription;
        public NicePlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutMain=itemView.findViewById(R.id.cl_row_main_container);
            ivPlaceImage=itemView.findViewById(R.id.iv_place_image);
            tvPlaceDescription=itemView.findViewById(R.id.tv_place_description);
        }
    }

}
