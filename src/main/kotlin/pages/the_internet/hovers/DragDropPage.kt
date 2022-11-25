package pages.the_internet.hovers

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

class DragDropPage(private val driver: WebDriver) {
    private var action: Actions = Actions(driver)
    private val columnA = By.id("column-a")
    private val columnB = By.id("column-b")

    fun dragAndDrop() {
        val from = driver.findElement(columnA)
        val to = driver.findElement(columnB)
        action.dragAndDrop(from, to).build().perform()
    }
}