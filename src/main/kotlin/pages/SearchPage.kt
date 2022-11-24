package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SearchPage(private var driver: WebDriver) {
    private val searchField: By = By.name("q")
    private val button: By = By.name("btnK")

    fun searchFor(searchTerm: String) {
        driver.findElement(searchField).sendKeys(searchTerm)
    }

    fun clickButtonSearch() {
//        searchFor("Akbar")
        driver.findElement(button).click()
//        return SearchResultPage(driver)
    }

    fun getSearchResult(): String {
        return driver.findElement(By.id("result-stats")).text
    }
}