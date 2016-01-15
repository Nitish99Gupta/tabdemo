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
 * Created by user on 06-01-2016.
 */
public class MyCardViewDataAdapter extends RecyclerView.Adapter<MyCardViewDataAdapter.MyViewHolder> {
    ArrayList<DetailInfo> data = new ArrayList<>();
    private Context context;


    private LayoutInflater inflater;

    public MyCardViewDataAdapter(Context context,ArrayList<DetailInfo>data){
        inflater=LayoutInflater.from(context);
        this.data=data;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.row,parent,false);
        MyViewHolder vh=new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        DetailInfo current=data.get(position);
        holder.title.setText(current.title);
        holder.pic.setImageResource(current.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent();
                switch ((position)){
                    case 0:
                        intent =  new Intent(context, ActivityB.class);
                        break;

                    case 1:
                        intent =  new Intent(context, ActivityN.class);
                        break;

                }
                context.startActivity(intent);

            }
        });



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
            title= (TextView) itemView.findViewById(R.id.info_text);
            pic= (ImageView) itemView.findViewById(R.id.photo);
        }



    }
}




