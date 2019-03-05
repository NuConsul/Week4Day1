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





/*
public class MainActivity extends AppCompatActivity {


    private static int threadId = 0 ;

        //instantiate the task
        asyncThreading = new AsyncThreading(tvAsyncResults) ;
        //asyncThreading = new AsyncThreading(tvAsyncResults) ;
        asyncThreading.execute() ;




        //startThread() ;
        //uiThreadDemo() ;

        //Looper
        LooperDemoThread looperDemoThread ;
        //instantiate the looper, and handle results from the looper to the main looper
        looperDemoThread = new LooperDemoThread(new Handler(Looper.getMainLooper()) {
@Override
public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Bundle bundle = msg.getData() ;
        tvLooperResults.setText(bundle.getString("key")) ;
        }
        }) ;
        //Message message = new Message() ;
        //message.what = 10 ;
        looperDemoThread.start() ;
        looperDemoThread.workerThreadHandler.sendMessage(new Message()) ;
        }

//Standard Java Runnable for Thread
private Runnable runnableForThread(final int id) {
        return new Runnable() {
@Override
public void run() {
        int x = 0 ;
        int y = 1 ;
        while(x < 19999) {
        x += y;
        //Log.d("TAG", "run: X = " + x) ;

        tvJavaThreadResults.setText("run: X = " + x) ;
        }
        }
        } ;
        }

@Override
protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this) ;

        }

@Override
protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this) ;

        }


//Standard Java Thread

    private void startThread() {
        threadId++ ;
        Thread javaThread = new Thread(runnableForThread()) ;
        Thread javaThreadTwo = new Thread(runnableForThread()) ;
        javaThread.start() ;
        //javaThreadTwo.start() ;
    }

//Thread that will run on th UI


    private void uiThreadDemo() {
        Thread thread = new Thread(runnableForThread(1000));
    }

//Just saying whenever this comes back run it in the main thread
public void onAsyncMessageReceived(AsyncTaskEvent asyncTaskEvent) {
        tvAsyncResults.setText(asyncTaskEvent.getMessageOne()) ;
        tvAsyncResultsTwo.setText(asyncTaskEvent.getMessageTwo()) ;
        }


        }

 */





/*
    1. Setup a activity with:
        A)  edittext for user input
        B)  textview  Java Thread
        C)  textView  AsyncTaskEvent
        D)  textView looper
        E)  start the Java Thread
        F)  start the asyncTask
        G)  start the looper

    2. Setup a java thread to get the count of how big the UserInput String is
    3. Setup a async task that will reverse the String(Do not use String.reverse)
    4. Setup a looper that will send back a message that will report any duplicate chars in the String
    5. Link the UI elements to the appropriate multithreading method.

 */

