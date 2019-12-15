package stepsDefinitions;

import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RegisterStep extends BasePage {

    HomePage home = new HomePage(getDriver());
    LoginPage login = new LoginPage();

    @Given("user is on Home Page")
    public void userIsOnHomePage() {
        getDriver();
    }

    @When("he clicks to register on the site")
    public void heClicksToRegisterOnTheSite() {
        home.clickOn_LoginOrRegister();

    }

    @When("choose the correct option for register")
    public void chooseTheCorrectOptionForRegister() {
        home.clickOn_RegisterModal();
    }

    @When("he clicks on Cadastrar")
    public void heClicksOnCadastrar() {
        alterPage();
        waitObject(3000);
        login.clickOnRegister();
    }


    @When("enter the required data")
    public void enterTheRequiredData() {
        login.writeName();
        login.writeLastName();
        login.writeEmail();
        login.writePassowrd();
        login.writePassowrd2();
        login.writeCPF();
        login.clickFemale();
        login.writeDate();
        login.writePhone();
        login.writeCEP();
        login.writeNumber();
        login.writeTelephone();
        login.clickButtonFinish();
    }

    @Then("user is registered")
    public void userIsRegistered() {
        login.showSucessMessage();
        waitObject(18000);
        killDriver();
    }

    @When("enter the required data with an existing email")
    public void enterTheRequiredDataWithAnExistingEmail() {
        login.writeName();
        login.writeLastName();
        login.useExistingEmail();
        login.writePassowrd();
        login.writePassowrd2();
        login.writeCPF();
        login.clickFemale();
        login.writeDate();
        login.writePhone();
        login.writeCEP();
        login.writeNumber();
        login.writeTelephone();
        login.clickButtonFinish();
    }

    @Then("then the error message is displayed")
    public void thenTheErrorMessageIsDisplayed() {
        login.showErrorMessage();
        waitObject(3000);
        killDriver();
    }


}
