package com.testdms.stepdefinitions;

import com.testdms.hooks.Hooks;
import com.testdms.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static LoginPage loginPage = new LoginPage();

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("Input url web dms {string}")
    public void input_url_web_dms(String url) {
        driver.get(url);
        extentTest.log(LogStatus.PASS, "Input url web lamar");
        Hooks.delay(1);
    }

    @Then("Menampilkan halaman login {string}")
    public void menampilkan_halaman_login(String expect) {
        Assert.assertTrue(loginPage.getTitlePage().contains(expect));
        Assert.assertEquals(loginPage.getTitlePage(), "Login");
    }

    @When("User input username {string}")
    public void user_input_username(String username) {
        loginPage.setTxtUsername(username);
        extentTest.log(LogStatus.PASS, "User input username");
    }

    @When("User input password {string}")
    public void user_input_password(String password) {
        loginPage.setTxtPassword(password);
        extentTest.log(LogStatus.PASS, "User input password");
    }

    @When("Klik tombol Sign In")
    public void klik_tombol_sign_in() {
        loginPage.clickBtnSignIn();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Klik Tombol Sign In");
    }

    @Then("Berhasil login dan menampilkan halaman home {string}")
    public void berhasil_login_dan_menampilkan_halaman_home(String txtDashboardPage) {
        if (txtDashboardPage.contains("Gagal!")) {
            Assert.assertTrue(loginPage.getTextInvalidCredentials().contains(txtDashboardPage));
            extentTest.log(LogStatus.PASS, "Wrong username or password!");
            Hooks.delay(1);
        } else if (txtDashboardPage.contains("true")) {
            Assert.assertTrue(loginPage.getRequired().contains(txtDashboardPage));
            extentTest.log(LogStatus.PASS, "Menampilkan pesan required");
        } else if (txtDashboardPage.contains("Dashboard")) {
            //driver.switchTo().alert().accept();
            Hooks.delay(2);
            Assert.assertTrue(loginPage.getTextDashboardPage().contains(txtDashboardPage));
            extentTest.log(LogStatus.PASS, "Menampilkan halaman home");
            Hooks.delay(1);
        }

    }
}
