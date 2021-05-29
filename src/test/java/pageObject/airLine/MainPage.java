package pageObject.airLine;

import org.openqa.selenium.By;
import pageObject.basePageObject.CommonPageObject;

public class MainPage extends CommonPageObject {

  public void navigateToAirLine(){
    navigateTo("https://web-qa.skyairline.com/english");
  }

  public void fillInTravelTo(String nameOfDestination){
    selectTravelTo(By.xpath("(//div[2]/div[1]/div[1]/div[1]/input[1])[1]"),nameOfDestination);
  }

  public void waitForDestination() {
    waitForAttributeValueNotPresent(By.xpath("(//*[@class = 'el-input__inner'])[4]"),"disabled","disabled");
  }

  public void fillInDestinationTo(String text) {
    selectDestinationTo(By.xpath("(//*[@class = 'el-input__inner'])[4]"),text);
  }

  public void selectDepartureDate() {
    getClickableElement(By.xpath("(//*[@class=\"button-selection-content-value-going\"]//*)[2]"))
        .sendKeys(" Mon 30 May ");
    getClickableElement(By.xpath("(//*[@class='button-selection-content-value-back']//*)[2]"))
        .sendKeys(" Sun 6 Jun ");
  }

  public void fillOutPromoCode(){
    fillInText(By.xpath("(//*[@class=\"input-selection ant-input\"])[1]"),"MyPromoCode");
  }
}
