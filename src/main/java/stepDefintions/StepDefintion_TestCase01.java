package stepDefintions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.GetProperty;

public class StepDefintion_TestCase01 extends GetProperty{
	String actual_Name = getProperty("actual_Name");
	String country = getProperty("country");
	String userName = getProperty("userName");
	String password = getProperty("password");
	public void login (WebDriver driver) {
		driver.findElement(By.xpath("//a[text()='"+country+"']")).click();
		driver.findElement(By.xpath("//p[@id='xyl-privacy-text']//following-sibling::a[text()='Accept']")).click();
		driver.findElement(By.xpath("//p[@id='xyl-cookies-text']//following-sibling::a[text()='Accept']")).click();
		driver.findElement(By.id("inpage_login_user")).sendKeys(userName);
		driver.findElement(By.id("inpage_login_passwd")).sendKeys(password);
		driver.findElement(By.id("inpage_login_submit")).click();
		String expected_Name = driver.findElement(By.xpath("//div[@class='HiNameInside']//span[@class='HiName_text']")).getText();
		Assert.assertEquals(actual_Name, expected_Name);
	}
	public void language_Validation(WebDriver driver) {
		driver.findElement(By.id("HeaderBtnOpts")).click();
		driver.findElement(By.xpath("//p[text()='Preferences']")).click();
		List<WebElement> language =  driver.findElements(By.id("TP__LGG"));
		for(WebElement ele : language) {
			System.out.println(ele.getText());
		}
	}
	public void quickSearch_Validation(WebDriver driver) {
		driver.findElement(By.id("quicksearch_inpproduct")).sendKeys("NSW");
		driver.findElement(By.xpath("//a[text()='NSW']")).click();
		String [] expectedVal = driver.findElement(By.className("wichtig")).getText().split(" ");
		driver.findElement(By.id("btn_quick_view_results")).click();
		String [] excpectedHeader = driver.findElement(By.id("head_result_count")).getText().split(" ");
		Assert.assertEquals(expectedVal[0], excpectedHeader[0]);
		List<WebElement> no_of_Pumps = driver.findElements(By.xpath("//div[@id='pulist']//tbody[@class='Common']//tr"));
		Assert.assertEquals(Integer.parseInt(excpectedHeader[0]), no_of_Pumps.size());
	}
}
