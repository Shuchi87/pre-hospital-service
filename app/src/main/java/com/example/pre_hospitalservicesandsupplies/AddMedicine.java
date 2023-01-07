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

public class AddMedicine extends AppCompatActivity {
    EditText AddMed,AddMedDetails,MedPrice;
    Button AddMedBtn;
    DatabaseReference reference;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        reference = FirebaseDatabase.getInstance().getReference().child("Medicine");
        storageReference = FirebaseStorage.getInstance().getReference();
        AddMed = findViewById(R.id.AddMed);
        MedPrice = findViewById(R.id.MedPrice);
        AddMedDetails = findViewById(R.id.AddMedDetails);
        AddMedBtn = findViewById(R.id.AddMedBtn);

        AddMedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(AddMed.getText().toString().isEmpty()){
                    AddMed.setError("Empty");
                    AddMed.requestFocus();
                } else if(AddMedDetails.getText().toString().isEmpty())
                {
                    AddMedDetails.setError("Empty");
                    AddMedDetails.requestFocus();
                }else if(MedPrice.getText().toString().isEmpty())
                {
                    MedPrice.setError("Empty");
                    MedPrice.requestFocus();
                }
                else{
                    InsertMedicine();
                }

            }
        });


    }

    private void InsertMedicine() {
        String med = AddMed.getText().toString();
        String det = AddMedDetails.getText().toString();
        String mprice = MedPrice.getText().toString();



        MedicineInsert medicineInsert = new MedicineInsert(med,det,mprice);

        reference.push().setValue(medicineInsert);
        Toast.makeText(AddMedicine.this,"Data inserted",Toast.LENGTH_SHORT).show();

    }
}