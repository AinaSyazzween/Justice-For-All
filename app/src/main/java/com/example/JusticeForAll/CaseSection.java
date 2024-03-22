package com.example.JusticeForAll;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CaseSection extends AppCompatActivity {

    TextView desc;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_section);

        //Action to get back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        desc = findViewById(R.id.desc);
        //use getIntent() to get the data
        Intent intent = getIntent();
        //After get data from putExtra, put the data into data variable
        data = String.valueOf(intent.getStringExtra(""));

        switch(data)
        {
            case "321 & 323 (Voluntarily causing hurt)":
                desc.setText("Max. 1 year imprisonment or RM2,000 fine or both");
                break;
            case "324 (Voluntarily causing hurt by dangerous weapons or means)":
                desc.setText("Max. 10 years imprisonment or fine or whipping or any two of the above");
                break;
            case "322 & 325 (Voluntarily causing grievous hurt)":
                desc.setText("Max. 7 years imprisonment or fine or whipping");
                break;
            case "326 (Voluntarily causing grievous hurt by dangerous weapons or means)":
                desc.setText("Max. 20 years imprisonment or fine or whipping");
                break;
            case "326A (Causing hurt to spouse, former spouse, child or other family members)":
                desc.setText("Twice the maximum term of imprisonment");
                break;
            case "Negligence":
                desc.setText("Disregard for the safety of others, resulting in their harm");
                break;
            case "Assault":
                desc.setText("Putting someone in danger or harming someone intentionally");
                break;
            case "Homicide":
                desc.setText("The killing of one person by another whether warranted or not");
                break;
            case "Arson":
                desc.setText("Intentional burning of someone else's property");
                break;
            case "Rape":
                desc.setText("The forcing of sexual intercourse on another person without their consent");
                break;
            case "Sexual Assault":
                desc.setText("The forcing of a sexual act on another person without their consent");
                break;
            case "Robbery":
                desc.setText("The taking of someone else's property under threat or use of force");
                break;
            case "Kidnapping":
                desc.setText("Holding or transporting someone against their will");
                break;
        }
    }
}