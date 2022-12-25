package com.example.dz8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn_chrome;
    Button btn_whats;
    Button btn_youtube;
    Button btn_camera;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_chrome = findViewById(R.id.btn_chrome);
        btn_whats = findViewById(R.id.btn_whats);
        btn_youtube = findViewById(R.id.btn_youtube);
        btn_camera = findViewById(R.id.btn_camera);
        inputText= findViewById(R.id.inputText);

        btn_chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?client=avast-a-1&q="));
                startActivity(intent);
            }
        });
        btn_whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = inputText.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://wa.me/"+ text));
                startActivity(intent);
            }
        });
        btn_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/"));
                startActivity(intent);
            }
        });

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.CAMERA},101);
        }
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,101);
            }
        });

    }

}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
