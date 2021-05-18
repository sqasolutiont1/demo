package pageObject.forms.wizard;

import org.openqa.selenium.By;

public class FormWizardFirstStepPO extends FormWizardPO {
    public static String URL = "http://authenticgoods.co/wrapbootstrap/themes/neuboard-v1.4.3/Angular_full_version/index.html#/forms/wizard/step_one";

    public static String HeaderOfTheFirstStep = "Enter first step data";

    public void navigateToWizard() {
        navigateTo(URL);
    }

    public String getDescriptionForTheFirstStep() {
        return getTextFromElement(By.tagName("h2"));
    }

    public void fillInFistName(String firstName) {
        fillInText(By.name("firstName"), firstName);
    }

    public void fillInLastName() {
    }
}
