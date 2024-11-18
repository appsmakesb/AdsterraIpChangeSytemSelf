package com.hosen.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        Button changeIpButton = findViewById(R.id.changeIpButton);

        changeIpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleWiFi();
            }
        });
    }

    private void toggleWiFi() {
        if (wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "Changing ip Address wait", Toast.LENGTH_SHORT).show();
            // Wait for a second to allow the Wi-Fi to turn off
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Changing ip Address Success", Toast.LENGTH_SHORT).show();
                }
            }, 2000);
        } else {
            wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "Changing ip Address Success", Toast.LENGTH_SHORT).show();
        }

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button dvevloper_ni_kajol = findViewById(R.id.dvevloper_ni_kajol);

        button1.setOnClickListener(v -> openLink(getString(R.string.Visit_Link_1)));
        button2.setOnClickListener(v -> openLink(getString(R.string.Visit_Link_2)));
        button3.setOnClickListener(v -> openLink(getString(R.string.Visit_Link_3)));
        button4.setOnClickListener(v -> openLink(getString(R.string.Visit_Link_4)));
        button5.setOnClickListener(v -> openLink(getString(R.string.Visit_Link_5)));
        dvevloper_ni_kajol.setOnClickListener(v -> openLink(getString(R.string.dvevloper_ni_kajol)));

    }

    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}