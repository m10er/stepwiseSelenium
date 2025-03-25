package com.stepwise.steps;

import com.stepwise.model.ContactBody;
import com.stepwise.pages.ContactPage;
import com.stepwise.utilities.URLs;
import com.stepwise.utilities.faker.TestDataGeneratorFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class ContactFormSteps {
    private final WebDriver driver;
    private final ContactPage contactPage;

    public ContactFormSteps() {

        this.driver = Hooks.driverManager.getDriver();
        this.contactPage = new ContactPage(driver);
    }


    @Given("User accepts the cookie notification")
    public void userAcceptsCookieNotification() {
        contactPage.acceptCookies();
    }

    @When("fills personal information")
    public void fillsPersonalInformation(DataTable dataTable) {
        Map<String, String> personalInfo = dataTable.asMap(String.class, String.class);
        ContactBody body = new ContactBody();
        body.setFirstName(personalInfo.get("FirstName"));
        body.setLastName(personalInfo.get("LastName"));
        body.setEmail(personalInfo.get("Email"));
        body.setCompany(personalInfo.get("Company"));
        body.setMessage(personalInfo.get("Message"));
        contactPage.fillPersonalInformation(body);
    }

    @When("submits the form")
    public void submitsTheForm() {
        contactPage.clickSubmitButton();
    }

    @And("fills personal information with fake Info")
    public void fillsPersonalInformationWithFakeInfo() {
        ContactBody contactInfo = new ContactBody(TestDataGeneratorFactory.getGenerator().generateUsername(),
                TestDataGeneratorFactory.getGenerator().generateLastName(),
                TestDataGeneratorFactory.getGenerator().generateCompanyName(),
                TestDataGeneratorFactory.getGenerator().generateEmail(),
                TestDataGeneratorFactory.getGenerator().genareteMessage());
        contactPage.fillPersonalInformation(contactInfo);
    }


    @Given("user enters as a email {string}")
    public void userEntersAsAEmail(String email) {
        ContactBody body = new ContactBody();
        body.setEmail(email);
        contactPage.fillPersonalInformation(body);
    }

    @Then("should see email error message")
    public void shouldSeeEmailErrorMessage()  {
        Assert.assertTrue(contactPage.isDisplayedEmailErrorMessage());
    }


    @Given("User navigates to Stepwise contact page")
    public void userNavigatesToStepwiseContactPage() {
        driver.get(URLs.CONTACT_PAGE.getUrl());
    }



    @Then("User should see Captcha Error Message")
    public void userShouldSeeCaptchaErrorMessage() {
        Assert.assertTrue(contactPage.isdisplayedCaptchaErrorMessage());

    }
}