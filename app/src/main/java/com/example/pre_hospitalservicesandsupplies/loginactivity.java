package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginactivity extends AppCompatActivity {
    TextView createAccount,forgotPassword;
    EditText loginemail, loginpassword;
    Button loginBtn, adminbtn,bypass;
    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    ImageView btnGoogle;
    ImageView signinfb;
    ImageView signinphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        forgotPassword = findViewById(R.id.forgotPassword);
        createAccount = findViewById(R.id.createAccount);
        loginBtn = findViewById(R.id.AdminloginBtn);
        loginemail = findViewById(R.id.adminusername);
        loginpassword = findViewById(R.id.adminpassword);
        btnGoogle = findViewById(R.id.btnGoogle);
        signinfb = findViewById(R.id.signinfb);
        adminbtn = findViewById(R.id.adminbtn);
        signinphone = findViewById(R.id.signinphone);
        bypass = findViewById(R.id.bypass);


        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginactivity.this, signup.class));
            }
        });
        bypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginactivity.this, DashBoard.class));
            }
        });

        signinphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(loginactivity.this, SendOTPActivity.class));
            }
        });

        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginactivity.this, AdminLogin.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginactivity.this, forgotPassword.class));
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performlogin();
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginactivity.this,GoogleSignin.class);
                startActivity(intent);
            }
        });

        signinfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginactivity.this,loginfacebook.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }
        });

    }

    private void performlogin() {

        String UserEmail = loginemail.getText().toString();
        String UserPassword = loginpassword.getText().toString();

        if (!UserEmail.matches(emailpattern)) {
            loginemail.setError("Enter Valid Email");
        } else if (UserPassword.isEmpty() || loginpassword.length() < 6) {
            loginpassword.setError("Enter Password(up to 6 latter");
        } else {
            progressDialog.setMessage("Please wait...");
            progressDialog.setTitle("login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(UserEmail,UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        openDashboar();
                        Toast.makeText(loginactivity.this,"login Successful",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(loginactivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    private void openDashboar() {
        Intent intent = new Intent(loginactivity.this,DashBoard.class);
        startActivity(intent);
    }
}