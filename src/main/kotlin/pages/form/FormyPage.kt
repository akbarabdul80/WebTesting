package pages.form

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import java.lang.Thread.sleep

class FormyPage(private val driver: WebDriver) {
    private val linkForm = By.linkText("Complete Web Form")

    fun clickLinkForm(): FormyComplateFormPage {
        driver.findElement(linkForm).click()
        sleep(2000)
        return FormyComplateFormPage(driver)
    }
}