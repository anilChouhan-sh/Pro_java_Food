package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class User_address extends AppCompatActivity implements View.OnClickListener {

    EditText area,mobile_number,pincode,city,state;
    Button button;
    String user = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_address);
        button =findViewById(R.id.button);
        Intent intent =getIntent();
        this.user = intent.getStringExtra("username");
        Log.i("username",user);
        setTitle("Your Address");

        area = findViewById(R.id.area);
        city = findViewById(R.id.city);
        mobile_number = findViewById(R.id.mobile);
        pincode= findViewById(R.id.pincode);
        state = findViewById(R.id.state);


        button.setOnClickListener( this);



    }


    @Override
    public void onClick(View v) {
        //ParseQuery<ParseUser> query = new ParseQuery<ParseUser>()

        //ParseQuery  query = new ParseQuery("User");
        int i=0;
        //query.whereEqualTo("username" , "food");
        if(i==0) {
            ParseObject saving = new ParseObject("info");
            saving.put("username", ParseUser.getCurrentUser().getUsername());
            saving.put("address", area.getText().toString());
            saving.put("city", city.getText().toString());
            saving.put("state", state.getText().toString());
            saving.put("mobile_number", mobile_number.getText().toString());
            saving.put("pincode", pincode.getText().toString());
            saving.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(User_address.this, "Address Saved", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            i++;
        }else {
            Toast.makeText(User_address.this,"Address already saved",Toast.LENGTH_SHORT).show();
        }
    }

}

