/*package com.example.pre_hospitalservicesandsupplies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HospitalLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_location);
    }
}*/



package com.example.pre_hospitalservicesandsupplies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HospitalLocation extends AppCompatActivity {

    private String Division,District,HospitalName;                 //vars to hold the values of selected State and District
    private TextView tvCountrySpinner, tvStateSpinner, tvDistrictSpinner;             //declaring TextView to show the errors
    private Spinner ountrySpinner, tateSpinner, istrictSpinner,DivisionSpiner,DistrictSpinner,HospitaSpinner;                  //Spinners
    private ArrayAdapter<CharSequence> countryAdapter, stateAdapter, districtAdapter;   //declare adapters for the spinners

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_location);

        //Country Spinner Initialisation
        DivisionSpiner = findViewById(R.id.spinner_country);    //Finds a view that was identified by the android:id attribute

        //Country Spinner Initialisation
        countryAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_country, R.layout.spinner_layout);

        // Specify the layout to use when the list of choices appear
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        DivisionSpiner.setAdapter(countryAdapter);            //Set the adapter to the spinner to populate the Country Spinner

        DivisionSpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //State Spinner Initialisation
                DistrictSpinner = findViewById(R.id.spinner_indian_states);    //Finds a view that was identified by the android:id attribute in xml
                Division = DivisionSpiner.getSelectedItem().toString();

                int parentID = parent.getId();
                if (parentID == R.id.spinner_country){
                    switch (Division){
                        case "Select Your Division": stateAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_state, R.layout.spinner_layout);
                            break;
                        case "Dhaka": stateAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Dhaka_Division, R.layout.spinner_layout);
                            break;
                        case "Sylhet": stateAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_sylhet_Division, R.layout.spinner_layout);
                            break;
                        case "Chittagong": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Chittagong, R.layout.spinner_layout);
                            break;
                        case "Barisal": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Barisal, R.layout.spinner_layout);
                            break;
                        case "Khulna": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Khulna, R.layout.spinner_layout);
                            break;
                        case "Mymensingh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Mymensingh, R.layout.spinner_layout);
                            break;
                        case "Rajshahi": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Rajshahi, R.layout.spinner_layout);
                            break;
                        case "Rangpur": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Rangpur, R.layout.spinner_layout);
                            break;
                        default:  break;
                    }

                    // Specify the layout to use when the list of choices appear
                    stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    DistrictSpinner.setAdapter(stateAdapter);            //Set the adapter to the spinner to populate the State Spinner

                    //When any item of the stateSpinner is selected
                    DistrictSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            //Define City Spinner but we will populate the options through the selected state
                            HospitaSpinner = findViewById(R.id.spinner_indian_districts);
                            District = DistrictSpinner.getSelectedItem().toString();      //Obtain the selected State

                            int parentID = parent.getId();
                            if (parentID == R.id.spinner_indian_states){
                                switch (District){
                                    case "Select Your District": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_default_districts, R.layout.spinner_layout);
                                        break;
                                 /*   case "Andhra Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Arunachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_arunachal_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Assam": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_assam_districts, R.layout.spinner_layout);
                                        break;
                                    case "Bihar": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_bihar_districts, R.layout.spinner_layout);
                                        break;
                                    case "Chhattisgarh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_chhattisgarh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Goa": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_goa_districts, R.layout.spinner_layout);
                                        break;
                                    case "Gujarat": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_gujarat_districts, R.layout.spinner_layout);
                                        break;
                                    case "Haryana": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_haryana_districts, R.layout.spinner_layout);
                                        break;
                                    case "Himachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_himachal_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Jharkhand": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_jharkhand_districts, R.layout.spinner_layout);
                                        break;
                                    case "Karnataka": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_karnataka_districts, R.layout.spinner_layout);
                                        break;
                                    case "Kerala": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_kerala_districts, R.layout.spinner_layout);
                                        break;
                                    case "Madhya Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_madhya_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Maharashtra": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_maharashtra_districts, R.layout.spinner_layout);
                                        break;
                                    case "Manipur": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_manipur_districts, R.layout.spinner_layout);
                                        break;
                                    case "Meghalaya": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_meghalaya_districts, R.layout.spinner_layout);
                                        break;
                                    case "Mizoram": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_mizoram_districts, R.layout.spinner_layout);
                                        break;
                                    case "Nagaland": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_nagaland_districts, R.layout.spinner_layout);
                                        break;
                                    case "Odisha": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_odisha_districts, R.layout.spinner_layout);
                                        break;
                                    case "Punjab": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_punjab_districts, R.layout.spinner_layout);
                                        break;
                                    case "Rajasthan": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_rajasthan_districts, R.layout.spinner_layout);
                                        break;
                                    case "Sikkim": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_sikkim_districts, R.layout.spinner_layout);
                                        break;
                                    case "Tamil Nadu": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_tamil_nadu_districts, R.layout.spinner_layout);
                                        break;
                                    case "Telangana": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_telangana_districts, R.layout.spinner_layout);
                                        break;
                                    case "Tripura": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_tripura_districts, R.layout.spinner_layout);
                                        break;
                                    case "Uttar Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_uttar_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Uttarakhand": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_uttarakhand_districts, R.layout.spinner_layout);
                                        break;
                                    case "West Bengal": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_west_bengal_districts, R.layout.spinner_layout);
                                        break;
                                    case "Andaman and Nicobar Islands": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_andaman_nicobar_districts, R.layout.spinner_layout);
                                        break;
                                    case "Chandigarh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_chandigarh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Dadra and Nagar Haveli": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_dadra_nagar_haveli_districts, R.layout.spinner_layout);
                                        break;
                                    case "Daman and Diu": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_daman_diu_districts, R.layout.spinner_layout);
                                        break;
                                    case "Delhi": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_delhi_districts, R.layout.spinner_layout);
                                        break;
                                    case "Jammu and Kashmir": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_jammu_kashmir_districts, R.layout.spinner_layout);
                                        break;
                                    case "Lakshadweep": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_lakshadweep_districts, R.layout.spinner_layout);
                                        break;
                                    case "Ladakh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_ladakh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Puducherry": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_puducherry_districts, R.layout.spinner_layout);
                                        break;*/

                                    case "Dhaka District": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_DhahaHospital, R.layout.spinner_layout);
                                        break;

                                    case "Habiganj": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_HabiganjHospital, R.layout.spinner_layout);
                                        break;

                                    default:  break;
                                }

                                districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
                                HospitaSpinner.setAdapter(districtAdapter);        //Populate the list of Districts in respect of the State selected

                                //To obtain the selected District from the spinner
                                HospitaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        HospitalName = HospitaSpinner.getSelectedItem().toString();
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        Button submitButton;                                //To display the selected State and District
        submitButton = findViewById(R.id.button_submit);
        tvCountrySpinner = findViewById(R.id.textView_country);
        tvStateSpinner = findViewById(R.id.textView_indian_states);
        tvDistrictSpinner = findViewById(R.id.textView_indian_districts);

        submitButton.setOnClickListener(v -> {
            if (Division.equals("Select Your Country")) {
                Toast.makeText(HospitalLocation.this, "Please select your country from the list", Toast.LENGTH_LONG).show();
                tvCountrySpinner.setError("Country is required!");      //To set error on TextView
                tvCountrySpinner.requestFocus();
            } else if (District.equals("Select Your State")) {
                Toast.makeText(HospitalLocation.this, "Please select your state from the list", Toast.LENGTH_LONG).show();
                tvStateSpinner.setError("State is required!");      //To set error on TextView
                tvStateSpinner.requestFocus();
            } else if (HospitalName.equals("Select Your District")) {
                Toast.makeText(HospitalLocation.this, "Please select your district from the list", Toast.LENGTH_LONG).show();
                tvDistrictSpinner.setError("District is required!");
                tvDistrictSpinner.requestFocus();
                tvStateSpinner.setError(null);                      //To remove error from stateSpinner
            } else {
                tvStateSpinner.setError(null);
                tvDistrictSpinner.setError(null);
                Toast.makeText(HospitalLocation.this, "Selected Country: "+Division+"\nSelected State: "+District+"\nSelected District: "+HospitalName, Toast.LENGTH_LONG).show();
                openactivity();
            }
        });
    }

    private void openactivity() {
        if (Division.toString().equals("Sylhet")&&District.toString().equals("Habiganj") && HospitalName.toString().equals("Chader Hasi Hospital")) {
            Intent intent = new Intent(HospitalLocation.this, HospitalListHabigang.class);
            startActivity(intent);

        }
    }
}
/*
package com.example.pre_hospitalservicesandsupplies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HospitalLocation extends AppCompatActivity {

    private String selectedDistrict, selectedState;                 //vars to hold the values of selected State and District
    private TextView tvStateSpinner, tvDistrictSpinner;             //declaring TextView to show the errors
    private Spinner stateSpinner, districtSpinner;                  //Spinners
    private ArrayAdapter<CharSequence> stateAdapter, districtAdapter;   //declare adapters for the spinners
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_location);

        //State Spinner Initialisation
        stateSpinner = findViewById(R.id.spinner_indian_states);    //Finds a view that was identified by the android:id attribute in xml

        //Populate ArrayAdapter using string array and a spinner layout that we will define
        stateAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_Division, R.layout.spinner_layout);

        // Specify the layout to use when the list of choices appear
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stateSpinner.setAdapter(stateAdapter);            //Set the adapter to the spinner to populate the State Spinner

        //When any item of the stateSpinner uis selected
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Define City Spinner but we will populate the options through the selected state
                districtSpinner = findViewById(R.id.spinner_indian_districts);

                selectedState = stateSpinner.getSelectedItem().toString();      //Obtain the selected State

                int parentID = parent.getId();
                if (parentID == R.id.spinner_indian_states){
                    switch (selectedState){
                        case "Select Your State": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_districts, R.layout.spinner_layout);
                            break;
                            //

                        //


                        case "Dhaka": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Dhaka, R.layout.spinner_layout);
                            break;
                        case "Sylhet": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Sylhet, R.layout.spinner_layout);
                            break;
                        case "Chittagong": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Chittagong, R.layout.spinner_layout);
                            break;
                       case "Barisal": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Barisal, R.layout.spinner_layout);
                            break;
                        case "Khulna": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Khulna, R.layout.spinner_layout);
                            break;
                        case "Mymensingh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Mymensingh, R.layout.spinner_layout);
                            break;
                        case "Rajshahi": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Rajshahi, R.layout.spinner_layout);
                            break;
                        case "Rangpur": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Rangpur, R.layout.spinner_layout);
                            break;
                        default:  break;
                    }
                    districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
                    districtSpinner.setAdapter(districtAdapter);        //Populate the list of Districts in respect of the State selected

                    //To obtain the selected District from the spinner
                    districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectedDistrict = districtSpinner.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button submitButton;                                //To display the selected State and District
        submitButton = findViewById(R.id.button_submit);
        tvStateSpinner = findViewById(R.id.textView_indian_states);
        tvDistrictSpinner = findViewById(R.id.textView_indian_districts);

        submitButton.setOnClickListener(v -> {
            if (selectedState.equals("Select Your Division")) {
                Toast.makeText(HospitalLocation.this, "Please select your state from the list", Toast.LENGTH_LONG).show();
                tvStateSpinner.setError("Division is required!");      //To set error on TextView
                tvStateSpinner.requestFocus();
            } else if (selectedDistrict.equals("Select Your District")) {
                Toast.makeText(HospitalLocation.this, "Please select your district from the list", Toast.LENGTH_LONG).show();
                tvDistrictSpinner.setError("District is required!");
                tvDistrictSpinner.requestFocus();
                tvStateSpinner.setError(null);                      //To reove error from stateSpinner
            } else {


                tvStateSpinner.setError(null);
                tvDistrictSpinner.setError(null);
                Toast.makeText(HospitalLocation.this, "Selected State: "+selectedState+"\nSelected District: "+selectedDistrict, Toast.LENGTH_LONG).show();

                startNewActivity();

            // Intent intent = new Intent(HospitalLocation.this,HospitalListHabigang.class);
             //startActivity(intent);
                /* if(tvStateSpinner.toString().equals("Sylhet")&&tvDistrictSpinner.toString().equals("Habiganj"));
                {
                    Intent intent = new Intent(HospitalLocation.this,HospitalListHabigang.class);
                }*/
         /*   }
        });
    }

    private void startNewActivity() {
        if(selectedState.toString().equals("Sylhet")&&selectedDistrict.toString().equals("Habiganj")){
            Intent intent = new Intent(HospitalLocation.this,HospitalListHabigang.class);
            startActivity(intent);

        }
    }
}*/