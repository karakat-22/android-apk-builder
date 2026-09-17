package com.example.sampleapp;

import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        tv.setText("ПРИЛОЖЕНИЕ РАБОТАЕТ!");
        tv.setTextColor(Color.parseColor("#D4AF37"));
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.parseColor("#1A1A2E"));
        
        setContentView(tv);
    }
}
