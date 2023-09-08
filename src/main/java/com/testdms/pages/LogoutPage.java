package com.testdms.pages;

import com.testdms.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='Logout']")
    WebElement btnLogout;

    @FindBy(xpath = "//b[normalize-space()='DIKA | DOKUMEN']")
    WebElement txtLogout;

    public void klikBtnLogout(){
        btnLogout.click();
    }
    public String getTextLogout(){
        return this.txtLogout.getText();
    }
}
