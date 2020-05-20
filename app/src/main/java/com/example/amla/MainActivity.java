package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    Boolean signupmodeactive = true;
    TextView login;

    public void showhomepage () {
        Intent intent = new Intent(getApplicationContext() , homepage.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            Button signupbutton = findViewById(R.id.signupbutton);
            if (signupmodeactive) {
                signupmodeactive = false;
                signupbutton.setText("Login");
                login.setText("or, Sign Up");
            }else {
                signupmodeactive = true;
                signupbutton.setText("Sign Up");
                login.setText("or, Login");
            }
        }
    }
    public void signupclicked(View view) {
        EditText username = findViewById(R.id.username);
        EditText userpassword = findViewById(R.id.userpassword);

        if(username.getText().toString().matches("")  || userpassword.getText().toString().matches("")) {
            Toast.makeText(this , "A username and password are required ", Toast.LENGTH_LONG).show();
        } else {
            if(signupmodeactive) {
                ParseUser user = new ParseUser();
                user.setUsername(username.getText().toString());
                user.setPassword(userpassword.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.i("Signup", "sucess");
                            showhomepage();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }else {
                //login
                ParseUser.logInInBackground(username.getText().toString(), userpassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null) {
                            Log.i("login","sucess");
                            showhomepage();
                        }else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("myappID")
                .clientKey("XK7uJu20XURA")
                .server("http://13.58.7.86/parse")
                .build()
        );

        login = findViewById(R.id.login);
        login.setOnClickListener(this);

        //ParseUser.logOut();

        if(ParseUser.getCurrentUser() != null) {
            showhomepage();
        }





        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);


        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}

