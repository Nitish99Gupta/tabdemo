package com.example.nitish.slidingtabdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by user on 15-12-2015.
 */
    public class FORYOU extends Fragment {
    private RecyclerView recyclerView;
    private MyCardViewDataAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab_1,container,false);
        recyclerView= (RecyclerView) layout.findViewById(R.id.recyclerView);
        adapter=new MyCardViewDataAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static ArrayList<DetailInfo> getData(){
        ArrayList<DetailInfo> Data=new ArrayList<>();
        int[] images= {R.drawable.apple,R.drawable.apple_b,R.drawable.apple_c,R.drawable.apple_d,R.drawable.apple_e,R.drawable.apple_f};
        String[] titles ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturady"};

        for (int i=0;i<images.length && i<titles.length;i++){
            DetailInfo current= new DetailInfo();
            current.image=images[i];
            current.title=titles[i];
            Data.add(current);


        }
        return Data;
    }


    }






