package com.example.starbucks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class payment_activity extends AppCompatActivity {

    Button pay;
    Button confirm;
    ListView list;
    TextView txt;

    String name []={
            "Credit/Debit Card","Google UPI","Paytm","Cash on Delivery"
    };

    Integer img[]={
            R.drawable.cards,R.drawable.googleicon,R.drawable.paytm,
            R.drawable.cash
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);
        confirm = findViewById(R.id.confirm);
        txt = findViewById(R.id.confirm_txt);
        txt.setAlpha(0f);
        pay = findViewById(R.id.pay);
        confirm.setAlpha(0f);
        pay.setAlpha(0f);

        list = findViewById(R.id.lt);
        MyList adapter = new MyList(this,name,img);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0)
                {
                    txt.setAlpha(0f);
                    Toast.makeText(payment_activity.this, "Select from Cards", Toast.LENGTH_SHORT).show();
                    pay.setAlpha(1f);
                    confirm.setAlpha(0f);
                    pay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(payment_activity.this,Account_details.class);
                            startActivity(i);

                        }
                    });
                }
                if(i==1)
                {
                    txt.setAlpha(0f);
                    Toast.makeText(payment_activity.this, "Select from Google UPI", Toast.LENGTH_SHORT).show();
                    pay.setAlpha(1f);
                    confirm.setAlpha(0f);
                    pay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(payment_activity.this,Account_details.class);
                            startActivity(i);
                        }
                    });


                }
                if(i==2)
                {
                    txt.setAlpha(0f);
                    Toast.makeText(payment_activity.this, "Paytm", Toast.LENGTH_SHORT).show();
                    pay.setAlpha(1f);
                    confirm.setAlpha(0f);
                    pay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(payment_activity.this,Account_details.class);
                            startActivity(i);


                        }
                    });
                }
                if(i==3)
                {
//                    Toast.makeText(payment_activity.this, "Cash on Delivery", Toast.LENGTH_SHORT).show();
                    txt.setAlpha(0f);
                    pay.setAlpha(0f);
                    confirm.setAlpha(1f);
                    confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view)
                        {
                            txt.setAlpha(1f);
                            txt.setText("Payment will be collected by our trusted Delivery boy  !!!! ");
                            AlertDialog.Builder msg2 = new AlertDialog.Builder(payment_activity.this);
                            msg2.setTitle("Success");
                            msg2.setMessage("Your Payment Selection is Cash on Delivery ");
                            startService(new Intent(payment_activity.this, MyService.class));
                            msg2.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    stopService(new Intent(payment_activity.this, MyService.class));

                                }
                            });
                            msg2.show();
                        }
                    });


                }
            }
        });


    }
}