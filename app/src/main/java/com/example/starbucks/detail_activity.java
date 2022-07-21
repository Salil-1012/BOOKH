package com.example.starbucks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.starbucks.databinding.ActivityDetailBinding;
import com.example.starbucks.databinding.ActivityFoodBinding;

public class detail_activity extends AppCompatActivity {


    TextView price_detail;
    int i = 0;
    ActivityDetailBinding binding;
    TextView quantity;
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int cid = bundle.getInt("Cid");
        Log.d("Detail","DETAIL ID IS"+cid);

        quantity = findViewById(R.id.quantity_id);
        price_detail = findViewById(R.id.price_detail_id);




        binding.addId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int baseprice = 200;
                binding.subtractId.setAlpha(1f);
                count ++;
                quantity.setText(Integer.toString(count));
                int meae_price = baseprice *count;
                String new_meal_price = String.valueOf(meae_price);
                price_detail.setText(new_meal_price);




            }
        });
        binding.subtractId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count == 1)
                {
                    binding.subtractId.setAlpha(0f);
                }
                else {
                    int baseprice = 200;
                    binding.subtractId.setAlpha(1f);
                    count--;
                    quantity.setText(Integer.toString(count));
                    int meae_price = baseprice *count;
                    String new_meal_price = String.valueOf(meae_price);
                    price_detail.setText(new_meal_price);

                }
            }
        });


        final int images = getIntent().getIntExtra("image",0);
        final int price_detail = Integer.parseInt(getIntent().getStringExtra("price"));
        final String description = getIntent().getStringExtra("description");
        final String food_name = getIntent().getStringExtra("food_name");


        binding.detailImageId.setImageResource(images);
        binding.detailImagesNameId.setText(food_name);
        binding.descriptionDetailId.setText(description);
        binding.priceDetailId.setText(String.format("%d",price_detail));




        DBloder db = new DBloder(this);
        binding.orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result= db.insertData2(images,price_detail,description,food_name,cid);



                if(result.equals("ok"))
                {

                    AlertDialog.Builder msg2 = new AlertDialog.Builder(detail_activity.this);
                    msg2.setTitle("Payment");
                    msg2.setMessage("Please Select Payment methods ");
                    msg2.setPositiveButton("Pay now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                            stopService(new Intent(detail_activity.this, MyService.class));
                            Bundle bundle1 = new Bundle();
                            bundle1.putInt("Cid",cid);
//                            Intent intent = new Intent(detail_activity.this,order_activity.class);
                            intent.putExtras(bundle1);
                            startActivity(intent);
                            Intent intent1 = new Intent(detail_activity.this,payment_activity.class);
                            startActivity(intent1);

                        }
                    });
                    msg2.show();
//                    Bundle bundle1 = new Bundle();
//                    bundle1.putInt("Cid",cid);
////                            Intent intent = new Intent(detail_activity.this,order_activity.class);
//                    intent.putExtras(bundle1);
//                    startActivity(intent);

//                    AlertDialog.Builder msg = new AlertDialog.Builder(detail_activity.this);
////                    startService(new Intent(detail_activity.this, MyService.class));
//                    msg.setTitle("Order Placed Successfully ");
//                    msg.setMessage("Your order will reach at home within 30 min.. Thank you and Keep ordering the food ");
//                    msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
////                            simpleProgressBar.setVisibility(View.VISIBLE);
//                            Bundle bundle1 = new Bundle();
//                            bundle1.putInt("Cid",cid);
////                            Intent intent = new Intent(detail_activity.this,order_activity.class);
//                            intent.putExtras(bundle1);
//                            startActivity(intent);
////                            stopService(new Intent(detail_activity.this, MyService.class));
//
//                        }
//                    });
//                    msg.show();
                }
//                else
//                {
//                    AlertDialog.Builder msg = new AlertDialog.Builder(detail_activity.this);
//                    msg.setTitle("Error ");
//                    msg.setMessage("Error Placing the Order");
//                    msg.setPositiveButton("try again", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    });
//                    msg.show();
//                }

            }
        });





    }



}