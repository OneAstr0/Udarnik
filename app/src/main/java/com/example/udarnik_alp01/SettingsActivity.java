package com.example.udarnik_alp01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String INFINITY_GAME = "infinityGame";
    private boolean infinityMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Получаем сохраненное значение infinityMode из SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        infinityMode = sharedPreferences.getBoolean(INFINITY_GAME, false);

        Switch infinityModeSwitch = findViewById(R.id.infinityMode);
        infinityModeSwitch.setChecked(infinityMode);

        infinityModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                infinityMode = isChecked;

                // Сохраняем значение infinityMode в SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(INFINITY_GAME, infinityMode);
                editor.apply();
            }
        });

        // для выхода обратно (в меню)
        findViewById(R.id.btnBackSettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}