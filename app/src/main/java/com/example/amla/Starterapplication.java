package com.example.amla;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import static com.parse.Parse.getApplicationContext;

public class Starterapplication extends Application {
    @Override
    public void onCreate()  {
        super.onCreate();

    }
}
