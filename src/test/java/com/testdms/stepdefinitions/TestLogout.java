package com.testdms.stepdefinitions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testdms.hooks.Hooks;
import com.testdms.pages.LogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogout {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static LogoutPage logoutPage = new LogoutPage();

    public TestLogout(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik button logout")
    public void klik_button_logout() {
        logoutPage.klikBtnLogout();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Klik button logout");
    }

    @Then("Menampilkan halaman login")
    public void menampilkan_halaman_login() {
        Assert.assertTrue(logoutPage.getTextLogout().contains("DIKA | DOKUMEN"));
    }
}
