package com.example.amla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycle_adapter extends RecyclerView.Adapter<Recycle_adapter.Viewholder>{


        private Context con  ;
       // ArrayList<String> s ;
    public Recycle_adapter(Context con) {

        this.con = con;
        //this.s = s;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.cart_items_layout , null) ;
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        int i = position ;
        holder.food_price.setText(String.valueOf(i*6));
        holder.food_quantity.setText(String.valueOf(i+3));
        holder.food_name.setText(String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class Viewholder  extends RecyclerView.ViewHolder{
            TextView food_price , food_name , food_quantity;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            food_name = itemView.findViewById(R.id.cart_product_name);
            food_quantity = itemView.findViewById(R.id.cart_product_quantity);
            food_price = itemView.findViewById(R.id.cart_product_price);
        }
    }
}
