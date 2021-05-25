package pageObject.ebay;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.basePageObject.CommonPageObject;

public class DailyDeals extends CommonPageObject {

  public void navToDDeals() {
    navigateTo("https://www.ebay.com/deals");
  }

  public List<WebElement> getTheDeals(){
    return getClickableElements(By.cssSelector("[itemprop=\"name\"]"));
  }

  public List<WebElement> getThePrices(){
    return getClickableElements(By.cssSelector("[itemprop=\"price\"]"));
  }

  public void prinAlltheDeals(){
    JSONObject jsonObject = new JSONObject();

    for(int i=0; i<getThePrices().size(); i++){
      System.out.println(getTheDeals().get(i).getText());
      System.out.println(getThePrices().get(i).getText());
      jsonObject.put(getTheDeals().get(i).getText(), getThePrices().get(i).getText());
    }

    PrintWriter printWriter = null;
    try {
      printWriter = new PrintWriter("ebay.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    printWriter.write(jsonObject.toJSONString());

    printWriter.flush();
    printWriter.close();
  }
}
