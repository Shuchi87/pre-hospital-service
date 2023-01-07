package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashBoard extends AppCompatActivity {
    Button AddMedicine;
    Button AddMedical;
    Button Diseaseandtreatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_board);

        AddMedicine = findViewById(R.id.AddMedicine);
        AddMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminDashBoard.this, AddMedicine.class));
            }
        });

        AddMedical = findViewById(R.id.AddMedical);
        AddMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AdminDashBoard.this, AddMedical.class));
            }
        });
        Diseaseandtreatment = findViewById(R.id.Diseaseandtreatment);
        Diseaseandtreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(AdminDashBoard.this, InsertTreatment.class));
            }
        });


    }
}