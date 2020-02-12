package com.gdc.googlemapapiexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_map1, btn_map2;

    private int REQUEST_MAP_CODE_1 = 1;
    private int REQUEST_MAP_CODE_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_map1 = findViewById(R.id.btn_map1);
        btn_map2 = findViewById(R.id.btn_map2);

        btn_map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivityForResult(intent, REQUEST_MAP_CODE_1);
            }
        });

        btn_map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivityForResult(intent, REQUEST_MAP_CODE_2);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_MAP_CODE_1) {
            if (resultCode == Activity.RESULT_OK) {
                btn_map1.setText(data.getStringExtra("MAP_RESULT_LAT") + "," + data.getStringExtra("MAP_RESULT_LNG"));
            }
        } else if (requestCode == REQUEST_MAP_CODE_2) {
            if (resultCode == Activity.RESULT_OK) {
                btn_map2.setText(data.getStringExtra("MAP_RESULT_LAT") + "," + data.getStringExtra("MAP_RESULT_LNG"));
            }
        }
    }
}
