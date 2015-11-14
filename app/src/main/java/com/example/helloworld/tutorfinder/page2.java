//student page
package com.example.helloworld.tutorfinder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page2 extends AppCompatActivity {
TextView t2;
GPSTracker gps;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        t2=(TextView)findViewById(R.id.t2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps=new GPSTracker(page2.this);
                if(gps.canGetLocation()) {
                    t2.setText("");
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    t2.setText(String.valueOf(latitude) + " , " + String.valueOf(longitude));
                    Intent intent = new Intent(page2.this, page4.class);//(current_javafile.this,filetoshiftto.class)
                    startActivity(intent);

                }else{
                    gps.showSettingsAlert();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
