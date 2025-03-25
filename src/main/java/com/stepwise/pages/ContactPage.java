package com.stepwise.pages;

import com.stepwise.model.ContactBody;
import com.stepwise.utilities.URLs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page Object Model for the Contact page.
 * Handles all interactions with the contact form and its elements.
 */
public class ContactPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ContactPage.class);

    // Form field locators
    /** Locator for first name input field */
    private final By firstNameInput = By.id("nf-field-7");
    
    /** Locator for last name input field */
    private final By lastNameInput = By.id("nf-field-6");
    
    /** Locator for company input field */
    private final By company = By.id("nf-field-5");
    
    /** Locator for email input field */
    private final By emailInput = By.id("nf-field-8");
    
    /** Locator for message textarea */
    private final By message = By.id("nf-field-9");

    // Action button locators
    /** Locator for submit button */
    private final By submitButton = By.id("nf-field-10");

    // Error message locators
    /** Locator for captcha error message */
    private final By checkCapthcaCheckBox = By.id("nf-error-11");
    
    /** Locator for email error message */
    private final By emailErrorMessage = By.id("nf-error-8");

    /**
     * Constructor for ContactPage.
     * @param driver WebDriver instance to be used
     */
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the contact page.
     * Waits for the page to load completely.
     */
    @Override
    protected void navigateToPage() {
        driver.get(URLs.CONTACT_PAGE.getUrl());
        waitForPageLoad();
    }

    /**
     * Fills the contact form with provided information.
     * Uses JavaScript to ensure reliable input.
     * @param body ContactBody object containing form data
     */
    public void fillPersonalInformation(ContactBody body) {
        logger.info("Filling contact form with provided information");
        try {
            WebElement firstNameElement = driver.findElement(firstNameInput);
            sendKeysWithJS(firstNameElement, body.getFirstName());
            
            WebElement lastNameElement = driver.findElement(lastNameInput);
            sendKeysWithJS(lastNameElement, body.getLastName());
            
            WebElement companyElement = driver.findElement(company);
            sendKeysWithJS(companyElement, body.getCompany());
            
            WebElement emailElement = driver.findElement(emailInput);
            sendKeysWithJS(emailElement, body.getEmail());
            
            WebElement messageElement = driver.findElement(message);
            sendKeysWithJS(messageElement, body.getMessage());
            
            logger.debug("Contact form filled successfully");
        } catch (Exception e) {
            logger.error("Failed to fill contact form", e);
            throw e;
        }
    }

    /**
     * Clicks the submit button using JavaScript.
     */
    public void clickSubmitButton() {
        logger.info("Clicking submit button");
        clickWithJS(submitButton);
    }

    /**
     * Checks if the captcha error message is displayed.
     * @return true if captcha error is visible, false otherwise
     */
    public boolean isdisplayedCaptchaErrorMessage() {
        logger.debug("Checking if captcha error message is displayed");
        waitForElementVisible(checkCapthcaCheckBox);
        return driver.findElement(checkCapthcaCheckBox).isDisplayed();
    }

    /**
     * Checks if the email error message is displayed.
     * @return true if email error is visible, false otherwise
     */
    public boolean isDisplayedEmailErrorMessage() {
        logger.debug("Checking if email error message is displayed");
        return driver.findElement(emailErrorMessage).isDisplayed();
    }
}