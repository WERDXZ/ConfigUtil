package com.werdxz.ConfigUtil;

import org.jetbrains.annotations.NotNull;

public class ConfigInstance {
    public String annotation;
    public Instance instance;

    public ConfigInstance(@NotNull String annotation, @NotNull Instance instance) {
        this.annotation = annotation;
        this.instance = instance;
    }

    public ConfigInstance(@NotNull Instance instance) {
        this.annotation="";
        this.instance = instance;
    }

    public ConfigInstance(@NotNull String annotation) {
        this.annotation = annotation;
        this.instance = new Instance();
    }

    /**
      * Author: WERDXZ
      * Description: Set Annotation
      * Function Name: SetAnnotation
      * Param: Annotation
      * Return: void
      * Date: 8:08 AM 2022/4/14
    */
    void SetAnnotation(String Annotation){
        this.annotation=Annotation;
    }
    public String GetAnnotation(){
        return this.annotation;
    }

}

//finished
