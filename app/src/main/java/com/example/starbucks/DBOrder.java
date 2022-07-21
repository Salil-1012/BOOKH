//package com.example.starbucks;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import com.example.starbucks.models.OrderModel;
//
//import java.util.ArrayList;
//
//public class DBOrder extends SQLiteOpenHelper
//{
//    public static final String dbname ="Orders_of_food";
//
//    public DBOrder(@Nullable Context context) {
//        super(context,dbname,null,1 );
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("Create Table orderingoffood(id integer primary key autoincrement,phone TEXT ,name TEXT,image integer,price integer,description integer,food_name TEXT)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("drop table if exists orderingoffood");
//        onCreate(db);
//    }
////    public String insertData2(String phone,String name,int image,int price, String description,String food_name)
////    {
////        SQLiteDatabase db = this.getReadableDatabase();
////        ContentValues cv = new ContentValues();
////        cv.put("phone",phone);
////        cv.put("name",name);
////        cv.put("image",image);
////        cv.put("price",price);
////        cv.put("description",description);
////        cv.put("food_name",food_name);
////
////        long res = db.insert("orderingoffood",null,cv);
////        if(res == -1)
////        {
////            return "no";
////        }
////        else
////        {
////            return "ok";
////        }
////
////    }
//
////    public ArrayList<OrderModel> getOrder()
////    {
////        ArrayList<OrderModel> order = new ArrayList<>();
////        SQLiteDatabase database = this.getWritableDatabase();
////        Cursor cursor = database.rawQuery("select image,food_name,price,id from orderingoffood",null);
////        if(cursor.moveToFirst())
////        {
////            while (cursor.moveToNext())
////            {
////               OrderModel model = new OrderModel();
////               model.setOrder_img(cursor.getInt(0));
////               model.setFood_name(cursor.getString(1));
////               model.setPrice(cursor.getInt(2)+"");
////               model.setOrder_number(cursor.getInt(3)+"");
////               order.add(model);
////            }
////        }
////        cursor.close();
////        database.close();
////        return order;
////    }
////    public int delete_order(String id)
////    {
////        SQLiteDatabase db = this.getWritableDatabase();
////        return db.delete(" orderingoffood","id="+id,null);
////    }
//
//}
//
//
