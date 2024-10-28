package com.example.webgridcardview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import com.example.webgridcardview.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    protected String tbTitle = "Мобильный браузер";

    private List<GridViewModal> list = Arrays.asList(
            new GridViewModal("Yandex", R.drawable.yandex_logo, "https://ya.ru"),
            new GridViewModal("Yandex.Maps", R.drawable.yandex_maps, "https://yandex.ru/maps/197/barnaul"),
            new GridViewModal("Yandex.Weather", R.drawable.yandex_weather, "https://yandex.ru/pogoda"),
            new GridViewModal("Lenta", R.drawable.lenta_logo, "https://lenta.com")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.mainTB);
        binding.mainTB.setTitle(tbTitle);
        GridViewAdapter adapter = new GridViewAdapter(list, this);
        binding.tabletGV.setAdapter(adapter);
        binding.tabletGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String adress = list.get(position).getAdress();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(adress)));
            }
        });
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