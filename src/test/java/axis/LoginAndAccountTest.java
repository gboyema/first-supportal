package axis;

import Configuration.ConfigFileReader;
import axis.webpages.Account;
import axis.webpages.Account_contacts;
import axis.webpages.Account_details;
import axis.webpages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class LoginAndAccountTest {

    public WebDriver driver;
    private ConfigFileReader configfilereader;

    @BeforeMethod
    public void setup() throws Exception {
        String userProfile= "C:\\Users\\soyoolag\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);
        File file = new File(System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        //configfilereader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Setup Done");
    }

    @Test(dataProvider = "login_data")
    public void loginAndAccountTest ( TestData data ) throws Exception {
        Thread.sleep(7000);
        //System.out.println("tests");
        Login login = new Login(driver);
        Assert.assertTrue(login.isPageOpened());

        login.setUsername(data.get(0));
        login.setPassword(data.get(1));
        login.setLogin_button();
        Thread.sleep(7000);

        Account account = new Account(driver);
        account.clickAccount();
        Thread.sleep(5000);
        account.clickNew();
        Thread.sleep(5000);
        account.setAccount_name_input(data.get(2));
        account.clickSave_button();
        Thread.sleep(4000);

        Account_details account_details = new Account_details(driver);
        Thread.sleep(2000);
        account_details.clickEdit();
        Thread.sleep(2000);
        account_details.scroll_down();
        Thread.sleep(4000);
//        account_details.setAccount_name();
//        Thread.sleep(2000);
        account_details.setAccount_fax( data.get(4));
        Thread.sleep(2000);
        account_details.setAccount_phone(data.get(3));
        Thread.sleep(2000);
        account_details.setAccount_website(data.get(5));
        Thread.sleep(2000);
        account_details.clickSave_edit();

        Account_contacts account_contacts = new Account_contacts(driver);
        Thread.sleep(3000);
        account_contacts.scroll_up();
        Thread.sleep(3000);
        account_contacts.clickContacts_nav();
        Thread.sleep(5000);
        account_contacts.add_newContact();
    }

    @DataProvider(name = "loginAndAccountTest")
    public Object [] [] login_data() {
        return new Object[][] {
                //{ new TestData("hey", "you", "guys") },
                //{ new TestData("Sloth", "Baby", "Ruth") },
                { new TestData("soyoolag-nccm@force.com", "love3611", "Account 6", "07034567898", "090789867342323", "www.website.com") }
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
    public void endSession() {
        driver.quit();
        System.out.println("Done");
    }
}
