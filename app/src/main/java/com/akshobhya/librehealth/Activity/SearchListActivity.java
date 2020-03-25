package com.akshobhya.librehealth.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.akshobhya.librehealth.Adapter.SearchListAdapter;
import com.akshobhya.librehealth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class SearchListActivity extends AppCompatActivity {

    public static ArrayList<String> list_id = new ArrayList<String>();
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<String> list_fathername = new ArrayList<String>();
    ArrayList<String> list_mothername = new ArrayList<String>();
    String search_name;
    String search_date;
    RecyclerView rv;
    Context context;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        Intent intent = getIntent();
        search_name = intent.getStringExtra("SEARCH_NAME");
        search_date = intent.getStringExtra("SEARCH_DATE");
        context = SearchListActivity.this;
        fetch_data();
        progressbar = findViewById(R.id.progress_bar);
        rv = findViewById(R.id.recyclerview_search_list);
        rv.setLayoutManager(new LinearLayoutManager(context));
    }


    void fetch_data() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        if (search_name.isEmpty() && search_date.isEmpty()) {
            db.collection("child")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    list_id.add(document.getId());
                                    list_name.add(document.getString("name"));
                                    list_fathername.add(document.getString("father_name"));
                                    list_mothername.add(document.getString("mother_name"));
                                }
                                rv.setVisibility(View.VISIBLE);
                                progressbar.setVisibility(View.GONE);
                                SearchListAdapter adapter = new SearchListAdapter(context, list_id, list_name, list_fathername, list_mothername);
                                rv.setAdapter(adapter);
                            } else {
                                Toast.makeText(SearchListActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }

    else {
            db.collection("child")
                    .whereEqualTo("name", search_name)
                    .whereEqualTo("dob", search_date)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    list_id.add(document.getId());
                                    list_name.add(document.getString("name"));
                                    list_fathername.add(document.getString("father_name"));
                                    list_mothername.add(document.getString("mother_name"));
                                }
                                rv.setVisibility(View.VISIBLE);
                                progressbar.setVisibility(View.GONE);
                                SearchListAdapter adapter = new SearchListAdapter(context, list_id, list_name, list_fathername, list_mothername);
                                rv.setAdapter(adapter);
                            } else {
                                Toast.makeText(SearchListActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
    }

