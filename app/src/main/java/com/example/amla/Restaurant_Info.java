package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;

import android.widget.ImageView;
import android.widget.TextView;


import com.parse.FindCallback;


import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;


import java.util.List;


public class Restaurant_Info extends AppCompatActivity {



    ImageView imageView ;
    TextView view_resto_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__info);

        Intent intent = getIntent();
        final String resto_name =intent.getStringExtra("Resto_name");
        Log.i("name" , resto_name);
        imageView = findViewById(R.id.profile);
        view_resto_name=findViewById(R.id.Resto_name);
        final List<ParseObject>[] list = new List[]{null};

        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Restaurants");
        query1.whereEqualTo("Resto_name",resto_name);
        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){

                    for(ParseObject object : objects){

                        ParseFile file = (ParseFile) object.get("image");


                        String fileUrl = file.getUrl();
                        Log.i("info", fileUrl);
                        String [] arr = fileUrl.split("/" , 4) ;
                        String actual_url = "http://13.58.7.86/"  +  arr[3];
                        Log.i("actual url" , actual_url) ;
                        Picasso.get().load(actual_url).into(imageView);
                        view_resto_name.setText(object.getString("Resto_name"));

                    }
                }else {
                    Log.i("infoout", e.getMessage());
                }
            }
        });

     /*   ParseQuery<ParseObject> query = ParseQuery.getQuery("Food");
        query.addAscendingOrder("Food");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {
                            Log.i("dish", object.getString("Name"));
                            try {
                               // resto_name.add(object.getString("Resto_name"));
                            }catch (Exception ex){
                                //ex.printStackTrace();
                            }
                        }
                    }

                    //listView.setAdapter(arrayAdapter);
                }
                ////chnged
                else {Log.i("parse exception " , e.getMessage());
                }
            }
        });
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Restaurants");
        query2.whereEqualTo("Resto_name",resto_name);
        query2.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {
                            Log.i("owner", object.getString("Resto_owner"));
                            try {
                                // resto_name.add(object.getString("Resto_name"));
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                    else { Log.i("msgggggg" , "NO object");}
                    //listView.setAdapter(arrayAdapter);
                }
                ////chnged
                else {Log.i("parse exception " , e.getMessage());
                }
            }
        });*/








    }

    }

