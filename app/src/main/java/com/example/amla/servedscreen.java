package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class servedscreen extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servedscreen);
        Button home = findViewById(R.id.home);
        ParseQuery<ParseObject> clean = ParseQuery.getQuery("Cart");
        clean.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                for (ParseObject object : objects) {
                    try {
                        object.delete();
                        object.saveInBackground();
                    } catch (ParseException exe) {
                        exe.printStackTrace();
                    }

                }
            }
        });
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),homepage.class);
        startActivity(intent);
    }
}
