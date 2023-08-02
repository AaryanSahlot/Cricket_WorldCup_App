package com.mastercoding.worldcupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static CustomAdapter adapter;
    ArrayList<CountryModelClass> dataModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a listView
        listView = findViewById(R.id.listView);

        // 2- Data Source
        dataModels = new ArrayList<>();

        dataModels.add(new CountryModelClass("Australia","5",R.drawable.australiaflag));
        dataModels.add(new CountryModelClass("India","2",R.drawable.indiaflag));
        dataModels.add(new CountryModelClass("West Indies","2",R.drawable.westindeseflag));
        dataModels.add(new CountryModelClass("Pakistan","1",R.drawable.pakistanflag));
        dataModels.add(new CountryModelClass("Sri Lanka","1",R.drawable.srilankaflag));
        dataModels.add(new CountryModelClass("England","1",R.drawable.englandflag));
        dataModels.add(new CountryModelClass("South Africa","0",R.drawable.southafricaflag));
        dataModels.add(new CountryModelClass("New Zealand","0",R.drawable.newzeelandflag));
        dataModels.add(new CountryModelClass("Bangladesh","0",R.drawable.bangladeshflag));
        dataModels.add(new CountryModelClass("Afghanistan","0",R.drawable.afganistanflag));

        // 3- Adapter
        adapter = new CustomAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);

        // 4- Handeling the click event on listview items

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Country "+ adapter.getItem(i).getCountry_name()+"\n"+
                                "Cricket World Wins: "+adapter.getItem(i).getCup_win_count(), Toast.LENGTH_LONG).show();
            }
        });


    }
}