package com.example.zhm.weather.db;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import com.example.zhm.weather.R;

/**
 * Created by EDEG5540 on 2016-07-19.
 */
public class WeatherOpenHelper extends SQLiteOpenHelper{
    /*
     * provinc表建表语句
     */


    public static final String CREATE_PROVINCE ="create table province("
            +"id integer primary key  autoincrement,"
            +"province_name text,"
            +"province_code text)";

    /*
   * City表建表语句
   */
    public static final String CREATE_CITY ="create table city("
            +"id integer primary key  autoincrement,"
            +"city_name text,"
            +"city_code text"
            +"province_id integer)";

    /*
    * Country表建表语句
    */
    public static final String CREATE_COUNTY ="create table county("
            +"id integer primary key  autoincrement,"
            +"county_name text,"
            +"county_code text"
            +"county_id integer)";

    public WeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PROVINCE);
        sqLiteDatabase.execSQL(CREATE_CITY);
        sqLiteDatabase.execSQL(CREATE_COUNTY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
