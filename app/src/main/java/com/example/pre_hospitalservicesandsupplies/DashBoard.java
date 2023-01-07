package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {

    Button MedicineListView;
    Button HospitalListView;
    Button Videos;
    Button DiseasBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        MedicineListView = findViewById(R.id.MedicineListView);
        MedicineListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, MedicineList.class));
            }
        });


        HospitalListView = findViewById(R.id.HospitalListView);
        HospitalListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, HospitalLocation.class));
            }
        });
        Videos = findViewById(R.id.Videos);
        Videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, videos.class));
            }
        });
        DiseasBtn = findViewById(R.id.DiseasBtn);
        DiseasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, DiseaseAndTreatment.class));
            }
        });
    }
}