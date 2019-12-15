package pageObjects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.Set;

public class LoginPage extends BasePage {

    public void clickOnRegister() {
            click(By.xpath("//a[contains(@href, 'registro')]"));
    }

    public void writeName(){
        writeElements(By.id("InputNome1"),"Ana");
    }

    public void writeLastName(){
        writeElements(By.id("InputSobrenome1"),"Automatizado");
    }

    public void writeEmail(){
        writeElements(By.id("InputEmail1"),writeFileEmail());

    }

    public void writePassowrd(){
        writeElements(By.id("InputSenha1"),"123456");
    }

    public void writePassowrd2(){
        writeElements(By.id("InputConfirmeSenha1"),"123456");
    }

    public void writeCPF(){
        writeElements(By.id("InputCpf1"),generateStringCPF());
    }

    public void clickFemale(){
        click(By.xpath("//label[@for = 'RadioFeminino1']"));
    }

    public void writeDate(){
        writeElements(By.id("InputDataNascimento1"),"23/05/1995");
    }

    public void writePhone(){
        writeElements(By.id("InputCelular1"),"99999999999");
    }

    public void writeCEP(){
        writeElements(By.id("InputCep1"),"38405142");

    }

    public void writeNumber(){
        click(By.id("InputNumero1"));
        waitObject(2000);
        writeElements(By.id("InputNumero1"),"123");
    }

    public void writeTelephone(){
        writeElements(By.id("InputTelefone1"),"3432102365");
    }

    public void clickButtonFinish(){
        click(By.id("FinalizarCadastro1"));
    }

    public void useExistingEmail() {
        writeElements(By.id("InputEmail1"),readFileEmail());
    }

    public void showErrorMessage(){
        existElement(By.xpath("//*[contains(@class,'error')]"));
    }

    public void showSucessMessage(){
        existElement(By.xpath("//*[contains(@class,'modal')]"));
    }
}
