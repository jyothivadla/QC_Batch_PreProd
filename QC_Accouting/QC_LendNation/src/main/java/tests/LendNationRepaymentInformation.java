package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

public class LendNationRepaymentInformation extends LendNation{

	  @Test(priority=4)
	  public static void repaymentInformation(String SSN,String AppURL) throws Exception
	  {
		  try{
			  String FileName= prop.getProperty("file_name");
				ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 

			//Excel TestData = new Excel(System.getProperty("user.dir")+"/TestData/LendNation/"+FileName);  		 
			int lastrow=TestData.getLastRow("Repayment Information");
			String sheetName="Repayment Information";
			WebDriverWait wait = new WebDriverWait(driver, 40000);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{	
			String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row);
			String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			String LastName = TestData.getCellData(sheetName,"LastName",row);
			String BillingAddress = TestData.getCellData(sheetName,"BillingAddress",row);
			String DebitCard = TestData.getCellData(sheetName,"DebitCard",row);
			String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
			String CardType = TestData.getCellData(sheetName,"CardType",row);
			String CVV = TestData.getCellData(sheetName,"CVV",row);
			String ExpMonth = TestData.getCellData(sheetName,"ExpMonth",row);
			String ExpYear = TestData.getCellData(sheetName,"ExpYear",row);
			
			
			
			
			
			Thread.sleep(30000);

			  wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("repayment_method_type"))));
			
			//================== Repayment Method ACH ===================================
			  
			  if(RepaymentMethod.equalsIgnoreCase("ACH")){

				  test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page");
					driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
					test.log(LogStatus.PASS, "Selected repayment type as " + RepaymentMethod);
					Thread.sleep(10000);

					driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
					  test.log(LogStatus.PASS, "Clicked on Continue " );
					  Thread.sleep(30000);
					  Thread.sleep(30000);
			/*		  try{
						  driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys("d");
						  Thread.sleep(2000);
						  driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
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
							}
					*/
					
						}
			  
	//================== Repayment Method CHECK ===================================
			  
			      Thread.sleep(100);
			  
			  if(RepaymentMethod.equalsIgnoreCase("CHECK")){
				  
				 Thread.sleep(200); 
				 
				test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page");
				driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
			    test.log(LogStatus.PASS, "Selected repayment type as " + RepaymentMethod); 
			    
			    Thread.sleep(1000);
			    
			    driver.findElement(By.xpath("//*[@id='chkproceed']")).click();
				test.log(LogStatus.PASS, "Clicked on Proceed button ");
				
				 Thread.sleep(500);
				 
				driver.findElement(By.xpath("//*[@id='repaycheck']")).click();
				test.log(LogStatus.PASS, "Clicked on Check box ");
				
				Thread.sleep(500);
				
				driver.findElement(By.xpath("//*[@id='discproceed']")).click();
				test.log(LogStatus.PASS, "Clicked on Check box ");
				
				Thread.sleep(5000);
				
				driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
				test.log(LogStatus.PASS, "Clicked on Continue " );
				
				Thread.sleep(30000);
				Thread.sleep(30000);
				
				}
			  
			//================== Repayment Method DEBIT CARD ===================================
			  
				if(RepaymentMethod.equalsIgnoreCase("DEBIT CARD")){
					
				  Thread.sleep(500);
				  
				  test.log(LogStatus.INFO, "Lend Nation application navigated to Repayment Information page");
				  driver.findElement(locator(prop.getProperty("repayment_method_type"))).sendKeys(RepaymentMethod);
				  test.log(LogStatus.PASS, "Selected repayment type as " + RepaymentMethod); 
				  
				  Thread.sleep(100);
				
				  driver.findElement(By.xpath("//*[@id='rCardHolderFirstName']")).sendKeys(FirstName);
				  test.log(LogStatus.PASS, "Card Holder First Name is : " + FirstName); 
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rCardHolderLastName']")).sendKeys(LastName);
				  test.log(LogStatus.PASS, "Card Holder Last Name is : " + LastName);
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rCardHolderStreetAddress']")).sendKeys(BillingAddress);
				  test.log(LogStatus.PASS, "Billing Address is : " + BillingAddress);
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rCardNumber']")).sendKeys(DebitCard);
				  test.log(LogStatus.PASS, "Debit Card Number is : " + DebitCard);
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rCardHolderPostalCode']")).sendKeys(ZipCode);
				  test.log(LogStatus.PASS, "Zip Code is : " + ZipCode);
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rCVVNumber']")).sendKeys(CVV);
				  test.log(LogStatus.PASS, "Cvv Number is : " + CVV);
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rMonth']")).sendKeys(ExpMonth);
				  test.log(LogStatus.PASS, "Exp Month is : " + ExpMonth);
				  
				  Thread.sleep(100);
				  
				  driver.findElement(By.xpath("//*[@id='rYear']")).sendKeys(ExpYear);
				  test.log(LogStatus.PASS, "Exp year is : " + ExpYear);
				  
				  Thread.sleep(5000);
					
				  driver.findElement(locator(prop.getProperty("continue_button_Information_page"))).click();
				  test.log(LogStatus.PASS, "Clicked on Continue " );
				  
				  Thread.sleep(30000);
				  Thread.sleep(30000);



				}
			  
		  
	//============================		  
					}
			}
				  }
				  catch(Exception e)
				  {
						test.log(LogStatus.ERROR, "Repayment Information is not entered Successfully with SSN  " +SSN);
						test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "Repayment");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));

				  }
					
			  }
			  
			  

		}
				  
				  
	//}
			  
			  

			
