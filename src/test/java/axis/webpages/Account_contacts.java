package axis.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Account_contacts {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[text()[contains(.,'Contacts')]]")
    WebElement contacts_nav;

    @FindBy(how = How.CSS, using = "div.maincontent")
    WebElement body;

    @FindAll(@FindBy(how = How.XPATH, using = "//a[@role='button']"))
    List<WebElement> news;

    public Account_contacts(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickContacts_nav() {
        contacts_nav.click();
    }

    public void scroll_up() {
        body.sendKeys(Keys.ARROW_UP);
        body.sendKeys(Keys.ARROW_UP);
        body.sendKeys(Keys.ARROW_UP);
    }

    public void add_newContact() {
        System.out.println(news.get(18).getText());
        for (WebElement element: news
             ) {
            System.out.println(element.getText());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(news.get(18)));

        news.get(18).click();
    }
}
