package com.example.starbucks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class signup_activity extends AppCompatActivity {
    ImageView photo;
    Button signup ;
    EditText name, phone, email, password;
    TextView upload;
    DBloder db;

    //Image --->
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data!=null)
        {
            Uri selectedImages = data.getData();
            photo = findViewById(R.id.photo_id);
            photo.setImageURI(selectedImages);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        photo = findViewById(R.id.photo_id);
        signup = findViewById(R.id.login_btn);
        name = findViewById(R.id.name_id);
        phone = findViewById(R.id.phone_id);
        email = findViewById(R.id.Email_id);
        password = findViewById(R.id.password_id);
        upload = findViewById(R.id.Upload_Photo_id);



        db = new DBloder(this);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,3);

            }
        });

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(signup_activity.this);
                    dialog.setTitle("Fill Requirements");
                    dialog.setMessage("Please fill all the details ");
                    dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }
                if(!email.getText().toString().contains("@gmail.com"))
                {
                    AlertDialog.Builder msg = new AlertDialog.Builder(signup_activity.this);
                    msg.setTitle("Invalid Username");
                    msg.setMessage("Please Enter Valid Email .");
                    msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    msg.show();
                }
                if(phone.length()!=10)
                {
                    AlertDialog.Builder msg = new AlertDialog.Builder(signup_activity.this);
                    msg.setTitle("Invalid Number");
                    msg.setMessage("Please valid usernme Phone .");
                    msg.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    msg.show();
                }
                else
                {
                    String name_of_cust = name.getText().toString().trim();
                    String phone_of_cust = phone.getText().toString().trim();
                    String email_of_cust = email.getText().toString().trim();
                    String password_of_cust = password.getText().toString().trim();


                    String check = db.insertData(phone_of_cust,name_of_cust,email_of_cust,password_of_cust);

                    if(check.equals("Inserted"))
                    {
                        AlertDialog.Builder msg = new AlertDialog.Builder(signup_activity.this);
                        msg.setTitle("Success");
                        msg.setMessage("Successfully create the Account !!!!!!.Please order the Food Now ");
                        msg.setPositiveButton("Order now", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(signup_activity.this,login_activity.class);
                                startActivity(intent);

                            }
                        });
                        msg.setNegativeButton("later", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        msg.show();

                    }
                    else
                    {
                        AlertDialog.Builder msg = new AlertDialog.Builder(signup_activity.this);
                        msg.setTitle("USER ALREADY EXISTS");
                        msg.setMessage("The user already have an account ");
                        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        msg.show();

                    }

                }

            }
        });




    }
}