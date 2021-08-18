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

    @FindAll(@FindBy(how = How.XPATH, using = "//a[@title='Konton']")) //slds-truncate
    List<WebElement> accounts;

    public Account (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickAccount () {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Konton']")));
        driver.get("https://axiscommunicationsab2.lightning.force.com/lightning/o/Account/home");
        System.out.println("text to see");
        for (WebElement element: accounts) {
            System.out.println("SOME");
            System.out.println(element.getText());
        }
    }

    public void clickNew () {
        newr.click();
    }
}
