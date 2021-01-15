package com.example.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.view_holder, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView firstTextView, secondTextView;

        private static int counter = 1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstTextView = itemView.findViewById(R.id.firstText);
            secondTextView = itemView.findViewById(R.id.secondText);

            secondTextView.setText(String.valueOf(counter));
            counter++;

        }

        public void bind(int index) {
            firstTextView.setText(String.valueOf(index));
        }
    }

}
