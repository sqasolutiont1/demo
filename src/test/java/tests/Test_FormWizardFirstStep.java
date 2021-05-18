package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.forms.wizard.FormWizardFirstStepPO;

public class Test_FormWizardFirstStep extends CommonTest {
    @Test
    public void testFirstForm() {
        Assert.assertEquals(formWizardFirstStep.getDescriptionForTheFirstStep(),
                FormWizardFirstStepPO.HeaderOfTheFirstStep);
    }

    @DataProvider(name = "FirstNames")
    public Object[][] createData1() {
        return new Object[][]{
                {"new Integer(36)"},
                {"new Integer(37)"},
        };
    }


    @Test(dataProvider = "FirstNames")
    public void testFillOutFirstName(String firstNames) {
        formWizardFirstStep.fillInFistName(firstNames);
    }
}
