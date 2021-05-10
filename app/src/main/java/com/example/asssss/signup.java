package com.example.asssss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class signup extends AppCompatActivity {
    private Button button;
    EditText emailId,password;
    Button btnsignup;
    Button btnAlreadyHaveAccountLogin;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        button=findViewById(R.id.signupbutton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openenterotp();
            }
        });
        mFirebaseAuth=FirebaseAuth.getInstance();
        emailId=findViewById(R.id.signup_email);
        password=findViewById(R.id.signup_password);
        btnsignup=findViewById(R.id.signupbutton2);
        btnAlreadyHaveAccountLogin=findViewById(R.id.alreadyHaveAccount);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailId.getText().toString();
                String passwd=password.getText().toString();
                if(email.isEmpty()){
                    emailId.setError("Provide Email ID");
                    emailId.requestFocus();
                }else if(passwd.isEmpty()){
                    password.setError("Enter desired password");
                    password.requestFocus();
                }else if(email.isEmpty() && passwd.isEmpty()){
                    Toast.makeText(signup.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }else if(!(email.isEmpty() && passwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,passwd).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(signup.this,"SignUp Unsuccesfull, Please try again",Toast.LENGTH_SHORT).show();

                            }else{
                                startActivity(new Intent(signup.this,Main_Screen.class));

                            }
                        }
                    });

                }
                else{
                    Toast.makeText(signup.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnAlreadyHaveAccountLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(signup.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
    public void openenterotp(){
        Intent intent=new Intent(signup.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}