package com.example.starbucks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.starbucks.adapters.MainAdapter;
import com.example.starbucks.databinding.ActivityFoodBinding;
import com.example.starbucks.models.MainModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class food_activity extends AppCompatActivity {
    ActivityFoodBinding binding;
    FloatingActionButton plus,call,rating,cart;
    RelativeLayout screen;
    Boolean isAllFabsVisible;

    //int cid

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar();
        isAllFabsVisible = true;

        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int cid = bundle.getInt("Cid");
         Log.d("FOOD","FOOD CID IS "+cid);

         // Briding of raw data to user interface is
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.vegthali,"Special Thali","300","Including Shahi Paneer,Dal makhni,Mushroom matar,curd,2 butter naan,Pulao, salad with Gulab jamun that will make you meal complete "));
        list.add(new MainModel(R.drawable.pizza,"Cheese Marghertia Pizza","455","Classic Italian pizza with hot cheese toppings"));
        list.add(new MainModel(R.drawable.burger,"Crunchy Paneer Burger","105","Burger bun are stuffed with mix vegetables patties, Paneer chunk spiced mayonnaise dressing and onion slices"));
        list.add(new MainModel(R.drawable.pizza,"Chilly Paneer Pizza","525","Combination of onions, green, capsicum ,cheese, mushroom,tomatoes,and black olives"));
        list.add(new MainModel(R.drawable.man,"Gravy Manchurian","190","In main course  "));
        list.add(new MainModel(R.drawable.b,"cappuccino","100","A special cappuccino made with fresh grinded coffee beans. With sugar or no sugar option available "));
        list.add(new MainModel(R.drawable.breadpizza,"Garlic Bread","60","freshly baked Garlic bread stuffed with delectable vegies, cheese with dip "));
        list.add(new MainModel(R.drawable.pizza,"Chicken Delight Pizza","410","Combination of capsicum, chicken malabari, green chilly, olives"));
        list.add(new MainModel(R.drawable.burger,"Chicken Burger","95","Super crispy and flakey chicken patty topped with sauces "));
        list.add(new MainModel(R.drawable.chiken,"Double Decker Burger ","130","Tender chicken patties and creamy mayonnaise all served on a bun"));
        list.add(new MainModel(R.drawable.pizza,"Cheese Overloaded Pizza","580","Paneer, mozzerella, and processed cheese"));
        list.add(new MainModel(R.drawable.butter_chiken,"gravy Chicken","700","In main course"));

        list.add(new MainModel(R.drawable.pizza,"Veggie Special Pizza","430","Mushroom, capsicum, onion, tomato,baby corn and pineapple"));
        list.add(new MainModel(R.drawable.pasta,"Napolean Pasta","240","Mushroom,zucchini,broccoli,mixed capsicum with nepoli red sauce"));
        list.add(new MainModel(R.drawable.rosted,"Tandoori Chicken","300","Delectable Tandoori Chicken comes with special tandoori sauce and authentic green chutney."));
        list.add(new MainModel(R.drawable.pizza,"Non Veg Supreme Pizza","15","Spicy chicken sausage,onion,barbecue chicken,jalapeno"));
        list.add(new MainModel(R.drawable.alootikki,"Aloo Tikki Burger","19","Stuffed with mix vegetables,crispy potato patty with sauce"));

        list.add(new MainModel(R.drawable.fires,"French Fires","5","Potato strips deep fried in vegetable oil"));
        list.add(new MainModel(R.drawable.burji,"Burji","17","In main course"));
        list.add(new MainModel(R.drawable.dosa,"Dosa","15",""));
        list.add(new MainModel(R.drawable.dal,"Dal Makhni","25","In main course"));
        list.add(new MainModel(R.drawable.noodel,"Noodles","12","Noodles stri-fried with curry powder,bean sprouts,a variety of vegetables"));
        list.add(new MainModel(R.drawable.sandwich,"Corn Delight Sandwich","15","Stuffed with baby corn,mix veggies,olives with sausage"));
        list.add(new MainModel(R.drawable.momo,"Momos","15","Steamed, fried or roasted momos available with vegetable, paneer or chicken stuffing."));
        list.add(new MainModel(R.drawable.wrap,"Wraps","15","Luscious wraps with the crazy filling options, think of it and you will get it"));
        list.add(new MainModel(R.drawable.bchicken,"Butter Chicken","15","In main course"));
        list.add(new MainModel(R.drawable.pulao,"Pulao","15","In main course"));
        list.add(new MainModel(R.drawable.vegcrs,"Veg crispy","15","In main course"));
        list.add(new MainModel(R.drawable.dhokla,"Dhokla","15","Tasty dhokla with tamarind chutney and the taste of Rajasthan"));
        list.add(new MainModel(R.drawable.idli,"Idli Sambar","15","Mouthwatering plain, masala or paneer dosa comes with coconut chutney, tomato chutney and fresh sambar."));
        list.add(new MainModel(R.drawable.shahi,"Shahi Paneer","15","In main course"));
        list.add(new MainModel(R.drawable.pav,"Pav Bhaji","15","Mumbai special pav Bhaji with green chutney, chopped onions and grated cheese."));
        list.add(new MainModel(R.drawable.shahi,"Chhole Bhature","15",""));
        list.add(new MainModel(R.drawable.butterroti,"Butter naan","15","In main course"));
        list.add(new MainModel(R.drawable.roti,"Plain Roti","15","In main course"));
        list.add(new MainModel(R.drawable.firni,"Firni","15","In desserts"));
        list.add(new MainModel(R.drawable.jamun,"Gulab Jamun","15","In desserts"));
        list.add(new MainModel(R.drawable.rasgulla,"Rasgulla","15","In desserts"));
        list.add(new MainModel(R.drawable.matar,"Mushroom Matar","15","In main course"));

        MainAdapter adapter = new MainAdapter(list,cid,food_activity.this);
        binding.recycleview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleview.setLayoutManager(layoutManager);


        plus = findViewById(R.id.plus_btn);
        call = findViewById(R.id.call_btn);
        rating = findViewById(R.id.rate_btn);
        cart = findViewById(R.id.cart_btn);
        screen = findViewById(R.id.screen_id);



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9815959064"));
                startActivity(intent);
            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(food_activity.this,rating_act.class);
                startActivity(i);

            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAllFabsVisible)
                {
                    call.hide();
                    rating.hide();
                    cart.hide();
                    isAllFabsVisible = false;

                }
                else
                {
                    call.show();
                    rating.show();
                    cart.show();
                    isAllFabsVisible = true;
//
                }


            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = new Bundle();
                bundle1.putInt("Cid",cid);
                Intent intent3 = new Intent(food_activity.this,order_activity.class);
                intent3.putExtras(bundle1);
                startActivity(intent3);
            }
        });



    }


}