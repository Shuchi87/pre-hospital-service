package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {
    Button forgotBtn;
    EditText forgotemail;
    String email;
    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Auth = FirebaseAuth.getInstance();

        forgotBtn = findViewById(R.id.forgotBtn);
        forgotemail = findViewById(R.id.forgotemail);

        forgotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validedData();
            }
        });
    }

    private void validedData() {
        email = forgotemail.getText().toString();
        if(email.isEmpty())
        {
            forgotemail.setError("Required");
        }else{
            forgetpass();
        }
    }

    private void forgetpass() {
        Auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(forgotPassword.this,"check your email",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(forgotPassword.this,loginactivity.class));
                } else
                {
                    Toast.makeText(forgotPassword.this,"error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}