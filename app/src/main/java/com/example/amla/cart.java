package com.example.amla;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class cart extends Fragment {


    RecyclerView recyclerView ;
    RecyclerView.LayoutManager layoutManager ;
    Button placeorder ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

   /* LayoutInflater x = new LayoutInflater(view.) {
        @Override
        public LayoutInflater cloneInContext(Context newContext) {
            return null;
        }
    };*/
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        placeorder = view.findViewById(R.id.placeorder);

        Recycle_adapter adapter = new Recycle_adapter(view.getContext() );
        recyclerView.setAdapter(adapter);

    }
}
