package com.akshobhya.librehealth.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.akshobhya.librehealth.Adapter.HospitalTabAdapter;
import com.akshobhya.librehealth.R;
import com.google.android.material.tabs.TabLayout;

public class HospitalActivity extends AppCompatActivity {


    TabLayout tabLayout_hospital;
    ViewPager viewPager_hospital;
    HospitalTabAdapter tablayout_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        tabLayout_hospital = findViewById(R.id.tablayout_hospital);
        viewPager_hospital = findViewById(R.id.viewpager_hospital);
        tablayout_adapter = new HospitalTabAdapter(getSupportFragmentManager());
        viewPager_hospital.setAdapter(tablayout_adapter);
        tabLayout_hospital.setupWithViewPager(viewPager_hospital);
    }
}
