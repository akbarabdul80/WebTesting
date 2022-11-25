package pages.the_internet.hovers

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class HoverPage(private val driver: WebDriver) {
    private var action: Actions = Actions(driver)
    private val imageFigure = By.className("figure")
    private val figcaption = By.className("figcaption")
    private val h5 = By.tagName("h5")


    // max index == 2
    fun hoverImage(index: Int) {
        toHover(driver.findElements(imageFigure)[index])
    }

    fun getNameCationFigure(): String {
        driver.findElements(figcaption).forEach {
            if (it.isDisplayed) {
                return it.findElement(h5).text
            }
        }

        return ""
    }

    private fun toHover(element: WebElement) {
        action.moveToElement(element).perform()
    }
}