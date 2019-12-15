package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private static WebDriver driver;

    private static void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.saraiva.com.br");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }

    public void waitObject(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void alterPage(){
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
        getDriver().manage().window().maximize();
    }

    public void click(By by){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        while(!existElement(by)){
            scroll();
        }
        getDriver().findElement(by).click();
    }

    public void writeElements(By by, String text){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        while(!existElement(by)){
            scroll();
        }
        getDriver().findElement(by).sendKeys(text);
    }

    public String generateEmail(){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

        Random random = new Random();

        String email = "";
        int index = -1;
        for( int i = 0; i < 9; i++ ) {
            index = random.nextInt( letras.length() );
            email += letras.substring( index, index + 1 );
        }
        System.out.println(email.toLowerCase());
        return email.toLowerCase();
    }

    public void scroll(){
        ((JavascriptExecutor)getDriver()).executeScript("scroll(0,250)");
    }

    public static boolean existElement(By by) {
        List<WebElement> element = getDriver().findElements(by);
        return element.size() > 0;
    }

    private static String calcDigVerif(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = new Integer(0);
        else
            primDig = new Integer(11 - (soma % 11));

        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = new Integer(0);
        else
            segDig = new Integer(11 - (soma % 11));

        return primDig.toString() + segDig.toString();
    }

    public static String generateCPF() {
        String iniciais = "";
        Integer numero;
        for (int i = 0; i < 9; i++) {
            numero = new Integer((int) (Math.random() * 10));
            iniciais += numero.toString();
        }
        return iniciais + calcDigVerif(iniciais);
    }

    public static boolean validaCPF(String cpf) {
        if (cpf.length() != 11)
            return false;

        String numDig = cpf.substring(0, 9);
        return calcDigVerif(numDig).equals(cpf.substring(9, 11));
    }

    public static String generateStringCPF(){
        int val = 0;

        while (val == 0){
            String cpf = generateCPF();
            if (validaCPF(cpf)){
                val = 1;
                return cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
            }
            else generateCPF();}

        return null;

    }

    public String readFileEmail(){
        String email = "";
        try {
        FileInputStream fi = new FileInputStream("src/test/resources/email.txt");
        InputStreamReader ir = new InputStreamReader(fi);
        BufferedReader br = new BufferedReader(ir);
        String linha;
        while ((linha = br.readLine()) != null) {
            email = linha;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return email;
    }

    public String writeFileEmail(){
        String email = "anaautomatizado@"+generateEmail()+".com";
        try {
            File file = new File("src/test/resources/email.txt");
            if ( file.exists()) {
                file.delete();
                file = new File("src/test/resources/email.txt");
            }
            FileOutputStream fo = new FileOutputStream(file);
            fo.write(email.getBytes());
            fo.close();
        }   catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }

}
