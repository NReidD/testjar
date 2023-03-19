import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver {
WebDriver driver;
    public Driver() {
        
        
    }
    boolean protocol(int i, Stock s, int shares,String extraargs, String extraargs2) throws IOException, InterruptedException {
        if (i==1) {
            driver = login();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.stockmarketgame.org/pa.html");
            assertEquals(driver.getTitle(), "https://www.stockmarketgame.org/pa.html");
        }
        if (i==10) {
            System.out.println("Right");
            EdgeOptions option = new EdgeOptions();
        option.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","./resources/chromedriver/chromedriver.exe");
        driver = new EdgeDriver(option);
            driver.get("https://www.stockmarketgame.org/login.html");
            WebElement user = driver.findElement(By.xpath("/html/body/div/div/section/section/div/form/p[1]/input"));
            user.sendKeys(extraargs);
            WebElement pass = driver.findElement(By.xpath("/html/body/div/div/section/section/div/form/p[2]/input[1]"));
            pass.sendKeys(extraargs2);
            WebElement enter = driver.findElement(By.xpath("/html/body/div/div/section/section/div/form/p[3]/input"));
            enter.click();
            Thread.sleep(500);
            if (driver.getCurrentUrl().equals("https://www.stockmarketgame.org/pa.html")) {
               return true; 
            }
        }
        if (i==2) {
            driver = login();

            System.out.println("Wpot");
            //Search Holdings
            /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.stockmarketgame.org/ahold.html");
            assertEquals(driver.getTitle(), "https://www.stockmarketgame.org/ahold.html");
            WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div/section/section/div/div[4]/div/div/div[1]/table/tbody"));
            ArrayList<String> datas = new ArrayList<String>();
            // Now get all the TR elements from the table
            List<WebElement> allRows = table.findElements(By.tagName("tr"));
            // And iterate over them, getting the cells
            for (WebElement row : allRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                
                for (WebElement cell : cells) {
                    System.out.println("content >>   " + cell.getText());
                    datas.add(cell.getText());
                }
            }
            for (int j = 0; j < datas.size(); j=j+11) {
                File newfile = new File("stocks/"+datas.get(j)+".xlsx");
                Scribe maker = new Scribe(newfile);
                
                maker.create();
            
            }
            */driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.stockmarketgame.org/tnotes.html");
            assertEquals(driver.getTitle(), "https://www.stockmarketgame.org/tnotes.html");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement pages = driver.findElement(By.xpath("//*[@id=\"dvData\"]/div/div[2]"));

            List<WebElement> pagesNum = pages.findElements(By.tagName("a"));

            WebElement pagess = driver.findElement(By.xpath("//*[@id=\"dvData\"]/div/div[2]"));
            List<WebElement> pagesNums = pages.findElements(By.xpath("/html/body/div[1]/div/section/section/div/div[3]/div/div/div[2]/div[2]"));
            for (int o = 0; o< 18; o++) {
                WebElement table2 = driver.findElement(By.xpath("//*[@id=\"dvData\"]/div/div[1]/table/tbody"));
            List<WebElement> rowsNumber = table2.findElements(By.tagName("tr"));
            int rowCount = rowsNumber.size();
            
            for (WebElement webElemnt : rowsNumber) {
                Thread.sleep(50);
                System.out.println(webElemnt.getText());
                newEntry(webElemnt.getText());
            }
            System.out.println("No of rows in this table : " + rowCount);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            if (i==2) {
                pagesNums = pages.findElements(By.xpath("/html/body/div[1]/div/section/section/div/div[3]/div/div/div[2]/div[2]"));

                
            }
            pagesNums.get(0).click();   
            assertEquals(driver.getTitle(), "https://www.stockmarketgame.org/tnotes.html");
            }

                
        }
        return false;
    }
    private void newEntry(String text) throws IOException, InterruptedException {
        String[] variables = text.split(" ");
        System.out.println(variables.toString());
            System.out.println(variables.length);
        if (variables[0].equals("INTCRD")||variables[0].equals("INTDEB")) {
            
        }
        else{
            StringBuilder checker = new StringBuilder();
            for (String string : variables) {
                checker.append(string);
            }
            String end = checker.toString();
            if (end.contains("Executed")) {
                
            
            String action = variables[0];
            String ticker = variables[1];
            String shares = variables[2];
            String orderType = variables[3];
            String tradeDay = variables[4];
            String tradeTime = variables[5];
            String Confirmation = variables[6];
            String price;
            if (shares.contains("$")) {
                 price = shares;

            } else {
                 price = variables[9];
                price = price.replace("price=$", "");

            }
            String value = variables[8];
            int commission = 5;
            Stock stock = new Stock(ticker);
            String newprice = String.valueOf((int)stock.price);
if (new File("stocks/"+ticker+".xlsx").exists()) {
    Scribe scribe = new Scribe(new File("stocks/"+ticker+".xlsx"));
    Object[] newVars = new Object[7];
    newVars[0] = action;
    newVars[1] = ticker;
    newVars[2] = shares;
    
    newVars[03] = tradeDay;
    newVars[04] = tradeTime;
    newVars[05] = price;
    newVars[6] = commission;

    
    scribe.writeTo(newVars);
} else {
    Scribe scribe = new Scribe(new File("stocks/"+ticker+".xlsx"));
scribe.create();

Object[] newVars = new Object[7];
newVars[0] = action;
    newVars[1] = ticker;
    newVars[2] = shares;
    
    newVars[03] = tradeDay;
    newVars[04] = tradeTime;
    newVars[05] = price;
    newVars[6] = commission;
scribe.writeTo(newVars);
}
}

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
