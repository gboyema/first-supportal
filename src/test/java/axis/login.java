package axis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Configuration.ConfigFileReader;
import axis.contents;

import java.io.File;

public class login {
    public WebDriver driver;
    private ConfigFileReader configfilereader;

    @BeforeMethod
    public void setup() throws InterruptedException {
        String userProfile= "C:\\Users\\soyoolag\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        //String test="C:\\Users\\soyoolag\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);
        //options.addArguments("--start-maximized");
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        configfilereader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test(dataProvider="login_data", priority = 0)
    public void login_function( TestData data  ) throws Exception {
        System.out.println(configfilereader.getappURL());
        driver.get("https://axiscommunicationsab2.lightning.force.com/");
        Thread.sleep(5000);
        driver.findElement(contents.username).sendKeys(data.get(0));
        Thread.sleep(1000);
        driver.findElement(contents.password).sendKeys(data.get(1));
        Thread.sleep(5000);
        driver.findElement(contents.Login).click();
        Thread.sleep(6000);
        System.out.println("passed");
    }

    @Test(priority = 1)
    public void click_account() throws Exception {
        Thread.sleep(5000);
        driver.findElement(contents.account).click();
    }

    @DataProvider(name = "login_function")
    public Object [] [] login_data() {
        return new Object[][] {
                //{ new TestData("hey", "you", "guys") },
                //{ new TestData("Sloth", "Baby", "Ruth") },
                { new TestData("soyoolag-nccm@force.com", "love3611") }
        };
    }

    static class TestData {
        public String[] items;

        public TestData(String... items) {
            this.items = items; // should probably make a defensive copy
        }

        public String get(int x) {
            return items[x];
        }
    }

    @AfterMethod
    public void closedriver() {
        System.out.println("Test completed");
        //driver.quit();
        //driver.close();
    }
}
