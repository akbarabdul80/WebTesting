package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.w3c.dom.Text

class LoginPage(val webDriver: WebDriver) {

    private val usernameField = By.id("user-name")
    private val passwordField = By.id("password")
    private val loginButton = By.id("login-button")

    fun inputLogin(username: String, password: String) {
        webDriver.findElement(usernameField).sendKeys(username)
        webDriver.findElement(passwordField).sendKeys(password)
    }

    fun btnClick(): ProductPage {
        webDriver.findElement(loginButton).click()
        return ProductPage(webDriver)
    }

    fun btnLoginVisible(): Boolean {
        return WebDriverWait(webDriver, 10)
            .until(ExpectedConditions.elementToBeClickable(webDriver.findElement(loginButton))).isDisplayed
    }

    fun getErrorText(): String {
        return WebDriverWait(webDriver, 10)
            .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.tagName("h3")))).text
    }
}