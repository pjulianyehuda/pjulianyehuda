package com.example.pauljulianuts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<User> userArrayList;

    public MainAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        holder.aNama.setText(userArrayList.get(position).getName();
        holder.aAlamat.setText(userArrayList.get(position).getAddress();
        holder.aUmur.setText(userArrayList.get(position).getAge();
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView aNama;
        public TextView aAlamat;
        public TextView aUmur;

        public ViewHolder(View itemView) {
            super(itemView);
            aNama = (TextView) itemView.findViewById(R.id.txt_nama);
            aAlamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            aUmur = (TextView) itemView.findViewById(R.id.txt_umur);
        }
    }
}
