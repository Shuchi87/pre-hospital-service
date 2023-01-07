package com.example.pre_hospitalservicesandsupplies;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HospitalHabiganj extends RecyclerView.ViewHolder {

    TextView textMedicalName;


    TextView textDoctorName,textDesignationName,textTime,TextSearialNumber;

    View view;
    public HospitalHabiganj(@NonNull View itemView) {
        super(itemView);
        textMedicalName = itemView.findViewById(R.id.textMedicalName);


        textDoctorName = itemView.findViewById(R.id.textDoctorName);
        textDesignationName = itemView.findViewById(R.id.textDesignationName);
        textTime = itemView.findViewById(R.id.textTime);
        TextSearialNumber = itemView.findViewById(R.id.TextSearialNumber);
        view = itemView;

    }
}
