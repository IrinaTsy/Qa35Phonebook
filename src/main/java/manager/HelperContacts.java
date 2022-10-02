package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HelperContacts extends HelperBase{


    public HelperContacts(WebDriver wd) {
        super(wd);
    }


    public void openAddContactsForm() {
        WebElement addTab = wd.findElement(By.xpath("//a[@href='/add']"));
        addTab.click();
    }

    public void fillContactsForm(Contacts contacts) {
        type(By.xpath("//input[@placeholder='Name']"), contacts.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contacts.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contacts.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contacts.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contacts.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contacts.getDescription());
    }

    public void buttonSave() {
        WebElement buttonSave = wd.findElement(By.xpath("//b[text()='Save']"));
        buttonSave.click();
    }

    public boolean elmPresent(){
        return wd.findElement(By.cssSelector("div[class *='2SOIM']")).isEnabled();
    }


    public int getCountContacts() {//css div[class *='leftdiv']
        return wd.findElements(By.cssSelector("div[class *='leftdiv']")).size();
    }

    public boolean buttonNotActive() {
        return wd.findElement(By.xpath("//b[text()='Save']")).isSelected();
        }
}
