package com.company.pages;

import com.company.utils.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    public static String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement inventory;

    @FindBy(id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "reset_sidebar_link")
    private WebElement reset;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    public WebDriver driver;

    public InventoryPage() {
        driver = DriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public InventoryPage goToPage() {
        driver.get(inventoryPageUrl);
        return this;
    }

    public boolean browserIsOnThePage() {
        return this.driver.getCurrentUrl().equals(this.inventoryPageUrl);
    }

    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        logout.click();
    }


    public void goToMenu(){
        menu.click();
    }
    public void fourOptions(){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(logout));
        wait.until(ExpectedConditions.visibilityOf(inventory));
        wait.until(ExpectedConditions.visibilityOf(about));
        wait.until(ExpectedConditions.visibilityOf(reset));

        //return logout, inventory, reset, about
    }

}
