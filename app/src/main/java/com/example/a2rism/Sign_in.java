package com.example.a2rism;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.a2rism.Models.ClientModel;
import com.example.a2rism.Models.ProviderModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_in extends AppCompatActivity {
    private static final int RC_SIGN_IN = 9001;
    EditText textMail, textPassword,textName;
    Spinner typeOfUser;
    Button logButton, login;

    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        //Initialize Awesome Validation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.textMail, Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        awesomeValidation.addValidation(this, R.id.textPassword, ".{6,}", R.string.invalid_password);
        awesomeValidation.addValidation(this, R.id.textName, ".{1,}", R.string.empty_field);

        //Initialize Views
        login = findViewById(R.id.textLogIn);
        textMail = findViewById(R.id.textMail);
        textPassword = findViewById(R.id.textPassword);
        textName = findViewById(R.id.textName);

        typeOfUser = findViewById(R.id.typeOfUser);

        //Initialize Buttons
        logButton = findViewById(R.id.signButton);

        typeOfUser.setAdapter(new ArrayAdapter<String>(Sign_in.this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Provider", "Client"}));

        //Set OnClickListener for Login Button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_in.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Set OnClickListener for Sign Up Button
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    //Create User
                    firebaseAuth.createUserWithEmailAndPassword(textMail.getText().toString(), textPassword.getText().toString())
                            .addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Sign_in.this, "User Created", Toast.LENGTH_SHORT).show();
                                        String UserUid = firebaseAuth.getUid();
                                        final FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        DatabaseReference ref = database.getReference();
                                        if(typeOfUser.getSelectedItem().toString().equals("Provider")){
                                            ProviderModel user = new ProviderModel();
                                            user.setUid(UserUid);
                                            user.setType(typeOfUser.getSelectedItem().toString());
                                            user.setName(textName.getText().toString());
                                            ref.child("Users").child(UserUid).setValue(user);
                                        }
                                        else{
                                            ClientModel user = new ClientModel();
                                            user.setUid(UserUid);
                                            user.setType(typeOfUser.getSelectedItem().toString());
                                            user.setName(textName.getText().toString());
                                            ref.child("Users").child(UserUid).setValue(user);
                                        }
                                        finish();
                                    } else {
                                        Toast.makeText(Sign_in.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(Sign_in.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}