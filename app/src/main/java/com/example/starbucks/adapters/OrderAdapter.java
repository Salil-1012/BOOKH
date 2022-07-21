package com.example.starbucks.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.starbucks.DBOrder;
import com.example.starbucks.DBloder;
import com.example.starbucks.R;
import com.example.starbucks.models.OrderModel;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewholder>
{
    ArrayList<OrderModel> list;
    Context context;
    int cid;

    public OrderAdapter(ArrayList<OrderModel> list,int cid, Context context) {
        this.list = list;
        this.cid = cid;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position)
    {
        final OrderModel model = list.get(position);
        holder.order_imge.setImageResource(model.getOrder_img());
        holder.food_name.setText(model.getFood_name());
        holder.orderNumber.setText(model.getOrder_number());
        holder.price.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Bundle bundle = new Bundle();
                bundle.putInt("Cid",cid);

                AlertDialog.Builder msg = new AlertDialog.Builder(context);
                msg.setTitle("ALERT");
                msg.setMessage("DO YOU WANT TO DELETE THE ORDER !!!");
                msg.setPositiveButton("yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        DBloder dbloader = new DBloder(context);
                        if (dbloader.delete_order(model.getOrder_number()) > 0)
                        {
                            AlertDialog.Builder msg = new AlertDialog.Builder(context);
                            msg.setTitle("Success");
                            msg.setMessage("Successfully DELETED !!!");
                            msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            msg.setNegativeButton("not now ", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {


                                }
                            });
                            msg.show();
                        }

                    }
                });
                msg.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
                    }
                });
                msg.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        ImageView order_imge;
        TextView food_name,orderNumber,price,item;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            order_imge = itemView.findViewById(R.id.order_images_id);
            food_name = itemView.findViewById(R.id.order_name_id);
            orderNumber = itemView.findViewById(R.id.order_number_id);
            price = itemView.findViewById(R.id.price_id);
            item = itemView.findViewById(R.id.quantity_id);

        }
    }

}
