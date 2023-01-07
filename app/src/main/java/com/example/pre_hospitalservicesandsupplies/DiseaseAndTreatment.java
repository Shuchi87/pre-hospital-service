package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DiseaseAndTreatment extends AppCompatActivity {
    RecyclerView RecycleViewDisease;
    FirebaseRecyclerOptions<DiseaseAndTreatementcode1> options;
    FirebaseRecyclerAdapter<DiseaseAndTreatementcode1,DiseaseAndTreatementcode> adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference databaseReference;

    List<DiseaseAndTreatementcode1> list;
    DiseaseAndTreatementcode diseaseAndTreatementcode;
    List<DiseaseAndTreatementcode1> filterList = new ArrayList<>();

    //Boolean fvrtChecker = false;
    DiseaseAndTreatementcode1 diseaseAndTreatementcode1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_and_treatment);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("DiseaseAndTreatment");
        //searchMedicine=findViewById(R.id.searchMedicine);

        RecycleViewDisease=findViewById(R.id.RecycleViewDisease);
        RecycleViewDisease.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecycleViewDisease.setHasFixedSize(true);
        list = new ArrayList<>();
        LoadData();
    }

    private void LoadData() {
        //  Query query = databaseReference.orderByChild("med").startAt(data).endAt(data+"\uf8ff");


        options = new FirebaseRecyclerOptions.Builder<DiseaseAndTreatementcode1>().setQuery(databaseReference,DiseaseAndTreatementcode1.class).build();
        adapter = new FirebaseRecyclerAdapter<DiseaseAndTreatementcode1, DiseaseAndTreatementcode>(options) {



            @Override
            protected void onBindViewHolder(@NonNull DiseaseAndTreatementcode holder, @SuppressLint("RecyclerView") int position, @NonNull DiseaseAndTreatementcode1 model) {
               holder.textDiseaseName.setText(model.getAdddiseasename());

                //holder.DiseaseName.setText(model.getDiseaseName());

                //   holder.med.setText(medicinelistCode1.getMed());
                //   holder.textDoctorName.setText(model.getAddDocotorName());
                //    holder.textDesignationName.setText(model.getAddDesignation());
                //  holder.textTime.setText(model.getAddTime());

                //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //String currentUserid = user.getUid();

                //final String postKey = getRef(position).getKey();


                holder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DiseaseAndTreatment.this,DiseaseAndTreatmentDet.class);
                        intent.putExtra("DiseaseKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

              /* String med = getItem(position).getMed();
              holder.favouriteChecker(postKey);
                holder.favourite_Medicine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fvrtChecker = true;
                        fvrtref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                               if(fvrtChecker.equals(true)){
                                   if(snapshot.child(postKey).hasChild(currentUserid)){
                                       fvrtref.child(postKey).child(currentUserid).removeValue();
                                       delete(med);
                                       fvrtChecker = false;
                                   }else {
                                       fvrtref.child(postKey).child(currentUserid).setValue(true);
                                       medicinelistCode1.setMed(med);

                                       String id = fvrt_listref.push().getKey();
                                       fvrt_listref.child(id).setValue(medicinelistCode1);
                                       fvrtChecker = false;

                                   }
                               }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });*/

            }
            @NonNull
            @Override
            public DiseaseAndTreatementcode onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diseaselist,parent,false);
                return new DiseaseAndTreatementcode(view);
            }
        };
        adapter.startListening();
        RecycleViewDisease.setAdapter(adapter);
    }
}
