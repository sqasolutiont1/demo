package pageObject.basePageObject;

import utils.WDManager;

public class CommonPageObject extends WDManager {
    String URL = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/index.html#/index";
    public void navigateTo(){
        driver.navigate().to(URL);
    }
    public void navigateTo(String URL){
        driver.navigate().to(URL);
    }
}
