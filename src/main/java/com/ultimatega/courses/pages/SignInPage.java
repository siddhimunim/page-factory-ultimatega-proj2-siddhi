package com.ultimatega.courses.pages;

import com.aventstack.extentreports.Status;
import com.ultimatega.courses.customlistner.CustomListners;
import com.ultimatega.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage extends Utility {
    public SignInPage(){
        PageFactory.initElements(driver, this);

    }
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeBackText;
    @CacheLookup
    @FindBy(id =("user[email]"))
    WebElement emailField;
    @CacheLookup
    @FindBy(id =("user[password]"))
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Sign in')]")
    WebElement signInField;
    @CacheLookup
    @FindBy(xpath="//li[contains(text(),'Invalid email or password.')]")
    WebElement invalidField;

    public String verifyTextField(){
        Reporter.log("verify welcomeback text" + welcomeBackText.toString());
        return getTextFromElement(welcomeBackText);

    }
    public void clickOnEmail(String email){
        Reporter.log("Enter email" + email + "to emailField "+ emailField.toString());
        sendTextToElement(emailField,email);
        CustomListners.test.log(Status.PASS,"Enter email" +email);
    }
    public void clickOnPassword(String password){
        Reporter.log("Enter password" + password + "to password "+ passwordField.toString());
        sendTextToElement(passwordField,password);
        CustomListners.test.log(Status.PASS,"Enter password" + password);
    }
    public void clickOnSignButton(){
        Reporter.log("click on signIn" + signInField.toString());
        clickOnElement(signInField);
        CustomListners.test.log(Status.PASS,"clickOnSignIn");
    }
    public String verifyInvalidField(){
        Reporter.log("verify invaildfield text" + invalidField.toString());
        CustomListners.test.log(Status.PASS,"text from unvaild massage");
        return getTextFromElement(invalidField);
    }
}
