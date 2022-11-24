package pages.form

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

class FormyComplateFormPage(val driver: WebDriver) {
    private val firstnameField = By.id("first-name")
    private val lastnameField = By.id("last-name")
    private val jobtitleField = By.id("job-title")
    private val dateField = By.id("datepicker")
    private val select = By.id("select-menu")
    private val submitBtn = By.linkText("Submit")

    fun inputFirstName(firstname: String) {
        driver.findElement(firstnameField).sendKeys(firstname)
    }

    fun inputLastName(lastname: String) {
        driver.findElement(lastnameField).sendKeys(lastname)
    }

    fun inputJobTitle(jobtitle: String) {
        driver.findElement(jobtitleField).sendKeys(jobtitle)
    }

    fun selectHighestEducation(educationID: String) {
        driver.findElement(By.id(educationID)).click()
    }

    fun selectSex(checkBoxID: String) {
        driver.findElement(By.id(checkBoxID)).click()
    }

    fun selectYearsOfExperience(text: String) {
        Select(driver.findElement(select)).selectByVisibleText(text)
    }

    fun inputDate(date: String) {
        driver.findElement(dateField).sendKeys(date)
    }

    fun clickSubmitBtn() {
        driver.findElement(submitBtn).click()
    }
}