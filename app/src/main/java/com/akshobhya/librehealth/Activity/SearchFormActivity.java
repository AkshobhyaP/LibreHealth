package com.akshobhya.librehealth.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akshobhya.librehealth.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchFormActivity extends AppCompatActivity {

    String result_id;
    CircleImageView photo;
    ImageView birth_certi;
    TextView name;
    TextView father_name;
    TextView mother_name;
    TextView gender;
    TextView dob;
    TextView tob;
    TextView blood;
    TextView contact;
    TextView address;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_form);
        Intent intent = getIntent();
        result_id = intent.getStringExtra("ID");
        context = this;
        initializer();
        form_viewBinder();
    }

    public void initializer() {
        photo = findViewById(R.id.imageview_form_child);
        name = findViewById(R.id.textview_form_name);
        father_name = findViewById(R.id.textview_form_father_name);
        mother_name = findViewById(R.id.textview_form_mother_name);
        gender = findViewById(R.id.textview_form_gender);
        dob = findViewById(R.id.textview_form_dob);
        tob = findViewById(R.id.textview_form_tob);
        blood = findViewById(R.id.textview_form_blood);
        contact = findViewById(R.id.textview_form_contact);
        address = findViewById(R.id.textview_form_address);
        birth_certi = findViewById(R.id.imageview_birthcerti);
    }

    public void form_viewBinder() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("child").document(result_id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    name.setText(document.getString("name"));
                    father_name.setText(document.getString("father_name"));
                    mother_name.setText(document.getString("mother_name"));
                    gender.setText(document.getString("gender"));
                    blood.setText(document.getString("blood"));
                    contact.setText(document.getString("contact"));
                    dob.setText(document.getString("dob"));
                    tob.setText(document.getString("tob"));
                    address.setText(document.getString("address"));
                    Glide.with(context)
                            .load(document.getString("photo"))
                            .into(photo);
                    Glide.with(context)
                            .load(document.getString("birth_certi"))
                            .into(birth_certi);


                } else {
                    Toast.makeText(context, "Error fetching data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void button_birth_certificate(View view) {
        birth_certi.setVisibility(View.VISIBLE);
    }

    public void button_addToProfile(View view) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentuser = mAuth.getCurrentUser();
        Map<String, Object> child = new HashMap<>();
        child.put(result_id, currentuser.getUid());
        db.collection("users").document(currentuser.getUid())
                .set(child, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Added Successfully", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
