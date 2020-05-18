package com.example.amla;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;



public class ListFood extends Fragment {



    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_food, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


  final ListView listView = view.findViewById(R.id.listview);

        final ArrayList<String> resto_name   = new ArrayList<String>();

        //i changed this
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,resto_name);


        ParseQuery<ParseObject> query = ParseQuery.getQuery("Restaurants");
        query.addAscendingOrder("Restaurants");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {
                            Log.i("Resto_name", object.getString("Resto_name"));
                            try {
                                resto_name.add(object.getString("Resto_name"));
                            }catch (Exception ex){
                                //ex.printStackTrace();
                            }
                        }
                    }

                    listView.setAdapter(arrayAdapter);
                }

                else {Log.i("parse exception " , e.getMessage());
                }
            }
        });

    }
}
