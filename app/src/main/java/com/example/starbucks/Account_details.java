package com.example.starbucks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Account_details extends AppCompatActivity {

    EditText account,cvv_one,exdate;
    Button paying;
    String act,cvv,expiry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        account = findViewById(R.id.et1);
        cvv_one = findViewById(R.id.et2);
        exdate = findViewById(R.id.et3);

        paying = findViewById(R.id.pay);

        act = account.getText().toString();
        cvv = cvv_one.getText().toString();
        expiry = exdate.getText().toString();

        paying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"ACC:"+act,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"CVV:"+cvv,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"exp:"+expiry,Toast.LENGTH_SHORT).show();

                if(act.isEmpty()||cvv.isEmpty()||expiry.isEmpty())
                {
                    AlertDialog.Builder msg2 = new AlertDialog.Builder(Account_details.this);
                    msg2.setTitle("Fill ALL REQUIREMENTS ");
                    msg2.setMessage("Please Enter all necessary details for payments ");
                    msg2.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                    stopService(new Intent(Account_details.this, MyService.class));

                        }
                    });
                    msg2.show();
                }
                if(act.length()!=10 )
                {
                    AlertDialog.Builder msg3 = new AlertDialog.Builder(Account_details.this);
                    msg3.setTitle("Account in invalid ");
                    msg3.setMessage("Account in valid ");
                    msg3.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                    stopService(new Intent(Account_details.this, MyService.class));

                        }
                    });
                    msg3.show();
                }
                if(cvv.length()<3)
                {
                    AlertDialog.Builder msg3 = new AlertDialog.Builder(Account_details.this);
                    msg3.setTitle("Cvv is valid ");
                    msg3.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//                    stopService(new Intent(Account_details.this, MyService.class));

                        }
                    });
                    msg3.show();
                }

                if(!act.contains("")&&!cvv.contains("")&&!expiry.contains(""))
                {
                    Toast.makeText(Account_details.this, "Ordered", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder msg = new AlertDialog.Builder(Account_details.this);
                    msg.setTitle("Order Placed Successfully ");
                    msg.setMessage("Your order will reach at home within 30 min.. Thank you and Keep ordering the food ");
                    startService(new Intent(Account_details.this, MyService.class));
                    msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            stopService(new Intent(Account_details.this, MyService.class));
                            Intent intent = new Intent(Account_details.this,track_the_order.class);
                            startActivity(intent);

                        }
                    });
                    msg.show();
               }
                else
                {
                    Toast.makeText(Account_details.this, "Not Orderd", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}