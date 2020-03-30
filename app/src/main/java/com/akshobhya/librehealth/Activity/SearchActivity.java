package com.akshobhya.librehealth.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.akshobhya.librehealth.Adapter.SearchListAdapter;
import com.akshobhya.librehealth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {

    private String name, date, did, result_id;
    Context context;
    private EditText editText_search_name, editText_search_date, editText_search_did;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        context = this;
        editText_search_did = findViewById(R.id.editText_search_did);
        editText_search_name = findViewById(R.id.editText_search_name);
        editText_search_date = findViewById(R.id.editText_search_date);
    }


    public void date_picker(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear, mMonth, mDay;
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {

                EditText editText_date = (EditText) findViewById(R.id.editText_search_date);
                editText_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void button_search(View view) {
        date = editText_search_date.getText().toString();
        name = editText_search_name.getText().toString();
        did = editText_search_did.getText().toString();
        if (date.isEmpty() || name.isEmpty()) {
            Toast.makeText(SearchActivity.this, "Please enter the details", Toast.LENGTH_LONG).show();
        } else {
            fetch_data();
        }
    }

    void fetch_data() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("child")
                .whereEqualTo("name", name)
                .whereEqualTo("dob", date)
                .whereEqualTo("id", did)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                result_id = document.getString("id");
                            }
                            Intent intent = new Intent(context, SearchFormActivity.class);
                            intent.putExtra("ID", result_id);
                            context.startActivity(intent);
                        } else {
                            Toast.makeText(SearchActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}

