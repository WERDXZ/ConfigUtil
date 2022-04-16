package com.werdxz.ConfigUtil;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author WERDXZ
 * date 2022/04/14/
 */
public class FileManager {
    File file;
    String fileName;
    MainContainer mainContainer;
    String fileHeader;
    String fileFooter;
    int fileType;
    FileWriter FW;


    //Construction below
    FileManager(MainContainer mainContainer, String fileHeader, String fileFooter, int fileType){
        this.mainContainer = mainContainer;
        this.fileHeader = fileHeader;
        this.fileFooter = fileFooter;
        this.fileType = fileType;
    }
     /**
       * Author: WERDXZ
       * Description: Set the file
       * Function Name: SetFile
       * Param: file
       * Return: void
       * Date: 8:10 PM 2022/4/14
     */
    void SetFile(File file){
        this.file = file;
    }

    /**
      * Author: WERDXZ
      * Description: Set the file Name
      * Function Name: SetFileName
      * Param: fileName
      * Return: void
      * Date: 8:11 PM 2022/4/14
    */
    void SetFileName(String fileName){
        this.fileName = fileName;
    }

    /**
      * Author: WERDXZ
      * Description: Create the file (By file name)
      * Function Name: CreateFile
      * Param: fileName
      * Return: void
      * Date: 8:11 PM 2022/4/14
    */
    void CreateFile(String fileName){
        this.fileName = fileName;
        switch (fileType){
            case 0->this.file=new File(this.fileName+".config");
        }

    }
    void CreateFile() throws NullVariableException{
        if(this.fileName.length()==0)throw new NullVariableException("Must use the <SetFileName(String fileName)> " +
                "function first, or use <CreateFile(String fileName)>");
        this.file=new File(this.fileName+".config");
    }

    //Above is for construction

    //Writer Below
    void MainWriter(){
        try {
            FW=new FileWriter(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!HeaderWriter())return;

        this.ContainerWriter(this.mainContainer,0);


    }

    boolean HeaderWriter(){
        final String header=AnnotationFormatting(this.fileHeader);
        try {
            FW.write(header);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    void AnnotationWriter(String annotation, int layer){

    }

    void StringListWriter(String[] stringList, int layer){}

    void ConfigInstanceWriter(ConfigInstance configInstance, int layer){

    }

    void ContainerWriter(@NotNull Container ct, int layer){
        final String header=AnnotationFormatting(ct.Header);
        try {
            FW.write(header);
            FW.write("\n"+ct.Title+"{");
            for (int i = 0; i < ct.SubConfigInstance.length; i++) {
                this.ConfigInstanceWriter(ct.SubConfigInstance[i], layer);
            }
            for (int i = 0; i < ct.SubContainers.length; i++) {
                this.ContainerWriter(ct.SubContainers[i], layer+1);
            }
            FW.write("\n"+"}");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String AnnotationFormatting(String Annotation){
        String[] temp_0=Annotation.split("\n");
        String output="";
        for (int i = 0; i < temp_0.length; i++) {
            temp_0[i]="#"+temp_0[i]+"\n";
            output+=temp_0[i];
        }
        return output;
    }
    //Above is for Writer
}
