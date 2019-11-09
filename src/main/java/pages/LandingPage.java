package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage{

    private WebDriver driver;

    // Initializing web elements of Landing page
    public LandingPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // element locators of landing page
    @FindBy(linkText="Your trips")
    private WebElement yourtrips;

    @FindBy(id="SignIn")
    private WebElement signInlink;

    @FindBy(id="signInButton")
    private WebElement signInbutton;

    @FindBy(id="errors1")
    private WebElement signInerror;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    // methods for landing page functionality
    public void goToYourTrips(){
        yourtrips.click();
    }

    public void navigateToSignIn(){
        signInlink.click();
    }

    public void signIn(){
        driver.switchTo().frame("modal_window");
        signInbutton.click();
    }

    public String getSignError(){
        return(signInerror.getText());
    }

    public void navigateToHotelSearch(){
        hotelLink.click();
    }

}
