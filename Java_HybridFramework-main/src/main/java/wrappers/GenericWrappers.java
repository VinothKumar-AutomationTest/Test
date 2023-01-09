package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporting;


public class GenericWrappers extends Reporting implements Wrappers {
	
	public static RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			    driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			    driver = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver","./drivers/IEDriverserver.exe");
			    driver = new InternetExplorerDriver();
			}
			 // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  driver.get(url);
			  
			 // System.out.println("The browser "+browser+" is lauched with the given URL "+url+ " successfully");
			 reportStep("The browser "+browser+" is lauched with the given URL "+url+ " successfully","pass"); 
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browser "+browser+"is not launched due to session not created error");
		    reportStep("The browser "+browser+"is not launched due to session not created error"," fail");
		}catch (InvalidArgumentException e) {
			// TODO: handle exception
			//System.err.println("The browser "+browser+"is not loaded with the URL "+url+" as it not contains http/https");
			reportStep("The browser "+browser+"is not loaded with the URL "+url+" as it not contains http/https","fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The browser "+browser+" is not lauched with the URL "+url+" due to unknown error");
			reportStep("The browser "+browser+" is not lauched with the URL "+url+" due to unknown error","fail");
		}/*finally {
			
			
		}*/
          
	}
	
    public static Properties prop;

	
	public void loadProperties() {

		try {
			prop = new Properties();
			prop.load(new FileInputStream("C:\\Users\\tgt425\\eclipse-workspace\\AllPojects\\src\\test\\java\\Selenium\\AllPojects\\Object.Properties"));
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unLoadProperties() {
         prop=null;
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
      try {
		driver.findElementById(idValue).sendKeys(data);
		//System.out.println("The Element with id "+idValue+" is successfully entered with the data "+data);
		reportStep("The Element with id "+idValue+" is successfully entered with the data "+data,"pass");
	}catch (NoSuchElementException e) {
		// TODO: handle exception
		//System.err.println("The Element with id "+idValue+" is not found in the DOM");
       reportStep("The Element with id "+idValue+" is not found in the DOM","fail");	
	} catch (ElementNotVisibleException e) {
		// TODO Auto-generated catch block
		//System.err.println("The Element with id "+idValue+" is not visibe in the Application");
		reportStep("The Element with id "+idValue+" is not visibe in the Application ","fail");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		//System.err.println("The Element with id "+idValue+" is not interactable with the Application");
		reportStep("The Element with id "+idValue+" is not interactable with the Application", "fail");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		//System.err.println("The Element with id "+idValue+" is not stable in the Application");
	    reportStep("The Element with id "+idValue+" is not stable in the Application", "fail");
	} catch (WebDriverException e) {
		// TODO: handle exception
		//System.err.println("The Element with id "+idValue+" is not enetered with data "+data+" due to unknown Error");
		reportStep("The Element with id "+idValue+" is not entered with data "+data+" due to unknown Error","fail");
	} /*finally {
		
	}
	*/
}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
		    //System.out.println("The Element with name "+nameValue+" is successfully entered with the data "+data);
	        reportStep("The Element with name "+nameValue+" is successfully entered with the data "+data,"pass");	
		}catch (NoSuchElementException e) {
			// TODO: handle exception
	       // System.err.println("The Element with name "+nameValue+" is not found in the DOM");
			reportStep("The Element with name "+nameValue+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with name "+nameValue+" is not visible in the application");
			reportStep("The Element with name "+nameValue+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
		//System.err.println("The Element with name "+nameValue+" is not interactable with the application");
			reportStep("The Element with name "+nameValue+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//System.err.println("The Element with name "+nameValue+" is not stable in the application");
			reportStep("The Element with name "+nameValue+" is not stable in the application","fail" );
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with name "+nameValue+" is not entered with the data "+data+" due to unknown Error");
			reportStep("The Element with name "+nameValue+" is not entered with the data "+data+" due to unknown Error", "fail");
/*		}finally {
			
*/		}
   }

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The Element with xpath"+xpathValue+" is successfully entered with the data "+data);
			reportStep("The Element with xpath"+xpathValue+" is successfully entered with the data "+data,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		    //System.err.println("The Element with xpath "+xpathValue+" is not found in the DOM");
			reportStep("The Element with xpath "+xpathValue+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not visible in the application");
			reportStep("The Element with xpath "+xpathValue+" is not visible in the application","fail" );
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not interactable with the application");
			reportStep("The Element with xpath "+xpathValue+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not stable in the application");
			reportStep("The Element with xpath "+xpathValue+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not entered with the data "+data+" due to unknown Error");
			reportStep("The Element with xpath "+xpathValue+" is not entered with the data "+data+" due to unknown Error","fail");
/*		}finally {
			
*/		}
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		String actualTitle = null;
		try {
			 actualTitle = driver.getTitle();
			if(actualTitle.equals(title)) {
				//System.out.println("The title for the page "+actualTitle+" is matched with the expected title "+title);
				reportStep("The title for the page "+actualTitle+" is matched with the expected title "+title, "pass");
			}else {
				//System.err.println("The title for the page "+actualTitle+" is not matched with expected title "+title);
			  reportStep("The title for the page "+actualTitle+" is not matched with expected title "+title,"fail");
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The title for the page "+actualTitle+" is not verfied with the expected text due to unknown Errors");
			reportStep("The title for the page "+actualTitle+" is not verfied with the expected text due to unknown Errors","fail");
/*		}finally {
			
*/		}
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		String actualText = null;
		try {
	          actualText = driver.findElementById(id).getText();
			if(actualText.equals(text)) {
				//System.out.println("The element with the id "+id+" its holding the text "+actualText+" is matched with the expected text "+text);
				reportStep("The element with the id "+id+" its holding the text "+actualText+" is matched with the expected text "+text,"pass");
			}else {
				//System.err.println("The element with the id "+id+" its holding the text "+actualText+" is not matched with expected text "+text);
				reportStep("The element with the id "+id+" its holding the text "+actualText+" is not matched with expected text "+text,"fail");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id "+id+" is found in the DOM");
			reportStep("The Element with id "+id+" is found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
		    //System.err.println("The Element with the id "+id+" is not visible in the application");
			reportStep("The Element with the id "+id+" is not visible in the application", "fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" is not interactable with the application");
			reportStep("The Element with id "+id+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" is not stable in the application");
			reportStep("The Element with id "+id+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" and its holding text "+ actualText +" is not verified with expected text "+text+" due to unknown errors");
			reportStep("The Element with id "+id+" and its holding text "+ actualText +" is not verified with expected text "+text+" due to unknown errors","fail");
/*		}finally {
			
*/		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String actualText =null;
		try {
			 actualText = driver.findElementByXPath(xpath).getText();
			if(actualText.equals(text)){
			//System.out.println("The element with the xpath "+xpath+" its holding the text "+actualText+" is matched with the expected text "+text);
				reportStep("The element with the xpath "+xpath+" its holding the text "+actualText+" is matched with the expected text "+text,"pass");
			}else {
			//System.err.println("The element with the xpath "+xpath+" its holding the text "+actualText+" is not matched with expected text "+text);
				reportStep("The element with the xpath "+xpath+" its holding the text "+actualText+" is not matched with expected text "+text, "fail");
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with xpath "+xpath+" is not found in the DOM");
			reportStep("The Element with xpath "+xpath+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
		   //System.err.println("The Element with xpath "+xpath+" is not visible in the Application");
			reportStep("The Element with xpath "+xpath+" is not visible in the Application", "fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
		//	System.err.println("The Element with xpath "+xpath+" is not interactable with the appplication");
			reportStep("The Element with xpath "+xpath+" is not interactable with the appplication","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		//System.err.println("The Element with xpath "+xpath+" is not stable in the application");
			reportStep("The Element with xpath "+xpath+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
		//	System.err.println("The Element with xpath "+xpath+"and its holding text "+actualText+" is not verified with the expectedText "+text+" due to unknown error");
			reportStep("The Element with xpath "+xpath+"and its holding text "+actualText+" is not verified with the expectedText "+text+" due to unknown error","fail");
/*		}finally {
			
*/		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String actualText=null;
		try {
		    actualText = driver.findElementByXPath(xpath).getText();
			if(actualText.contains(text)) {
			//System.out.println("The Element with xpath "+xpath+" successfully contains the given text "+text+" in its holding text "+actualText);
				reportStep("The Element with xpath "+xpath+" successfully contains the given text "+text+" in its holding text "+actualText,"pass");
			}else {
			//System.err.println("The Element with xpath "+xpath+" as not contains the given text "+text+" in its holding text "+actualText);
				reportStep("The Element with xpath "+xpath+" as not contains the given text "+text+" in its holding text "+actualText,"fail");
			}
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with xpath "+xpath+" is not found in the DOM");
			reportStep("The Element with xpath "+xpath+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" is not visible in the application");
			reportStep("The Element with xpath "+xpath+" is not visible in the application", "fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" is not interactable with the application");
			reportStep("The Element with xpath "+xpath+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" is not stable in the application");
			reportStep("The Element with xpath "+xpath+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" is not verified wheather the holding text "+actualText+" contains expected text "+text+" or not due to unknown errors");
            reportStep("The Element with xpath "+xpath+" is not verified wheather the holding text "+actualText+" contains expected text "+text+" or not due to unknown errors","fail");	
/*		}finally {
			
*/		}
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			//System.out.println("The Element with id "+id+" is successfully clicked in the application");
			reportStep("The Element with id "+id+" is successfully clicked in the application","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id "+id+" is not found in the DOM");
			reportStep("The Element with id "+id+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with id "+id+" is not visbile in the application");
			reportStep("The element with id "+id+" is not visbile in the application","fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
		     //System.err.println("The element with id "+id+" is not clickable in the application");
			reportStep("The element with id "+id+" is not clickable in the application","fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not interactable with the application");
			reportStep("The element with the id "+id+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with the id "+id+" is not stable in the application");
			reportStep("The element with the id "+id+" is not stable in the application", "fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//system.err.println("The element with id "+id+" is not clickable in the application due to unknown errors");
			reportStep("The element with id "+id+" is not clickable in the application due to unknown errors","fail");
/*		}finally {
			
*/		}
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
     try {
		driver.findElementByClassName(classVal).click();
		//System.out.println("The element with the class "+classVal+" is successfully clicked in the application");
		reportStep("The element with the class "+classVal+" is successfully clicked in the application","pass");
     } catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		//System.err.println("The element with the class "+classVal+" is not found in the DOM");
    	 reportStep("The element with the class "+classVal+" is not found in the DOM","fail");
	} catch (ElementNotVisibleException e) {
		// TODO: handle exception
	   //System.err.println("The element with the class "+classVal+" is not vissible in the application");
		reportStep("The element with the class "+classVal+" is not vissible in the application", "fail");
	}catch (ElementClickInterceptedException e) {
		// TODO: handle exception
		//System.err.println("The element with the class "+classVal+" is not clickable in the application");
		reportStep("The element with the class "+classVal+" is not clickable in the application","fail");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		//System.err.println("The Element with class "+classVal+" is not interactable with the application");
		reportStep("The Element with class "+classVal+" is not interactable with the application","fail");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		//System.err.println("The element with the class "+classVal+" is not stable in the application");
		reportStep("The element with the class "+classVal+" is not stable in the appplication","fail");
	}catch (WebDriverException e) {
		// TODO: handle exception
		//System.err.println("The element with class "+classVal+" is not clickable in the application due to unknown errors");
		reportStep("The element with class "+classVal+" is not clickable in the application due to unknown errors","fail");
/*	}finally {
		
*/	 }
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			//System.out.println("The element with name "+name+" is successfully clicked in the application");
			reportStep("The element with name "+name+" is successfully clicked in the application","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the name "+name+" is not found in the DOM");
			reportStep("The element with the name "+name+" is not found in the DOM", "fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not vissible in the applicaction");
			reportStep("The element with name "+name+" is not vissible in the applicaction","fail");
		}catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not clickable in the application");
			reportStep("The element with name "+name+" is not clickable in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not interactable with application");
            reportStep("The element with name "+name+" is not interactable with application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not stable in the application");
			reportStep("The element with name "+name+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with name "+name+" is not clickable in the application due to unknown errors");
			reportStep("The element with name "+name+" is not clickable in the application due to unknown errors","fail");
/*		}finally {
			
*/		}
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element with LinkText "+name+" is successfully clicked in the application");
			reportStep("The element with LinkText "+name+" is successfully clicked in the application","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with LinkText "+name+" is not found in the DOM");
			reportStep("The element with LinkText "+name+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with LinkText "+name+" is not vissible in the application");
			reportStep("The element with LinkText "+name+" is not vissible in the application","fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with LinkText "+name+" is not clickable in the appplication");
			reportStep("The element with LinkText "+name+" is not clickable in the appplication","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with LinkText "+name+" is not interactable with application");
			reportStep("The element with LinkText "+name+" is not interactable with application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with LinkText "+name+" is not stable in the application");
			reportStep("The element with LinkText "+name+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
		    //System.err.println("The element with LinkText "+name+" is not clickable in the application due to unknown errors");
			reportStep("The element with LinkText "+name+" is not clickable in the application due to unknown errors","fail");
/*		}finally {
			
*/		}
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			//System.out.println("The element with the LinkText "+name+" is successfully clicked in the application");
			reportStep("The element with the LinkText "+name+" is successfully clicked in the application","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with the LinkText "+name+" is not found in the DOM");
			reportStep("The element with the LinkText "+name+" is not found in the DOM","fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.err.println("The element with the LinkText "+name+" is not clickable in the application");
			reportStep("The element with the LinkText "+name+" is not clickable in the application","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with the LinkText "+name+" is not visible in the application");
			reportStep("The element with the LinkText "+name+" is not visible in the application", "fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The elemant with LinkText "+name+" is not interactable with the application");
			reportStep("The elemant with LinkText "+name+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with LinknText "+name+" is not stable in the application");
			reportStep("The element with LinknText "+name+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with LinkText "+name+" is not clickable in the application due to unknown error");
			reportStep("The element with LinkText "+name+" is not clickable in the application due to unknown error","fail");
		}
		
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The element with the xpath "+xpathVal+" is successfully clicked in the application");
			reportStep("The element with the xpath "+xpathVal+" is successfully clicked in the application","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not visible in the application");
			reportStep("The element with xpath "+xpathVal+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not interactable with the application");
			reportStep("The element with xpath "+xpathVal+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not clicked due to unknown error");
			reportStep("The element with xpath "+xpathVal+" is not clicked due to unknown error","fail");
/*		}finally {
			
*/		}
		
		}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal);
			//System.out.println("The element with xpath "+xpathVal+" is successfully clicked in the application");
			reportStep("The element with xpath "+xpathVal+" is successfully clicked in the application","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpathVal+" is not found in the appplication");
			reportStep("The element with xpath "+xpathVal+" is not found in the appplication","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not visible in the application");
			reportStep("The element with xpath "+xpathVal+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not interactable with the application");
			reportStep("The element with xpath "+xpathVal+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpathVal+" is not stable in the application");
			reportStep("The element with xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with the xpath "+xpathVal+" is not clicked due to unknown errors");
			reportStep("The element with the xpath "+xpathVal+" is not clicked due to unknown errors","fail");
		}
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String actualText = null;
		try {
			actualText = driver.findElementById(idVal).getText();
			//System.out.println("The Element with id "+idVal+" and its holding text is successfully driven as "+actualText);
			reportStep("The Element with id "+idVal+" and its holding text is successfully driven as "+actualText,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id "+idVal+" is not found in the DOM");
			reportStep("The Element with id "+idVal+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+idVal+" is not visible in the application");
           reportStep("The Element with id "+idVal+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+idVal+" is not interactable with the application");
			reportStep("The Element with id "+idVal+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+idVal+" is not stable in the application");
			reportStep("The Element with id "+idVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+idVal+" and its holding text "+actualText+" is not driven due to unknown error");
			reportStep("The Element with id "+idVal+" and its holding text "+actualText+" is not driven due to unknown error","fail");
		}finally {
			
		}
		return actualText;
	}
	String actualText = null;
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		
		try {
			actualText = driver.findElementByXPath(xpathVal).getText();
		//System.out.println("The Element with xpath "+xpathVal+" and its holding text "+actualText+" is successfully driven");
			reportStep("The Element with xpath "+xpathVal+" and its holding text "+actualText+" is successfully driven","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
			reportStep("The element with xpath "+xpathVal+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathVal+" is not vissible in the application");
			reportStep("The Element with xpath "+xpathVal+" is not vissible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathVal+" is not interactable with the application");
			reportStep("The Element with xpath "+xpathVal+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathVal+" is not stable in the application");
			reportStep("The Element with xpath "+xpathVal+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathVal+" and its holding text "+actualText+" is not driven due to unknown error");
			reportStep("The Element with xpath "+xpathVal+" and its holding text "+actualText+" is not driven due to unknown error","fail");
		}finally {
			
		}
		return actualText;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement title = driver.findElementById(id);
			Select sel = new Select(title);
			sel.selectByVisibleText(value);
			//System.out.println("The Element with id "+id+" and its dropdown visible Text "+value+" is successfully selected");
			reportStep("The Element with id "+id+" and its dropdown visible Text "+value+" is successfully selected","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id "+id+" and its dropdown visible text "+value+" is not found in the DOM");
			reportStep("The Element with id "+id+" and its dropdown visible text "+value+" is not found in the DOM", "fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The Element with id "+id+" and its dropdown visible text "+value+" is not visible in the application");
			reportStep("The Element with id "+id+" and its dropdown visible text "+value+" is not visible in the application","fail");
			// TODO: handle exception
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" and its dropdown visible text "+value+" is not interactable with the appplication");
			reportStep("The Element with id "+id+" and its dropdown visible text "+value+" is not interactable with the appplication","fail");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception 
			//System.err.println("The Element with id "+id+" and its dropdown visible text "+value+" is not selectable in the application");
			reportStep("The Element with id "+id+" and its dropdown visible text "+value+" is not selectable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: ndle exception
			//System.err.println("The Element with id "+id+" and its dropdown visible text "+value+" are not stable in the application");
			reportStep("The Element with id "+id+" and its dropdown visible text "+value+" are not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" and its dropdown visible text "+value+" are not selected due to unknown error");
			reportStep("The Element with id "+id+" and its dropdown visible text "+value+" are not selected due to unknown error","fail");
		}finally {
			
		}
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement title = driver.findElementById(id);
			Select sel = new Select(title);
			sel.selectByIndex(value);
			//System.out.println("The Element with id "+id+" and its dropdown Index "+value+" is successfully selected");
			reportStep("The Element with id "+id+" and its dropdown Index "+value+" is successfully selected","pass");
			} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id "+id+" and its dropdown Index "+value+" is not found in the DOM");
				reportStep("The Element with id "+id+" and its dropdown Index "+value+" is not found in the DOM","fail");
		   }catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" and its dropdown index "+value+" is not visible in the application");
			   reportStep("The Element with id "+id+" and its dropdown index "+value+" is not visible in the application","fail");
		   }catch (ElementNotInteractableException e) {
			// TODO: handle exception
			   //System.err.println("The Element with id "+id+" and its dropdown index "+value+" is not interactable with the application");
			   reportStep("The Element with id "+id+" and its dropdown index "+value+" is not interactable with the application","fail");
		  }catch (ElementNotSelectableException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" and its dropdown index "+value+" is not selectable in the application");
		  reportStep("The Element with id "+id+" and its dropdown index "+value+" is not selectable in the application","fail"); 
		  }catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" and its dropdown index"+value+" is not selected due to unknown error");
			  reportStep("The Element with id "+id+" and its dropdown index"+value+" is not selected due to unknown error","fail");
		   }finally {
			
		}
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> actualWindowId = driver.getWindowHandles();
			
			for(String eachWinId:actualWindowId) {
			driver.switchTo().window(eachWinId);
			break;
			}
			//System.out.println("The browser is successfully switched to the the parent window");
			reportStep("The browser is successfully switched to the the parent window","pass");
		}catch (NoSuchWindowException e) {
			// TODO: handle exception
			//System.err.println("The browser is not switched to the parent Window due to the window not found/Exist");
			reportStep("The browser is not switched to the parent Window due to the window not found/Exist","fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The browser is not switched to the parent window due to unknown error");
			reportStep("The browser is not switched to the parent window due to unknown error","fail");
		}finally {
			
		}
	}

	 public void switchToLastWindow() {
		// TODO Auto-generated method stub
	    
		try {
			Set<String> lastWindow  = driver.getWindowHandles();
			 for(String eachId:lastWindow) {
			  driver.switchTo().window(eachId);
              }
			 //System.out.println("The browser is successfully switched to the last window");
			 reportStep("The brower is successfully switched to the last window","pass");
	    } catch (NoSuchWindowException e) {
			// TODO: handle exception
	    	//System.err.println("The browser is not switched to the last window due to the window not found/Exist");
	    	reportStep("The browser is not switched to the last window due to the window not found/Exist","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
	    	//System.err.println("The browser is not switched to last window due to unknown error");
			reportStep("The browser is not switched to last window due to unknown error","fail");
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			//System.out.println("The alert is successfully accepted in the application");
			reportStep("The alert is successfully accepted in the application","pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("The alert is not accepted due to alert not found/Exist in the application");
			reportStep("The alert is not accepted due to alert not found/Exist in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The alert is not accepted due to the unknown error ");
			reportStep("The alert is not accepted due to the unknown error", "fail");
		}finally {
			
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			//System.out.println("The Alert is successfully dismissed in the application");
			reportStep("The Alert is successfully dismissed in the application","pass");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//System.err.println("The alert is not dissmissed due to the alert not Found/Exist in the application");
			reportStep("The alert is not dissmissed due to the alert not Found/Exist in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Alert is not dismissed due to unknown errors");
			reportStep("The Alert is not dismissed due to unknown errors","fail");
		}finally {
			
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String alertText = null;
		try {
			alertText = driver.switchTo().alert().getText();
			//System.out.println("The Element with the Alert text displayed "+alertText+" is driven successfully");
            reportStep("The Element with the Alert text displayed "+alertText+" is driven successfully","pass");
		} catch (NoSuchElementException e) {
			//System.err.println("The Element with Alert text is not found in the DOM");
			reportStep("The Element with Alert text is not found in the DOM","fail");
			// TODO: handle exception
		}catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//system.err.println("The Element with Alert text is not displayed due to Alert not Found/Exist");
			reportStep("The Element with Alert text is not displayed due to Alert not Found/Exist","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with the Alert text is not visible in the application");
			reportStep("The Element with the Alert text is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with Alert text is not interactable with the application");
			reportStep("The Element with Alert text is not interactable with the application", "fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with Alert text is not successfully driven due to unknown error");
			reportStep("The Element with Alert text is not successfully driven due to unknown error","fail");
		}finally {
			
		}
		return alertText;
	}
	
	public long takeSnap() {
		// TODO Auto-generated method stub
		long number =0;
		try {
		
			number = 	(long) (Math.floor(Math.random()*100000000)+100000);
	
			File tmp = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./reports/screenshots/"+number+".jpg");
			FileUtils.copyFile(tmp, dest);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			}
		
		return number;
}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			//System.out.println("The active browser is successfully closed");
			reportStep("The active browser is successfully closed","pass", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The active browser is not closed due to unknown errors");
			reportStep("The active browser is not closed due to unknown errors","fail", false);
		}		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
		    //System.out.println("All the browsers are closed successfully");
			reportStep("All the browsers are closed successfully","pass", false);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The browsers are not closed due to unknown errors");
			reportStep("The browsers are not closed due to unknown errors","fail", false);
		}
	}

	public void enterByLinkText(String name, String value) {
		// TODO Auto-generated method stub
	try {
		driver.findElementByLinkText(name).sendKeys(value);
		//System.out.println("The Element with LinkText "+name+" is successfully entered with the value "+value);
		reportStep("The Element with LinkText "+name+" is successfully entered with the value "+value,"pass");
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		//System.err.println("The Element with LinkText "+name+" is not found in the DOM");
		reportStep("The Element with LinkText "+name+" is not found in the DOM","fail");
	} catch (ElementNotVisibleException e) {
		// TODO: handle exception
		//System.err.println("The Element with LinkText "+name+" is not visible in the application");
		reportStep("The Element with LinkText "+name+" is not visible in the application","fail");
	}catch (ElementNotInteractableException e) {
		// TODO: handle exception
		//System.err.println("The Element with LinkText "+name+" is not interactable with the application");
		reportStep("The Element with LinkText "+name+" is not interactable with the application","fail");
	}catch (StaleElementReferenceException e) {
		// TODO: handle exception
		//System.err.println("The Element with LinkText "+name+" is not stable in the application" );
		reportStep("The Element with LinkText "+name+" is not stable in the application","fail");
	}catch (WebDriverException e) {
		// TODO: handle exception
		//System.err.println("The Element with LinkText "+name+" is not enetered with the value "+value);
		reportStep("The Element with LinkText "+name+" is not enetered with the value "+value,"fail");
	}finally {
		
	}
	
	}

	public void waitProperty(long sec) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
		
	
		
	
	}

	public void selectIndexByClass(String className, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement sel = driver.findElementByClassName(className);
			Select obj = new Select(sel);
			obj.selectByIndex(value);
			//System.out.println("The Element with class "+className+" is successfully selected the data "+value);
			reportStep("The Element with class "+className+" is successfully selected the data "+value,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with class "+className+" is not found in the DOM");
			reportStep("The Element with class "+className+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Elemetr with class "+className+" is not visible in the application");
			reportStep("The Elemetr with class "+className+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with class "+className+" is not intractable with the application");
			reportStep("The Element with class "+className+" is not interactable with the application","fail");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			//System.err.println("The Element with class "+className+" is not selectable in the application");
			reportStep("The Element with class \"+className+\" is not selectable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with class "+className+" is not stable in the application");
           reportStep("The Element with class "+className+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with class "+className+" is not selected with the date "+value+" due to unknown error" );
			reportStep("The Element with class "+className+" is not selected with the date "+value+" due to unknown error","fail");
		}finally {
			
		}
		
	}

	public void enterByIdWithKeys(String id, String value, Keys tab) {
		// TODO Auto-generated method stub
	      try {
			driver.findElementById(id).sendKeys(value ,Keys.TAB);
		//	System.out.println("The Element with id "+id+" is successfully entered with the value "+value);
			reportStep("The Element with id "+id+" is successfully entered with the value "+value,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with id "+id+" is not found in the DOM");
			reportStep("The Element with id "+id+" is not found in the DOM","fail");
		}	catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with Id "+id+" is not visible in the applciation");
			reportStep("The Element with Id "+id+" is not visible in the applciation","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" is not interactable with the application");
			reportStep("The Element with id "+id+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with id "+id+" is not stable in the application");
			reportStep("The Element with id "+id+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
		//System.err.println("The Element with id "+id+" is not entered with the value "+value+" due to unknown error");
			reportStep("The Element with id "+id+" is not entered with the value "+value+" due to unknown error", "fail");
		}
	}

	
	public void selectVisibleTextByName(String name, String data) {
		// TODO Auto-generated method stub
		try {
		
			WebElement title = driver.findElementByName(name);
			Select sel = new Select(title);
			sel.selectByVisibleText(data);
			//System.out.println("The Element with name "+name+" and its dropdown visible Text "+data+" is successfully selected");
			reportStep("The Element with name "+name+" and its dropdown visible Text "+data+" is successfully selected","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with name "+name+" and its dropdown visible text "+data+" is not found in the DOM");
			reportStep("The Element with name "+name+" and its dropdown visible text "+data+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
		//	System.err.println("The Element with name "+name+" and its dropdown visible text "+data+" is not visible in the application");
			reportStep("The Element with name "+name+" and its dropdown visible text "+data+" is not visible in the application","fail");
			// TODO: handle exception
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with name "+name+" and its dropdown visible text "+data+" is not interactable with the appplication");
			reportStep("The Element with name "+name+" and its dropdown visible text "+data+" is not interactable with the appplication","fail");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception 
			//System.err.println("The Element with name+ "+name+" and its dropdown visible text "+data+" is not selectable in the application");
			reportStep("The Element with name+ "+name+" and its dropdown visible text "+data+" is not selectable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with name "+name+" and its dropdown visible text "+data+" are not stable in the application");
			reportStep("The Element with name "+name+" and its dropdown visible text "+data+" are not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with name "+name+" and its dropdown visible text "+data+" are not selected due to unknown error");
			reportStep("The Element with name "+name+" and its dropdown visible text "+data+" are not selected due to unknown error","fail");
		}finally {
			
		}
	}

	public void selectVisibleTextByXpath(String xpath, String data) {
		// TODO Auto-generated method stub
		try {
			WebElement title = driver.findElementByXPath(xpath);
			Select sel = new Select(title);
			sel.selectByVisibleText(data);
			//System.out.println("The Element with xpath "+xpath+" and its dropdown visible Text "+data+" is successfully selected");
			reportStep("The Element with xpath "+xpath+" and its dropdown visible Text "+data+" is successfully selected","pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with xpath "+xpath+" and its dropdown visible text "+data+" is not found in the DOM");
			reportStep("The Element with xpath "+xpath+" and its dropdown visible text "+data+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The Element with xpath "+xpath+" and its dropdown visible text "+data+" is not visible in the application");
			reportStep("The Element with xpath "+xpath+" and its dropdown visible text "+data+" is not visible in the application","fail");
			// TODO: handle exception
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" and its dropdown visible text "+data+" is not interactable with the appplication");
            reportStep("The Element with xpath "+xpath+" and its dropdown visible text "+data+" is not interactable with the appplication","fail");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception 
			//System.err.println("The Element with xpath + "+xpath+" and its dropdown visible text "+data+" is not selectable in the application");
			reportStep("The Element with xpath + "+xpath+" and its dropdown visible text "+data+" is not selectable in the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" and its dropdown visible text "+data+" are not stable in the application");
			reportStep("The Element with xpath "+xpath+" and its dropdown visible text "+data+" are not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" and its dropdown visible text "+data+" are not selected due to unknown error");
			reportStep("The Element with xpath "+xpath+" and its dropdown visible text "+data+" are not selected due to unknown error","fail");
		}finally {
			
		}

	}
    String eactualPrice;
	static String  actualPrice ;
	public String getPriceTextByXpath(String xpath) {
		// TODO Auto-generated method stub		
				try {
					String eactualPrice = driver.findElementByXPath(xpath).getText();
					
					actualPrice=eactualPrice.substring(2,eactualPrice.length());
					
				//System.out.println("The Element with xpath "+xpath+" and its holding price "+actualPrice+" is successfully driven");
					reportStep("The Element with xpath "+xpath+" and its holding price "+actualPrice+" is successfully driven","pass");
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
					reportStep("The element with xpath "+xpath+" is not found in the DOM","fail");
				}catch (ElementNotVisibleException e) {
					// TODO: handle exception
					//System.err.println("The Element with xpath "+xpath+" is not vissible in the application");
					reportStep("The Element with xpath "+xpath+" is not vissible in the application","fail");
				}catch (ElementNotInteractableException e) {
					// TODO: handle exception
					//System.err.println("The Element with xpath "+xpath+" is not interactable with the application");
					reportStep("The Element with xpath "+xpath+" is not interactable with the application","fail");
				}catch (StaleElementReferenceException e) {
					// TODO: handle exception
					//System.err.println("The Element with xpath "+xpath+" is not stable in the application");
					reportStep("The Element with xpath "+xpath+" is not stable in the application","fail");
				}catch (WebDriverException e) {
					// TODO: handle exception
				//	System.err.println("The Element with xpath "+xpath+" and its holding price "+actualPrice+" is not driven due to unknown error");
					reportStep("The Element with xpath "+xpath+" and its holding price "+actualPrice+" is not driven due to unknown error","fail");
				}finally {
					
				}
				return actualPrice;	
		
	}
	Integer a;
	
	Integer b;
	public void getPriceCompareValue(String xpat,String hotelPrice, int day) {
		// TODO Auto-generated method stub
		try {
			String finalPrice = driver.findElementByXPath(xpat).getText();
			finalPrice=finalPrice.substring(2,finalPrice.length());
			 a=Integer.parseInt(finalPrice);
			b = Integer.parseInt(actualPrice);
	        b=b*day;
			reportStep("The value of actualprice per day is "+actualPrice,"pass");
	        //System.out.println("The value of finalprice is "+finalPrice);
			reportStep("The value of finalprice is "+finalPrice, "pass");
			if(a.toString().equals(b.toString())){
			//System.out.println("The Element with xpath "+xpat+" and its price "+a+" is successfully driven and matched with the actualprice "+b);
			reportStep("The Element with xpath "+xpat+" and its price "+a+" is successfully driven and matched with the actualprice "+b,"pass");
			}else {//System.err.println("The Element with xpath "+xpat+ "and its driven price "+b+" is not matched with the actualprice "+a
				reportStep("The Element with xpath "+xpat+ "and its driven price "+a+" is not matched with the actualprice "+b,"fail");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//System.err.println("The String is not converted to numbers due to the mismatched String format and the values are "+a+" "+b);
			reportStep("Print "+actualPrice +b+"The String is not converted to numbers due to the mismatched String format and the values are "+a+" , "+actualPrice,"fail");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpat+" is not found in the DOM");
			reportStep("The Element with xpath "+xpat+" is not found in the DOM","fail");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpat+" is not visible in the application");
			reportStep("The Element with xpath "+xpat+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpat+" is not interactable with the application");
			reportStep("The Element with xpath "+xpat+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpat+" is not stable in the application");
			reportStep("The Element with xpath "+xpat+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			//System.out.println("The Element with xpath "+xpat+" and its price "+a+" is not compared with actualprice "+b+" due to unknown error");
			reportStep("The Element with xpath "+xpat+" and its price "+a+" is not compared with actualprice "+b+" due to unknown error","fail");
			// TODO: handle exception
		}
			
		}
		
			
		

	public void pageScroll() {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_DOWN);
		//System.out.println("The Element with xpath is successfully scroll down the page view");
			reportStep("The Element with xpath is successfully scroll down the page view","pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with xpath is not able to scroll the page due to unknown error");
			reportStep("The Element with xpath is not able to scroll the page due to unknown error","fail");
		}finally {
			
		}
	}

	public void clickByXpathWithCount(String xpath, int i) {
		// TODO Auto-generated method stub
	int a=0;
		try {
			for(a=0;a<i;a++)  {
			driver.findElementByXPath(xpath).click();}{
			if(a==i) {
			//System.out.println("The element with the xpath "+xpath+" is successfully clicked with counts "+i+" in the application");
				reportStep("The element with the xpath "+xpath+" is successfully clicked with counts "+i+" in the application","pass");
			}else {
				//System.err.println("The element with the xpath "+xpath+" is not successfully clicked with counts "+i+" in the application");
				reportStep("The element with the xpath "+xpath+" is not successfully clicked with counts "+i+" in the application","fail");}	
			}} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The element with xpath "+xpath+" is not found in the DOM");
				reportStep("The element with xpath "+xpath+" is not found in the DOM","fail");
				
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpath+" is not visible in the application");
			reportStep("The element with xpath "+xpath+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpath+" is not interactable with the application");
			reportStep("The element with xpath "+xpath+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpath+" is not stable in the application");
			reportStep("The element with xpath "+xpath+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The element with xpath "+xpath+" is not clicked with the counts "+i+" due to unknown error");
			reportStep("The element with xpath "+xpath+" is not clicked with the counts "+i+" due to unknown error","fail");
		}finally {
			
		}
}

	public void selectindexByXpath(String xpath, int index) {
		// TODO Auto-generated method stub
		try {
			WebElement title = driver.findElementByXPath(xpath);
			Select sel = new Select(title);
			sel.selectByIndex(index);
			//System.out.println("The Element with xpath "+xpath+" and its dropdown Index "+index+" is successfully selected");
		   reportStep("The Element with xpath "+xpath+" and its dropdown Index "+index+" is successfully selected","pass");	
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("The Element with xpath "+xpath+" and its dropdown Index "+index+" is not found in the DOM");
			reportStep("The Element with xpath "+xpath+" and its dropdown Index "+index+" is not found in the DOM","fail");
		   }catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" and its dropdown index "+index+" is not visible in the application");
			   reportStep("The Element with xpath "+xpath+" and its dropdown index "+index+" is not visible in the application","fail");
		   }catch (ElementNotInteractableException e) {
			// TODO: handle exception
			   //System.err.println("The Element with xpath "+xpath+" and its dropdown index "+index+" is not interactable with the application");
			   reportStep("The Element with xpath "+xpath+" and its dropdown index "+index+" is not interactable with the application","fail");
		  }catch (ElementNotSelectableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" and its dropdown index "+index+" is not selectable in the application");
			  reportStep("The Element with xpath "+xpath+" and its dropdown index "+index+" is not selectable in the application","fail");
		   }catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpath+" and its dropdown index"+index+" is not selected due to unknown error");
			   reportStep("The Element with xpath "+xpath+" and its dropdown index"+index+" is not selected due to unknown error","fail");
		   }finally {
			
		
		
	
	}
}

          public void enterByXpath(String xpathValue, String data, Keys tab)  {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data,Keys.TAB);
			//System.out.println("The Element with xpath"+xpathValue+" is successfully entered with the data "+data);
			reportStep("The Element with xpath"+xpathValue+" is successfully entered with the data "+data,"pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
		    //System.err.println("The Element with xpath "+xpathValue+" is not found in the DOM");
		reportStep("The Element with xpath "+xpathValue+" is not found in the DOM","fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not visible in the application");
			reportStep("The Element with xpath "+xpathValue+" is not visible in the application","fail");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not interactable with the application");
			reportStep("The Element with xpath "+xpathValue+" is not interactable with the application","fail");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not stable in the application");
			reportStep("The Element with xpath "+xpathValue+" is not stable in the application","fail");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//System.err.println("The Element with xpath "+xpathValue+" is not entered with the data "+data+" due to unknown Error");
			reportStep("The Element with xpath "+xpathValue+" is not entered with the data "+data+" due to unknown Error", "fail");
		}
		
	}
		
	

		public void pageScrollUp() {
			// TODO Auto-generated method stub
			driver.findElementByXPath("//html/body").sendKeys(Keys.PAGE_UP);
			
	}
/*		String newText=null;
		public  void verifyTextWithExistingText(String xpathVal) {
			
			try {
				newText=getTextByXpath(xpathVal);
				if(actualText.equalsIgnoreCase(newText)) {
					System.out.println("The Element with xpath "+xpathVal+" and its holding text "+newText+" is matched with the existing text "+actualText);
				}else {System.err.println("The Element with Xpath "+xpathVal+" and its holding text is not matched  with the existing text "+actualText);
				}
			} catch (NoSuchElementException e) {System.err.println("The Element with xpath "+xpathVal+" and its holding text "+newText+" is not found in the DOM");
				// TODO Auto-generated catch block
			}catch (ElementNotVisibleException e) {System.err.println("The Element with xpath "+xpathVal+ " and its holding text is not visible in the application");
				// TODO: handle exception
			}catch (ElementNotInteractableException e) {System.err.println("The Element with xpath "+ xpathVal+" is not interactable with the application");
			// TODO: handle exception
			}catch (StaleElementReferenceException e) {System.err.println("The Element with xpath "+xpathVal+" and its holding text "+newText+" is not stable in the application");
				// TODO: handle exception
			}catch (WebDriverException e) {System.err.println("The Element with xpath "+xpathVal+" and its holding text "+newText+" is not matched due to unknown error in the application");
				// TODO: handle exception
			}}
*/

		@Override
		public void getPriceCompareValue(String xpat, int day) {
			// TODO Auto-generated method stub
			
		}			
		    
}
