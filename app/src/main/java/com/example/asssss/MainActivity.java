package com.example.asssss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button button;
    private TextView textView;


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