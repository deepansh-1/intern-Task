package com.deepanshu.intrerntask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
FirebaseAuth mAuth;

    private EditText password;
    private EditText email;
    private Button mLogin;
    private TextView create;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    mAuth = FirebaseAuth.getInstance();
    email = (EditText) findViewById(R.id.email);
    password = (EditText) findViewById(R.id.password);
    mLogin = (Button) findViewById(R.id.login);
    create = (TextView) findViewById(R.id.account);


     create.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));

         }
     });

    }



    public void Login(View view) {

        String useremail = email.getText().toString();
        String userpassword = password.getText().toString();


        if (TextUtils.isEmpty(useremail)){
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            return;
        }


        if (userpassword.isEmpty()) {
            Toast.makeText(this, "fill the password", Toast.LENGTH_SHORT).show();
            return;
        }


  mAuth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {

          if (!task.isSuccessful()){
              Toast.makeText(LoginActivity.this, " Login Failed ", Toast.LENGTH_SHORT).show();
          }

          else{
              Toast.makeText(LoginActivity.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
              startActivity(new Intent(LoginActivity.this,MainActivity.class));
              finish();


             }
             }
             });
             }
             }