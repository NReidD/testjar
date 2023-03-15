import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
WebDriver driver;
    public Driver() {
        
        driver = login();
        
    }
    void protocol(int i, Stock s, int shares) {
        if (i==1) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.stockmarketgame.org/pa.html");
            assertEquals(driver.getTitle(), "https://www.stockmarketgame.org/pa.html");
        }
        if (i==2) {
            
            //Search Holdings
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.stockmarketgame.org/pa.html");
            assertEquals(driver.getTitle(), "https://www.stockmarketgame.org/pa.html");

        }
    }
    private boolean assertEquals(String text, String string) {
        if (text.equals(string)) {
            return true;
        }
        return false;
    }
    private WebDriver login() {
        
        EdgeOptions option = new EdgeOptions();
        option.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver/chromedriver.exe");
        driver = new EdgeDriver(option);
        driver.get("https://www.stockmarketgame.org/login.html");
        WebElement user = driver.findElement(By.xpath("/html/body/div/div/section/section/div/form/p[1]/input"));
        user.sendKeys("DE_78_A497");
        WebElement pass = driver.findElement(By.xpath("/html/body/div/div/section/section/div/form/p[2]/input[1]"));
        pass.sendKeys("XBYWVFZY");
        WebElement enter = driver.findElement(By.xpath("/html/body/div/div/section/section/div/form/p[3]/input"));
        enter.click();
        return driver;
    }
    
}
