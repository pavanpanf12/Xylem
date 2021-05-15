package stepDefintions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.GetProperty;

public class StepDefintion_TestCase01 extends GetProperty{
	String actual_Name = getProperty("actual_Name");
	String country = getProperty("country");
	String userName = getProperty("userName");
	String password = getProperty("password");
	String search = getProperty("search");
	
	
	/* 
	 * This method will use to login into test Xylem application
	 */
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

	/* 
	 * This method will use to validate the languages drop down
	 */
	public void language_Validation(WebDriver driver) {
		driver.findElement(By.id("HeaderBtnOpts")).click();
		driver.findElement(By.xpath("//p[text()='Preferences']")).click();
		WebElement lang =  driver.findElement(By.id("TP__LGG"));
		Select sel = new Select(lang);
		List<WebElement> language = sel.getOptions();
		List<String> language_Name = new ArrayList<String>();
		for(WebElement ele : language) {
			String lang1 = ele.getText();
			language_Name.add(lang1);
		}
		List<String> expetctedLanguageList = getLanguages();
		for(String languages :expetctedLanguageList) {
			boolean b = language_Name.contains(languages);
			Assert.assertEquals(true, b);
		}
		
		
	}

	/* 
	 * This method will use to validate no of record present in the table of view result.
	 */
	public void quickSearch_Validation(WebDriver driver) {
		driver.findElement(By.id("quicksearch_inpproduct")).sendKeys(search);
		driver.findElement(By.xpath("//a[text()='"+search+"']")).click();
		String [] expectedVal = driver.findElement(By.className("wichtig")).getText().split(" ");
		driver.findElement(By.id("btn_quick_view_results")).click();
		String [] excpectedHeader = driver.findElement(By.id("head_result_count")).getText().split(" ");
		Assert.assertEquals(expectedVal[0], excpectedHeader[0]);
		List<WebElement> no_of_Pumps = driver.findElements(By.xpath("//div[@id='pulist']//tbody[@class='Common']//tr"));
		Assert.assertEquals(Integer.parseInt(excpectedHeader[0]), no_of_Pumps.size());
	}
	
	/*
	 * this method is used to validate the languages in the list.
	 */
	public List<String> getLanguages() {
		List<String> lang = new ArrayList<String>();
		lang.add("Croatian");
		lang.add("Czech");
		lang.add("Dansk");
		lang.add("English (UK)");
		lang.add("English (US)");
		lang.add("Nederlands (NL)");
		lang.add("Suomi");
		lang.add("Français");
		lang.add("Français (Canada)");
		lang.add("Deutsch");
		lang.add("Dansk");
		lang.add("Magyar");
		lang.add("Italiano");
		lang.add("Japanese");
		lang.add("Lithuanian");
		lang.add("Norsk");
		lang.add("Polski");
		lang.add("Português (Portugal)");
		lang.add("Português (Brazil)");
		lang.add("Romanian");
		lang.add("Serbian (Latin)");
		lang.add("Slovak");
		lang.add("Slovenian");
		lang.add("Español tradicional");
		lang.add("Svenska");
		lang.add("Thai");
		lang.add("TRANSLATE_MODE");
		lang.add("Türkçe (TR)");
		return lang;
	}
}
