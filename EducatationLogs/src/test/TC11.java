package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TC11 {
	public WebDriver driver;
	public LogInPage logInPage = new LogInPage();
  @Test
  public void f() throws InterruptedException {
	  List<WebElement> arr_records = driver.findElements(By.xpath("//table/tbody/tr"));
	  WebElement first_record = arr_records.get(0);
	  WebElement lnk_status = first_record.findElement(By.xpath("./td[@tabindex='2']"));
	  lnk_status.click();
	  String txt_request_status = first_record.findElement(By.xpath("./td[@tabindex='2']")).getText();
	  Thread.sleep(5000);
	  List<WebElement> lst_options = driver.findElements(By.xpath("//ul/li[@role='presentation']"));
	  int i = 0;
	  Boolean break_condition = true;
	  do {
		  if(txt_request_status != lst_options.get(i).getText()) {
			  break_condition = false;
		  }
		  i++;
	  } while (break_condition && i < lst_options.size());
	  String txt_selected = lst_options.get(i).getText();
	  lst_options.get(i).click();
	  Assert.assertEquals(first_record.getText(), txt_selected);
	  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", logInPage.geckoPath);
	  driver = new FirefoxDriver();
	  driver.get(logInPage.siteUrl);
	  WebElement txt_email = driver.findElement(By.name("email"));
	  txt_email.sendKeys(logInPage.userName);
	  WebElement txt_password = driver.findElement(By.name("password"));
	  txt_password.sendKeys(logInPage.password);
	  WebElement btn_signin = driver.findElement(By.xpath("//a[@class='col-login__btn']"));
	  btn_signin.click();
	  Thread.sleep(5000);
//	  WebDriverWait wait = new WebDriverWait(driver, 10);
//	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='main-module_tableview']")));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
