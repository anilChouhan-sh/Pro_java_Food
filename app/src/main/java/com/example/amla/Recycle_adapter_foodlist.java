package com.example.amla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Recycle_adapter_foodlist extends RecyclerView.Adapter<Recycle_adapter_foodlist.Viewholder_food> implements View.OnClickListener {

   private Context con;
   private ArrayList<HashMap<String , String>> list_of_food = new ArrayList<HashMap <String , String> >();
   private int position =0;
    public Recycle_adapter_foodlist(Context con , ArrayList<HashMap<String , String>> list_of_food ){
    this.con =con;
    this.list_of_food = list_of_food ;
    }

    @NonNull
    @Override
    public Viewholder_food onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(R.layout.cardview_foodlist , null) ;
        Viewholder_food holder = new Viewholder_food(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder_food holder, int position) {

       HashMap<String ,String> hash =  list_of_food.get(position);


        holder.name_food.setText(hash.get("Food_name"));
        holder.price_food.setText(hash.get("Food_price"));

        this.position =position;
    }

    @Override
    public int getItemCount() {
        return list_of_food.size();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext() , String.valueOf(position) , Toast.LENGTH_SHORT).show();
    }

    final ArrayList<HashMap <String , String> > list_of_foods = new ArrayList<HashMap <String , String> >();
    class Viewholder_food extends RecyclerView.ViewHolder {
            TextView name_food , price_food;
            ImageView im ;
        public Viewholder_food(@NonNull final View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.plus);
            name_food = itemView.findViewById(R.id.name_food);
            price_food = itemView.findViewById(R.id.price_food);
            im.setOnClickListener(Recycle_adapter_foodlist.this);


        }
    }
}
