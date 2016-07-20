package com.example.zhm.weather.model;

/**
 * Created by EDEG5540 on 2016-07-19.
 */
public abstract class Area {
    private   int id;
    private String name;
    private String code;
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id     =   id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name   =   name;
    }
    public String getCode(){
        return  code;
    }

    public void setCode(String code){

        this.code   =   code;
    }

}

