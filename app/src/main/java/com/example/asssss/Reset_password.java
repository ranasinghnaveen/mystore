package com.example.asssss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reset_password extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        button=findViewById(R.id.resetbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openotp();
            }
        });
    }
    public void openotp(){
        Intent intent=new Intent(Reset_password.this,Enter_otp.class);
        startActivity(intent);
        finish();
    }
}

