package axis.webpages;

import Configuration.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;
    private ConfigFileReader configFileReader;

    @FindBy(how=How.CSS, using = "input#username")
    WebElement username;

    @FindBy(how = How.CSS, using = "input#password")
    WebElement password;

    @FindBy(how = How.CSS, using="input#rememberUn")
    WebElement rememberMe;

    @FindBy(how = How.XPATH, using = "//input[@id='Login']")
    WebElement login_button;

    public Login (WebDriver driver){
        this.driver = driver;
        configFileReader = new ConfigFileReader();

        driver.get(configFileReader.getappURL());


        PageFactory.initElements(driver, this);
    }

    public void setUsername(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void setPassword(String passcode) {
        password.clear();
        password.sendKeys(passcode);
    }

    public void setRememberMe() {
        rememberMe.click();
    }

    public void setLogin_button() {
        login_button.click();
    }

    public boolean isPageOpened() {
        return login_button.isDisplayed();
    }
}
