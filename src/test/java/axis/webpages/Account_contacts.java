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

    @FindAll(@FindBy(how = How.TAG_NAME, using = "input"))
    List<WebElement> inputs;

    @FindAll(@FindBy(how = How.XPATH, using = "//a[@role='button']"))
    List<WebElement> news;

    @FindAll(@FindBy(how = How.XPATH, using = "//legend[text()[contains(.,'Namn')]]/following-sibling::div/div/div/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div/input"))
    List<WebElement> dropdown;

    @FindAll(@FindBy(how = How.XPATH, using = "//legend[text()[contains(.,'Namn')]]/following-sibling::div/div/div/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div/lightning-base-combobox-item"))
    List<WebElement> dropdown_items;

    @FindAll(@FindBy(how = How.XPATH, using = "//legend[text()[contains(.,'Namn')]]/following-sibling::div/div/div/lightning-input/div/input"))
    List<WebElement> lastname;

    @FindBy(how = How.XPATH, using = "//button[text()[contains(.,'Spara')]]")
    WebElement save_edit;

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

    public void add_newContact() throws Exception {
        System.out.println(news.get(18).getText());
        for (WebElement element: news
             ) {
            System.out.println(element.getText() + " same");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(news.get(21)));
        try {
            news.get(18).click();
        } catch (Exception e) {
            news.get(21).click();
        }
    }

    public void setDropdown() {
        dropdown.get(0).click();
    }

    public void pick_dropdown() {
        dropdown_items.get(1).click();
    }

    public void setLastname (String name) {
        lastname.get(1).sendKeys(name);
        for (WebElement element: lastname) {
            System.out.println(element.getAttribute("id") + "seconda");
        }
    }

    public void clickSave_edit() {
        save_edit.click();
    }
}
