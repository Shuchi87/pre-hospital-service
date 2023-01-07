package com.example.pre_hospitalservicesandsupplies;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pre_hospitalservicesandsupplies.databinding.ActivityMedicineListBinding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MedicineListCode extends RecyclerView.ViewHolder {



    TextView textMedicineName;
    ArrayList<MedicinelistCode1> list;

    ArrayList<MedicinelistCode1> arrayListcopy;


    TextView textMedicineNameD,textMedicinepricD,textMedicineDetD;

    View view;
    public MedicineListCode(@NonNull View itemView) {
        super(itemView);
        textMedicineName = itemView.findViewById(R.id.textMedicineName);

        textMedicineNameD = itemView.findViewById(R.id.textMedicineNameD);
        textMedicinepricD = itemView.findViewById(R.id.textMedicinepricD);
        textMedicineDetD = itemView.findViewById(R.id.textMedicineDetD);
        list = new ArrayList<>();
        view = itemView;



    }

}







/*package com.example.pre_hospitalservicesandsupplies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MedicineListCode extends RecyclerView.Adapter<MedicineListCode.MyViewHolder> {

    Context context;
   // ArrayList<MedicinelistCode1> list;
    List<MedicinelistCode1> list =new ArrayList<>();
    //
    MyViewHolder myViewHolder;




    public MedicineListCode(Context context, ArrayList<MedicinelistCode1> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.medicinelist,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        MedicinelistCode1 medicinelistCode1 = list.get(position);

        holder.med.setText(medicinelistCode1.getMed());

        //newactivitycode




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public *//*static*/ /*class MyViewHolder extends RecyclerView.ViewHolder{

       TextView med;


        MedicinelistCode1 medicineCode1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            med = itemView.findViewById(R.id.textMedicineName);


          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(),MedicineListDet.class);
                    intent.putExtra("Medicine",medicineCode1);
                    itemView.getContext().startActivity(intent);
                }
            });*/

/*
        }

        //
        public void bind(MedicinelistCode1 medicinelistCode1){
            medicineCode1 = medicinelistCode1;

        }
    }

    public void filterlist(List<MedicinelistCode1> filterdlist){
        list = filterdlist;
        notifyDataSetChanged();
    }

}
*/