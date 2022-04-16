package com.werdxz.ConfigUtil;


/**
 * @author WERDXZ
 * date 2022/04/14/
 */
public class MainContainer extends Container {
    MainContainer(String Title) {
        super(Title,0);
    }

    MainContainer(String Header, String Title) {
        super(Header, Title,0);
    }

    MainContainer(String Header, String Title, ConfigInstance[] SubConfigInstance){
        super(Header, Title, SubConfigInstance,0);
    }
}


//finished