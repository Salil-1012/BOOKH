package com.example.starbucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.starbucks.adapters.OrderAdapter;
import com.example.starbucks.databinding.ActivityOrderBinding;
import com.example.starbucks.models.OrderModel;

import java.util.ArrayList;

public class order_activity extends AppCompatActivity {

    ActivityOrderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int cid = bundle.getInt("Cid");
        Log.d("Order","Order od CId is"+cid);

        DBloder dBloder = new DBloder(this);
        ArrayList<OrderModel> list = dBloder.showOrder(cid);


        OrderAdapter adapter = new OrderAdapter(list,cid,this);
        binding.orderRecycleview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecycleview.setLayoutManager(layoutManager);

    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    };

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.orders:
                Intent i = new Intent(order_activity.this,track_the_order.class);
                startActivity(i);
                return true;

        }
        return super.onOptionsItemSelected(item);
    };
}