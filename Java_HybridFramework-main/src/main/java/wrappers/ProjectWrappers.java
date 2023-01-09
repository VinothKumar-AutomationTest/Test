package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utils.DP;

public class ProjectWrappers extends GenericWrappers {
	
	public String browserName;
	
	public String appName;
	
	public String sheetName;
	
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	} 
	
	@BeforeTest
	public void beforeTest() {
		loadProperties();
	}
	
	
	@BeforeMethod
    public void beforeMethod() {
	startTest(testCaseName, testCaseDescribtion);	
	
	switch (appName) {
	case "facebook":
		invokeApp(browserName,"http://www.facebook.com");
		break;
	case "amazon":
		invokeApp(browserName,"https://www.amazon.in/");
		break;
	
	case "formC":
		invokeApp(browserName,"https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");
        break;
	case "PanIndia":
		invokeApp(browserName, "https://panind.com/india/new_pan/");
	    break;
	case "Irctc":
		invokeApp(browserName,"https://www.irctc.co.in/nget/train-search");
	    break;
	case "phpTravellers":
		invokeApp(browserName, "https://www.phptravels.org/register.php");
		break;
		
	default:
		System.err.println("Invalid application !!");
		break;
	}
	
	}
	
	@AfterMethod
    public void AfterMethod() {
	closeAllBrowsers();
    }
	
	
	@AfterClass 
	public void afterClass() {
	}
	 
	
	@AfterTest
	public void afterTest() {
		unLoadProperties();
	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
     
	@org.testng.annotations.DataProvider(name = "fetchData")
	public String [][] DataProvider(){
		return DP.getData(sheetName);
	}
}
