package com.example.possible_vulnerabilities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private static String EXTRA_CVE = "extra_cve";

    public static Intent createStartIntent(Context context, CVE cve) {
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra(EXTRA_CVE, cve);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        if (getIntent() != null) {
            CVE cve = (CVE) getIntent().getSerializableExtra(EXTRA_CVE);
            if (cve != null) {
                setTitle(cve.getCveId());
                ((TextView) findViewById(R.id.textViewCveDescription)).setText(cve.getSummary());
            }
        }
    }
}
