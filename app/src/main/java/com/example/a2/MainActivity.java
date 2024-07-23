package com.example.a2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment fragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
        BottomNavigationView btn_nav = findViewById(R.id.btn_Nav);

        btn_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    fragment = new HomeFragment();
                } else if (itemId == R.id.kim) {
                    fragment = new kimFragment();
                } else if (itemId == R.id.yoq) {
                    fragment = new yoqFragment();
                } else if (itemId == R.id.adjust) {
                    fragment = new AdjustFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                return true;

            }
                });
    }
}