package pom.facebook.pages;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers {
	
	public HomePage clickOnEnglishLanguage() {
		
		clickByXpath(prop.getProperty("HomePage.Language.xpath"));
		return this;
	}
	
	
	public SignUpPage clickOnCreateNewAccount() {
      		
	clickByXpath(prop.getProperty("HomePage.createNewAccount.xpath"));
	//clickByXpath("//a[text()='Create New Account']");	
	return new SignUpPage();
    
	}	
}
