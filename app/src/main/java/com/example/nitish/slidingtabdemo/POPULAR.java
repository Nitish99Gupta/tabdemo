package com.example.nitish.slidingtabdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15-12-2015.
 */
public class POPULAR extends Fragment {
    private RecyclerView recyclerView;
    private PopularAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab_2,container,false);
        recyclerView= (RecyclerView) layout.findViewById(R.id.popularList);
        adapter=new PopularAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static ArrayList<Information> getData(){
        ArrayList<Information> Data=new ArrayList<>();
        int[] images= {R.drawable.g_e,R.drawable.g_g,R.drawable.g_l,R.drawable.g_o};
        String[] titles ={"Google","Gmail","YouTube","Yahoo"};

        for (int i=0;i<images.length && i<titles.length;i++){
            Information current= new Information();
            current.image=images[i];
            current.title=titles[i];
            Data.add(current);


        }
        return Data;
    }
}
