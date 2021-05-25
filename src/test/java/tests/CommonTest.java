package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObject.airLine.MainPage;
import pageObject.ebay.DailyDeals;
import pageObject.forms.wizard.FormWizardFirstStepPO;
import pageObject.forms.wizard.FormWizardLastStepPO;
import pageObject.forms.wizard.FormWizardPO;
import pageObject.forms.wizard.FormWizardSecondStepPO;

public class CommonTest {

  FormWizardFirstStepPO formWizardFirstStep = new FormWizardFirstStepPO();
  FormWizardSecondStepPO formWizardSecondStep = new FormWizardSecondStepPO();
  FormWizardLastStepPO formWizardLastStep = new FormWizardLastStepPO();
  FormWizardPO formWizardPO = new FormWizardPO();
  MainPage mainPage = new MainPage();
  DailyDeals dailyDeals = new DailyDeals();

  @BeforeMethod
  public void getToThePage() {
    new DailyDeals().navToDDeals();
  }

  @AfterMethod
  public void closeTheDriverEveryTime() {
    formWizardPO.closeDriver();
  }
}
