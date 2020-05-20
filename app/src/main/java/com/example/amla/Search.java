package com.example.amla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
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

import java.sql.Array;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bolts.Task;

public class Search extends Fragment {


    RecyclerView recyclerView ;
    RecyclerView.LayoutManager layoutManager ;
    Button placeorder ;

    ArrayList<HashMap<String , String>> list_of_food_incart =null ;

        TextView cart_total;

    String x = "Hello";

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
        cart_total= view.findViewById(R.id.cart_total);
        placeorder = view.findViewById(R.id.placeorder);

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),payment.class);
                startActivity(intent);
            }
        });

         list_of_food_incart = new ArrayList<HashMap<String, String>>() ;

        final HashMap<String ,Integer> qauntity =new HashMap<String, Integer>();
        final ArrayList<HashMap<String ,String>> final_list =new ArrayList<HashMap<String, String>>();
        final Recycle_adapter_cart adapter = new Recycle_adapter_cart(view.getContext() , final_list);



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
                                qauntity.put(  p.get("Food_name") + "/" + p.get("Food_price") , 0);
                            }
                            else{
                                Log.i("mymymyymchanges" , "NOt Found");
                            }
                        }


                        for (HashMap<String ,String> h : list_of_food_incart )
                        {
                            String name = h.get("Food_name") + "/" + h.get("Food_price");
                                    int temp = qauntity.get(name);
                                    qauntity.put(name , temp+1);
                        }
                            int total =0;
                        Iterator entries = qauntity.entrySet().iterator();
                        while (entries.hasNext()) {
                            HashMap<String ,String> temp =new HashMap<String, String>();
                            Map.Entry entry = (Map.Entry) entries.next();
                            String key = (String) entry.getKey();
                            Integer value = (Integer)entry.getValue();
                            String [] array = key.split("/");
                            Integer price = Integer.valueOf(array[1]);

                             temp.put("Food_name", array[0]);
                             temp.put("Food_quantity" , String.valueOf(value)) ;
                             temp.put("Food_price" , String.valueOf(value*price));
                             total = total+ value*price;
                             final_list.add(temp);
                        }
                        cart_total.setText("Total: Rs."+String.valueOf(total));
                        recyclerView.setAdapter(adapter);
                    }
                    else {Log.i("parse exception 1" , "NO     OBJECT");}
                }
                else {Log.i("parse exception " , e.getMessage());
                }
            }
        });

///////////////////////////////////////////



       //ArrayList x = adapter.list_of_food;

    }





}
