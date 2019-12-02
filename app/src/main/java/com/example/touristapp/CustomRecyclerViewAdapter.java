package com.example.touristapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.touristapp.JavaBean.Info;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Info> creditsInfo;

    public CustomRecyclerViewAdapter(ArrayList<Info> creditsInfo){
        this.creditsInfo = creditsInfo;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Info info = creditsInfo.get(position);
        ((CustomViewHolder)holder).link.setText(info.getLink());
    }

    @Override
    public int getItemCount() {
        if(creditsInfo != null){
            return creditsInfo.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView link;

        public CustomViewHolder(View view){
            super(view);
            this.link = view.findViewById(R.id.link);
        }
    }
}
