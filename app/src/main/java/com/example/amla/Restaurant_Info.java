package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.parse.FindCallback;


import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bolts.Task;


public class Restaurant_Info extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    ImageView imageView;
    TextView view_resto_name;
    String owner2 ="Lakshay";
    String owner3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__info);

        Intent intent = getIntent();
        final String resto_name = intent.getStringExtra("Resto_name");
        Log.i("name", resto_name);
        imageView = findViewById(R.id.profile);
        view_resto_name = findViewById(R.id.Resto_name);




         final ArrayList<String> s = new ArrayList<String>();

        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Restaurants");
        query1.whereEqualTo("Resto_name", resto_name);
        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    for (ParseObject object : objects) {

                        ParseFile file = (ParseFile) object.get("image");


                        String fileUrl = file.getUrl();
                        Log.i("info", fileUrl);
                        String[] arr = fileUrl.split("/", 4);
                        String actual_url = "http://13.58.7.86/" + arr[3];
                        Log.i("actual url", actual_url);
                        Picasso.get().load(actual_url).into(imageView);
                        view_resto_name.setText(object.getString("Resto_name"));
                    }

                } else {
                    Log.i("infoout", e.getMessage());
                }
            }
        });

         //  c.getOwner("hello");
          //  Log.i("owneeeee" , owner2);
          //  ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Restaurants")


        recyclerView = findViewById(R.id.recycle_foodlist);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final ArrayList<HashMap <String , String> > list_of_food = new ArrayList<HashMap <String , String> >();
        final Recycle_adapter_foodlist adapter = new Recycle_adapter_foodlist(this , list_of_food);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Food");
        query.whereEqualTo("Resto_name" , resto_name);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {
                            Log.i("dish", object.getString("Name"));

                            HashMap<String ,String > hash = new HashMap<String, String>() ;
                            hash.put("Food_name" , object.getString("Name") );
                            hash.put("Food_price" , String.valueOf(object.getNumber("Food_price")));

                            list_of_food.add(hash);
                        }
                        recyclerView.setAdapter(adapter);
                    }
                    else {Log.i("parse exception 1" , "NO     OBJECT");}
                }
                else {Log.i("parse exception " , e.getMessage());
                }
            }
        });












    }

}





