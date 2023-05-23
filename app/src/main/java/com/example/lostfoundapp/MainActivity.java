package com.example.lostfoundapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button advertBtn;
    private Button lostFoundBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        advertBtn = findViewById(R.id.advert_btn);
        lostFoundBtn = findViewById(R.id.lostfound_btn);

        advertBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewAdvertActivity.class);
            startActivity(intent);
        });

        lostFoundBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LostFoundActivity.class);
            startActivity(intent);
        });
    }
}
