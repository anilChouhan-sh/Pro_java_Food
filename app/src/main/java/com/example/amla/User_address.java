package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class User_address extends AppCompatActivity {

    EditText area,mobile_number,pincode,city,state;
    Button button;
    String user = "";


    public void onsave (View view){

       // ParseQuery<ParseUser> query = ParseUser.getQuery();
        ParseObject  saving = new ParseObject("User");
        saving.put("address",area.getText().toString());
        saving.put("city",city.getText().toString());
        saving.put("state",state.getText().toString());
        saving.put("mobileNumber",mobile_number.getText().toString());
        saving.put("pincode",pincode.getText().toString());
        saving.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(User_address.this,"Address saved",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_address);

        Intent intent =getIntent();
        user = intent.getStringExtra("username");
        Log.i("username",user);
        setTitle("Your Address");
    }
}
