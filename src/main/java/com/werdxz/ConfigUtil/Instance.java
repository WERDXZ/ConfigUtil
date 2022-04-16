package com.werdxz.ConfigUtil;


public class Instance {


    //name of instance
    public String Name;
    //type of instance
//    Enum of types of value
//    TYPE_INT=0;
//    TYPE_FLOAT=1;
//    TYPE_DOUBLE=2;
//    TYPE_STRING=3;
//    TYPE_BOOLEAN=4;
//    TYPE_LIST=5;
    public int Type;

    public double DefaultNum;
    public boolean DefaultBool;
    public String DefaultString;
    public String[] DefaultStringList;


    Instance(String name, int type) throws WrongTypeException {
        this.Name=name;
        this.Type=type;
    }

    /**
      * Author: WERDXZ
      * Description: Set the Default Value
      * Function Name: SetDefault
      * Param: Any!
      * Return: void
      * Date: 7:30 PM 2022/4/14
    */
    public void SetDefault(double defaultNum) throws WrongTypeException {
        if(this.Type>3)throw new WrongTypeException("Type needs to be INT(0) FLOAT(1) DOUBLE(2) to use a integer(double) default value");
        this.DefaultNum=defaultNum;
    }

    public void SetDefault(boolean defaultBool) throws WrongTypeException {
        if(this.Type!=4)throw new WrongTypeException("Type needs to be BOOLEAN(4) to use a boolean default value");
        this.DefaultBool=defaultBool;
    }

    public void SetDefault(String defaultString) throws WrongTypeException {
        if(this.Type!=3)throw new WrongTypeException("Type needs to be STRING(3) to use a string default value");
        this.DefaultString=defaultString;
    }

    public void SetDefault(String[] defaultStringList) throws WrongTypeException {
        if(this.Type!=5)throw new WrongTypeException("Type needs to be LIST(5) to use a list default value");
        this.DefaultStringList=defaultStringList;
    }

    Instance(){
        this.Name="config";
        this.Type=4;
        this.DefaultBool=true;
    }

}


//finished