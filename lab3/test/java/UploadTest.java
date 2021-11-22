import io.github.sukgu.Shadow;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class UploadTest extends BaseTest {
    @Test()
    public void uploadFailed() {
        driver.get("http://archive.org/");

        Shadow shadow = new Shadow(driver);
        WebElement pro_element = shadow.findElement("a[href='https://archive.org/create']");
        pro_element.click();

        assertThrows(NoSuchElementException.class, () -> {
            WebElement element = driver.findElement(By.xpath("a[href='/upload']"));
            element.click();
        });
    }

    @Test()
    public void uploadPassed() {
        driver.get("http://archive.org/");

        Shadow shadow = new Shadow(driver);
        WebElement pro_element = shadow.findElement("login-button>div>span>a[href='https://archive.org/account/login']");
        pro_element.click();

        Actions actions = new Actions(driver);

        WebElement elementName = driver.findElement(By.xpath("//input[@name='username']"));
        actions.moveToElement(elementName).perform();
        elementName.click();
        elementName.sendKeys("cloud9nine@yandex.ru");

        WebElement elementPassword = driver.findElement(By.xpath("//input[@name='password']"));
        actions.moveToElement(elementPassword).perform();
        elementPassword.click();
        elementPassword.sendKeys("********");

        WebElement elementSubmit = driver.findElement(By.xpath("//input[@name='submit-to-login']"));
        actions.moveToElement(elementSubmit).perform();
        elementSubmit.click();

        WebElement element1 = shadow.findElement("a[href='https://archive.org/create']");
        element1.click();

        WebElement element = shadow.findElement("a[href='/upload']");
        element.click();

        WebElement upload = driver.findElement(By.xpath("//div[@class='table drag_target']/div/div[@class='hidden']/input"));
        upload.sendKeys("D:\\Dev\\Projects\\warlocks\\assets\\textures\\mainmenu.png");

        WebElement descp = driver.findElement(By.xpath("//span[@title='Add a description of the item page']"));
        descp.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='javascript:false;']")));

        WebElement descp_text = driver.findElement(By.xpath("//body"));
        descp_text.click();
        descp_text.sendKeys("mainmenu description");

        driver.switchTo().parentFrame();

        WebElement tags = driver.findElement(By.xpath("//span[@title='Add keywords, separated by commas']"));
        tags.click();

        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Add keywords, separated by commas']"));
        input.sendKeys("mainmenu, png");

        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        actions.moveToElement(submit).perform();
        submit.click();

        WebElement stat = driver.findElement(By.xpath("//body[@class='navia']/div[@style='top: 52.5px; left: 377.5px;']"));

        assertNotNull(stat);
    }
}
