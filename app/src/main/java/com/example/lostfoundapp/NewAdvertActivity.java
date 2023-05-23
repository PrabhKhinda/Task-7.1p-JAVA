package com.example.lostfoundapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NewAdvertActivity extends AppCompatActivity {

    private EditText advertNameEditText;
    private EditText advertDescriptionEditText;
    private EditText advertDateEditText;
    private EditText advertLocationEditText;
    private EditText advertPhoneEditText;
    private RadioButton lostRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);

        advertNameEditText = findViewById(R.id.advertname);
        advertDescriptionEditText = findViewById(R.id.advertdescription);
        advertDateEditText = findViewById(R.id.advertdate);
        advertLocationEditText = findViewById(R.id.advertlocation);
        advertPhoneEditText = findViewById(R.id.advertphone);
        lostRadioButton = findViewById(R.id.lost_rbtn);

        Button saveButton = findViewById(R.id.advertsave_btn);
        saveButton.setOnClickListener(v -> {
            String advertType = lostRadioButton.isChecked() ? "Lost" : "Found";
            String advertName = advertNameEditText.getText().toString();
            String advertDescription = advertDescriptionEditText.getText().toString();
            String advertDate = advertDateEditText.getText().toString();
            String advertLocation = advertLocationEditText.getText().toString();
            String advertPhone = advertPhoneEditText.getText().toString();

            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            databaseHelper.insertAdvert(advertType, advertName, advertDescription, advertDate, advertLocation, advertPhone);
            Toast.makeText(this, "Advert saved successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
