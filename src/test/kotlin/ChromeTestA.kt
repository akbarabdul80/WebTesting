import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import kotlin.test.assertEquals

class ChromeTestA {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            WebDriverManager.firefoxdriver().setup()
        }
    }

    private val webDriver: WebDriver by lazy {
        FirefoxDriver()
    }

    @Test
    fun test() {
        // Exercise
        webDriver.get("https://the-internet.herokuapp.com/")
        val title: String = webDriver.title
        println(title)

        // Verify
        assertEquals("The Internet", title)

        webDriver.findElement(By.cssSelector("a")).click()
        val element = webDriver.findElement(By.linkText("Shifting Content"))
        element.click()
        val element2 = webDriver.findElement(By.linkText("Example 2: An image" + Keys.ENTER)).click()

//        val elms = webDriver.findElements(By.cssSelector("li"))
//        elms[0].click()
//        elms.forEach {
//            println(it.text)
//        }
//        webDriver.quit()
    }


}