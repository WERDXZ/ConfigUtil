package com.werdxz.ConfigUtil;

/**
 * @author WERDXZ
 * date: 2022/04/14/
 */
public class Container {
    public String Header;
    public String Title;
    public Container[] SubContainers;
    public ConfigInstance[] SubConfigInstance;
    private final int CurrentLayer;

    public final int TYPE_CONTAINER = 0;
    public final int TYPE_CONFIG_INSTANCE = 1;

    Container(String Title, int CurrentLayer){
        this.Title=Title;
        this.CurrentLayer=CurrentLayer;
    }

    Container(String Header, String Title, int CurrentLayer){
        this.Header=Header;
        this.Title=Title;
        this.CurrentLayer=CurrentLayer;
    }

    Container(String Header, String Title, ConfigInstance[] SubConfigInstance, int CurrentLayer){
        this.Header=Header;
        this.Title=Title;
        this.SubConfigInstance=SubConfigInstance;
        this.CurrentLayer=CurrentLayer;
    }

    /**
      * Author: WERDXZ
      * Description: create a new container
      * Function Name: CreateSubContainer
      * Param: Title - the title of the container
      * Return: boolean - true if success, false if failed
      * Date: 9:59 AM 2022/4/15
    */
    public boolean CreateSubContainer(String Title){

        Container Temp=new Container(Title,this.CurrentLayer+1);

        this.AllocateMemory(TYPE_CONTAINER);
        this.SubContainers[this.SubContainers.length-1]=Temp;
        return true;
    }

    /**
     * Author: WERDXZ
     * Description: create a new container
     * Function Name: CreateSubContainer
     * @param Header - the header of the container
     * @param Title - the title of the container
     * @return boolean
     */
    public boolean CreateSubContainer(String Header, String Title){

        Container Temp=new Container(Header,Title,this.CurrentLayer+1);
        this.AllocateMemory(TYPE_CONTAINER);
        this.SubContainers[this.SubContainers.length-1]=Temp;
        return true;
    }

    /**
      * Author: WERDXZ
      * Description: Create a new config instance
      * Function Name: CreateSubConfigInstance
      * @param: configInstance - the config instance to be added
      * @return: boolean
      * Date: 20:09 2022/5/14
    */
    public boolean CreateSubConfigInstance(ConfigInstance configInstance){

        this.AllocateMemory(TYPE_CONFIG_INSTANCE);
        this.SubConfigInstance[this.SubConfigInstance.length-1]=configInstance;
        return true;
    }


    /**
      * Author: WERDXZ
      * Description: Allocate memory for the lists
      * Function Name: AllocateMemory
      * @param type - the type of the container
      * @return
      * Date: 10:25 AM 2022/4/15
    */
    public boolean AllocateMemory(int type){
        if(type==TYPE_CONTAINER){
            if(this.SubContainers==null){
                this.SubContainers=new Container[1];
            }
            else{
                Container[] tempContainer=new Container[this.SubContainers.length+1];
                System.arraycopy(this.SubContainers, 0, tempContainer, 0, this.SubContainers.length);
                this.SubContainers=tempContainer;
            }
            return true;
        }
        if (type== TYPE_CONFIG_INSTANCE){
            if(this.SubConfigInstance==null){
                this.SubConfigInstance=new ConfigInstance[1];
            }
            else{
                ConfigInstance[] tempConfigInstance=new ConfigInstance[this.SubConfigInstance.length+1];
                System.arraycopy(this.SubConfigInstance, 0, tempConfigInstance, 0, this.SubConfigInstance.length);
            }
            return true;
        }
        return false;
    }
}


//finished