package com.example.komal.eventreminder;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class reminder extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {

        Toast.makeText(this, "your reminder", Toast.LENGTH_LONG).show();


        return false;

    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
