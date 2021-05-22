package pageObject.forms.wizard;

import org.openqa.selenium.By;

public class FormWizardLastStepPO extends FormWizardPO {

  public void getDescriptionForTheLastStep() {
  }

  public String getFirstName() {
    return getTextFromElement(By.cssSelector("div:nth-child(1) > p:nth-child(2)"));
  }

  public String getLastName() {
    return getTextFromElement(By.cssSelector("div:nth-child(2) > p:nth-child(2)"));
  }

  public String getAddress() {
    return getTextFromElement(By.cssSelector("div:nth-child(3) > p:nth-child(2)"));
  }

  public String getLastStepData() {
    return "";
  }
}
