package pages.the_internet

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import pages.the_internet.hovers.DragDropPage
import pages.the_internet.hovers.HoverPage
import pages.the_internet.hovers.KeyPressesPage

class TheInternetHerokuappPage(val driver: WebDriver) {
    private val linkHovers = By.linkText("Hovers")
    private val linkDragDrop = By.linkText("Drag and Drop")
    private val linkKeyPresses = By.linkText("Key Presses")
    private val content = By.id("content")

    fun clickLinkHovers(): HoverPage {
        driver.findElement(linkHovers).click()

        WebDriverWait(driver, 60)
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(content)))

        return HoverPage(driver)
    }

    fun clickLinkDragDrop(): DragDropPage {
        driver.manage().window().maximize()
        driver.findElement(linkDragDrop).click()

        WebDriverWait(driver, 60)
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(content)))

        return DragDropPage(driver)
    }

    fun clickKeyPresses(): KeyPressesPage {
        driver.manage().window().maximize()
        driver.findElement(linkKeyPresses).click()

        WebDriverWait(driver, 60)
            .until(ExpectedConditions.elementToBeClickable(driver.findElement(content)))

        return KeyPressesPage(driver)
    }

}