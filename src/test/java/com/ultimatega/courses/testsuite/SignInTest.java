package com.ultimatega.courses.testsuite;

import com.ultimatega.courses.customlistner.CustomListners;
import com.ultimatega.courses.pages.MainPage;
import com.ultimatega.courses.pages.SignInPage;
import com.ultimatega.courses.testbase.BaseTest;
import com.ultimatega.courses.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(CustomListners.class)
public class SignInTest extends BaseTest {
    MainPage mainPage;
    SignInPage signInPage ;

    @BeforeMethod (alwaysRun = true)
    public void inIt(){
       this. mainPage = new MainPage();
      this.  signInPage = new SignInPage();

    }
    @Test (groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {

       this. mainPage.clickOnSignin();
        SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(this.signInPage.verifyTextField(),"Welcome Back!");
        softAssert.assertAll();


    }
    @Test(groups = {"smoke","regression"})
    public void  verifyTheErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        mainPage.clickOnSignin();
        signInPage.clickOnEmail("abcd@gamil.com");
        signInPage.clickOnPassword("abcd1234");
        Thread.sleep(1000);
        signInPage.clickOnSignButton();
        String expText ="Invalid email or password.";
        String actText = signInPage.verifyInvalidField();
        Assert.assertEquals(actText,expText,"Not varify");


    }

}
