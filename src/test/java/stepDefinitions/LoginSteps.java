package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver = Hooks.driver;

    @Given("saya berada di halaman login")
    public void saya_di_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("saya memasukkan username {string} dan password {string}")
    public void input_credentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("saya klik tombol login")
    public void klik_login() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("saya berhasil login ke halaman dashboard")
    public void berhasil_login() {
        driver.findElement(By.cssSelector(".flash.success"));
    }

    @Then("saya melihat pesan error {string}")
    public void melihat_pesan_error(String message) {
        driver.findElement(By.cssSelector(".flash.error")).getText().contains(message);
    }
}
