
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestboxExample {
    WebDriver driver;
    @BeforeMethod
    public void OpenLinkTestPage()  {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }
    @Test
    public void textBoxTest(){
        //type your name
        WebElement name=driver.findElement(By.id("j_idt88:name"));
             name.sendKeys("Sandani Dhammage");

        //append country to this city
        WebElement appendText=driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //verify if textbox is disable
        boolean enabled=driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is textbox enabled"+enabled);

        //clear the type text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //retrieve the type text
        WebElement typeText=driver.findElement(By.id("j_idt88:j_idt97"));
        String value =typeText.getAttribute("value");
        System.out.println(value);

        //type email and tab
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("sandanid01@gmail.com"+ Keys.TAB+"Confirm control move to next element");
    }

    }
