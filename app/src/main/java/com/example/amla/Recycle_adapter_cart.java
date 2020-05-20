package com.example.amla;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Recycle_adapter_cart extends RecyclerView.Adapter<Recycle_adapter_cart.Viewholder> {


        private Context con  ;


    HashMap<String ,Integer> list_of_food =new HashMap<String, Integer>();
        Iterator hmIterator ;


       public Recycle_adapter_cart(Context con ,  HashMap<String ,Integer> qauntity) {
        this.list_of_food =qauntity;
        this.con = con;
        this.hmIterator = qauntity.entrySet().iterator();

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

       // Map.Entry mapElement = (Map.Entry)hmIterator.next();

        holder.food_name.setText(String.valueOf(list_of_food));
        holder.food_price.setText(String.valueOf(list_of_food.get(0)));
        holder.food_quantity.setText(String.valueOf(300));

    }

    @Override
    public int getItemCount() {


        return list_of_food.size()  ;
    }

    protected  class Viewholder  extends RecyclerView.ViewHolder{
            TextView food_price , food_name , food_quantity;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            food_name = itemView.findViewById(R.id.cart_product_name);
            food_quantity = itemView.findViewById(R.id.cart_product_quantity);
            food_price = itemView.findViewById(R.id.cart_product_price);
        }
    }
}
