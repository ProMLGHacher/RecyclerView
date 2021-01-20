package com.example.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView loh;
    Button button;
    MyAdapter adapter;



    static ArrayList<String> str = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        loh = findViewById(R.id.loh);
        button = findViewById(R.id.button);

        adapter = new MyAdapter(MainActivity.this);

        loh.setLayoutManager(linearLayoutManager);

        loh.setAdapter(adapter);
    }

    public void addContact(View view) {
        String add = "LoH \n" + "0-0-0";
        str.add(add);
        adapter.notifyDataSetChanged();
    }


}