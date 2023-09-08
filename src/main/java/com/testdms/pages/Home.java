package com.testdms.pages;

import com.testdms.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    private final WebDriver driver;

    public Home(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class='small-box bg-aqua'] a[class='small-box-footer']")
    WebElement btnInternal;

    @FindBy (xpath = "//span[normalize-space()='Home']")
    WebElement btnHome;

    @FindBy (css = "div[class='small-box bg-green'] a[class='small-box-footer']")
    WebElement btnExternal;

    @FindBy (css = "div[class='small-box bg-yellow'] a[class='small-box-footer']")
    WebElement btnPerizinan;

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/ol/li[2]")
    WebElement txtInternal;

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/ol/li[2]")
    WebElement txtEksternal;

    @FindBy(xpath = "/html/body/div[1]/div/section[1]/ol/li[2]")
    WebElement txtPerizinan;

    public void setBtnInternal(){
        btnInternal.click();}
    public void setBtnExternal(){
        btnExternal.click();}
    public void setBtnHome(){
        btnHome.click();}
    public void setBtnPerizinan(){
        btnPerizinan.click();}

    public String getTxtInternal(){
        return txtInternal.getText();
    }
    public String getTxtEksternal(){
        return txtEksternal.getText();
    }
    public String getTxtPerizinan(){
        return txtPerizinan.getText();
    }
}
