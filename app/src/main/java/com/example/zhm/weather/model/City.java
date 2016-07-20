package com.example.zhm.weather.model;

/**
 * Created by EDEG5540 on 2016-07-19.
 */
public class City extends SecondaryArea {

   // private int provinceId;

    public int getProvinceId(){
      return getParentsId();
    }

    public void setProvinceId(int provinceId){
       // this.provinceId =   provinceId;
        setProvinceId(provinceId);
    }
}
