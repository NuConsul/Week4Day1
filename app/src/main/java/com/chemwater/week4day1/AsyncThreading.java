package com.chemwater.week4day1 ;

import android.os.AsyncTask ;
import android.util.Log ;
import android.widget.EditText;
import android.widget.TextView ;

public class AsyncThreading extends AsyncTask<String, String, String> {

    String editTextString ;

    //DO NOT DO THIS
    //TextView textView ;

    /*
    public AsyncThreading(TextView textView) {
        this.textView = textView;
    }*/
    public AsyncThreading(String editText) {
        this.editTextString = editText ;
    }

    @Override
    protected void onPreExecute() {
        //Runs on Main thread
        //set up anything that needs to be set up before thread runs(initializations, etc.)
        Log.d("TAG", "onPreExecute: ABOUT TO RUN") ;

        super.onPreExecute() ;
    }


    @Override
    protected String doInBackground(String... strings) {
        Log.d("TAG", "doInBackground: RUNNIN") ;
        int controller = 0 ;
        while(controller < 100) {
            //SHOULD NOT AT ALL USE THREAD.SLEEP IN LIVE CODE. MORESO USED FOR OS OPERATIONS AND DEMO'S LIKE THIS
            try {
                Thread.sleep(100) ;
            } catch (InterruptedException e) {
                e.printStackTrace() ;
            }

            //send the current thread update to the onProgressUpdate method
            publishProgress("RAN " + controller++ + " Time(s)" ) ;
        }

        //Runs on WORKER thread
        return "COMPLETE " + controller ;
    }

    //Handles updates from the thread(doInBackground method above)

    @Override
    protected void onProgressUpdate(String... values) {
        //Runs on main thread
        super.onProgressUpdate(values) ;

        Log.d("TAG", "onProgressUpdate: SENDING PERIODIC UPDATE" + editTextString) ;
    }

    @Override
    protected void onPostExecute(String s) {
        //Runs on main thread
        //Reports the results
        super.onPostExecute(s);
        Log.d("TAG", "onPostExecute: DONE") ;
    }
}
