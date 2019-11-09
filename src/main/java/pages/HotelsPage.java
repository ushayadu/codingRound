package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HotelsPage{

    private WebDriver driver;

    // Initializing web elements of Hotels page
    public HotelsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // element locators of hotels page
    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    // methods for hotels page actions
    public void enterArea(String area){
        localityTextBox.sendKeys(area);
    }
    public void travellersDetails(String details){
        new Select(travellerSelection).selectByVisibleText(details);
    }
    public void search(){
        searchButton.click();
    }
}
