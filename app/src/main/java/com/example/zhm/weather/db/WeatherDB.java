package com.example.zhm.weather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zhm.weather.model.City;
import com.example.zhm.weather.model.County;
import com.example.zhm.weather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EDEG5540 on 2016-07-19.
 */
public class WeatherDB {
    /*DB名字*/
    public  static final String DB_NAME="weather";

    /*
    * DB版本
    * */
    public static final int VERSION =   1;
    private static WeatherDB weatherDB     =   null;
    private SQLiteDatabase DB       =   null;

    /*
    * 构造实例化
    * */

    private  WeatherDB(Context context){

        WeatherOpenHelper weatherOpenHelper = new WeatherOpenHelper(context,DB_NAME,null,VERSION);
        DB      =   weatherOpenHelper.getWritableDatabase();
    }

    /*
    * 获取DB实例
    * */

    public  synchronized static  WeatherDB getInstance(Context context){
        if(weatherDB == null){
            weatherDB   =   new WeatherDB(context);
        }

        return  weatherDB;
    }

    /*
    *将province实例写入的数据库
    * */

    public void saveProvince(Province province){
        if(province != null){
            ContentValues   contentValues   =   new ContentValues();
            contentValues.put("province_name",province.getName());
            contentValues.put("province_code",province.getCode());
            DB.insert("province",null,contentValues);
        }
    }

    /*
    * 从数据库读取所有province的信息
    * */

    public  List<Province> loadProvinceDB(){
        List<Province> list = new ArrayList<Province>();
        Cursor cursor   =   DB.query("province",null,null,null,null,null,null);

        if(cursor.moveToFirst()){
            do{
                Province province   =   new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
                //province.set(cursor.getInt(cursor.getColumnIndex("province_name")));

            }while(cursor.moveToNext());
        }
        return list;
    }

    /*
    * 将city实例存放到数据库
    * */

    public void saveCity(City city){
        if(city != null){
            ContentValues   contentValues   =   new ContentValues();
            contentValues.put("city_name",city.getName());
            contentValues.put("city_code",city.getCode());
            contentValues.put("province_id",city.getProvinceId());

            DB.insert("city",null,contentValues);
        }
    }

    /*
    * 从数据库读取一个省的所有城市信息
    * */

    public List<City> loadCityDB(int proviceId){
        List<City> list = new ArrayList<City>();
        Cursor cursor   =   DB.query("city",null,"province_id = ?",new String[]{String.valueOf(proviceId)},null,null,null);
        if(cursor.moveToFirst()){
            do{
                City  city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("city_id")));
                city.setName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(cursor.getInt(cursor.getColumnIndex("province_id")));
                list.add(city);
            }while (cursor.moveToNext());

        }

        return  list;
    }

    /**
     * 将country实例写入到DB
     * */

    public void saveCounty(County county){
        if(county != null){
            ContentValues contentValues =   new ContentValues();
            contentValues.put("county_name",county.getName());
            contentValues.put("county_code",county.getCode());
            contentValues.put("city_id",county.getCityId());
            DB.insert("county",null,contentValues);

        }
    }

    /*
    * 从数据库读取一个城市的所有县信息
    * */
    public List<County> loadCountyDB(int cityId){
        List<County> list = new ArrayList<County>();
        Cursor cursor   =   DB.query("county",null,"cityId = ?",new String[]{String.valueOf(cityId)},null,null,null);

        if(cursor.moveToFirst()){
            do{
                County county   =   new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("county_id")));
                county.setName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCode(cursor.getString(cursor.getColumnIndex("county_code")));
                county.setCityId(cursor.getInt(cursor.getColumnIndex("city_id")));
                list.add(county);
            }while(cursor.moveToNext());
        }
        return list;
    }

}
