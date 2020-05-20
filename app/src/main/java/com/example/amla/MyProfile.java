package com.example.amla;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class MyProfile extends Fragment implements View.OnClickListener {


        LinearLayout address_layout  ,logout_layout  ,past_order;
        TextView name;
        String username = ParseUser.getCurrentUser().getUsername();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            address_layout = view.findViewById(R.id.linearLayout_2);
            logout_layout =view.findViewById(R.id.linearLayout_logout);
            past_order =view.findViewById(R.id.linearLayout_1);
            name= view.findViewById(R.id.name);
            name.setText(ParseUser.getCurrentUser().getUsername());


            past_order.setOnClickListener(this);
            address_layout.setOnClickListener(this);
            logout_layout.setOnClickListener(this);
    }


   @Override
    public void onClick(View v) {

       final String[] check = new String[1];
        if (v.getId() == R.id.linearLayout_2)
        {
            Intent intent = new Intent(getContext(), User_address.class);
            intent.putExtra("username",username);
            startActivity(intent);
            //adress
        }

       if (v.getId() == R.id.linearLayout_logout)
       {
           ParseUser.logOut();
           Intent it = new Intent(getContext(),MainActivity.class);
           startActivity(it);
           //logout
       }

       if (v.getId() == R.id.linearLayout_1)
       {

           //pastorder
       }

    }
}
