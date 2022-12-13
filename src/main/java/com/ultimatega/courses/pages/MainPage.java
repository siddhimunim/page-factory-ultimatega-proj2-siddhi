package com.ultimatega.courses.pages;

import com.aventstack.extentreports.Status;
import com.ultimatega.courses.customlistner.CustomListners;
import com.ultimatega.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import javax.rmi.CORBA.Util;

public class MainPage extends Utility {
    public MainPage(){
        PageFactory.initElements(driver, this);

    }

    @CacheLookup
    @FindBy(xpath = "//li[@class='header__nav-item header__nav-sign-in']/a")
    WebElement signInLink;


    public void clickOnSignin(){
      Reporter.log("click on Sign in "+ signInLink.toString());

        clickOnElement(signInLink);
        CustomListners.test.log(Status.PASS,"click on sing in" + signInLink);
    }
}
