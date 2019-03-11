package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC01 {
  public WebDriver driver;
  public LogInPage logInPage = new LogInPage();
	
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", logInPage.geckoPath);
	  driver = new FirefoxDriver();
	  driver.get(logInPage.siteUrl);
  }	
  @Test
  public void f() {
	  // Enter correct user name and password	 
	  WebElement txt_email = driver.findElement(By.name("email"));
	  txt_email.sendKeys(logInPage.userName);
	  WebElement txt_password = driver.findElement(By.name("password"));
	  txt_password.sendKeys(logInPage.password);
	  // Click Sign In button	  
	  WebElement btn_signin = driver.findElement(By.xpath("//a[@class='col-login__btn']"));
	  btn_signin.click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-filter module_grid__btn_filter btn btn-default']")));
	  // Wait until one element on Home page returned	  
	  WebElement btn_filters = driver.findElement(By.xpath("//button[@class='btn btn-filter module_grid__btn_filter btn btn-default']"));
	  Assert.assertEquals(true, btn_filters.isDisplayed());
	 
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }	

}
