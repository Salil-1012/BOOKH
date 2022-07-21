package com.example.starbucks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;


public class login_activity extends AppCompatActivity {
    Button login;
    EditText email, password;
    TextView facebook,google;
    DBloder db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        email = findViewById(R.id.Email_id);
        password = findViewById(R.id.password_id);
        login = findViewById(R.id.login_btn);
        db = new DBloder(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().isEmpty()||password.getText().toString().isEmpty())
                {
                    AlertDialog.Builder msg = new AlertDialog.Builder(login_activity.this);
                    msg.setTitle("Fill All Requirements ");
                    msg.setMessage("Please fill your password and email.");
                    msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    msg.show();
                }
                if(!email.getText().toString().contains("@gmail.com"))
                {
                    AlertDialog.Builder msg = new AlertDialog.Builder(login_activity.this);
                    msg.setTitle("Invalid Username");
                    msg.setMessage("Please Enter Valid Email .");
                    msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    msg.show();
                }
                else
                {
                    String email_of_cust = email.getText().toString().trim();
                    String password_of_cust = password.getText().toString().trim();

                    String checking = db.Check_data(email_of_cust,password_of_cust);
                    StringTokenizer st = new StringTokenizer(checking,"#");
                    String ans = st.nextToken();
                    String id = st.nextToken();
                    int cid= Integer.parseInt(id);

                    if(ans.equals("ok"))
                    {
                        //Toast.makeText(getApplicationContext(),"Your id is: "+cid,Toast.LENGTH_LONG).show();

                        AlertDialog.Builder msg = new AlertDialog.Builder(login_activity.this);
                        msg.setTitle("Success");
                        msg.setMessage("Successfully login. Enjoy Ordering the food!!!");
                        msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                Bundle bundle = new Bundle();
                                //Log.d("Login","CID IS"+cid);
                                bundle.putInt("Cid",cid);
                                Intent intent = new Intent(login_activity.this,food_activity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                        msg.setNegativeButton("not now ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(login_activity.this,MainActivity.class);
                                startActivity(intent);

                            }
                        });
                        msg.show();
                    }
                    else
                    {

                        AlertDialog.Builder msg2 = new AlertDialog.Builder(login_activity.this);
                        msg2.setTitle("Sorry");
                        msg2.setMessage("Wrong Email or password.");
                        msg2.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        msg2.show();
                    }
                }

            }
        });
    }
}