package com.example.list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView loh;
    Button button;
    MyAdapter adapter;

    int peremennaya = 1;

    People[] people;
    JSONArray jsonObjectJSONArray;



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

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, "https://swapi.dev/api/people/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            addContactBezView(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        lol();
                    }
                },
                error -> Log.e("Request", error.toString()));

        queue.add(request);

        loh.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (people != null) {
                    if (!loh.canScrollVertically(1)) {
                        lol();
                    }
                }
            }
        });
    }

    public void addContactBezView(String response) throws JSONException {
            JSONObject jsonObject = new JSONObject(response);
            jsonObjectJSONArray = jsonObject.getJSONArray("results");
            people = new Gson().fromJson(jsonObjectJSONArray.toString(), People[].class);
    }

    public void lol() {
        for (int i = 0; i < jsonObjectJSONArray.length(); i++) {
            String add = people[i].name + "\n" + i;
            str.add(add);
            adapter.notifyDataSetChanged();
        }
    }
}