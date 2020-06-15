package com.example.possible_vulnerabilities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView startScreentitle = findViewById(R.id.textViewStartScreenTitle);
        startScreentitle.setText(getString
                (R.string.start_screen_title, Build.VERSION.RELEASE,
                        Build.MANUFACTURER, Build.MODEL));
        startScreentitle.setTextSize(20);

        findViewById(R.id.button).setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
