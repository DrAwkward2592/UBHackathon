package com.example.helloworld.tutorfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class page4 extends AppCompatActivity {
EditText a1,a2,a3,b1,b2,b3,c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        a1=(EditText)findViewById(R.id.a1);
        a2=(EditText)findViewById(R.id.a2);
        a3=(EditText)findViewById(R.id.a3);
        b1=(EditText)findViewById(R.id.b1);
        b2=(EditText)findViewById(R.id.b2);
        b3=(EditText)findViewById(R.id.b3);
        c1=(EditText)findViewById(R.id.c1);
        c2=(EditText)findViewById(R.id.c2);
        c3=(EditText)findViewById(R.id.c3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page4, menu);
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
