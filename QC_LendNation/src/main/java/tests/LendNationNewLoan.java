package tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationNewLoan extends LendNation{

	public static void LendNationCashAtStore(String SSN,String AppURL,String loan_number) throws Exception
	{
		try{
			//String FileName= prop.getProperty("file_name");
			String FileName= "Registration_Lend_Nation_CAS.xls";
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("CSRNewLoan");
				String sheetName="CSRNewLoan";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{		
					
					String admin_url = TestData.getCellData(sheetName,"AdminURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String Product_Type = TestData.getCellData(sheetName,"Product_Type",row);
					String Courtesy_Call_Consent = TestData.getCellData(sheetName,"Courtesy_Call_Consent",row);
					String State_Id  = TestData.getCellData(sheetName,"State_Id",row);
					String PIN  = TestData.getCellData(sheetName,"PIN",row);
					   
					
						test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "CSR Application is launched");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(admin_url);
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					
				     // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)("topFrame"));
				       
				        driver.switchTo().frame("topFrame");
					    wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(locator(prop.getProperty("borrower_tab"))))));

						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						Thread.sleep(3000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						Thread.sleep(300);
						
					    driver.findElement(By.xpath("//*[@id='955190407']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Cash At Store");						
						Thread.sleep(3000);
						driver.switchTo().frame("main");
						
						driver.findElement(By.name("requestBean.stateCode")).sendKeys(State_Id);
						test.log(LogStatus.PASS, "entered State_Id as" +State_Id);
						
						driver.findElement(By.name("requestBean.ssn")).sendKeys(RegSSN);
						test.log(LogStatus.PASS, "entered SSN as" +RegSSN);
						
						driver.findElement(By.name("submit")).click();
						test.log(LogStatus.PASS, "Clicked on submit button");
						
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on GO button");
						
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						test.log(LogStatus.PASS, "entered State_Id as" +PIN);
						
						
						
						Thread.sleep(2000);
						
						driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(Courtesy_Call_Consent);
						test.log(LogStatus.PASS, "Selected as" +Courtesy_Call_Consent  );
						
						driver.findElement(By.name("requestBean.siilBean.preference")).click();
						test.log(LogStatus.PASS, "Selected as preferenceCall" );
						
						
						driver.findElement(By.name("finishLoan")).click();
						//driver.findElement(locator(prop.getProperty("finish_loan"))).click();
						
						test.log(LogStatus.PASS, "Clicked on Finish loan button "  );
						Thread.sleep(2000);

					    driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
						test.log(LogStatus.PASS, "clicked on Yes for Confirm "  );
						Thread.sleep(2000);
						driver.findElement(By.name("ok")).click();
						test.log(LogStatus.PASS, "clicked on OK "  );
						test.log(LogStatus.PASS, "Installment Loan Completed Successfully "  );
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "lendNationCSR");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
							
					  }
	
}
	}

