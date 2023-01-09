package pom.facebook.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.facebook.pages.HomePage;
import wrappers.ProjectWrappers;

public class TC_Facebook extends ProjectWrappers {
	
	 
	 @BeforeClass 
	 public void beforeClass() {
	  
	  testCaseName="TC_Facebook";
	  testCaseDescribtion= "To verify facebook sign up for new users";
	  author = "Arun";
	  category="Smoke"; 
	  browserName="chrome";
	  appName="facebook";
	  sheetName="TC_Facebook";
	  }
	 
	
	@Test(dataProvider = "fetchData")
	public void faceboSignup(String firstName,String lastName,String MobileNumber,
			String password,String day,String month,String year,String gender) {
		
		HomePage ff= new HomePage();
		//.clickOnEnglishLanguage()
		ff.clickOnCreateNewAccount()
		.waitForSignUpPage(5000)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterMobileNumber(MobileNumber)
		.enterPassword(password)
		.selectBirthDate(day)
		.waitForSignUpPage(3000)
		.selectMonth(month)
		.waitForSignUpPage(3000)
		.selectYear(year)
		.clickGender(gender);
	}
}
