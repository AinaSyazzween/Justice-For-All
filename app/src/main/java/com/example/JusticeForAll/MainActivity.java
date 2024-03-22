package com.example.JusticeForAll;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtEmail, edtPassword;
    Button Loginbtn;
    //use regular expression to set the email pattern as we want
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]";
    ProgressDialog progressDialog;

    //to get authorisation
    FirebaseAuth mAuth;
    //to store user's email and password
    FirebaseUser mUser;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect id in xml to java file
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        Loginbtn = findViewById(R.id.btnLogin);

        //set button functionality
        Loginbtn.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
    }

    @Override
    public void onClick(View view) {
        perforLogin();
    }

    private void perforLogin(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (password.isEmpty() || password.length() < 6){
            edtPassword.setError("Enter a Proper Password");
        } else {
            progressDialog.setMessage("Login In...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(MainActivity.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity(){
        Intent intent = new Intent(MainActivity.this, LawSection.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}