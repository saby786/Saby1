package com.example.saby7.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private DataAdapter adapter;
     public String s="null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.rc);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<Saby> call = request.getJSON();
        call.enqueue(new Callback<Saby>() {
            @Override
            public void onResponse(Call<Saby> call, Response<Saby> response) {
                List<Contact> contacts= response.body().getContacts();

                adapter = new DataAdapter(contacts);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Saby> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
