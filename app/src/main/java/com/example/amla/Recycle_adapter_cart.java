package com.example.amla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Recycle_adapter_cart extends RecyclerView.Adapter<Recycle_adapter_cart.Viewholder> {


        private Context con  ;
        private ArrayList<HashMap<String , String>> list_of_food = new ArrayList<HashMap <String , String> >();


    public Recycle_adapter_cart(Context con ,  ArrayList<HashMap<String , String>> list_of_food) {

        this.con = con;
        this.list_of_food = list_of_food;
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

        HashMap <String ,String> hash = list_of_food.get(position);


        holder.food_price.setText("Rs. " + hash.get("Food_price"));
        holder.food_quantity.setText("Qy. " + hash.get("Food_quantity"));
        holder.food_name.setText(hash.get("Food_name"));


    }

    @Override
    public int getItemCount() {
        return 5    ;
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
