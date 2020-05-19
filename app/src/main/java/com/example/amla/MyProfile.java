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
import android.widget.LinearLayout;


public class MyProfile extends Fragment implements View.OnClickListener {


        LinearLayout address_layout  ,logout_layout  ,past_order;

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


            past_order.setOnClickListener(this);
            address_layout.setOnClickListener(this);
            logout_layout.setOnClickListener(this);
    }


   @Override
    public void onClick(View v) {


        if (v.getId() == R.id.linearLayout_2)
        {
            Intent intent = new Intent(getContext(), User_address.class);
            startActivity(intent);
            //adress
        }

       if (v.getId() == R.id.linearLayout_logout)
       {

           //logout
       }

       if (v.getId() == R.id.linearLayout_1)
       {

           //pastorder
       }

    }
}
