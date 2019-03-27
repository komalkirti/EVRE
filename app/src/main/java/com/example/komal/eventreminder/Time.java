package com.example.komal.eventreminder;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Time extends AppCompatActivity {
    TimePicker timePicker;
    Calendar calendar;
    Button button;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        button = findViewById(R.id.time_button);
        timePicker = (TimePicker) findViewById(R.id.timepicker);
        calendar = Calendar.getInstance();
        Intent intentthatstarted = getIntent();
        day = intentthatstarted.getIntExtra("day", 0);
        month = intentthatstarted.getIntExtra("month", 0);
        year = intentthatstarted.getIntExtra("year", 0);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setIs24HourView(false);
                int hour = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    hour = timePicker.getHour();
                }
                int min = 0;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    min = timePicker.getMinute();
                }

                Intent i;
                i = new Intent(v.getContext(), Remindabout.class);
                i.putExtra("day", day);
                i.putExtra("month", month);
                i.putExtra("year", year);
                i.putExtra("hour", hour);
                i.putExtra("min", min);
                startActivity(i);
            }
        });
    }
}