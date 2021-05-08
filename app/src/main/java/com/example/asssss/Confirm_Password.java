package com.example.asssss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Confirm_Password extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);
        button=findViewById(R.id.otp_confirmpassword_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainactivity();
            }
        });
    }
    public void openmainactivity(){
        Intent intent=new Intent(Confirm_Password.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}