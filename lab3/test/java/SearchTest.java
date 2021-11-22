import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchTest extends BaseTest {
    @Test
    public void search() {
        driver.get("http://archive.org/");
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
        element.sendKeys("Kowalski, analysis");
        element.sendKeys(Keys.ENTER);

        assertDoesNotThrow(() -> driver.findElement(By.xpath("//h1/div")));
    }

    @Test
    public void searchFailed() {
        driver.get("http://archive.org/");
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
        element.sendKeys("asdasdg1v2312ads");
        element.sendKeys(Keys.ENTER);

        WebElement noResults = driver.findElement(By.xpath("//div[@class='no-results']"));
        assertNotNull(noResults);
    }
}
