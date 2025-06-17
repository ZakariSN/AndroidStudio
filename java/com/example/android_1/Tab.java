package com.example.android_1;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Tab extends AppCompatActivity {
    TabLayout tab1;
    FrameLayout frame1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab);
        tab1 = (TabLayout)findViewById(R.id.tab);
        frame1 = (FrameLayout)findViewById(R.id.frame1);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame1,new fragment1()).commit();

        tab1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment frt=null;
                switch (tab.getPosition())
                {case 0:frt=new fragment1();
                    break;
                    case 1:frt=new fragment2();
                    break;
                    case 2:frt=new fragment3();
                    break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame1,frt).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}