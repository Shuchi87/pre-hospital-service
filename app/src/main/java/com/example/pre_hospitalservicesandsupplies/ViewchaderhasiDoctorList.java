package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewchaderhasiDoctorList extends AppCompatActivity {

    TextView DoctorName,DoctorDesignation,schedule,DoctorSerialNumber;

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<MedicinelistCode1> options;
    FirebaseRecyclerAdapter<MedicinelistCode1,MedicineListCode> adapter;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewchaderhasi_doctor_list);

        DoctorName = findViewById(R.id.DoctorName);
        DoctorDesignation = findViewById(R.id.DoctorDesignation);
        schedule = findViewById(R.id.schedule);
        DoctorSerialNumber = findViewById(R.id.DoctorSerialNumber);
        //setContentView(R.layout.activity_medicine_list);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Habigang DoctorList").child("chader hasi");
        // inputSearch=findViewById(R.id.inputSearch);
        //  recyclerView=findViewById(R.id.recycleView);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //  recyclerView.setHasFixedSize(true);

        //   LoadData();

        String MedicineKey = getIntent().getStringExtra("Habigang DoctorListKey");

        databaseReference.child(MedicineKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String addDocotorName = dataSnapshot.child("addDocotorName").getValue().toString();
                    String addDesignation = dataSnapshot.child("addDesignation").getValue().toString();
                    String addTime = dataSnapshot.child("addTime").getValue().toString();
                    String addSerialNumber = dataSnapshot.child("addSerialNumber").getValue().toString();
                    DoctorName.setText(addDocotorName);
                    DoctorDesignation.setText(addDesignation);
                    schedule.setText(addTime);
                    DoctorSerialNumber.setText(addSerialNumber);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }

  /*  private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<MedicinelistCode1>().setQuery(databaseReference,MedicinelistCode1.class).build();
        adapter = new FirebaseRecyclerAdapter<MedicinelistCode1, MedicineListCode>(options){


            @Override
            protected void onBindViewHolder(@NonNull MedicineListCode holder, int position, @NonNull MedicinelistCode1 model) {


                holder.textMedicineNameD.setText(model.getMed());
                holder.textMedicinepricD.setText(model.getMprice());
                holder.textMedicineDetD.setText(model.getDet());
               // holder.TextSearialNumber.setText(model.getAddSerialNumber());

            }

            @NonNull
            @Override
            public MedicineListCode onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medcinedetiles,parent,false);
                return new MedicineListCode(view);
            }


        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }*/
}







/*package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewchaderhasiDoctorList extends AppCompatActivity {

    TextView textDoctorName,textDesignationName,textTime;

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<MedicalHabiganj> options;
    FirebaseRecyclerAdapter<MedicalHabiganj,HospitalHabiganj> adapter;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewchaderhasi_doctor_list);


        setContentView(R.layout.activity_hospital_list_habigang);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Habigang DoctorList").child("chader hasi");
       // inputSearch=findViewById(R.id.inputSearch);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        String Hospital = getIntent().getStringExtra("Hospital");
        databaseReference.child(Hospital).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String addDocotorName = snapshot.child("addDocotorName").getValue().toString();
                    textDoctorName.setText(addDocotorName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        LoadData();



    }

    private void LoadData() {

        options = new FirebaseRecyclerOptions.Builder<MedicalHabiganj>().setQuery(databaseReference,MedicalHabiganj.class).build();
        adapter = new FirebaseRecyclerAdapter<MedicalHabiganj, HospitalHabiganj>(options) {
            @Override
            protected void onBindViewHolder(@NonNull HospitalHabiganj holder, int position, @NonNull MedicalHabiganj model) {
              //  holder.textMedicalName.setText(model.getAddDocotorName());

                  holder.textDoctorName.setText(model.getAddDocotorName());
                holder.textDesignationName.setText(model.getAddDesignation());
                 holder.textTime.setText(model.getAddTime());
                 holder.TextSearialNumber.setText(model.getAddSerialNumber());




            }

            @NonNull
            @Override
            public HospitalHabiganj onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habiganjdoctorlist,parent,false);
                return new HospitalHabiganj(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}*/