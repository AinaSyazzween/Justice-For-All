package com.example.JusticeForAll;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Helpcenter extends AppCompatActivity implements View.OnClickListener {

    Button whatsappBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpcenter);

        // Put Back button on top of the screen.
        // Also change the parent of Helpcenter activity in AndroidManifest.xml to go back to law section
        //to enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        whatsappBtn = findViewById(R.id.whatsappBtn);
        whatsappBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //wrap URL in Uri
        Uri uri = Uri.parse("https://tyhlawyers.my/property-and-probate-lawyer-firm-services-in-kuala-lumpur-and-selangor-malaysia/free-online-legal-advice-in-malaysia/");

        //open the link
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        //start intent
        startActivity(intent);
    }
}