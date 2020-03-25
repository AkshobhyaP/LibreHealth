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

public class SignUpActivity extends AppCompatActivity {

    EditText editText_emailid;
    EditText editText_password;
    EditText editText_confirmpassword;
    Button button_signup;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("");
        setContentView(R.layout.activity_sign_up);
        context = this;
        editText_emailid = findViewById(R.id.editText_signup_id);
        editText_password = findViewById(R.id.editText_signup_password);
        editText_confirmpassword = findViewById(R.id.editText_signup_confirmpassword);
        button_signup = findViewById(R.id.button_signup);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = editText_password.getText().toString();
                String confirmPass = editText_confirmpassword.getText().toString();
                String email = editText_emailid.getText().toString();


                if (!pass.equals(confirmPass)) {
                    Toast.makeText(context, "Password Doesn't match", LENGTH_LONG).show();
                } else {
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUpActivity.this, "SignUp Complete", Toast.LENGTH_SHORT)
                                                .show();
                                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(context, task.getException().getLocalizedMessage(), LENGTH_LONG).show();
                                    }

                                }
                            });
                }
            }
        });


    }
}

