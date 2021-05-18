package pageObject.forms.wizard;

import org.openqa.selenium.By;

public class FormWizardFirstStepPO extends FormWizardPO {
    public static String HeaderOfTheFirstStep = "Enter first step data";
    public void navigateToWizard(){
        navigateTo(FormWizardPO.URL);
    }
    public String getDescriptionForTheFirstStep(){
        return getTextFromElement(By.tagName("h2"));
    }
    public void fillInFistName(){}
    public void fillInLastName(){}
}
