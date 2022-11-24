package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class ProductPage(private val webDriver: WebDriver) {
    private val titleField: By = By.className("title")
    private val btnLogout: By = By.id("logout_sidebar_link")
    private val btnSidebar: By = By.id("react-burger-menu-btn")

    fun getTitle(): String {
        return webDriver.findElement(titleField).text
    }

    fun logout() : LoginPage {
        WebDriverWait(webDriver, 10)
            .until(ExpectedConditions.elementToBeClickable(webDriver.findElement(btnSidebar))).click()

        webDriver.findElement(btnLogout).click()
        return LoginPage(webDriver)
    }
}