package com.example.mychatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends AppCompatActivity {

    private TextInputEditText editTextResetEmail;
    private Button buttonResetPassword;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        editTextResetEmail = findViewById(R.id.editTextResetEmail);
        buttonResetPassword = findViewById(R.id.buttonResetPassword);

        auth = FirebaseAuth.getInstance();

        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextResetEmail.getText().toString();
                if (!email.equals("")){
                    passwordreset(email);
                }
            }
        });
    }

    public void passwordreset(String email){
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetActivity.this,"Please check your email.",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ForgetActivity.this,"There is a problem.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}