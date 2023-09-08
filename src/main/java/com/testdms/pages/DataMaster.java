package com.testdms.pages;


import com.testdms.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataMaster {
    private final WebDriver driver;

    public DataMaster(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='pull-right-container']")
    WebElement menuDataMaster;

    @FindBy(xpath = "//a[normalize-space()='Departemen']")
    WebElement menuDepartemen;

    @FindBy(xpath = "//input[@name='katakunci']")
    WebElement inputDeptSearch;

    @FindBy(xpath = "//i[@class='glyphicon glyphicon-search']")
    WebElement btnSearch;

    @FindBy(xpath = "//td[normalize-space()='IT Programmer']")
    WebElement txtDeptSearch;

    @FindBy(xpath = "//button[normalize-space()='Input Data']")
    WebElement btnInputDataDept;

    @FindBy(xpath = "//input[@id='nama']")
    WebElement inputAddDept;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
     public WebElement addDeptInvalid;

    @FindBy(xpath = "//button[@id='adddept']")
    WebElement btnAddDept;

    @FindBy(xpath = "//td[normalize-space()='Juara Coding']")
    WebElement txtAddDeptValid;

    public void clickDataMaster(){
        menuDataMaster.click();
    }

    public void clickbtnDepartemen(){
        menuDepartemen.click();
    }

    public void setInputDeptSearch(String deptSearch) {
        this.inputDeptSearch.sendKeys(deptSearch);
    }

    public void clickbtnSearch(){
        btnSearch.click();
    }

    public String getTxtDeptSearch(){
        return txtDeptSearch.getText();
    }

    public void clickbtnInputDataDept(){
        btnInputDataDept.click();
    }

    public void clickbtnAddDept(){
        btnAddDept.click();
    }

    public void setInputAddDept(String addDept) {
        this.inputAddDept.sendKeys(addDept);
    }

    public String getTxtAddDeptValid(){
        return txtAddDeptValid.getText();
    }

    public String getTxtAddDeptInvalid(){
        return txtAddDeptValid.getText();
    }


}
