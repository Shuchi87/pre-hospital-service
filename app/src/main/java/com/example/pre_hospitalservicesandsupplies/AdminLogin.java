package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
   // Button AdminloginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

       // AdminloginBtn = findViewById(R.id.AdminloginBtn);

        TextView username =(TextView) findViewById(R.id.adminusername);
        TextView password =(TextView) findViewById(R.id.adminpassword);

        Button AdminloginBtn = (Button) findViewById(R.id.AdminloginBtn);

        //admin and admin

        AdminloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(AdminLogin.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    openDashboar();
                }else
                    //incorrect
                    Toast.makeText(AdminLogin.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void openDashboar() {
        Intent intent = new Intent(AdminLogin.this,AdminDashBoard.class);
        startActivity(intent);
    }
}