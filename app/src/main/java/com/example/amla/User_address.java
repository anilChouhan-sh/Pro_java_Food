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

        ParseQuery  query = new ParseQuery("TP");
        query.whereEqualTo("username" , "food");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null && objects.size() >0 ) {
                    for(ParseObject object : objects) {


                        object.put("address", area.getText().toString());
                               /* object.put("city", city.getText().toString());
                                object.put("state", state.getText().toString());
                                object.put("mobileNumber", mobile_number.getText().toString());
                                object.put("pincode", pincode.getText().toString());*/

                        object.saveInBackground();
                    }
                    Toast.makeText(User_address.this, "Sucess", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

