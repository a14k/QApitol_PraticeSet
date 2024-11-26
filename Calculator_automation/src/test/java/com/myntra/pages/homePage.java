package com.myntra.pages;

import com.myntra.testcases.homeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class homePage
{
    public AppiumDriver driver;
    public homePage(AppiumDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id ="com.myntra.android:id/closeDialog")
    public WebElement closeDiag;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"BANNER_2\"]/android.widget.ImageView")
    public WebElement image;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"TOPNAV_CAROUSEL_1_3\"])[1]/android.view.ViewGroup")
    public WebElement sweatshirt;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"text_brand\" and @text=\"Roadster \"]")
    public WebElement textBrand;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"buy_button\"]/android.view.ViewGroup")
    public WebElement buyButton;
    @FindBy(xpath = "//android.widget.TextView[@text=\"M\"]\n")
    public WebElement mSize;
    @FindBy(xpath = "//android.widget.TextView[@text=\"DONE\"]")
    public WebElement doneButton;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Go to Bag\"]\n")
    public WebElement goToBag;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"search\"]")
    public WebElement search;
    @FindBy(className = "android.widget.EditText")
    public WebElement searchBox;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"text_brand\" and @text=\"H&M \"]")
    public WebElement brand;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"image_image_container\"])[1]/android.view.ViewGroup/android.widget.ImageView")
    public WebElement imageContainer;
}
