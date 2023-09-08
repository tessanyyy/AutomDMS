package com.testdms.stepdefinitions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testdms.hooks.Hooks;
import com.testdms.pages.Home;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestHome {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static Home home = new Home();

    public TestHome(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("user klik more info internal")
    public void user_klik_more_info_internal() {
        home.setBtnInternal();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "User klik more info internal");
    }

    @Then("menampilkan halaman internal")
    public void menampilkan_halaman_internal() {
        home.getTxtInternal();
        Assert.assertEquals(home.getTxtInternal(), "Dokumen Internal");
    }

    @When("user klik tab home eksternal")
    public void user_klik_tab_home_eksternal() {
        home.setBtnHome();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "User klik tab home eksternal");
    }

    @And("user klik more info eksternal")
    public void user_klik_more_info_eksternal(){
        home.setBtnExternal();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "User klik more info eksternal");
    }

    @Then("menampilkan halaman eksternal")
    public void menampilkan_halaman_eksternal(){
        home.getTxtEksternal();
        Assert.assertEquals(home.getTxtEksternal(), "Dokumen Eksternal");
    }

    @When("user klik tab home perizinan")
    public void user_klik_tab_home_perizinan() {
        home.setBtnHome();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "User klik tab home perizinan");
    }

    @And("user klik more info perizinan")
    public void user_klik_more_info_perizinan(){
        home.setBtnPerizinan();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "User klik more info perizinan");
    }

    @Then("menampilkan halaman perizinan")
    public void menampilkan_halaman_perizinan(){
        home.getTxtPerizinan();
        Assert.assertEquals(home.getTxtPerizinan(), "Perizinan");
    }
}
