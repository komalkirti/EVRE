package com.example.komal.eventreminder;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Time extends AppCompatActivity {
    TimePicker timePicker;
    Calendar calendar;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        timePicker=(TimePicker)findViewById(R.id.timepicker);
        calendar=Calendar.getInstance();
        Intent intentthatstarted=getIntent();
        day=intentthatstarted.getIntExtra("day",0);
        month=intentthatstarted.getIntExtra("month",0);
        year=intentthatstarted.getIntExtra("year",0);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void ontimeselected(View v){
        timePicker.setIs24HourView(true);
        int hour = timePicker.getHour();
        int min = timePicker.getMinute();





        Intent i=new Intent(this,Remindabout.class);
        i.putExtra("day",day);
        i.putExtra("month",month);
        i.putExtra("year",year);
        i.putExtra("hour",hour);
        i.putExtra("min",min);
            startActivity(i);
}
}