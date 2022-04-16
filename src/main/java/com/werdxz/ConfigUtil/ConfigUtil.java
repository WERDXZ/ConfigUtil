package com.werdxz.ConfigUtil;


public class ConfigUtil {
    //Enum of types of file
    public static final int TYPE_CONFIG=0;

    //Enum of types of value
    public static final int TYPE_INT=0;
    public static final int TYPE_FLOAT=1;
    public static final int TYPE_DOUBLE=2;
    public static final int TYPE_STRING=3;
    public static final int TYPE_BOOLEAN=4;
    public static final int TYPE_LIST=5;

    public String Header;
    private ConfigInstance[] ConfigInstances;
    public FileManager Manager;
    ConfigUtil(){

    }

    public boolean AddConfigInstance(){
        return false;
    }
}
