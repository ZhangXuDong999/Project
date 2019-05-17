package com.main.httpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button send = null;
    private TextView responseTV = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        send=(Button) findViewById ( R.id.send );
        responseTV=(TextView) findViewById ( R.id.responseTV );

        send.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                sendRequestWithHttpURLConnection();
            }
        } );
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread ( new Runnable () {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL ("http://www.nuc.edu.cn");
                    connection =(HttpURLConnection) url.openConnection ();
                    connection.setRequestMethod ( "GET" );
                    connection.setConnectTimeout ( 5000 );
                    connection.setReadTimeout ( 5000 );
                    InputStream inputStream = connection.getInputStream ();
                    reader = new BufferedReader ( new InputStreamReader ( inputStream ) );
                    StringBuilder responseStr = new StringBuilder (  );
                    String lineStr = null;
                    while ((lineStr = reader.readLine ())!=null){
                           responseStr.append ( lineStr );
                           Log.d("MainActivity", lineStr);
                    }
                    showResponse(responseStr.toString ());
                } catch (IOException e) {
                    e.printStackTrace ();
                } finally {
                    if(reader!=null){
                        try {
                            reader.close ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                    else if(connection!=null){
                        connection.disconnect ();
                    }
                }
            }
        } ).start ();
    }

    private void showResponse(final String toString) {
        runOnUiThread ( new Runnable () {
            @Override
            public void run() {
                responseTV.setText ( toString );
            }
        } );
    }
}
