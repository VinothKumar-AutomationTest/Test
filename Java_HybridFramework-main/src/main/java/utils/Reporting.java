package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporting {
	
	public static ExtentHtmlReporter htmlreport;
	
	public static ExtentReports report;
	
	public static ExtentTest test;
	
	public String testCaseName,testCaseDescribtion,author,category ;
	
	public void startReport() {
		
		System.out.println("Started Report");
        
		 htmlreport = new ExtentHtmlReporter("./reports/result.html");
		
		 report = new ExtentReports();
		
		 report.attachReporter(htmlreport);
		
	}

	public void startTest(String description,String testName) {
		
	test = report.createTest(testName, description);
	test.assignAuthor(author);
	test.assignCategory(category);
		
	}	
	
	
	/**
	 * This method will take snapshot of the browser
	 * @author Basha - LibertyTestingCenter
	 */
	public abstract long takeSnap();
	
	
	
	
	//int i=1;
	public void reportStep(String details,String status) {
		
		try {
			long snapNumber =takeSnap();
			
			if(status.equalsIgnoreCase("pass")) {
			//System.out.println("Step is pass");
				test.log(Status.PASS, details +test.addScreenCaptureFromPath(".././reports/screenshots/"+snapNumber+".jpg") );
				
			}else if(status.equalsIgnoreCase("fail")) {
				System.err.println("Step is fail");
				test.log(Status.FAIL, details +test.addScreenCaptureFromPath(".././reports/screenshots/"+snapNumber+".jpg")) ;
				//System.err.println("The total number of failed step is: "+ i++);
			
			}else if (status.equalsIgnoreCase("INFO")) {
				
				test.log(Status.INFO, details +test.addScreenCaptureFromPath(".././reports/screenshots/"+snapNumber+".jpg"));
				
			}else if (status.equalsIgnoreCase("warning")) {
				test.log(Status.WARNING, details +test.addScreenCaptureFromPath(".././reports/screenshots/"+snapNumber+".jpg"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void reportStep(String details,String status, boolean snap) {
		
	
			if(!snap) {
			
			if(status.equalsIgnoreCase("pass")) {
			
				test.log(Status.PASS, details );
				
			}else if(status.equalsIgnoreCase("fail")) {
				System.err.println("Step is fail");
				test.log(Status.FAIL, details ) ;
			
			}else if (status.equalsIgnoreCase("INFO")) {
				
				test.log(Status.INFO, details );
				
			}else if (status.equalsIgnoreCase("warning")) {
				test.log(Status.WARNING, details );
			}
			}
		
			
	}
	
	public void endReport() {
		System.out.println("Ended Report");
		report.flush();
	}
}
