import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }
    //take me to dashboard
    @Test
    public void LinkTest(){
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //find my destination
        WebElement wheretoGo=driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String path=wheretoGo.getAttribute("href");
        System.out.println("This link is going to "+ path);

        //Am I broken link
        WebElement brokenLink=driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title=driver.getTitle();
        if (title.contains("404")){
            System.out.println("The link is broken");
        }else{
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        //count page links
        List<WebElement> countLinks= driver.findElements(By.tagName("a"));
        int linkSize=countLinks.size();
        System.out.println("count of full page link"+linkSize);

        //count layout links
        WebElement layoutLinks=driver.findElement(By.className("layout-main-content"));
        List<WebElement>Links=layoutLinks.findElements(By.tagName("a"));
        int linkCount= Links.size();
        System.out.println("Layout Links"+linkCount);

        driver.quit();



    }



}
