package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

import com.example.pre_hospitalservicesandsupplies.databinding.ActivityMedicineListBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MedicineList extends AppCompatActivity {

   /* String Mid;
    boolean isInMyFavourite = false;
    FirebaseAuth firebaseAuth;
    ActivityMedicineListBinding binding;*/

    RecyclerView recyclerView;
    FirebaseRecyclerOptions<MedicinelistCode1> options;
    FirebaseRecyclerAdapter<MedicinelistCode1,MedicineListCode> adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference databaseReference, fvrtref,fvrt_listref;
    SearchView searchMedicine;
    List<MedicinelistCode1> list;
    MedicineListCode medicineListCode;
    List<MedicinelistCode1> filterList = new ArrayList<>();

    //Boolean fvrtChecker = false;
    MedicinelistCode1 medicinelistCode1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_medicine_list);
    //  setContentView(R.layout.medicinelist);
        //setContentView(binding.getRoot());

      /*  binding = ActivityMedicineListBinding.inflate(getLayoutInflater());
        View v = (binding.getRoot());
        setContentView(v);

        Intent intent = getIntent();
        Mid = intent.getStringExtra("Mid");*/

        // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String currentUserid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Medicine");
        //searchMedicine=findViewById(R.id.searchMedicine);
        //favourite_Medicine_btn = findViewById(R.id.favourite_Medicine_btn);
        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();


      /* firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null){
            checkIsFavourite();
        }

           binding.getRoot().findViewById(R.id.favourite_Medicine_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firebaseAuth.getCurrentUser()==null){
                    Toast.makeText(MedicineList.this, "you are not login", Toast.LENGTH_SHORT).show();
                }else{
                    if(isInMyFavourite){
                        MedicineList.removeFromFavourite(MedicineList.this,Mid);

                    }else{
                        MedicineList.addToFavourite(MedicineList.this,Mid);


                    }
                }
            }
        });*/

        //   medicinelistCode1 = new MedicinelistCode1();
        //fvrtref = database.getReference("FavouriteMedicine");
       // fvrt_listref =  database.getReference("FavouriteMedicineList").child(currentUserid);
        //searchMedicine = (EditText)findViewById(R.id.searchMedicine);



      /*  FirebaseRecyclerOptions<MedicinelistCode1> options =
                new FirebaseRecyclerOptions.Builder<MedicinelistCode1>()
                .setQuery(databaseReference,MedicinelistCode1.class)
                .build();

        FirebaseRecyclerAdapter<MedicinelistCode1,MedicineListCode > firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<MedicinelistCode1, MedicineListCode>(options) {
                    @NonNull
                    @Override
                    public MedicineListCode onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        return null;
                    }

                    @Override
                    protected void onBindViewHolder(@NonNull MedicineListCode holder, int position, @NonNull MedicinelistCode1 model) {

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        String currentUserid = user.getUid();
                        final String postKey = getRef(position).getKey();



                         String med = getItem(position).getMed();
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
                                       //delete(med);
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
                });



                    }
                };
*/



      /*  searchMedicine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {




            }
        });*/
        LoadData();



    }



    private void LoadData() {

      //  Query query = databaseReference.orderByChild("med").startAt(data).endAt(data+"\uf8ff");


        options = new FirebaseRecyclerOptions.Builder<MedicinelistCode1>().setQuery(databaseReference,MedicinelistCode1.class).build();
        adapter = new FirebaseRecyclerAdapter<MedicinelistCode1, MedicineListCode>(options) {



            @Override
            protected void onBindViewHolder(@NonNull MedicineListCode holder, @SuppressLint("RecyclerView") int position, @NonNull MedicinelistCode1 model) {
                holder.textMedicineName.setText(model.getMed());

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
                        Intent intent = new Intent(MedicineList.this,MedicineListDet.class);
                        intent.putExtra("MedicineKey",getRef(position).getKey());
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
            public MedicineListCode onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicinelist,parent,false);
                return new MedicineListCode(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
   /* void  delete (String med){
        Query query = fvrt_listref.orderByChild("med").equalTo(med);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    dataSnapshot.getRef().removeValue();

                    Toast.makeText(MedicineList.this, "Deleted", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
*/

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

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }


    }*/





    /*public static void addToFavourite(Context context,String Mid){
        FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            Toast.makeText(context, "you are not login", Toast.LENGTH_SHORT).show();
        }else {
            long timestamp = System.currentTimeMillis();

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("MedicineId",""+Mid);
            hashMap.put("timestamp",""+timestamp);


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Medicine");
            reference.child(firebaseAuth.getUid()).child("Favorites_Medicine").child(Mid)
            .setValue(hashMap)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(context, "Added to your Favourite...", Toast.LENGTH_SHORT).show();

                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context, "Failed to Add to your Favourite..."+e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }) ;

        }

    }*/

   /* public static void removeFromFavourite(Context context,String Mid){
        FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            Toast.makeText(context, "you are not login", Toast.LENGTH_SHORT).show();
        }else {


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Medicine");
            reference.child(firebaseAuth.getUid()).child("Favorites_Medicine").child(Mid)
                    .removeValue()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "Removed from your Favourite...", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, "Failed to Removed from your Favourite..."+e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }) ;

        }

    }*/


}




/*package com.example.pre_hospitalservicesandsupplies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MedicineList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MedicinelistCode1> list;
    DatabaseReference databaseReference;
    MedicineListCode medicineListCode;

    SearchView searchMedicine;
    //newactivity
    FirebaseRecyclerOptions<MedicinelistCode1> options;
    FirebaseRecyclerAdapter<MedicinelistCode1,MedicineListCode> adapter;



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MedicineList.this,DashBoard.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list);



        searchMedicine = findViewById(R.id.searchMedicine);
        recyclerView = findViewById(R.id.recycleView);
        databaseReference = FirebaseDatabase.getInstance().getReference("Medicine");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();


        medicineListCode = new MedicineListCode(this,list);
        recyclerView.setAdapter(medicineListCode);

        recyclerView.setItemAnimator(null);

        //newactivity
        LoadData();

        searchMedicine.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    MedicinelistCode1 medicinelistCode1 = dataSnapshot.getValue(MedicinelistCode1.class);
                    list.add(medicinelistCode1);
                }
                medicineListCode.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



    private void filter(String newText) {
        List<MedicinelistCode1> filterlist =new ArrayList<>();
        for (MedicinelistCode1 item : list){
            if(item.getMed().toLowerCase().contains(newText.toLowerCase())){
                filterlist.add(item);
            }

        }
        medicineListCode.filterlist(filterlist);
    }
    //newactivity
    private void LoadData() {


        options = new FirebaseRecyclerOptions.Builder<MedicinelistCode1>().setQuery(databaseReference,MedicinelistCode1.class).build();
        adapter = new FirebaseRecyclerAdapter<MedicinelistCode1, MedicineListCode>(options) {

            @NonNull
            @Override
            public MedicineListCode onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            protected void onBindViewHolder(@NonNull MedicineListCode holder, int position, @NonNull MedicinelistCode1 model) {

            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    //endnewactivity



}*/