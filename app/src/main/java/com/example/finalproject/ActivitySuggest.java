package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class ActivitySuggest extends AppCompatActivity {
    private ImageView i1, i2, i3, i4;
    private View v;
    private ListView listView;
    private Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        i1 = findViewById(R.id.iWeb1);
        i2 = findViewById(R.id.iWeb2);
        i3 = findViewById(R.id.iWeb3);
        i4 = findViewById(R.id.iWeb4);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/ChloeTing/featured"));
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCvGEK5_U-kLgO6-AMDPeTUQ"));
                startActivity(intent);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC4B_CjUcZ4Y2sFH1WOiFYSQ"));
                startActivity(intent);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCpQ34afVgk8cRQBjSJ1xuJQ"));
                startActivity(intent);
            }
        });
        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySuggest.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}