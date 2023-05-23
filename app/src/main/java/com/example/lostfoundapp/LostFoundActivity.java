package com.example.lostfoundapp;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LostFoundActivity extends AppCompatActivity {

    private Fragment lostFragment;
    private Fragment foundFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_found);

        ImageButton lostBtn = findViewById(R.id.lost_btn);
        ImageButton foundBtn = findViewById(R.id.found_btn);

        lostFragment = new LostFragment();
        foundFragment = new FoundFragment();

        lostBtn.setOnClickListener(v -> showFragment(lostFragment));

        foundBtn.setOnClickListener(v -> showFragment(foundFragment));
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}
