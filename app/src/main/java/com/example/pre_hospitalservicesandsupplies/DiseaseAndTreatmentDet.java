package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiseaseAndTreatmentDet extends AppCompatActivity {
    TextView DiseaseName,ditection,tratment;

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<MedicinelistCode1> options;
    FirebaseRecyclerAdapter<MedicinelistCode1,MedicineListCode> adapter;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_and_treatment_det);

        DiseaseName = findViewById(R.id.DiseaseName);
        ditection = findViewById(R.id.ditection);
        tratment = findViewById(R.id.tratment);
        //setContentView(R.layout.activity_medicine_list);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("DiseaseAndTreatment");

        String MedicineKey = getIntent().getStringExtra("DiseaseKey");

        databaseReference.child(MedicineKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String adddiseasedetection = dataSnapshot.child("adddiseasedetection").getValue().toString();
                    String adddiseasename = dataSnapshot.child("adddiseasename").getValue().toString();
                    String addtreatment = dataSnapshot.child("addtreatment").getValue().toString();
                    DiseaseName.setText(adddiseasedetection);
                    ditection.setText(adddiseasename);
                    tratment.setText(addtreatment);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}