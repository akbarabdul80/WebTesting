import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import pages.SearchPage
import pages.the_internet.TheInternetHerokuappPage
import kotlin.test.assertEquals

class InternerHorokuappTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            WebDriverManager.chromedriver().setup()
        }
    }

    private val webDriver: WebDriver by lazy {
        ChromeDriver()
    }

    @AfterEach
    fun tearDown() {
        webDriver.quit()
    }

    @BeforeEach
    fun setUp() {
        webDriver.get("https://the-internet.herokuapp.com/")
    }

    @Test
    fun hover() {
        val internetHeroku = TheInternetHerokuappPage(webDriver)
        val hoverPage = internetHeroku.clickLinkHovers()
        hoverPage.hoverImage(1)

        assertEquals("name: user2", hoverPage.getNameCationFigure())
    }

    @Test
    fun testDragDrop() {
        val internetHeroku = TheInternetHerokuappPage(webDriver)
        val dragDropPage = internetHeroku.clickLinkDragDrop()
        dragDropPage.dragAndDrop()
    }

    @Test
    fun testKeyPresses() {
        val internetHeroku = TheInternetHerokuappPage(webDriver)
        val keyPressesPage = internetHeroku.clickKeyPresses()
        keyPressesPage.pressKey(Keys.SHIFT)
        assertEquals("You entered: SHIFT", keyPressesPage.getTextResult())
    }
}