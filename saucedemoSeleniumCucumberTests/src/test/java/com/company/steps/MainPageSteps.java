package com.company.steps;

import com.company.pages.InventoryPage;
import com.company.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageSteps {
    private MainPage mainPage;
    private InventoryPage inventoryPage;

    public MainPageSteps() {
        mainPage = new MainPage();
        inventoryPage = new InventoryPage();
    }

    @Given("Go to the home page")
    public void goToTheHomePage() {
        mainPage.goToPage();
    }

    @And("User login with username {string} and password as {string}")
    public void theUserProvidesTheUsernameAsAndPasswordAs(String username, String password) {
        mainPage.login(username, password);
    }

    @Then("The user should login successfully and is on the inventory page")
    public void theUserShouldLoginSuccessfullyAndIsOnTheInventoryPage() {
        assertTrue(inventoryPage.browserIsOnThePage());
    }

    @Then("The error should appear")
    public void theUserShouldLoginUnsuccessfully() {
        assertTrue(mainPage.getErrorText().equals("Epic sadface: Username and password do not match any user in this service"));
    }

    @And("User logouts")
    public void theUserLogouts() {
        inventoryPage.goToMenu();
        inventoryPage.logout();
    }

    @Then("User is back on the home page")
    public void UserIsBack() {
        assertTrue(mainPage.browserIsOnThePage());
    }

    @Then("Menu bar contains '4' options")
    public void FourOptions(){
        inventoryPage.goToMenu();
        inventoryPage.fourOptions();

    }


}
