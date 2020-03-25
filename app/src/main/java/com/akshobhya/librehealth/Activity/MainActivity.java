package com.akshobhya.librehealth.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.akshobhya.librehealth.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        firebase_authentication();
    }

    private void firebase_authentication() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(context, SignInActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Logged in from " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
        }
    }


    public void search_activity(View view) {
        startActivity(new Intent(this, SearchActivity.class));
    }

    public void profile_activity(View view) {
        startActivity(new Intent(this, ProfileListActivity.class));
    }

    public void records_activity(View view) {
        startActivity(new Intent(this, RecordsActivity.class));
    }

    public void hospital_activity(View view) {
        startActivity(new Intent(this, HospitalActivity.class));
    }

    public void growth_activity(View view) {
        startActivity(new Intent(this, GrowthActivity.class));
    }


    public void firstaid_activity(View view) {
        startActivity(new Intent(this, FirstaidActivity.class));
    }

    public void button_logout(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        startActivity(new Intent(this, SignInActivity.class));

    }
}