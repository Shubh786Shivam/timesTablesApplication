package com.example.timestablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setMax(20);
        seekBar.setProgress(1);
        ListView tableListView = findViewById(R.id.tableListView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if(progress < min)
                    timesTableNumber = min;
                else
                    timesTableNumber = progress;
                //Log.i("SeekBar Value ", Integer.toString(timesTableNumber));
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = 1; i <= 10; i++){
                    list.add(i*timesTableNumber);
                }
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                tableListView.setAdapter(arrayAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}