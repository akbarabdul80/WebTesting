package pages.the_internet.hovers

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class KeyPressesPage(val driver: WebDriver) {
    private val result = By.id("result")
    private val target = By.id("target")

    fun pressKey(key: Keys) {
        driver.findElement(target).sendKeys(key)
    }

    fun getTextResult(): String {
        return driver.findElement(result).text
    }
}