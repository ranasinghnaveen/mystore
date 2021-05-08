package com.example.asssss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Enter_otp extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
        button=findViewById(R.id.otpbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openconfirmpass();
            }
        });
    }
    public void openconfirmpass(){
        Intent intent=new Intent(Enter_otp.this,Confirm_Password.class);
        startActivity(intent);
        finish();
    }
}