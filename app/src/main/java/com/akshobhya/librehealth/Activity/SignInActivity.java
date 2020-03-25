package com.akshobhya.librehealth.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akshobhya.librehealth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_LONG;

public class SignInActivity extends AppCompatActivity {

    EditText editText_signin_emailid;
    EditText editText_signin_password;
    Button button_signin_login;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("");
        setContentView(R.layout.activity_sign_in);
        context = this;
        editText_signin_emailid = findViewById(R.id.editText_login_id);
        editText_signin_password = findViewById(R.id.editText_login_password);
        button_signin_login = findViewById(R.id.button_login);
        button_signin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editText_signin_emailid.getText().toString();
                String password = editText_signin_password.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(context, task.getException().getLocalizedMessage(), LENGTH_LONG).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(context, "Please enter details", LENGTH_LONG).show();
                }
            }
        });
    }

    public void intent_to_signup(View view) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
    }
}

