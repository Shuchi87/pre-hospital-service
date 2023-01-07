/*package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InsertTreatment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_treatment);
    }
}*/
package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class InsertTreatment extends AppCompatActivity {
    EditText AddDiseaseName,AddDiseaseDetection,AddTreatment;
    Button AddDiseaseBtn;
    DatabaseReference reference;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_treatment);

        reference = FirebaseDatabase.getInstance().getReference().child("DiseaseAndTreatment");
        storageReference = FirebaseStorage.getInstance().getReference();
        AddDiseaseName = findViewById(R.id.AddDiseaseName);
        AddDiseaseDetection = findViewById(R.id.AddDiseaseDetection);
        AddTreatment = findViewById(R.id.AddTreatment);
        AddDiseaseBtn = findViewById(R.id.AddDiseaseBtn);

        AddDiseaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AddDiseaseName.getText().toString().isEmpty()){
                    AddDiseaseName.setError("Empty");
                    AddDiseaseName.requestFocus();
                } else if(AddDiseaseDetection.getText().toString().isEmpty())
                {
                    AddDiseaseDetection.setError("Empty");
                    AddDiseaseDetection.requestFocus();
                }else if(AddTreatment.getText().toString().isEmpty())
                {
                    AddTreatment.setError("Empty");
                    AddTreatment.requestFocus();
                }
                else{
                    InsertMedicine();
                }

            }
        });


    }

    private void InsertMedicine() {
        String adddiseasename = AddDiseaseName.getText().toString();
        String addtreatment = AddDiseaseDetection.getText().toString();
        String adddiseasedetection = AddTreatment.getText().toString();



        insertTRT insertTRT = new insertTRT(adddiseasename,addtreatment,adddiseasedetection);

        reference.push().setValue(insertTRT);
        Toast.makeText(InsertTreatment.this,"Data inserted",Toast.LENGTH_SHORT).show();

    }
}