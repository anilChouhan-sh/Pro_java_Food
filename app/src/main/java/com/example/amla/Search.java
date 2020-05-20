package com.example.amla;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bolts.Task;

public class Search extends Fragment {

   /* SearchView search ;
    Button desert , lunch , dinner , snack ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_search, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SearchView s = ( SearchView )view.findViewById(R.id.searchs);


        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });

    }*/





    RecyclerView recyclerView ;
    RecyclerView.LayoutManager layoutManager ;
    Button placeorder ;

    ArrayList<HashMap<String , String>> list_of_food_incart =null ;



    String x = "Hello";
    tp s = new tp(x);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        placeorder = view.findViewById(R.id.placeorder);

         list_of_food_incart = new ArrayList<HashMap<String, String>>() ;
        final HashMap<String ,Integer> qauntity =new HashMap<String, Integer>();
        final Recycle_adapter_cart adapter = new Recycle_adapter_cart(view.getContext() , qauntity);



        ParseQuery<ParseObject> query = ParseQuery.getQuery("Cart");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if(objects.size()>0) {
                        for(ParseObject object : objects) {

                            HashMap<String ,String > hash = new HashMap<String, String>() ;
                            hash.put("Food_name" , object.getString("Food_name") );
                            hash.put("Food_price" , String.valueOf(object.getNumber("Food_price")));
                            Search.this.list_of_food_incart.add(hash);
                        }



                        for(HashMap<String ,String> p: list_of_food_incart)
                        {
                            if(! qauntity.containsKey(p.get("Food_name"))){
                                qauntity.put(p.get("Food_name") , 0);
                            }
                            else{
                                Log.i("mymymyymchanges" , "NOt Found");
                            }
                        }


                        for (HashMap<String ,String> h : list_of_food_incart )
                        {
                            String name = h.get("Food_name");
                                    int temp = qauntity.get(name);
                                    qauntity.put(name , temp+1);
                        }
                        recyclerView.setAdapter(adapter);
                    }
                    else {Log.i("parse exception 1" , "NO     OBJECT");}
                }
                else {Log.i("parse exception " , e.getMessage());
                }
            }
        });





       //ArrayList x = adapter.list_of_food;
        Toast.makeText(getContext() , String.valueOf(s.getX()) , Toast.LENGTH_LONG).show();
    }





}
