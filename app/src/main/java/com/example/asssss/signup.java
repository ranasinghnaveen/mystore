package com.example.asssss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signup extends AppCompatActivity {
    private Button button;

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
    }
    public void openenterotp(){
        Intent intent=new Intent(signup.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}