package com.Tablet.pages;

import com.Tablet.utilities.ConfigurationReader;
import com.Tablet.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabletHomePage {
    public TabletHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@class='QuickMenu__launch']")
    public WebElement mainMenu;

    @FindBy(xpath= "//span[text()='Register']")
    public WebElement registerButton;

    @FindBy(id = "RegisterEmailemail")
    public WebElement enterEmailInputBox;

    @FindBy(id = "RegisterNamesfirst_name")
    public WebElement firstNameInput;

    @FindBy(id = "RegisterNameslast_name")
    public WebElement lastNameInput;



    @FindBy(id = "RegisterPasswordpassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//span[@class='RegisterModal__Title' and text()=\"You're in!\"]") //not a right locator
    public WebElement registerConfirmationMessage;

    @FindBy(xpath = "//a[@href='/account']")
    public WebElement myInfoMenu;



    // random alphanumeric string
    public static String generateRandomString(int length) {
        Faker faker = new Faker();
        return faker.regexify("[a-zA-Z0-9]{" + length + "}");
    }

    // Method to format the email address
    public static String generateFormattedEmail(String email) {
        String randomString = generateRandomString(6);
        return email.replaceFirst("@", "+qainterview-" + randomString + "@");
    }

    public  void registerNewUser(String email, String firstName, String lastName, String password) throws InterruptedException {
        mainMenu.click();
        registerButton.click();

        String formattedEmail = TabletHomePage.generateFormattedEmail(email);
        enterEmailInputBox.sendKeys(formattedEmail);
        submitButton.click();
        Thread.sleep(2000);

        firstNameInput.sendKeys(ConfigurationReader.getProperty("firstName"));
        lastNameInput.sendKeys(ConfigurationReader.getProperty("lastName"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        Thread.sleep(2000);

        submitButton.click();
        Thread.sleep(2000);
    }






















}
