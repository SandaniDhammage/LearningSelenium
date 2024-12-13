import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");

    }
    @Test
    public void ButtonTest(){
        //click and confirm element
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle="Dashboard";
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected title");
        }else{
            System.out.println("Actual title not same as expected title");
        }
        driver.navigate().back();
        //find the position of submit button
        WebElement position = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = position.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is "+x + "Y position is"+y);

        //find the save button color
        WebElement buttonColor=driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println(color);

        //find the hight and width
        WebElement size=driver.findElement(By.id("j_idt88:j_idt98"));
        int height=size.getSize().getHeight();
        int width=size.getSize().getWidth();
        System.out.println("button height"+height+"button width"+width);
    }
}
