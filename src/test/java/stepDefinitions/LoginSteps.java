package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver = Hooks.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("saya berada di halaman login")
    public void saya_di_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("saya memasukkan username {string} dan password {string}")
    public void input_credentials(String username, String password) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("saya klik tombol login")
    public void klik_login() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("saya berhasil login ke halaman dashboard")
    public void berhasil_login() {
        WebElement successMessage = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".flash.success"))
        );
        assertNotNull("Success message should be present", successMessage);
    }

    @Then("saya melihat pesan error {string}")
    public void melihat_pesan_error(String expectedMessage) {
        WebElement errorElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".flash.error"))
        );
        String actualMessage = errorElement.getText();
        assertTrue("Error message should contain: " + expectedMessage + ", but was: " + actualMessage,
                actualMessage.contains(expectedMessage));
    }
}
