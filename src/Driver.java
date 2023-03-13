import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
WebDriver driver;
    public Driver(int i) {
        if (i==1) {
           WebDriver driver =login(); 
        }
    }
    private WebDriver login() {
        ChromeOptions option = new ChromeOptions();
       // option.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(option);
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
