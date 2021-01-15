package com.example.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView loh = findViewById(R.id.loh);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        loh.setLayoutManager(linearLayoutManager);

        MyAdapter adapter = new MyAdapter();

        loh.setAdapter(adapter);
    }
}