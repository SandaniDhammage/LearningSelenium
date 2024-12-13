import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownExample {
    WebDriver driver;
    @BeforeMethod
    public void dropdownTestPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();


    }
    @Test
    public void leafgroundpageDropdownTest() throws InterruptedException {
        driver.get("https://www.leafground.com/select.xhtml");
        //ways of select values in basic dropdown
        WebElement dropdown=driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select=new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //noOf select options
        List<WebElement> options=select.getOptions();
        int listOfoptions=options.size();
        System.out.println(listOfoptions);
        for(WebElement element:options){
            System.out.println(element.getText());
        }
        //using sendkeys select dropdown values
        dropdown.sendKeys("Puppeteer");



        }
        @Test
    public void googleSearchDropdown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googleSearch=driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='wM6W7d']"));
        int sizeGoogle=googleSearch.size();
            System.out.println(sizeGoogle);
        for (WebElement google:googleSearch){
            System.out.println(google.getText());

        }
        }

    }



