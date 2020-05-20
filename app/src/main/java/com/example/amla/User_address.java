package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

public class User_address extends AppCompatActivity {

    EditText area,mobile_number,pincode,city,state;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_address);

        area = findViewById(R.id.area);
        mobile_number = findViewById(R.id.mobile);
        pincode = findViewById(R.id.pincode);
        city =findViewById(R.id.city);
        state =findViewById(R.id.state);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                ParseUser user =ParseUser.getCurrentUser();
                user.put("address" , area.getText());
            }
        });


    }
}
