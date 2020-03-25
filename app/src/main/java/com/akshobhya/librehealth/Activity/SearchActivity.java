package com.akshobhya.librehealth.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.akshobhya.librehealth.R;

import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {

    private String name, date;
    private EditText editText_search_name, editText_search_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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
        if (date.isEmpty() || name.isEmpty()) {
            Toast.makeText(SearchActivity.this, "Please enter the details", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, SearchListActivity.class);
            intent.putExtra("SEARCH_NAME", name);
            intent.putExtra("SEARCH_DATE", date);
            startActivity(intent);
        }
    }

    public void button_showall(View view) {
        name = "";
        date = "";
        Intent intent = new Intent(this, SearchListActivity.class);
        intent.putExtra("SEARCH_NAME", name);
        intent.putExtra("SEARCH_DATE", date);
        startActivity(intent);
    }
}
