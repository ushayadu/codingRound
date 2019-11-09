package tests;

import org.testng.annotations.*;
import pages.HotelsPage;
import pages.LandingPage;

public class HotelBookingTest extends base.TestBase{

    private LandingPage landingpage;
    private HotelsPage hotelspage;

    public HotelBookingTest(){
        super();
    }
    @BeforeTest
    public void testSetup(){
        setDriverPath();
        navigateToUrl();
        landingpage=new LandingPage(driver);
        hotelspage=new HotelsPage(driver);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        landingpage.navigateToHotelSearch();
        hotelspage.enterArea("Indiranagar, Bangalore");
        hotelspage.travellersDetails("1 room, 2 adults");
        hotelspage.search();
    }
    @AfterSuite
    public void endTest(){
        driverQuit();
    }
}
