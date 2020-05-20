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


      private   ArrayList<HashMap<String ,String>> final_list ;



       public Recycle_adapter_cart(Context con ,  ArrayList<HashMap<String ,String>> list_of_food ) {
        this.final_list =list_of_food;
        this.con = con;
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

        HashMap<String ,String> temp = final_list.get(position);

        holder.food_name.setText(temp.get("Food_name"));
        holder.food_price.setText(temp.get("Food_price"));
        holder.food_quantity.setText(temp.get("Food_quantity"));

    }

    @Override
    public int getItemCount() {


        return final_list.size()  ;
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
