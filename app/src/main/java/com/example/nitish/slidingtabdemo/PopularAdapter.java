package com.example.nitish.slidingtabdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 09-01-2016.
 */
public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {
    ArrayList<Information> data = new ArrayList<>();


    private LayoutInflater inflater;

    public PopularAdapter(Context context,ArrayList<Information>data){
       inflater=LayoutInflater.from(context);
        this.data=data;
   }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder vh=new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.pic.setImageResource(current.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView pic;


        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.titleText);
            pic= (ImageView) itemView.findViewById(R.id.photo);
        }



    }
}
