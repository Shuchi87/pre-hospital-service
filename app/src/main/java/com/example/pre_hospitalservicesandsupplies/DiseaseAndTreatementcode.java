package com.example.pre_hospitalservicesandsupplies;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiseaseAndTreatementcode extends RecyclerView.ViewHolder {

    TextView textDiseaseName;
    ArrayList<MedicinelistCode1> list;

    ArrayList<MedicinelistCode1> arrayListcopy;


    TextView DiseaseName,ditection,tratment;
    View view;
    public DiseaseAndTreatementcode(@NonNull View itemView) {
        super(itemView);

        textDiseaseName = itemView.findViewById(R.id.textDiseaseName);

        DiseaseName = itemView.findViewById(R.id.DiseaseName);
        ditection = itemView.findViewById(R.id.ditection);
        tratment = itemView.findViewById(R.id.tratment);
        list = new ArrayList<>();
        view = itemView;

    }
}
