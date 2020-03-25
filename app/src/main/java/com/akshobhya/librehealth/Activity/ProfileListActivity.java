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
import android.widget.TextView;
import android.widget.Toast;

import com.akshobhya.librehealth.Adapter.SearchListAdapter;
import com.akshobhya.librehealth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;


public class ProfileListActivity extends AppCompatActivity {

    public static ArrayList<String> list_profile_id = new ArrayList<>();
    public ArrayList<String> list_profile_name = new ArrayList<>();
    public ArrayList<String> list_profile_fathername = new ArrayList<>();
    public ArrayList<String> list_profile_mothername = new ArrayList<>();
    RecyclerView rv;
    Context context;
    ProgressBar progressBar;
    TextView textView_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);
        context = ProfileListActivity.this;
        fetch_child_id();
        textView_profile = findViewById(R.id.textview_profile);
        progressBar = findViewById(R.id.progress_bar_profile);
        rv = findViewById(R.id.recyclerview_profile_list);
        rv.setLayoutManager(new LinearLayoutManager(context));
    }

    void fetch_child_id() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        DocumentReference docRef = db.collection("users").document(currentUser.getUid());
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Map<String, Object> map = document.getData();
                        if (map != null) {
                            for (Map.Entry<String, Object> child_id : map.entrySet()) {
                                data_setter(child_id.getKey());
                            }
                        }
                    } else {
                        progressBar.setVisibility(View.GONE);
                        textView_profile.setText("No child added. First add your child to profile.");
                    }

                } else {
                    Toast.makeText(ProfileListActivity.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context, MainActivity.class));
                    finish();
                }
            }
        });
    }

    void data_setter(String search) {
        FirebaseFirestore dbn = FirebaseFirestore.getInstance();
        dbn.collection("child")
                .whereEqualTo("id", search)
                .get()
                .addOnCompleteListener((new OnCompleteListener<QuerySnapshot>() {
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                list_profile_id.add(document.getId());
                                list_profile_name.add(document.getString("name"));
                                list_profile_fathername.add(document.getString("father_name"));
                                list_profile_mothername.add(document.getString("mother_name"));
                            }
                        } else {
                            Toast.makeText(ProfileListActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
                        }
                        rv.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        SearchListAdapter adapter = new SearchListAdapter(context, list_profile_id, list_profile_name, list_profile_fathername, list_profile_mothername);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }));
    }
}


