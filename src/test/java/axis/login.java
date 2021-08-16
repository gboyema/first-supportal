package axis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        configfilereader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider="login_data", priority = 0)
    public void login_function( TestData data  ) throws Exception {
        driver.get(configfilereader.getappURL());
        Thread.sleep(5000);
        driver.findElement(contents.username).sendKeys(data.get(0));
        driver.findElement(contents.password).sendKeys(data.get(1));
        Thread.sleep(5000);
        driver.findElement(contents.Login).click();
        System.out.println("passed");
    }

    @DataProvider(name = "login_function")
    public Object [] [] login_data() {
        return new Object[][] {
                //{ new TestData("hey", "you", "guys") },
                //{ new TestData("Sloth", "Baby", "Ruth") },
                { new TestData("foo", "bar", "baz") }
        };
    }
    //@Test(dataProvider="login_data")
    //public void login(TestData data) {
    //    System.out.println(data.get(0) + "..." + data.get(1) + "..." + data.get(2));
    //}

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
        driver.close();
    }
}
