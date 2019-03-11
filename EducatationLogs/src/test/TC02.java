package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC02 {
	public WebDriver driver;
	public LogInPage loginPage = new LogInPage();
  @Test
  public void f() {
	  // Enter incorrect user name/password	  
	  WebElement txt_email = driver.findElement(By.name("email"));
	  txt_email.sendKeys(loginPage.userName + "a");
	  WebElement txt_password = driver.findElement(By.name("password"));
	  txt_password.sendKeys(loginPage.password);
	  WebElement btn_signin = driver.findElement(By.xpath("//a[@class='col-login__btn']"));
	  btn_signin.click();
	  // look for the error message displays or just simple look for any element on Home page not exist
	  Boolean isPresent = driver.findElements(By.xpath("//div[@class='main-module_tableview']")).size() < 0;
	  Assert.assertTrue(isPresent);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", loginPage.geckoPath);
	  // open the page	  
	  driver = new FirefoxDriver();
	  driver.get(loginPage.siteUrl);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
