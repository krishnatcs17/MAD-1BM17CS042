package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

//imports for the widgets
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//imports for file operations
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button write,read,clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get all the widgets
        e1= (EditText) findViewById(R.id.editText);
        write= (Button) findViewById(R.id.button);
        read= (Button) findViewById(R.id.button2);
        clear= (Button) findViewById(R.id.button3);

        //add listener to write button
        write.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message=e1.getText().toString();
                Context context = getApplicationContext();
                try
                {
                    File f=new File(context.getFilesDir(),"myfile.txt");
                    f.createNewFile();
                    FileOutputStream fout=new FileOutputStream(f);
                    fout.write(message.getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(),"Data Written to Internal Storage",Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        //add listener to read button
        read.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message;
                String buf = "";
                Context context = getApplicationContext();
                try
                {
                    File f = new File(context.getFilesDir(),"myfile.txt");
                    FileInputStream fin = new FileInputStream(f);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while((message = br.readLine()) != null)
                    {
                        buf += message;
                    }

                    e1.setText(buf);
                    br.close();
                    fin.close();
                    Toast.makeText(getBaseContext(),"Data Received from SDCARD. Path: "+context.getPackageName(),Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        //add listener to the clear button
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                e1.setText("");
            }
        });
    }
}
