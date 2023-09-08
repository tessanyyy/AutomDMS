package com.testdms.pages;

import com.testdms.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement txtUsername;
    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnSignIn;
    @FindBy(xpath = "//span[@class='pull-right-container']")
    public WebElement menuDataMaster;
    public void clickDataMaster(){
        menuDataMaster.click();
    }
    @FindBy(xpath = "//h1[normalize-space()='Home']")
    WebElement txtDashboardPage;
    @FindBy(xpath = "//div[@class='brand']")
    WebElement txtLoginPage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissable']")
    WebElement invalidCredentials;

    @FindBy(xpath = "//a[normalize-space()='Departemen']")
    WebElement menuDepartemen;

    public void clickbtnDepartemen(){
        menuDepartemen.click();
    }


    public void setTxtUsername(String username) {
        this.txtUsername.clear();
        this.txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password) {
        this.txtPassword.clear();
        this.txtPassword.sendKeys(password);
    }

    public void clickBtnSignIn() {
        this.btnSignIn.click();
    }

    public void loginUser(String username, String password) {
        this.txtUsername.sendKeys(username);
        this.txtPassword.sendKeys(password);
        this.btnSignIn.click();
    }
    public String getTextInvalidCredentials(){
        return this.invalidCredentials.getText();
    }
    public String getTextDashboardPage() {
        return this.txtDashboardPage.getText();
    }

    public String getTxtLoginPage(){
        return txtLoginPage.getText();
    }

    public String getTitlePage() {
        String resultTitle= "";
        String titlePageNotFound= driver.getTitle();
        String titlePageLogin = driver.getTitle();
        if (titlePageNotFound.contains("Not Found")) {
            resultTitle = titlePageNotFound;
        }
        else if (titlePageLogin.contains("Home")) {
            resultTitle = titlePageLogin;
        }
        return resultTitle;
    }
    public String getRequired(){
        return this.txtUsername.getAttribute("required");
    }
}
