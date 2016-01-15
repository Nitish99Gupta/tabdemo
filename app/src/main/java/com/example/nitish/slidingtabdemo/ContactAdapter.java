package com.example.nitish.slidingtabdemo;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;



public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    ArrayList<ContactInfo> data = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;


    public ContactAdapter(Context context, ArrayList<ContactInfo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tab_2_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ContactInfo current = data.get(position);

        holder.vName.setText(current.name);
        holder.vSurname.setText(current.surname);
        holder.vEmail.setText(current.email);
        holder.pic.setImageResource(current.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent;
                intent=new Intent();
                switch ((position)){
                    case 0:
                        intent =  new Intent(context, ActivityM.class);
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
    public int getItemCount()  {
        return data.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView vName;
        public TextView vSurname;
        public TextView vEmail;
        ImageView pic;

        public MyViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);
            vName = (TextView) itemView.findViewById(R.id.txtName);
            vSurname = (TextView) itemView.findViewById(R.id.txtSurname);
            vEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            pic = (ImageView) itemView.findViewById(R.id.photo);
        }

//        @Override
//        public void onClick(View v) {
//
//            getAdapterPosition()
//            context.startActivity(new Intent(context,ActivityM.class));
//
//        }
    }

}
