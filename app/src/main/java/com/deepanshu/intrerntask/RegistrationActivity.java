package com.deepanshu.intrerntask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

         private FirebaseAuth mAuth;

         private EditText name;
         private EditText password;
         private EditText email;
         private EditText conformPassword;
         private Button mRegistration;
         private TextView loginGone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        conformPassword = (EditText) findViewById(R.id.conformPassword);
        mRegistration = (Button) findViewById(R.id.registration);
        loginGone =(TextView) findViewById(R.id.loginGone);

        loginGone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });

    }



    public void Registration(View view) {
        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String userpassword = password.getText().toString();
        String userconformpassword = conformPassword.getText().toString();

        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "Enter username Corectly", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(useremail)){
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userpassword.isEmpty()) {
            Toast.makeText(this, "fill the password", Toast.LENGTH_SHORT).show();
        return;
        }

        if (userpassword.length()<6 || userpassword.length()>15){
            Toast.makeText(this, "enter password length greater then 6 and lesst then 15", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!PASSWORD_PATTERN.matcher(userpassword).matches()){
            Toast.makeText(this, "Enter password according to requirement", Toast.LENGTH_SHORT).show();
            return;

        }

         mAuth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();


                }

                else{

                Toast.makeText(RegistrationActivity.this, "Registration Succesfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                finish();
                return;

                }

            }

        });




    }

}