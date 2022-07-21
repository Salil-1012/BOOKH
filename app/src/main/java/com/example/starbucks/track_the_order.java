package com.example.starbucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class track_the_order extends AppCompatActivity {

    ImageView img1, img2,img3,img4;
    TextView step_one,step_two,step_three,step_four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_the_order);
        step_one = findViewById(R.id.step_one);
        step_two = findViewById(R.id.step_two);
        step_three = findViewById(R.id.step_three);
        step_four = findViewById(R.id.fourth_step);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);

        img1.setAlpha(0.5f);

        img2.setAlpha(0.5f);

        img3.setAlpha(0.5f);

        img4.setAlpha(0.5f);


        step_one.setText("Your order is confirmed");
        step_one.setAlpha(0.2f);


        step_two.setText("Your Order is in processing");
        step_two.setAlpha(0.2f);


        step_three.setText("Delivery Boy is on the way to diliver your food ");
        step_three.setAlpha(0.2f);

        step_four.setText("Your order is delivered");
        step_four.setAlpha(0.2f);

        Thread thread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(6000);
                }
                catch(Exception e)
                {
                    e.getStackTrace();
                }
                finally
                {
                    step_one.setAlpha(1f);
                    img1.setAlpha(1f);
                }
            }
        };thread.start();

        Thread thread2 = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(20000);
                }
                catch(Exception e)
                {
                    e.getStackTrace();
                }
                finally
                {
                    step_two.setAlpha(1f);
                    img2.setAlpha(1f);
                }
            }
        };thread2.start();

        Thread thread3 = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(23000);
                }
                catch(Exception e)
                {
                    e.getStackTrace();
                }
                finally
                {
                    step_three.setAlpha(1f);
                    img3.setAlpha(1f);
                }
            }
        };thread3.start();

        Thread thread4 = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(30000);
                }
                catch(Exception e)
                {
                    e.getStackTrace();
                }
                finally
                {
                    step_four.setAlpha(1f);
                    img4.setAlpha(1f);
                }
            }
        };thread4.start();






    }
}