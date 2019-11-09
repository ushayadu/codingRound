package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FlightsPage;
import utils.TestUtils;

public class FlightBookingTest extends base.TestBase{

    private FlightsPage flightsPage;
    private TestUtils utils;
    public FlightBookingTest(){
        super();
    }
    @BeforeTest
    public void testSetup(){
        setDriverPath();
        navigateToUrl();
        flightsPage=new FlightsPage(driver);
        utils=new TestUtils();
    }
    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        flightsPage.selectOneway();
        flightsPage.enterOrigin("Bangalore");

        //wait until the auto complete options appear & clickable for the origin
        utils.waitUntil(flightsPage.getFromList(),driver);

        flightsPage.selectFirstMatchOrigin();
        flightsPage.enterDestination("Delhi");

        //wait for the auto complete options appear & clickable for the destination
        utils.waitUntil(flightsPage.getToList(),driver);

        //select the first item from the destination auto complete list
        flightsPage.selectFirstMatchDestination();
        flightsPage.selectDate();


        //all fields filled in. Now click on search
        flightsPage.search();

        utils.waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(utils.isElementPresent(By.className("searchSummary"),driver));

    }
    @AfterTest
    public void endTest(){
        driverQuit();
    }

}
