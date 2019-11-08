package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;

public class SignInTest extends base.TestBase{
    LandingPage landingpage;

    public SignInTest(){
        super();
    }
    @BeforeTest
    public void testSetup(){
        setDriverPath();
        navigateToUrl();
        landingpage=new LandingPage();
    }
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        landingpage.goToYourTrips();
        landingpage.navigateToSignIn();
        landingpage.signIn();
        Assert.assertTrue(landingpage.getsignError().contains("There were errors in your submission"));
    }
    @AfterTest
    public void endTest(){
        driverQuit();
    }
}
