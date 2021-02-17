package com.example.list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context ;

    public MyAdapter(MainActivity mainActivity) {
        context = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.view_holder, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String user = MainActivity.str.get(position);
        String[] str = user.split("\n");

        holder.firstTextView.setText(str[0]);
        holder.secondTextView.setText(str[1]);
    }

    @Override
    public int getItemCount() {
        return MainActivity.str.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView firstTextView, secondTextView;
        public ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstTextView = itemView.findViewById(R.id.firstText);
            secondTextView = itemView.findViewById(R.id.secondText);
            imageView = itemView.findViewById(R.id.imageView);

        }

        public void bind() {

        }
    }

}
