package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Admin_Login {
	public WebDriver d;
	public String expval;
	public String acval;
@BeforeTest
public void Launch(){
	d=new FirefoxDriver();
	d.get("http://opensource.demo.orangehrm.com/");
	d.manage().window().maximize();
	}
@Test(priority=0,enabled=true)
public void login(){
	d.findElement(By.name("txtUsername")).sendKeys("Admin");
	d.findElement(By.name("txtPassword")).sendKeys("admin");
	d.findElement(By.name("Submit")).click();
	expval="http://opensource.demo.orangehrm.com/index.php/dashboard";
	acval=d.getCurrentUrl();
	if(expval.equals(acval)){
		Reporter.log("login is success",true);}
	else{
		Reporter.log("login is unsuccess",true);
	}
			
	}
@Test(priority=1,enabled=true)
public void User_Creation(){
	d.findElement(By.id("menu_admin_viewAdminModule")).click();
	Sleeper.sleepTightInSeconds(2);
	d.findElement(By.name("btnAdd")).sendKeys(Keys.ENTER);
	d.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Benjamin Westfall");
	d.findElement(By.name("systemUser[userName]")).sendKeys("test676");
	d.findElement(By.name("systemUser[password]")).sendKeys("selenium");
	d.findElement(By.name("systemUser[confirmPassword]")).sendKeys("selenium");
	d.findElement(By.name("btnSave")).sendKeys(Keys.ENTER);
	
	}
	@AfterTest
	public void Logout(){
		//d.quit();
	
	
}
}
