package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage{

    private WebDriver driver;

    // Initializing web elements of Landing page
    public FlightsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    // Element locators of Flights Page
    @FindBy(id = "OneWay")
    private WebElement onewayOption;

    @FindBy(id="FromTag")
    private WebElement from;

    @FindBy(id="ToTag")
    private WebElement to;

    @FindBy(id="ui-id-1")
    private WebElement fromList;

    @FindBy(id="ui-id-2")
    private WebElement toList;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
    private WebElement datepicker;

    @FindBy(id="SearchBtn")
    private WebElement search;

    @FindBy(className="searchSummary")
    private WebElement searchSummary;

    //Getter functions
    public WebElement getFromList() {
        return fromList;
    }

    public WebElement getToList() {
        return toList;
    }

    // Function specific tp page functionality actions
    public void selectOneway(){
        onewayOption.click();
    }

    public void enterOrigin(String origin){
        from.clear();
        from.sendKeys(origin);
    }
    public void selectFirstMatchOrigin(){
        fromList.findElements(By.tagName("li")).get(0).click();
    }

    public void enterDestination(String destination){
        to.clear();
        to.sendKeys(destination);
    }
    public void selectFirstMatchDestination(){
        toList.findElements(By.tagName("li")).get(0).click();
    }
    public void selectDate(){
        datepicker.click();

    }
    public void search(){
        search.click();

    }

}
