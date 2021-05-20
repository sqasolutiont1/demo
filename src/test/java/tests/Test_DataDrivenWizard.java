package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import workflowPreSets.wizard.FilloutWizard;

public class Test_DataDrivenWizard extends CommonTest {
    FilloutWizard filloutWizard = new FilloutWizard();

    @DataProvider(name = "testDataForWizard")
    public Object[][] createData1() {
        return new Object[][]{
                {"first name", "Last name", "city", "State", "Address", "Zip"},
                {"first1 name1", "Last1 name1", "Address1", "city1", "State1", "Zip1"},
        };
    }

    @Test(dataProvider = "testDataForWizard")
    public void checkWizardForm(String firstName,
                                String lastName,
                                String city,
                                String state,
                                String address,
                                String zip) {
        filloutWizard.fillOutAllTheSteps(firstName, lastName, city, state, address, zip, false);
        //Assert.assertEquals(formWizardLastStep.getAddress(),address);
        Assert.assertEquals(formWizardLastStep.getFirstName(), firstName);
        Assert.assertEquals(formWizardLastStep.getLastName(), lastName);
    }
}
