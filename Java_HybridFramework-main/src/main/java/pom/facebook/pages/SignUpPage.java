package pom.facebook.pages;

import wrappers.GenericWrappers;

public class SignUpPage extends GenericWrappers {

    public SignUpPage waitForSignUpPage(long millSec) {
    	waitProperty(millSec);
    return this;
    }
     
    
	public SignUpPage enterFirstName(String data) {
		enterByXpath(prop.getProperty("SignUpPage.Firstname.xpath"), data);
		return this;
	}

	public SignUpPage enterLastName(String data) {
		enterByXpath(prop.getProperty("SignUpPage.LastName.xpath"), data);
		return this;
	}

	public SignUpPage enterMobileNumber(String data) {
		enterByXpath(prop.getProperty("SignUpPage.mobileNumber.xpath"), data);
		return this;
	}

	public SignUpPage enterPassword(String data) {
		enterByXpath(prop.getProperty("SignUpPage.password.xpath"), data);
		return this;
	}

	public SignUpPage selectBirthDate(String data) {

		selectVisibleTextByXpath(prop.getProperty("SignUpPage.date.xpath"), data);
		return this;
	}

	public SignUpPage selectYear(String data) {
		selectVisibleTextByXpath(prop.getProperty("SignUpPage.year.xpath"), data);
		return this;
	}

	public SignUpPage selectMonth(String data) {
		selectVisibleTextByXpath(prop.getProperty("SignUpPage.month.xpath"), data);
		return this;
	}

	public SignUpPage clickGender(String data) {

		clickByXpath(prop.getProperty("SignUpPage.gender.xpath"));
		return this;
	}

}
