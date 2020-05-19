package com.example.amla;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MyProfile extends Fragment implements View.OnClickListener {


        LinearLayout adress_layout ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            adress_layout = view.findViewById(R.id.linearLayout_2);
            adress_layout.setOnClickListener(this);
    }


   @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), User_address.class);
        startActivity(intent);
    }
}
