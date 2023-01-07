package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    TextView gosignin;
    EditText username,email,password,confirmPassword;
    Button SignUp;
    String emailpattern ="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        gosignin = findViewById(R.id.gosignin);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        SignUp = findViewById(R.id.SignUp);
        progressDialog = new ProgressDialog(this);

        mAuth  = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        gosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this,loginactivity.class));
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();
            }

            private void PerforAuth() {
                String UUsername = username.getText().toString();
                String UserEmail = email.getText().toString();
                String UserPassword = password.getText().toString();
                String UserConfirmPassword = confirmPassword.getText().toString();

               if(!UserEmail.matches(emailpattern))
                {
                   email.setError("Enter Valid Email");
                }else if(UUsername.toString().isEmpty()){
                   username.setError("Enter user name");
               }
               else if(UserPassword.isEmpty()||password.length()<6){
                    password.setError("Enter Password(up to 6 latter");
                }else if(!UserPassword.equals(UserConfirmPassword)){
                    confirmPassword.setError("Password Not Match");
                }else{
                    progressDialog.setMessage("Please wait...");
                    progressDialog.setTitle("Registration");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.createUserWithEmailAndPassword(UserEmail,UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                progressDialog.dismiss();
                                openDashboar();
                                Toast.makeText(signup.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                            }else
                            {
                                progressDialog.dismiss();
                                Toast.makeText(signup.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void openDashboar() {
        Intent intent = new Intent(signup.this,DashBoard.class);
        startActivity(intent);
    }
}