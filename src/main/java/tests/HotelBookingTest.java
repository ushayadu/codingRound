package tests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HotelsPage;
import pages.LandingPage;

public class HotelBookingTest extends base.TestBase{

    LandingPage landingpage;
    HotelsPage hotelspage;

    public HotelBookingTest(){
        super();
    }
    @BeforeTest
    public void testSetup(){
        setDriverPath();
        navigateToUrl();
        landingpage=new LandingPage();
        hotelspage=new HotelsPage();
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        landingpage.navigateToHotelSearch();
        hotelspage.enterArea("Indiranagar, Bangalore");
        hotelspage.travellersDetails("1 room, 2 adults");
        hotelspage.search();
    }

    @AfterTest
    public void endTest(){
        driverQuit();
    }
}
