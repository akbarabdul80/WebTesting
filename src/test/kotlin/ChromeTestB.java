import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ChromeTestB {
    private WebDriver driver;

    @Test
    public void test() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> vals = driver.findElements(By.cssSelector("li"));
        for (WebElement val : vals) {
            System.out.println(val.getText());
        }
        driver.quit();
    }
}
