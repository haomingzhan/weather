package com.example.zhm.weather.model;

/**
 * Created by EDEG5540 on 2016-07-19.
 */
public abstract class SecondaryArea extends Area {
    private int parentsId;

    public  int getParentsId(){
        return parentsId;
    }

    public  void setParentsId(int parentsId){
        this.parentsId  =   parentsId;

    }

}
