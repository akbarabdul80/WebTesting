package pages.the_internet.hovers

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions

class DragDropPage(val driver: WebDriver) {
    private var action: Actions = Actions(driver)
    private val content = By.id("content")
    private val columnA = By.id("column-a")
    private val columnB = By.id("column-b")

    fun dragAndDrop() {
        val from = driver.findElement(columnA)
        val to = driver.findElement(columnB)
        action.dragAndDrop(from, to).build().perform()
//        action.clickAndHold(from).moveToElement(to).release().build().perform()
//        val x: Int = from.location.x
//        val y: Int = to.location.y
//
//        val actions = Actions(driver)
//        actions.moveToElement(from)
//            .pause(1000)
//            .clickAndHold(from)
//            .pause(1000)
//            .moveToElement(to)
//            .pause(1000)
//            .release(to)
//            .build()
//            .perform()
    }
}