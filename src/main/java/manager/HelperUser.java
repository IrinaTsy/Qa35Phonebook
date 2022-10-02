package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {

        // //button[text()='Sign Out']
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }



    // open login form


    //fill email noa@gmail.com Nnoa12345$
    public void fillLogRegForm(String email, String password) {

        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);

        // WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder='Email']"));
        // inputEmail.click();
        // inputEmail.clear();
        // inputEmail.sendKeys(email);


        // WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder='Password']"));
        // inputPassword.click();
        // inputPassword.clear();
        // inputPassword.sendKeys(password);

    }

    public void fillLogRegForm(User user) {

        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }

    // submit login
    public void submitLog() {

        WebElement loginButton = wd.findElement(By.xpath("//*[text()=' Login']"));
        loginButton.click();
    }

    public boolean isAlertPresent() {

        Alert alert = wd.switchTo().alert();
        if(alert == null){

        return false;
        }
        else {
            return true;
        }
    }

    public boolean isErrorWrongFormat(){

        Alert alert = wd.switchTo().alert();
        String errorText = alert.getText();
        System.out.println(errorText);

        //click OK
        alert.accept();
        //click CANCEL    alert.dismiss();
        //type text       alert.sendKeys("aaaaaaaaa");





        return errorText.contains("Wrong email or password format");
    }

    //---------------------------------------------------------------------------------------------------------------------------------
                                        //REGISTRATION
    public void submitReg() {
       WebElement regButton = wd.findElement(By.xpath("//*[text()=' Registration']"));
       regButton.click();

    }

    public void Wait() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5)); //задержка на 5 сек
        wait.until(ExpectedConditions.alertIsPresent()); //пока не появится нужная форма
    }

    public boolean isUserExist(){

        Alert alert = wd.switchTo().alert();
        String errorText = alert.getText();
        System.out.println(errorText);
        alert.accept();
        return errorText.contains("User already exist");
    }



}

