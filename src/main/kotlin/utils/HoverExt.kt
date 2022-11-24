package utils

import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class HoverExt() {
    companion object {
        fun toHover(action: Actions, element: WebElement) {
            action.moveToElement(element).perform()
        }
    }

}