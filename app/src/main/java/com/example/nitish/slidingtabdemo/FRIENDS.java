package com.example.nitish.slidingtabdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.NamespaceContext;

/**
 * Created by user on 15-12-2015.
 */
public class FRIENDS extends Fragment  {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.tab_3, container, false);

        recyclerView= (RecyclerView) layout.findViewById(R.id.cardList);
        adapter=new ContactAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public static ArrayList<ContactInfo> getData() {
        ArrayList<ContactInfo> Data = new ArrayList<>();
        String[] names = {"Nitish", "Gaurav",  "Deepak",  "Ajay","Dipanshu","Bharat","Amar","Nishant","Kashish","Pawan"};
        String[] surnames = {"Gupta", "Sinha",  "Jhagra", "Singh","Daga","Khullar","Chillar","Kumar","Dahiya","Yadav"};
        String[] emails = {"nitish@gmail.com", "gaurav@gmail.com",  "deepak@gmail.com", "ajay@gmail.com",
                "Dipanshu@gamil.com",
                 "bharat@gmail.com", "amar@gmail.com","nishant@gmail.com","kashish@gmail.com","pawan@gmail.com"  };
        int[] images= {R.drawable.nitish,R.drawable.gaurav,R.drawable.deepak,R.drawable.ajay,R.drawable.daga,
                R.drawable.bharat,R.drawable.amar,R.drawable.nishant,R.drawable.kashish,R.drawable.pawan};

        for (int i = 0; i < names.length && i < surnames.length && i < emails.length && i< images.length; i++) {
            ContactInfo current = new ContactInfo();
            current.name = names[i];
            current.surname = surnames[i];
            current.email = emails[i];
            current.image=images[i];
            Data.add(current);
        }
        return Data;
    }


}
