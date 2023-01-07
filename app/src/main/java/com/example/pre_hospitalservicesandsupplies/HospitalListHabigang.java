package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HospitalListHabigang extends AppCompatActivity {


    SearchView inputSearch;
    RecyclerView recyclerView;
    FirebaseRecyclerOptions<MedicalHabiganj> options;
    FirebaseRecyclerAdapter<MedicalHabiganj,HospitalHabiganj> adapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list_habigang);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Habigang DoctorList").child("chader hasi");
        inputSearch=findViewById(R.id.inputSearch);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

        LoadData();
    }

    private void LoadData() {
        options = new FirebaseRecyclerOptions.Builder<MedicalHabiganj>().setQuery(databaseReference,MedicalHabiganj.class).build();
        adapter = new FirebaseRecyclerAdapter<MedicalHabiganj, HospitalHabiganj>(options) {
            @Override
            protected void onBindViewHolder(@NonNull HospitalHabiganj holder, int position, @NonNull MedicalHabiganj model) {
                holder.textMedicalName.setText(model.getAddDocotorName());
                //
             //   holder.textDoctorName.setText(model.getAddDocotorName());
            //    holder.textDesignationName.setText(model.getAddDesignation());
              //  holder.textTime.setText(model.getAddTime());


                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(HospitalListHabigang.this,ViewchaderhasiDoctorList.class);
                        intent.putExtra("Habigang DoctorListKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public HospitalHabiganj onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewmedicallisthabiganj,parent,false);
                return new HospitalHabiganj(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}