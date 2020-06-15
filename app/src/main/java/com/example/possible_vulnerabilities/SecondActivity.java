package com.example.possible_vulnerabilities;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    private SecondActivity activity;
    private List<CVE> cves = new ArrayList<>();
    private static HashMap<String, Integer> versions = new HashMap<>();

    static {
        versions.put("4.4.4", 177951);
        versions.put("5.0", 179829);
        versions.put("5.1.1", 186573);
        versions.put("6.0", 187788);
        versions.put("6.0.1", 188440);
        versions.put("7.0", 201744);
        versions.put("7.1.1", 207440);
        versions.put("7.1.2", 213923);
        versions.put("8.0", 223494);
        versions.put("8.1", 235173);
        versions.put("9.0", 264759);
        versions.put("10.0", 333544);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        activity = this;


        NetworkService.getInstance().getJSONApi().getCveList
                ("30", "1224", "19997",
                        versions.get(Build.VERSION.RELEASE)).
                enqueue(new Callback<List<CVE>>() {

                    @Override
                    public void onResponse(Call<List<CVE>> call, Response<List<CVE>> response) {
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
                        cves = response.body();
                        DataAdapter adapter = new DataAdapter(activity, response.body(), cve -> {
                            startActivity(ThirdActivity.createStartIntent(activity, cve));
                        });
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<CVE>> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("Error", t.getMessage());
                    }
                });
    }
}

