import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.HashMap;

public class ShoppingCartTest {

    @Test
    public void checkDiscount0() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=test&" +
                "email=test%40test.test&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/" +
                "tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Search']")));
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7"));
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value='Update']")).click();
        String discountPercent = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]" +
                "/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPercent, "0");
        softAssert.assertEquals(discountDollar, "0");
        softAssert.assertEquals(totalDollar, "190");
        driver.quit();
        softAssert.assertAll();
    }

    private static WebDriver getWebDriver() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

@Test
    public void checkDiscount2() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=test&" +
                "email=test%40test.test&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/" +
                "tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Search']")));
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7"));
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("25");
        driver.findElement(By.cssSelector("[value='Update']")).click();
        String discountPercent = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]" +
                "/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPercent, "2");
        softAssert.assertEquals(discountDollar, "5.00");
        softAssert.assertEquals(totalDollar, "245.00");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount3() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=test&" +
                "email=test%40test.test&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/" +
                "tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Search']")));
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7"));
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("99");
        driver.findElement(By.cssSelector("[value='Update']")).click();
        String discountPercent = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]" +
                "/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPercent, "3");
        softAssert.assertEquals(discountDollar, "29.70");
        softAssert.assertEquals(totalDollar, "960.30");
        driver.quit();
        softAssert.assertAll();
    }

    @Test
    public void checkDiscount4() {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=test&last_name=test&" +
                "email=test%40test.test&password1=12345&password2=12345");
        String email = driver.findElement(By.xpath("//table/tbody/tr[6]/td/table/" +
                "tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value='Login']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Search']")));
        driver.get("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7");
        wait.until(ExpectedConditions.urlToBe("https://www.sharelane.com/cgi-bin/add_to_cart.py?book_id=7"));
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value='Update']")).click();
        String discountPercent = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]" +
                "/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discountDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[6]")).getText();
        String totalDollar = driver.findElement(By.xpath("/html/body/center/table/" +
                "tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        softAssert.assertEquals(discountPercent, "4");
        softAssert.assertEquals(discountDollar, "40.00");
        softAssert.assertEquals(totalDollar, "960.00");
        driver.quit();
        softAssert.assertAll();
    }
}
