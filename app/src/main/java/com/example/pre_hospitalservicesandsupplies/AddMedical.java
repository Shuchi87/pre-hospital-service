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

public class AddMedical extends AppCompatActivity {

    EditText AddDocotorName,AddDesignation,AddTime,AddSerialNumber;
    Button AddMedicalBtn;
    DatabaseReference reference;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical);

        reference = FirebaseDatabase.getInstance().getReference().child("Habigang DoctorList").child("chader hasi");
        storageReference = FirebaseStorage.getInstance().getReference();
        AddDocotorName = findViewById(R.id.AddDocotorName);
        AddDesignation = findViewById(R.id.AddDesignation);
        AddTime = findViewById(R.id.AddTime);
        AddSerialNumber = findViewById(R.id.AddSerialNumber);
        AddMedicalBtn = findViewById(R.id.AddMedicalBtn);

        AddMedicalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AddDocotorName.getText().toString().isEmpty()){
                    AddDocotorName.setError("Empty");
                    AddDocotorName.requestFocus();
                }else if(AddDesignation.getText().toString().isEmpty())
                {
                    AddDesignation.setError("Empty");
                    AddDesignation.requestFocus();
                }else if( AddTime.getText().toString().isEmpty())
                {
                    AddTime.setError("Empty");
                    AddTime.requestFocus();
                }
                else if(AddSerialNumber.getText().toString().isEmpty())
                {
                    AddSerialNumber.setError("Empty");
                    AddSerialNumber.requestFocus();
                }
                else{
                    InsertMedical();
                }

            }
        });

    }

    private void InsertMedical() {
        String addDocotorName = AddDocotorName.getText().toString();
       String addDesignation = AddDesignation.getText().toString();
       String addSerialNumber =AddSerialNumber.getText().toString();
        String addTime = AddTime.getText().toString();




    //    MedicineInsert medicineInsert = new MedicineInsert(med,det,mprice);

        AddMedicalIn addMedicalIn = new AddMedicalIn(addDocotorName,addDesignation,addTime,addSerialNumber);

        reference.push().setValue(addMedicalIn);
        Toast.makeText(AddMedical.this,"Data inserted",Toast.LENGTH_SHORT).show();

    }
}