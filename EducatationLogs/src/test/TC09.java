package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TC09 {
	public WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ducvnguyen\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://ktvn-test.s3-website.us-east-1.amazonaws.com/signin");
	  WebElement txt_email = driver.findElement(By.name("email"));
	  txt_email.sendKeys("admin@test.com");
	  WebElement txt_password = driver.findElement(By.name("password"));
	  txt_password.sendKeys("test123");
	  WebElement btn_signin = driver.findElement(By.xpath("//a[@class='col-login__btn']"));
	  btn_signin.click();
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='main-module_tableview']")));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
