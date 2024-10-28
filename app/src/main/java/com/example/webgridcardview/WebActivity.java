package com.example.webgridcardview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.webgridcardview.databinding.ActivityMainBinding;
import com.example.webgridcardview.databinding.ActivityWebBinding;

public class WebActivity extends AppCompatActivity {
    private ActivityWebBinding webBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webBinding = ActivityWebBinding.inflate(getLayoutInflater());
        setContentView(webBinding.getRoot());

        setSupportActionBar(webBinding.webActivityTB);

        webBinding.windowWV.setWebViewClient(new WebViewClient());
        String webAdress = getIntent().getData().toString();
        webBinding.windowWV.loadUrl(webAdress);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.exitMenuMain) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
}