package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationSignContract extends LendNation{
	

	public static void signContract(String SSN,String AppURL) throws Exception
	{
		try{
			String FileName= prop.getProperty("file_name");
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";
				WebDriverWait wait = new WebDriverWait(driver, 40000);

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(10000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));

				System.out.println("Under SignContra");
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				//test.log(LogStatus.INFO, "Lend Nation application navigated to Sign Contract page ");
				test.log(LogStatus.INFO, "Lend Nation application navigated to Sign Contract page");


				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(2000);
				driver.findElement(locator(prop.getProperty("checkbox2_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(2000);

				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(2000);

				driver.findElement(locator(prop.getProperty("checkbox4_signpage"))).click();

				test.log(LogStatus.PASS, "Checked the fourth checkbox");
				driver.findElement(locator(prop.getProperty("signature_field1"))).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(2000);

				driver.findElement(locator(prop.getProperty("checkbox5_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the fifth checkbox");
				
				driver.findElement(locator(prop.getProperty("signature_field2"))).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the Second Signature field details as : "+Signaturename);
				

				driver.findElement(locator(prop.getProperty("get_loan_button"))).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				 if( driver.findElement(locator(prop.getProperty("go_to_dashboard_button"))).isEnabled())
				  {
						//test.log(LogStatus.PASS, "Esign Successfully with SSN :" +SSN);
						test.log(LogStatus.PASS, "Esign Successfully with SSN :" +SSN);

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}

//Verify By Phone page code
				 Thread.sleep(20000);
				 wait.until(ExpectedConditions.elementToBeClickable(locator(prop.getProperty("go_to_dashboard_button"))));
				 driver.findElement(locator(prop.getProperty("go_to_dashboard_button"))).click();
					//test.log(LogStatus.INFO, "Lend Nation application navigated to Verify By Phone page ");
					test.log(LogStatus.INFO, "Lend Nation application navigated to Verify By Phone page");


					test.log(LogStatus.PASS, "Clicked on go To Dashboard button");
					 Thread.sleep(10000);
					 //wait.until(ExpectedConditions.((driver.findElement(locator(prop.getProperty("Loan_number")))));
					 String loan_number_field=driver.findElement(locator(prop.getProperty("Loan_number"))).getText();
					 String[] loanfield=loan_number_field.split(":");
					 loan_number=loanfield[1];
					//test.log(LogStatus.PASS, "Loan number generated is :"+loan_number);
					test.log(LogStatus.PASS, "Loan number generated is :"+loan_number);


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	}
	
	
	

