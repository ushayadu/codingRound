package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsPage extends TestBase{
    public HotelsPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

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
