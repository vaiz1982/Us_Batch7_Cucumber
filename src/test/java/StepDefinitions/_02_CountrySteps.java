package StepDefinitions;

import Pages.DialogContent;
import Pages.Navigation;
import Utilities.MyMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _02_CountrySteps {

    DialogContent dc = new DialogContent();
    Navigation nv = new Navigation();
    @And("Navigate to Country page")
    public void navigateToCountryPage() {
        nv.clickMethod(nv.getSetupBtn());
        nv.clickMethod(nv.getParameterBtn());
        nv.clickMethod(nv.getCountriesBtn());
    }

    @When("Create a new country")
    public void createANewCountry() {
        dc.clickMethod(dc.getAddButton());
        dc.sendKeysMethod(dc.getFormNameInput(),"USA1");
        dc.sendKeysMethod(dc.getFormCodeInput(),"U1");
        dc.clickMethod(dc.getSaveButton());
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.getSuccessMessage(),"successfully");
    }

    @When("Delete country")
    public void deleteCountry() {
        dc.sendKeysMethod(dc.getCountryNameSearch(),"USA1");
        dc.sendKeysMethod(dc.getCountryCodeSearch(),"U1");
        dc.clickMethod(dc.getCountrySearchBtn());
        dc.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("ms-delete-button[class='ng-star-inserted']"),10));
        dc.clickMethod(dc.getDeleteCountryButton());
        dc.clickMethod(dc.getConfirmDeleteCountry());
    }
}