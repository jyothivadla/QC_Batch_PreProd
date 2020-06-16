package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

public class LendNationLoanDecision extends LendNation{

	  @Test(priority=4)
	  public static void loandecision(String SSN,String AppURL) throws Exception
	  {
		 
			  //String FileName= prop.getProperty("file_name");
			  String FileName= "Registration_Lend_Nation_CAS.xls";
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 

			//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			int lastrow=TestData.getLastRow("Loan Decision");
			String sheetName="Loan Decision";
			WebDriverWait wait = new WebDriverWait(driver, 40000);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			//String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			  String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			  String Verification_Code = TestData.getCellData(sheetName,"Verification_Code",row);
			
			Thread.sleep(500);
			test.log(LogStatus.INFO, "Lend Nation application navigated to Loan Decision page " );
			Thread.sleep(100);
			  //wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rad1']")));
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pdlloan']")));
			  
			  if (ProductID.equals("PDL")) {	 
			     driver.findElement(By.xpath("//*[@id='rad1']")).click();
			     test.log(LogStatus.PASS, "Clicked on Payday Loan Radio buton " );
			  }
			     else{
			     //driver.findElement(By.xpath("//*[@id='rad2']")).click();
			      Thread.sleep(100);
			     driver.findElement(By.xpath("//*[@id='insloan']")).click();
			     test.log(LogStatus.PASS, "Clicked on Installment Loan" );
			     }
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			  Thread.sleep(30000);
			  //driver.findElement(By.id("storeloan")).click();
			   driver.findElement(By.xpath("//*[@id='onlineLoan']")).click();
			
			  //*[@id="onlineLoan"]
			  test.log(LogStatus.PASS, "Clicked on onlineLoan buton " );
			    
			  //driver.findElement(By.xpath("//*[@id='productSubmitBtn']")).click();
			  /*driver.findElement(By.xpath("//*[@id='productSelectBtn']")).click();                  
			  test.log(LogStatus.PASS, "Clicked on Next buton " );*/

			 // Thread.sleep(30000);
			  Thread.sleep(30000);
			  
			  
			  
			  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loanAmt']")));
			  Thread.sleep(500);
			  
			  String MaxEligibleLoanamount = driver.findElement(By.xpath("//*[@id='maxAmt']")).getAttribute("value");
			  test.log(LogStatus.PASS, "Max Eligible Loan amount is : " +MaxEligibleLoanamount );
			  
			  Thread.sleep(500); 
			  
			  String Loanamount = driver.findElement(By.name("loanAmt")).getAttribute("value");
			  test.log(LogStatus.PASS, "Loan amount is : " +Loanamount );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='terms1']")).click();
			  test.log(LogStatus.PASS, "Clicked on option1" );//clicked on option1
			  			     
			  driver.findElement(By.xpath("//input[@value='3' and @type='radio']")).click();
			  test.log(LogStatus.PASS, "Clicked on send email Radio button " );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.name("aEmailVerificationCode")).sendKeys(Verification_Code);
			  test.log(LogStatus.PASS, "Verification Code set as : " +Verification_Code );
			  
			  Thread.sleep(500);
			  
			  driver.findElement(By.xpath("//*[@id='confirm']")).click();
			  test.log(LogStatus.PASS, "Clicked on Verification Confirm button " );
			  
			  Thread.sleep(500);
			  			 
		/*	  if(driver.findElement(By.xpath("//*[@id='msg']/span")).isDisplayed())
			    	
			 	{
				
					 test.log(LogStatus.FAIL,"Verification Code Doesn't Match");
					 
					 
					 //Assert.assertTrue(false);

			 	}
			 	else
				{
				
				 test.log(LogStatus.PASS,"Verification Code Match");

				}*/
			  
			  Thread.sleep(5000);
			  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("ratechart_disclosure_checkbox")))));

			 
			  //driver.findElement(locator(prop.getProperty("ratechart_disclosure_checkbox"))).click();
			  
			    driver.findElement(By.xpath("//*[@id='loanRateChartChk']")).click();
			    test.log(LogStatus.PASS, "Checked the radio button of Rate Chart, License and Related State Disclosures " );
				Thread.sleep(5000);
				driver.findElement(locator(prop.getProperty("submit_button_under_submit"))).click();
				test.log(LogStatus.PASS, "Clicked on Submit " );
				Thread.sleep(50000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				
				 if( driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).isEnabled())
				  {
						//test.log(LogStatus.PASS, "Submitted Application Successfully with SSN : " +SSN);	
						test.log(LogStatus.PASS, "Submitted Application Successfully with SSN : " +SSN);

					 	}
						else
						{
						test.log(LogStatus.FAIL, " Application not submitted successfully with SSN : " +SSN);
						}


			
					}
					}
				
			  
			 

			
	/*	//	test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page " );
			test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page");
			//driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
			//test.log(LogStatus.PASS, "Selected repayment type as " + RepaymentMethod);
			Thread.sleep(10000);

			driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
			  test.log(LogStatus.PASS, "Clicked on Continue " );
			  try{
				  driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys("d");
				  Thread.sleep(2000);
				  //driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
				  Thread.sleep(4000);
				  driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
			  }
			  catch(Exception e)
			  {
				  
			  }

			  wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("loan_amount"))));
	Thread.sleep(20000);
			  if( driver.findElement(locator(prop.getProperty("loan_amount"))).isEnabled())
			  {
					//test.log(LogStatus.PASS, "Repayment Information Entered Successfully with SSN : " +SSN);
					test.log(LogStatus.PASS, "Repayment Information Entered Successfully with SSN : " +SSN);

				 	}
					else
					{
					test.log(LogStatus.FAIL, "Repayment Information is not entered Successfully with SSN  : " +SSN);
					}*/
			
			
				
			
			
		  }
		/*  catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Loan Information is not entered Successfully with SSN  " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "LoanDecision");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));

		  }*/
			
	  }
	  
	  


