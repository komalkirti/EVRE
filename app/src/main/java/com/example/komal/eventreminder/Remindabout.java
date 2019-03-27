package com.example.komal.eventreminder;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.widget.Toast.LENGTH_LONG;

public class Remindabout extends AppCompatActivity {
    public static final int JOB_ID = 123;
    TextView textView;
    EditText editText;
    int day, month, year, hour, minute, d = 0, m = 0, y = 0, h = 0, mi = 0;
    String mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remindabout);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }

    public void currentscenario(View v) {
        Intent intentthatstarted = getIntent();
        day = intentthatstarted.getIntExtra("day", 1);
        month = intentthatstarted.getIntExtra("month", 1);
        year = intentthatstarted.getIntExtra("year", 0);
        hour = intentthatstarted.getIntExtra("hour", 0);
        minute = intentthatstarted.getIntExtra("min", 0);
        Toast.makeText(this, "Reminder Set successfully", LENGTH_LONG).show();
        remind r = new remind();
        r.execute();
    }

    public class remind extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                Calendar c = Calendar.getInstance();
                d = c.get(Calendar.DATE);
                m = c.get(Calendar.MONTH);
                m += 1;
                y = c.get(Calendar.YEAR);
                h = c.get(Calendar.HOUR_OF_DAY);
                mi = c.get(Calendar.MINUTE);
                if (d == day && m == month && y == year && mi == minute && h == hour) {
                    schedulejob();
                    break;
                }
            }
            return null;
        }



        private void schedulejob() {

            JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            JobInfo jobInfo = new JobInfo.Builder(JOB_ID, new ComponentName(Remindabout.this, reminder.class))
                    .setOverrideDeadline(0)
                    .setPersisted(true)
                    .build();

            jobScheduler.schedule(jobInfo);


        }
    }
}

