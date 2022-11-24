import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.LoginPage
import java.time.Duration
import kotlin.math.log
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LoginTest {

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
        webDriver.get("https://www.saucedemo.com/")

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user")
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce")
        webDriver.findElement(By.id("login-button")).click()

        // Verify
        assertEquals("PRODUCTS", webDriver.findElement(By.className("title")).text)

        webDriver.close()
    }


    @Test
    fun loginFailed() {
        // Exercise
        webDriver.get("https://www.saucedemo.com/")

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user")
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce1")
        webDriver.findElement(By.id("login-button")).click()

        val wait: WebElement = WebDriverWait(webDriver, 2)
            .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.tagName("h3"))))

        // Verify
        assertEquals("Epic sadface: Username and password do not match any user in this service", wait.text)

        webDriver.close()
    }

    @Test
    fun loginFailed2() {
        // Exercise
        webDriver.get("https://www.saucedemo.com/")

        val loginPage = LoginPage(webDriver)
        loginPage.inputLogin("standard_user", "secret_sauce1")
        loginPage.btnClick()

        val errorText = loginPage.getErrorText()

        assertEquals("Epic sadface: Username and password do not match any user in this service", errorText)
        webDriver.close()
    }

    @Test
    fun logout() {
        // Exercise
        webDriver.get("https://www.saucedemo.com/")

        var loginPage = LoginPage(webDriver)
        loginPage.inputLogin("standard_user", "secret_sauce")

        val product = loginPage.btnClick()

        loginPage = product.logout()

        assertTrue(loginPage.btnLoginVisible())
    }
}