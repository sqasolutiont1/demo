package tests;

import org.testng.annotations.Test;

public class Test_Ebay_DailyDeals extends CommonTest{
  @Test
  public void testIt(){
    dailyDeals.prinAlltheDeals();
  }

}
