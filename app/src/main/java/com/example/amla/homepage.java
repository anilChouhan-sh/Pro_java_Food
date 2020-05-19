package com.example.amla;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView buttomNavigationView = findViewById(R.id.bottomNavigationView);

        //set
       // buttomNavigationView.setSelectedItemId(R.id.listFood);

        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(buttomNavigationView,navController);

    }

}
