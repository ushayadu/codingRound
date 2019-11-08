package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends TestBase {


    public LandingPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText="Your trips")
    WebElement yourtrips;

    @FindBy(id="SignIn")
    WebElement signInlink;

    @FindBy(id="signInButton")
    WebElement signInbutton;

    @FindBy(id="errors1")
    WebElement signInerror;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

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

    public String getsignError(){
        return(signInerror.getText());
    }

    public void navigateToHotelSearch(){
        hotelLink.click();
    }

}
