package pageObject.forms.wizard;

import org.openqa.selenium.By;
import pageObject.basePageObject.CommonPageObject;

public class FormWizardPO extends CommonPageObject {
    /**
     * 1. Step #1. Create empty methods which will describe the behavior of the Page
     * 2. Step #2. Create the first architecture model. Don';t stuck with your first architectures.
     * Always think how to improve them.
     * 3. Just follow the best practices:
     * 3.1. Use PO design pattern
     * 3.2. Keep similar things together and different things separate.
     * 3.3. Don't tolerate code duplications
     * 3.4. Keep your Classes and methods small.!!!!! ----!!!!!
     */
    public void getHeader() {
    }

    public void pressOnStepOne() {
    }

    public void pressOnStepTwo() {
    }

    public void pressOnLastStep() {
    }

    public void pressOnNextBtn() {
        pressOnBtn(By.xpath("//a[normalize-space()='Next']"));
    }

    public void pressOnPrevBtn() {
    }

    public void pressOnSubmitBtn() {
    }

    public void dealThisAlert() {
    }

}
