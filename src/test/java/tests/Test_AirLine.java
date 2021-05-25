package tests;

import org.junit.experimental.theories.Theories;
import org.testng.annotations.Test;

public class Test_AirLine extends CommonTest{

  @Test
  public void clickOnTravelTo(){
    mainPage.fillInTravelTo("Santiago");
    mainPage.waitForDestination();
    mainPage.fillInDestinationTo("Arica");
    mainPage.selectDepartureDate();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
