package ru.mirea.topalidi.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent in2 = getIntent();
        String string = in2.getStringExtra("m");

        TextView time = (TextView) findViewById(R.id.textView);
        time.setText(string);
    }
}