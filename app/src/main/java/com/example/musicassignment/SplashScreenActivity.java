package com.example.musicassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SplashScreenActivity extends AppCompatActivity  {

    Button btnStart;
    Switch switchOfflineMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        btnStart = findViewById(R.id.btn_start);
        switchOfflineMode = findViewById(R.id.switch_offline_mode);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean offlineMode = false;
                if (switchOfflineMode.isChecked()) {
                    offlineMode = true;
                }
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                intent.putExtra("mode", offlineMode);
                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        });
    }
}