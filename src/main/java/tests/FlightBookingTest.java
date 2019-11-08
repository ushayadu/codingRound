package tests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.LandingPage;

import java.util.List;

public class FlightBookingTest extends base.TestBase{
    FlightsPage flightsPage;
    public FlightBookingTest(){
        super();
    }
    @BeforeTest
    public void testSetup(){
        setDriverPath();
        navigateToUrl();
        flightsPage=new FlightsPage();
    }
    @Test
    public void testThatResultsAppearForAOneWayJourney() {


//        waitFor(2000);
        flightsPage.selectOneway();
        flightsPage.enterOrigin("Bangalore");

        //wait for the auto complete options to appear for the origin

        waitFor(2000);

        flightsPage.selectFirstMatchOrigin();
        flightsPage.enterDestination("Delhi");

        //wait for the auto complete options to appear for the destination

        waitFor(2000);
        //select the first item from the destination auto complete list
        flightsPage.selectFirstMatchDestination();

        flightsPage.selectDate();

        //all fields filled in. Now click on search

        flightsPage.search();

        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(flightsPage.searchResult());

    }
    @AfterTest
    public void endTest(){
        driverQuit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }





}
