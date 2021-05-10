package com.example.asssss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button button;
    private TextView textView;

    EditText emailId,password;
    Button btnlogin;
    Button btnsignup;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.loginbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainscreen();
            }
        });
        textView=findViewById(R.id.forgotpass);textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openforgot();
            }
        });
        button=findViewById(R.id.signupbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignup();
            }
        });
        mFirebaseAuth=FirebaseAuth.getInstance();
        emailId=findViewById(R.id.login_email);
        password=findViewById(R.id.login_password);
        btnlogin=findViewById(R.id.loginbutton);
        btnsignup=findViewById(R.id.signupbutton);

        mAuthStateListener= new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull @NotNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser= mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null){
                    Toast.makeText(MainActivity.this, "You are Logged in", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(MainActivity.this,Main_Screen.class);
                    startActivity(i);

                }else{
                    Toast.makeText(MainActivity.this, "Wrong EMAIL or PASSWORD,Log in again", Toast.LENGTH_SHORT).show();
                }

            }
        };
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailId.getText().toString();
                String passwd=password.getText().toString();
                if(email.isEmpty()){
                    emailId.setError("Provide Email ID");
                    emailId.requestFocus();
                }else if(passwd.isEmpty()) {
                    password.setError("Enter password");
                    password.requestFocus();
                }else if(email.isEmpty() && passwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }else if(!(email.isEmpty() && passwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,passwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"LogIn error, please try again",Toast.LENGTH_SHORT).show();
                            }else{
                                Intent inToHome=new Intent(MainActivity.this,Main_Screen.class);
                                startActivity(inToHome);
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(MainActivity.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intoSignUp= new Intent(MainActivity.this,signup.class);
                startActivity(intoSignUp);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    public void openmainscreen(){
        Intent intent=new Intent(MainActivity.this,Main_Screen.class);
        startActivity(intent);
        finish();
    }
    public void openforgot(){
        Intent i=new Intent(MainActivity.this,Reset_password.class);
        startActivity(i);
        finish();
    }
    public void opensignup(){
        Intent i=new Intent(MainActivity.this,signup.class);
        startActivity(i);
        finish();
    }
}