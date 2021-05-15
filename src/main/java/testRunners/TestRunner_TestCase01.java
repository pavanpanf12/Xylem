package testRunners;

import org.testng.annotations.Test;

import utilities.initialization;


public class TestRunner_TestCase01 extends initialization {
	
	@Test // (enabled = false)
	public void login_Validation() {
		/*
		 * 1. Login · 
		 * User name: testpoc1 · 
		 * Password: 5nG%7#3G%yLh · 
		 * TODO: Validate that
		 * the login was successful and “Hi, name” is shown (next to My Projects in the
		 * top right corner).
		 */
		hp.login(driver);
		hp.quickSearch_Validation(driver);
	}

	@Test//(enabled = false)
	public void noOfPumps_Validation() {
		/*
		 * 2. Search for N 3000 from drop down and assert the number of products.
		 * · Do a quick search for “N 3000, N-technology pumps, Flygt” selecting from
		 * the previewed options and view results:
		 * · TODO: Validate search for N 3000 and get a result of 55 pumps.
		 */
		hp.login(driver);
		hp.quickSearch_Validation(driver);
	}

	@Test
	public void languageList_Validation() {
		/*
		 * 3. Language list · If you click on the image next to the units in the top
		 * right corner, you will get the preferences · In the preferences you will see
		 * the language list · 
		 * TODO: Assert the values in the language drop down list
		 * (check that the all the entries are there and they are correct).
		 */
		hp.login(driver);
		hp.language_Validation(driver);
	}

}
