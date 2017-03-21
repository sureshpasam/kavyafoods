package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Web_Login {
public WebDriver obj;
public String expval;
public String acval;
@BeforeTest
public void launch(){
	obj=new FirefoxDriver();
	obj.get("http://newtours.demoaut.com/");
	obj.manage().window().maximize();
	}
@Test
public void Login(){
	obj.findElement(By.name("userName")).sendKeys("admin");
	obj.findElement(By.name("password")).sendKeys("mercury");
	obj.findElement(By.name("login")).sendKeys(Keys.ENTER);
	expval=obj.findElement(By.name("passCount")).getAttribute("passCount");
	acval="passCount";
	if(expval.equals(acval)){
		Reporter.log("Login success",true);}
	else{
		Reporter.log("Login unsuccess",true);
	}
	
}
@AfterTest
public void signoff(){
	//obj.close();
}
}
