import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import pages.SearchPage
import kotlin.test.assertEquals

class SearchTest {

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
        webDriver.get("https://www.google.com/")
        val searchPage = SearchPage(webDriver)

        searchPage.searchFor("Selenium")
        val searchResultPage = searchPage.clickButtonSearch()

        // Verify
//        assertEquals("Google", searchResultPage.getTitle())

//        webDriver.close()
    }
}