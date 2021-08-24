package axis.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Account {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[@title='Ny']")
    WebElement new_account;

    @FindBy(how = How.XPATH, using = "//a[@title='Konton']") //slds-truncate
    WebElement accounts;

    @FindAll(@FindBy(how = How.CSS, using = "input.default.input.uiInput.uiInputTextForAutocomplete.uiInput--default.uiInput--input.uiInput.uiAutocomplete.uiInput--default.uiInput--lookup"))
    List<WebElement> account_name_inputs;

    @FindBy(how = How.XPATH, using = "//button[@title='Spara']")
    WebElement save_button;


    public Account (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickAccount () {
        driver.get(accounts.getAttribute("href"));
    }

    public void clickNew () {
        new_account.click();
    }

    public void setAccount_name_input(String name) {
        account_name_inputs.get(0).sendKeys(name);
    }

    public void clickSave_button() {
        save_button.click();
    }
}
