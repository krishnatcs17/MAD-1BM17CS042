package com.example.lab1_1bm17cs042;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    public void change_size() {
//
//    }
    int ch = 1;
    float font = 36;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView t1 = (TextView) findViewById(R.id.text1);
        Button b1 = (Button) findViewById(R.id.size_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setTextSize(font);
                font += 5;
                if(font > 66){
                    font = 36;
                }
            }
        });

        Button b2 = (Button) findViewById(R.id.color_button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (ch) {
                    case 1: t1.setTextColor(Color.GREEN); break;
                    case 2: t1.setTextColor(Color.BLUE); break;
                    case 3: t1.setTextColor(Color.RED); break;
                    case 4: t1.setTextColor(Color.CYAN); break;
                    case 5: t1.setTextColor(Color.BLACK); break;
                    case 6: t1.setTextColor(Color.MAGENTA); break;
                    case 7: t1.setTextColor(Color.YELLOW); break;
                }
                ch += 1;
                ch = (ch == 7) ? 1 : ch;
            }
        });
    }
}
