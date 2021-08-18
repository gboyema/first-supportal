package axis.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Account {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@title='Ny']")
    WebElement newr;

    @FindBy(how = How.XPATH, using = "//a[@title='Konton']") //slds-truncate
    WebElement accounts;

    public Account (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickAccount () {
        driver.get(accounts.getAttribute("href"));
    }

    public void clickNew () {
        newr.click();
    }
}
