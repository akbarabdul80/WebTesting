package pages

import org.openqa.selenium.WebDriver

class SearchResultPage(private val driver: WebDriver) {

    fun getTitle(): String {
        return driver.title
    }
}