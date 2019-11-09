package tests;

import org.testng.annotations.*;
import org.testng.Assert;
import pages.LandingPage;

public class SignInTest extends base.TestBase{

    private LandingPage landingpage;

    public SignInTest(){
        super();
    }
    @BeforeTest
    public void testSetup(){
        setDriverPath();
        navigateToUrl();
        landingpage=new LandingPage(driver);
    }
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        landingpage.goToYourTrips();
        landingpage.navigateToSignIn();
        landingpage.signIn();
        Assert.assertTrue(landingpage.getSignError().contains("There were errors in your submission"));
    }
    @AfterSuite
    public void endTest(){
        driverQuit();
    }
}
