package com.example.amla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.QuickViewConstants;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Queue;

public class Restaurant_Info extends AppCompatActivity {

    LinearLayout linlayout;

    ImageView imageView =findViewById(R.id.imageView2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__info);

        Intent intent = getIntent();
        final String resto_name =intent.getStringExtra("Resto_name");
        linlayout = findViewById(R.id.linlayout);

       ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Restaurants");
        query1.whereEqualTo("Resto_name",resto_name);

        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    for(ParseObject object : objects){
                        Log.i("info", "image found!");
                        ParseFile file = (ParseFile) object.get("image");
                        file.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] data, ParseException e) {
                                if (e == null ) {

                                    Bitmap bitmapImage = BitmapFactory.decodeByteArray(data, 0, data.length);

                                    imageView.setImageBitmap(bitmapImage);
                                    //image.setImageDrawable(getResources().getDrawable(R.drawable.pic));
                                    linlayout.addView(imageView);
                                } else {
                                    Log.i("info", e.getMessage());
                                }
                            }
                        });
                    }
                }else {
                    Log.i("info", e.getMessage());
                }
            }
        });
        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Food");
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
        });*/
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Restaurant");
        query2.whereEqualTo("Resto_owner",resto_name);
        query2.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {
                            Log.i("owner", object.getString("Resto_owner"));
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
    }
}
