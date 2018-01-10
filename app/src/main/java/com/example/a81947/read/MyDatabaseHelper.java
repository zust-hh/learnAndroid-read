package com.example.a81947.read;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 81947 on 2018/1/9.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper{

    private  static final String name = "book";
    private static final int version = 1; //数据库版本
    private Context mContext;
    public MyDatabaseHelper(Context context) {

        super(context, "book.db", null, version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS book (id integer primary key autoincrement, name varchar(20), content text)");
        String sql = "insert into book(id,name,content) values (1,'第一本书','这是第一好看的书')";
        db.execSQL(sql);//执行SQL语句
        sql = "insert into book(id,name,content) values (2,'第二本书','这是第二好看的书')";
        db.execSQL(sql);//执行SQL语句
        sql = "insert into book(id,name,content) values (3,'第三本书','这是第三好看的书')";
        db.execSQL(sql);//执行SQL语句
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
