package com.akshobhya.librehealth.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.akshobhya.librehealth.Adapter.RecordsAdapter;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class RecordsActivity extends AppCompatActivity {

    RecyclerView rv;
    ProgressBar progressBar_records;
    TextView textView_record;
    Context context;
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<String> list_vaccine = new ArrayList<String>();
    ArrayList<String> list_date = new ArrayList<>();
    RecordsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        context = this;
        textView_record = findViewById(R.id.textview_records);
        rv = findViewById(R.id.rv_records);
        progressBar_records = findViewById(R.id.progress_bar_record);
        rv.setLayoutManager(new LinearLayoutManager(context));
        fetch_child_id();
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
                                fetch_dob(child_id.getKey());
                            }
                        }
                    } else {
                        progressBar_records.setVisibility(View.GONE);
                        textView_record.setText("No child added. First add your child to profile.");
                    }

                } else {
                    Toast.makeText(RecordsActivity.this, "Error fetching data", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context, MainActivity.class));
                    finish();
                }
            }
        });
    }

    void fetch_dob(String key) {
        FirebaseFirestore dbn = FirebaseFirestore.getInstance();
        dbn.collection("child")
                .whereEqualTo("id", key)
                .get()
                .addOnCompleteListener((new OnCompleteListener<QuerySnapshot>() {
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                fetch_vaccine(document.getString("dob"), document.getString("name"));
                            }
                        } else {
                            Toast.makeText(RecordsActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
                        }
                    }
                }));
    }

    void fetch_vaccine(String dob, String n) {
        final String name = n;
        final String d = dob;
        FirebaseFirestore dbm = FirebaseFirestore.getInstance();
        dbm.collection("vaccine")
                .get()
                .addOnCompleteListener((new OnCompleteListener<QuerySnapshot>() {
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                list_name.add(name);
                                list_vaccine.add(document.getString("name"));
                                duedate_calculator(d, document.getString("date"));
                            }
                        } else {
                            Toast.makeText(RecordsActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
                        }
                    }
                }));
    }

    void duedate_calculator(String dob, String period) {
        int current = 0;
        String date = "";
        for (int i = 0; i < period.length(); i++) {
            if (period.charAt(i) == ',') {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Calendar c = Calendar.getInstance();
                try {
                    c.setTime(sdf.parse(dob));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                c.add(Calendar.DAY_OF_MONTH, (7 * current));
                date = date.concat(sdf.format(c.getTime()) + "\n");
                current = 0;
            } else {
                if (current == 0) {
                    current = Character.getNumericValue(period.charAt(i));
                } else {
                    current = (current * 10) + Character.getNumericValue(period.charAt(i));
                }
            }
        }
        Log.e("sdf", Integer.toString(list_name.size()));
        list_date.add(date);
        progressBar_records.setVisibility(View.GONE);
        adapter = new RecordsAdapter(context, list_name, list_vaccine, list_date);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
