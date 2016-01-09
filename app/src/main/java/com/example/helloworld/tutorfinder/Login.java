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
import android.os.AsyncTask;
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
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ok = (Button) findViewById(R.id.okaybutton);
        username = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

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

                new JSONTask().execute("http://127.0.0.1:5000/signin");
                Intent intent = new Intent(Login.this, page2.class);//(current_javafile.this,filetoshiftto.class)
                startActivity(intent);

            }
        });
    }
}
        class JSONTask extends AsyncTask<String,String,String>
        {   HttpURLConnection connection=null;
                        URL url = null;

            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url=new URL(params[0]);
                    connection= (HttpURLConnection)url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.connect();
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.accumulate("username", "abc");
                        jsonObject.accumulate("password", "xyz");
                        String json = jsonObject.toString();
                        DataOutputStream wr = new DataOutputStream(
                                connection.getOutputStream());
                        wr.writeBytes(json);
                        System.out.println(wr);
                        wr.close();

                        InputStream is = connection.getInputStream();
                        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
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
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    return null;
            } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                return null;

            }



        }


