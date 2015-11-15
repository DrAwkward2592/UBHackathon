package com.example.helloworld.tutorfinder;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Login extends AppCompatActivity {

    Button ok;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ok = (Button)findViewById(R.id.okaybutton);
        username = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                enableStrictMode();

                URL url = null;
                try {
                    url = new URL("http://10.0.3.2:5000/signin");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

//                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("POST");
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.accumulate("username", "abc");
                        jsonObject.accumulate("password", "xyz");
                        String json = jsonObject.toString();
                        urlConnection.setRequestProperty("json", json);
                        urlConnection.setRequestProperty("Content-Type",
                                "application/json");
                        urlConnection.connect();
                        DataOutputStream wr = new DataOutputStream(
                                urlConnection.getOutputStream());
                        wr.writeBytes(json);
                        System.out.println(wr);
                        wr.close();

                        InputStream is = urlConnection.getInputStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                        Log.d("output",)
                        /*
                        StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+
                        String line;
                        while ((line = rd.readLine()) != null) {
                            response.append(line);
                            response.append('\r');
                        }
                        rd.close();*/

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Login.this, page2.class);//(current_javafile.this,filetoshiftto.class)
                    startActivity(intent);

                }

            private void enableStrictMode() {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);
            }
        });

        
    }


}
