package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pre_hospitalservicesandsupplies.databinding.ActivityMedicineListBinding;
import com.example.pre_hospitalservicesandsupplies.databinding.ActivityMedicineListDetBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MedicineListDet extends AppCompatActivity {

    TextView textView,mnn,textMedicineDetD;




    RecyclerView recyclerView;
    FirebaseRecyclerOptions<MedicinelistCode1> options;
    FirebaseRecyclerAdapter<MedicinelistCode1,MedicineListCode> adapter;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list_det);



        textView = findViewById(R.id.mn);
        mnn = findViewById(R.id.mnn);
        textMedicineDetD = findViewById(R.id.textMedicineDetD);
        //setContentView(R.layout.activity_medicine_list);

       databaseReference = FirebaseDatabase.getInstance().getReference().child("Medicine");
        // inputSearch=findViewById(R.id.inputSearch);
      //  recyclerView=findViewById(R.id.recycleView);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
      //  recyclerView.setHasFixedSize(true);

     //   LoadData();

        String MedicineKey = getIntent().getStringExtra("MedicineKey");

        databaseReference.child(MedicineKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String med = dataSnapshot.child("med").getValue().toString();
                    String mprice = dataSnapshot.child("mprice").getValue().toString();
                    String det = dataSnapshot.child("det").getValue().toString();
                    textView.setText(med);
                    mnn.setText(mprice);
                    textMedicineDetD.setText(det);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
  /* private void checkIsFavourite(){

        FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){

        }else{
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Medicine");
            reference.child(firebaseAuth.getUid()).child("Favorites_Medicine").child(Mid)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            isInMyFavourite = snapshot.exists();

                            if(isInMyFavourite){
                                binding.


                            }else{

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }


    }*/

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