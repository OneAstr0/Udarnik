 package com.example.udarnik_alp01;


 import androidx.appcompat.app.AppCompatActivity;

 import android.content.Intent;
 import android.net.Uri;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.ImageButton;
 import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
     Button btnStart, btnSettings, btnTheory;
     ImageButton btnTelegram;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         btnStart = findViewById(R.id.btnStart);
         btnSettings = findViewById(R.id.btnSettings);
         btnTheory = findViewById(R.id.btnTheory);
         btnTelegram = findViewById(R.id.btnTelegram);

         if (btnTelegram != null) {
             btnTelegram.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent telegramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/fed_apps"));
                     telegramIntent.setPackage("org.telegram.messenger"); // Установить пакет приложения Телеграма
                     telegramIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Флаг, который говорит о том, что это новая задача
                     startActivity(telegramIntent);
                 }
             });
         }


         if (btnStart != null) {
             btnStart.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(MainActivity.this, GameActivity.class);
                     startActivity(intent);
                 }
             });
         }

         if (btnSettings != null) {
             btnSettings.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                     startActivity(intent);
                 }
             });
         }

         if (btnTheory != null) {
             btnTheory.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(MainActivity.this, TheoryActivity.class);
                     startActivity(intent);
                 }
             });
         }
     }
 }