package com.example.komal.eventreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsave;
    DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsave = findViewById(R.id.btnsave);
        picker = findViewById(R.id.picker);
    }
        void ondateselected(View v){
            int day=picker.getDayOfMonth();
            int month=picker.getMonth()+1;
            int year=picker.getYear();

                     Intent i=new Intent(MainActivity.this,Time.class);

            i.putExtra("day", day);
            i.putExtra("month",month);
            i.putExtra("year",year);

            startActivity(i);



        }

}
