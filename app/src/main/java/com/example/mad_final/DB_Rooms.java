package com.example.mad_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DB_Rooms extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ROOM_maneger.db";
    public static final String TABLE_NAME = "room";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "RoomType";
    public static final String COL_3 = "NoOfRooms";
    public static final String COL_4 = "RoomCost";
    public static final String COL_5 = "RoomFacilities";

    public DB_Rooms( Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER primary key ,RoomType text,NoOfRooms interger,RoomCost interger,RoomFacilities text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String ID, String RoomType, String NoOfRooms, String RoomCost, String RoomFacilities) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, ID);
        contentValues.put(COL_2, RoomType);
        contentValues.put(COL_3, NoOfRooms);
        contentValues.put(COL_4, RoomCost);
        contentValues.put(COL_5, RoomFacilities);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public  boolean updateData(String ID,String RoomType, String NoOfRooms, String RoomCost, String RoomFacilities){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1, ID);
        contentValues.put(COL_2, RoomType);
        contentValues.put(COL_3, NoOfRooms);
        contentValues.put(COL_4, RoomCost);
        contentValues.put(COL_5, RoomFacilities);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"ID = ?",new String[] {ID});
        return true;
    }
    public Integer deleteData (String ID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"ID = ?",new String[]{ID});
    }

}
