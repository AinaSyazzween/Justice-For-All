package com.example.JusticeForAll;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LawSection extends AppCompatActivity implements View.OnClickListener {

    //Declare listview variable
    ListView listview;
    TextView txt;
    FirebaseAuth mAuth;
    // Declare button variable
    Button helpBtn, logout, gpstrack;

    // List of item that will be display to the listview
    String[] list = {"321 & 323 (Voluntarily causing hurt)", "324 (Voluntarily causing hurt by dangerous weapons or means)",
                     "322 & 325 (Voluntarily causing grievous hurt)", "326 (Voluntarily causing grievous hurt by dangerous weapons or means)",
                     "326A (Causing hurt to spouse, former spouse, child or other family members)", "Negligence", "Assault", "Homicide",
                     "Arson", "Rape", "Sexual Assault", "Robbery", "Kidnapping"};

    String violentCrime;
    ArrayAdapter<String> arrayAdapterViolent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawsection);
        mAuth = FirebaseAuth.getInstance();
        // Connect listview to listview at Activity_LawSection.xml
        listview = findViewById(R.id.listview);
        // Adapter set for simple list item and what list of item will be display in the listview, Which is list.
        arrayAdapterViolent = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        // Connect listview with the adapter.
        listview.setAdapter(arrayAdapterViolent);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //it will display according to what user select
                Intent intent = new Intent(LawSection.this, CaseSection.class);
                //save data that user will click
                violentCrime = arrayAdapterViolent.getItem(position).toString();
                intent.putExtra("", violentCrime);
                startActivity(intent);
            }
        });

        //Connect button to button at Activity_LawSection.xml
        helpBtn = findViewById(R.id.helpBtn);
        helpBtn.setOnClickListener(this);

        //connect logout at activity_lawsection.xml
        logout = findViewById(R.id.logoutBtn);
        logout.setOnClickListener(this);

        //connect gps track button at activity_LawSection.xml
        gpstrack = findViewById(R.id.gpsBtn);
        gpstrack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        // CREATE OBJECT INTENT, we set intent is default value is null
        // outside of the switch to save storage
        Intent intent = null;

        // WE HAVE 3 BUTTON, TO KNOW WHICH BUTTON IS EXECUTE, WE GET ID
        switch(v.getId()){
            case R.id.helpBtn:
                // Declare intent as to go to Help Center
                intent = new Intent(this, Helpcenter.class);
                break;
            case R.id.logoutBtn:
                mAuth.signOut();
                break;
            case R.id.gpsBtn:
                Uri uri = Uri.parse("https://www.google.com.my/maps/@2.260992,102.285312,15z");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                break;
        }
        // Start Activity
        startActivity(intent);
    }
}