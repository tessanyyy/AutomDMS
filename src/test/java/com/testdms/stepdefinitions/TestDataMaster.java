package com.testdms.stepdefinitions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.source.tree.IfTree;
import com.testdms.hooks.Hooks;
import com.testdms.pages.DataMaster;
import com.testdms.pages.LogoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestDataMaster {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static DataMaster dataMaster = new DataMaster();
    public static LogoutPage logoutPage = new LogoutPage();

    public TestDataMaster() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("klik Data master")
    public void klik_data_master() {
        dataMaster.clickDataMaster();
        Hooks.delay(5);
        extentTest.log(LogStatus.PASS, "klik Data master");
    }

    @Then("klik departemen")
    public void klik_departemen() {
        dataMaster.clickbtnDepartemen();
        extentTest.log(LogStatus.PASS, "klik departemen");
    }

    //SeacrhDataDepartemen
    @When("input data search departemen")
    public void input_data_search_departemen() {
        dataMaster.setInputDeptSearch("IT Programmer");
        extentTest.log(LogStatus.PASS, "input data search departemen");
    }

    @And("klik search")
    public void klik_search() {
        dataMaster.clickbtnSearch();
        extentTest.log(LogStatus.PASS, "klik search");
    }

    @Then("menampilkan data departemen")
    public void menampilkan_data_departemen() {
        dataMaster.getTxtDeptSearch();
        Assert.assertEquals(dataMaster.getTxtDeptSearch(), "IT Programmer");
    }

    //InputDataDepartemenValid
    @When("user klik input data departemen")
    public void user_klik_input_data_departemen() {
        dataMaster.clickbtnInputDataDept();
        extentTest.log(LogStatus.PASS, "user klik input data departemen");
    }

    @And("user mengisi data departemen {string}")
    public void user_mengisi_data_departemen(String Departemen) {
        dataMaster.setInputAddDept(Departemen);
        extentTest.log(LogStatus.PASS, "user mengisi data departemen");
    }

    @And("user klik simpan add departemen")
    public void user_klik_simpan_add_departemen() {
        dataMaster.clickbtnAddDept();
        extentTest.log(LogStatus.PASS, "user klik simpan add departemen");
    }

    @Then("data departemen ditambahkan {string} {string}")
    public void data_departemen_ditambahkan(String type, String departement) {
        if (type.contains("positif")) {
            dataMaster.setInputDeptSearch("Juara Coding");
            dataMaster.clickbtnSearch();
            Assert.assertTrue(dataMaster.getTxtAddDeptValid().contains(departement));
            extentTest.log(LogStatus.FAIL, "data departemen ditambahkan");
        } else {
            Assert.assertEquals(dataMaster.getTxtAddDeptInvalid(),(""));
            extentTest.log(LogStatus.FAIL, "Menambahkan data departemen Invalid");
        }
    }

}

