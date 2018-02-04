package com.example.saby7.retrofit2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saby7 on 24-01-2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Contact> contacts;
    public  DataAdapter (List<Contact> contacts)
    {
        this.contacts=contacts;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent .getContext()).inflate(R.layout.row, parent, false);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact androidVersion =contacts.get(position);
        holder.tv1.setText(androidVersion.getId());
        holder.tv2.setText(androidVersion.getName());
        holder.tv3.setText(androidVersion.getEmail());
        holder.tv4.setText(androidVersion.getPhone().getMobile());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv1, tv2, tv3, tv4;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1= itemView.findViewById(R.id.tv1);
            tv2= itemView.findViewById(R.id.tv2);
            tv3= itemView.findViewById(R.id.tv3);
            tv4= itemView.findViewById(R.id.tv4);
        }
    }
}
