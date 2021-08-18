package axis;

import org.openqa.selenium.By;

public class contents {
    // User login
    public static By username = By.cssSelector("input#username");
    public static By password = By.cssSelector("input#password");
    public static By Login = By.xpath("//input[@id='Login']");
    public static By remember = By.cssSelector("input#rememberUn");

    // Account
    public static By account = By.xpath("//*[@data-id='Account']//a");
}
