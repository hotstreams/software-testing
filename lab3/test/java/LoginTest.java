import io.github.sukgu.Shadow;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void login() throws InterruptedException {
        driver.get("http://archive.org/");

        Shadow shadow = new Shadow(driver);
        WebElement pro_element = shadow.findElement("login-button>div>span>a[href='https://archive.org/account/login']");
        pro_element.click();

        Actions actions = new Actions(driver);

        WebElement elementName = driver.findElement(By.xpath("//input[@name='username']"));
        actions.moveToElement(elementName).perform();
        elementName.click();
        elementName.sendKeys("***@yandex.ru");

        WebElement elementPassword = driver.findElement(By.xpath("//input[@name='password']"));
        actions.moveToElement(elementPassword).perform();
        elementPassword.click();
        elementPassword.sendKeys("********");

        WebElement elementSubmit = driver.findElement(By.xpath("//input[@name='submit-to-login']"));
        actions.moveToElement(elementSubmit).perform();
        elementSubmit.click();

        Thread.sleep(5000);

        WebElement login_title = shadow.findElement("span[class='username']");

        assertEquals("LAB3TEST", login_title.getText());
    }

    @Test
    public void loginFailed() {
        driver.get("http://archive.org/");

        Shadow shadow = new Shadow(driver);
        WebElement pro_element = shadow.findElement("login-button>div>span>a[href='https://archive.org/account/login']");
        pro_element.click();

        Actions actions = new Actions(driver);

        WebElement elementName = driver.findElement(By.xpath("//input[@name='username']"));
        actions.moveToElement(elementName).perform();
        elementName.click();
        elementName.sendKeys("****@yandex.ru");

        WebElement elementPassword = driver.findElement(By.xpath("//input[@name='password']"));
        actions.moveToElement(elementPassword).perform();
        elementPassword.click();
        elementPassword.sendKeys("123123123");

        WebElement elementSubmit = driver.findElement(By.xpath("//input[@name='submit-to-login']"));
        actions.moveToElement(elementSubmit).perform();
        elementSubmit.click();

        assertDoesNotThrow(() -> driver.findElement(By.xpath("//span[@class='login-error password-error']")));
    }
}
