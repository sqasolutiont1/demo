package pageObject.forms.wizard;

import org.openqa.selenium.By;

public class FormWizardSecondStepPO extends FormWizardPO {

  public void getDescriptionForTheSecondStep() {
  }

  public void fillStreetAddress(String address) {
    fillInText(By.name("streetAddress"), address);
  }

  public void fillCity(String city) {
    fillInText(By.name("city"), city);
  }

  public void fillState(String state) {
    fillInText(By.name("state"), state);
  }

  public void fillZip(String zip) {
    fillInText(By.name("postalCode"), zip);
  }
}
