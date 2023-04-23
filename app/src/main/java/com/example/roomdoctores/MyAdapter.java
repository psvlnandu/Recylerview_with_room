package com.example.roomdoctores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdoctores.databinding.DoctorListItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Doctor> doctorsList;

    public MyAdapter(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DoctorListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.doctor_list_item, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {


        Doctor d = doctorsList.get(position);
        holder.doctorListItemBinding.setDoc(d);
        //holder.bind(d);

    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DoctorListItemBinding doctorListItemBinding;

        public MyViewHolder(@NonNull DoctorListItemBinding doctorListItemBinding) {
            super(doctorListItemBinding.getRoot());
            this.doctorListItemBinding = doctorListItemBinding;
        }
    }
}
