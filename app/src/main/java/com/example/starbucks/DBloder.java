package com.example.starbucks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.starbucks.models.OrderModel;

import java.util.ArrayList;

public class DBloder extends SQLiteOpenHelper
{
    public static final String dbname = "ACET";
    public DBloder(@Nullable Context context) {
        super(context,dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
       db.execSQL("Create Table cafedata(Cid integer primary key autoincrement,phone TEXT ,name TEXT,email TEXT,password TEXT)");
       db.execSQL("Create Table orderingoffood(Oid integer primary key autoincrement,phone TEXT ,name TEXT,image integer,price integer,description integer,food_name TEXT,Cid integer,FOREIGN KEY(Cid)  REFERENCES cafedata(Cid))");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("drop table if exists cafedata");
        db.execSQL("drop table if exists orderingoffood");
        onCreate(db);

    }
    public String insertData(String phone, String name, String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("phone",phone);
        cv.put("name",name);
        cv.put("email",email);
        cv.put("password",password);


        long res = db.insert("cafedata",null,cv);
        if(res == -1)
        {
            return "Already Registered";
        }
        else
        {
            return "Inserted";
        }

    }

    public String Check_data(String email,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from cafedata where email = ? and password = ?",new String[]{email,password});

        if(cursor.getCount()>0)
        {
            cursor.moveToNext();
            int i = cursor.getInt(0);
            Log.d("ID","The id is "+i);
            String ans= "ok"+"#"+i;
            return ans;
        }
        else
        {

            String ans = "no"+"#";
            return ans;

        }

    }

    // ORDER OF FOOD DATA

    public String insertData2(int image,int price, String description,String food_name,int cid)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put("phone",phone);
//        cv.put("name",name);
        cv.put("image",image);
        cv.put("price",price);
        cv.put("description",description);
        cv.put("food_name",food_name);
        cv.put("Cid",cid);

        long res = db.insert("orderingoffood",null,cv);
        if(res == -1)
        {
            return "no";
        }
        else
        {
            return "ok";
        }

    }

    public int delete_order(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(" orderingoffood","Oid="+id,null);
    }

    public ArrayList<OrderModel> showOrder(int cid)
    {
        ArrayList<OrderModel> order = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Log.d("DBLOADER","Cid is "+cid);
        Cursor cursor = database.rawQuery("select image,food_name,price,Oid from orderingoffood where Cid = '"+cid+"'",null);
        if(cursor.moveToFirst())
        {
            while (cursor.moveToNext())
            {
                OrderModel model = new OrderModel();
                model.setOrder_img(cursor.getInt(0));
                model.setFood_name(cursor.getString(1));
                model.setPrice(cursor.getInt(2)+"");
                model.setOrder_number(cursor.getInt(3)+"");
                order.add(model);
            }
        }
        cursor.close();
        database.close();
        return order;
    }

}