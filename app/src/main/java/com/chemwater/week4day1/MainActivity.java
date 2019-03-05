package com.chemwater.week4day1;

import android.app.Activity ;
import android.os.Handler ;
import android.os.Looper ;
import android.os.Bundle;
import android.os.Message ;
import android.util.Log ;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView ;

//Can track method bein called while my program is running by creating Log.d inside the given methods

public class MainActivity extends Activity {

    EditText etUserInput ;
    TextView tvJavaThreadResults, tvAsyncResults, tvLooperResults ;
    Button btnStartJavaThread, btnStartAsyncTask, btnStartLooper ;

    //Declare our async task
    AsyncThreading asyncThreading ;


    String textOne, textTwo, textThree ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        etUserInput = findViewById(R.id.etUserInput) ;
        tvJavaThreadResults = findViewById(R.id.tvReportResultsJavaThread) ;
        tvAsyncResults = findViewById(R.id.tvReportResultsAsyncTask) ;
        tvLooperResults = findViewById(R.id.tvReportResultsLooper) ;
        btnStartJavaThread = findViewById(R.id.btnStartJavaThread) ;
        btnStartAsyncTask = findViewById(R.id.btnStartAsyncTask) ;
        btnStartLooper = findViewById(R.id.btnStartLooper) ;


    }


    public void onStartJavaThread(View view) {
         textOne = etUserInput.getText().toString() ;
        //instantiate the task
        asyncThreading = new AsyncThreading(textOne) ;
    }


    public void onStartAsyncTask(View view) {
        textTwo = etUserInput.getText().toString() ;
    }

    public void onStartLooper(View view) {
        textThree = etUserInput.getText().toString() ;
    }

}