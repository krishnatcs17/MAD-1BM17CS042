package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText, usnText;
        String [] dept_array = {"CSE","ECE","IT","Mech","Civil"};
        final Spinner sp;
        ArrayAdapter<String> adapter;

        nameText = findViewById(R.id.nameBox);
        usnText = findViewById(R.id.usnBox);

        sp = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, dept_array);
        sp.setAdapter(adapter);

        Button sb = findViewById(R.id.submit);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                i.putExtra("name_key", nameText.getText().toString());
                i.putExtra("usn_key", usnText.getText().toString());
                i.putExtra("dept_key", sp.getSelectedItem().toString());

                startActivity(i);
            }
        });
    }

}
