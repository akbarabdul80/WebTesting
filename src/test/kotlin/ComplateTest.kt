import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import pages.form.FormyPage
import kotlin.test.assertEquals

class ComplateTest {
    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            WebDriverManager.firefoxdriver().setup()
        }
    }

    private val webDriver: WebDriver by lazy {
        FirefoxDriver()
    }

    @Test
    fun formTest() {
        // Exercise
        webDriver.get("https://formy-project.herokuapp.com")
        val formlyPage = FormyPage(webDriver)

        val completeForm = formlyPage.clickLinkForm()
        completeForm.inputFirstName("John")
        completeForm.inputLastName("Smith")
        completeForm.inputJobTitle("QA")
        completeForm.selectHighestEducation("radio-button-2")
        completeForm.selectSex("checkbox-1")
        completeForm.selectYearsOfExperience("0-1")
        completeForm.inputDate("01/01/2022")
        completeForm.clickSubmitBtn()

        assertEquals("https://formy-project.herokuapp.com/thanks", webDriver.currentUrl)
        webDriver.close()
    }
}