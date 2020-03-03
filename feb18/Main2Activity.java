package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import java.lang.String;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView t1, t2, t3;
        Intent i = getIntent();

        String name = i.getStringExtra("name_key");
        String usn = i.getStringExtra("usn_key");
        String dept = i.getStringExtra("dept_key");

        t1 = (TextView)findViewById(R.id.name3);
        t2 = (TextView)findViewById(R.id.usn3);
        t3 = (TextView)findViewById(R.id.dept3);
        t1.setText(name.toString());
        t2.setText(usn);
        t3.setText(dept);
    }
}
