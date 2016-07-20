package com.example.zhm.weather.model;

/**
 * Created by EDEG5540 on 2016-07-19.
 */
public class County extends SecondaryArea
{
    public int getCityId(){
        return getParentsId();
    }

    public void setCityId(int CityId){

        setParentsId(CityId);
    }
}
