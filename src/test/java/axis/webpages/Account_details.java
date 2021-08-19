package axis.webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Account_details {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@title='Redigera Kontonamn']")
    WebElement edit_button;

    @FindBy(how = How.CSS, using = "div.maincontent")
    WebElement body;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='maincontent']//input"))
    List<WebElement> inputs;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='maincontent']//textarea"))
    List<WebElement> text_area;

    @FindBy(how = How.XPATH, using = "//button[text()[contains(.,'Avbryt')]]")
    WebElement cancel_edit;

    @FindBy(how = How.XPATH, using = "//button[text()[contains(.,'Spara')]]")
    WebElement save_edit;

    public Account_details(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void clickEdit() {
        edit_button.click();
    }

    public void scroll_page() {
        body.sendKeys(Keys.ARROW_DOWN);
        body.sendKeys(Keys.ARROW_DOWN);
        body.sendKeys(Keys.ARROW_DOWN);
    }

    public void fillInputs() {
        for (WebElement element: inputs) {
            element.sendKeys("input");
        }
    }

    public void fillTextArea() {
        for (WebElement element: text_area) {
            element.sendKeys("text");
        }
    }

    public void setAccount_phone(String phone) {
        inputs.get(0).sendKeys(phone);
    }

    public void setAccount_fax(String fax) {
        inputs.get(2).sendKeys(fax);
    }

    public void setAccount_website(String website) {
        inputs.get(4).sendKeys(website);
    }

    public void clickCancel_edit() {
        cancel_edit.click();
    }

    public void clickSave_edit() {
        save_edit.click();
    }
}
