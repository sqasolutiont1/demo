package workflowPreSets.wizard;

import pageObject.forms.wizard.FormWizardFirstStepPO;
import pageObject.forms.wizard.FormWizardLastStepPO;
import pageObject.forms.wizard.FormWizardSecondStepPO;

public class FilloutWizard {
    FormWizardFirstStepPO formWizardFirstStep = new FormWizardFirstStepPO();
    FormWizardSecondStepPO secondStep = new FormWizardSecondStepPO();
    FormWizardLastStepPO lastStep = new FormWizardLastStepPO();

    //todo: refactor the code so it will reflect something
    public void fillOutAllTheSteps(String firstName,
                                   String lastName,
                                   String city,
                                   String state,
                                   String address,
                                   String zip, boolean shouldSubmit) {
        formWizardFirstStep.fillInFistName(firstName);
        formWizardFirstStep.fillInLastName(lastName);
        formWizardFirstStep.pressOnNextBtn();
        formWizardFirstStep.checkIfSwitchedToTheSecondPage();
        secondStep.fillCity(city);
        secondStep.fillState(state);
        secondStep.fillStreetAddress(address);
        secondStep.fillZip(zip);
        secondStep.pressOnNextBtn();
        if (shouldSubmit) {
            lastStep.pressOnSubmitBtn();
            lastStep.dealThisAlert();
        }
    }
}
