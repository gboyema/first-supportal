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

    @FindBy(how = How.NAME, using = "Name")
    WebElement account_name;

    @FindBy(how = How.NAME, using = "Phone")
    WebElement account_phone;

    @FindBy(how = How.NAME, using = "Fax")
    WebElement account_fax;

    @FindBy(how = How.NAME, using = "Website")
    WebElement account_website;

    @FindBy(how = How.NAME, using = "CancelEdit")
    WebElement cancel_edit;

    @FindBy(how = How.NAME, using = "SaveEdit")
    WebElement save_edit;

    public Account_details(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void clickEdit() {
        edit_button.click();
    }

    public void setAccount_details() {
        body.sendKeys(Keys.ARROW_DOWN);
        body.sendKeys(Keys.ARROW_DOWN);
        body.sendKeys(Keys.ARROW_DOWN);


       // account_name.sendKeys("a");
        //account_fax.sendKeys("b");
        //account_phone.sendKeys("c");
        //account_website.sendKeys("d");
    }

    public void setAccount_name() {
        account_name.sendKeys("a");
    }

    public void setAccount_phone() {
        account_phone.sendKeys("b");
    }

    public void setAccount_fax() {
        account_fax.sendKeys("c");
    }

    public void clickCancel_edit() {
        cancel_edit.click();
    }
}
