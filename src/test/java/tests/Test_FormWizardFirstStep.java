package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.forms.wizard.FormWizardFirstStepPO;

public class Test_FormWizardFirstStep extends CommonTest{
    @Test
    public void testFirstForm(){
        Assert.assertEquals(formWizardFirstStep.getDescriptionForTheFirstStep(),
                FormWizardFirstStepPO.HeaderOfTheFirstStep);
    }
}
