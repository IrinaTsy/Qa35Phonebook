package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void type(By locator,String text){ //универсальный метод заполнения форм

        if(text!=null){
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        el.sendKeys(text);
        }
    }

    public void logOut() {

        // WebElement element = wd.findElement(By.xpath("//button[text()='Sign Out']"));
//       //element.click();
        wd.findElement(By.xpath("//button[text()='Sign Out']")).click();
    }

    public void openLogRegForm() {

        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login']"));
        loginTab.click();
    }
}


