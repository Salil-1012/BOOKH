package com.example.starbucks.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starbucks.R;
import com.example.starbucks.detail_activity;
import com.example.starbucks.models.MainModel;

import java.util.ArrayList;

public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.viewholder>
{
    ArrayList<MainModel> list;
    Context context;
    int cid;


    public MainAdapter(ArrayList<MainModel> list, int cid, Context context) {
        this.list = list;
        this.cid = cid;
        Log.d("CIDAD","CID OF "+cid);
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model = list.get(position);
        holder.food_image.setImageResource(model.getImage());
        holder.food_name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle = new Bundle();
                bundle.putInt("Cid",cid);
                //Log.d("salil","The Main Adapter id is "+cid);

                Intent intent = new Intent(context, detail_activity.class);
                intent.putExtras(bundle);
                intent.putExtra("image",model.getImage());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("description",model.getDescription());
                intent.putExtra("food_name",model.getName());

                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        ImageView food_image;
        TextView food_name,price,description;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            food_image = itemView.findViewById(R.id.img1);
            food_name = itemView.findViewById(R.id.name_of_food_id);
            description = itemView.findViewById(R.id.step_one);
            price = itemView.findViewById(R.id.order_price_id);


        }
    }
}
