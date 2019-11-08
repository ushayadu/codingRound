package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage extends  TestBase{

    public FlightsPage() {
        PageFactory.initElements(driver,this);
    }

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
    public boolean searchResult(){
        return isElementPresent(By.className("searchSummary"));
    }
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
