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



public class LendNationCSR extends LendNation{

	public static void lendNationCSRLogin(String SSN,String AppURL,String loan_number) throws Exception
	{
		try{
			//String FileName= prop.getProperty("file_name");
			String FileName= "Registration_Lend_Nation_CAS.xls";
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("CSRLogin");
				String sheetName="CSRLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String admin_url = TestData.getCellData(sheetName,"AdminURL",row);

					String username = TestData.getCellData(sheetName,"Username",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String ApplicationStatus = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String Product_Type = TestData.getCellData(sheetName,"Product_Type",row);
					String Courtesy_Call_Consent = TestData.getCellData(sheetName,"Courtesy_Call_Consent",row);
					String RepaymentMethod = TestData.getCellData(sheetName,"RepaymentMethod",row); 
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					//String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
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
				       if(ReceiveType.equalsIgnoreCase("ACH")){
					
				     // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)("topFrame"));
				       
				        driver.switchTo().frame("topFrame");
					    wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(locator(prop.getProperty("borrower_tab"))))));

						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
						Thread.sleep(3000);
						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Borrower tab");
						driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(prop.getProperty("pam_link"))).click();			
						//driver.switchTo().defaultContent();

						driver.switchTo().frame("main");

						//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
						test.log(LogStatus.PASS, "Clicked on PAM");	
						//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
						test.log(LogStatus.INFO, "Applicant Search page is displayed");

						driver.findElement(By.xpath("//*[@id='loanType2']/select")).sendKeys(Product_Type);
						test.log(LogStatus.INFO, "producttype is entered as :" +Product_Type);
				        //loan_number="10788581";
						driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
						//driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
						
						test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
						Thread.sleep(4000);
						
						
						driver.findElement(By.name("requestBean.applicationStatus")).sendKeys("Pending");
						test.log(LogStatus.PASS, "Selected Application status as " +ApplicationStatus);
						
						driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
						test.log(LogStatus.PASS, "Clicked on Submit button " );
						
						Thread.sleep(2000);
						driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();  
						test.log(LogStatus.PASS, "Selected the radio button" );
						driver.findElement(locator(prop.getProperty("go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on Go button "  );
						
					

						
						driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
						test.log(LogStatus.PASS, "Given comments as  " +comments );
						
						driver.findElement(By.id("verificationActionId")).sendKeys(ApplicationStatus);
						test.log(LogStatus.PASS, "Entered Application Status"+ApplicationStatus);
						
						driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
						test.log(LogStatus.PASS, "Clicked on Continue button "  );
						/*Thread.sleep(2000);
						driver.findElement(locator(prop.getProperty("last_four_account_no"))).sendKeys(last_four_account_no);
						test.log(LogStatus.PASS, "Entered last four digits of account no : " +last_four_account_no );*/
						Thread.sleep(3000);
						//requestBean.siilBean.courtesyCallFlag
					
					  
						
							
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
						
						}
						
						else if(ReceiveType.equalsIgnoreCase("Cash At Store")) {		
						
					     test.log(LogStatus.PASS, "Receive Type is : "+ReceiveType);
							 driver.switchTo().frame("topFrame");
							    wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(locator(prop.getProperty("borrower_tab"))))));

								driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
								Thread.sleep(3000);
								driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
								test.log(LogStatus.PASS, "Clicked on Borrower tab");
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								
								driver.findElement(locator(prop.getProperty("pam_link"))).click();			
								//driver.switchTo().defaultContent();

								driver.switchTo().frame("main");

								//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
								test.log(LogStatus.PASS, "Clicked on PAM");	
								//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
								test.log(LogStatus.INFO, "Applicant Search page is displayed");

								driver.findElement(By.xpath("//*[@id='loanType2']/select")).sendKeys(Product_Type);
								test.log(LogStatus.INFO, "producttype is entered as :" +Product_Type);
								
								loan_number="10788581";
								driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
								
								test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
								Thread.sleep(4000);
								driver.findElement(By.name("requestBean.applicationStatus")).sendKeys(ApplicationStatus);
								test.log(LogStatus.PASS, "Selected Application status as " +ApplicationStatus);
								Thread.sleep(4000);
								driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
								test.log(LogStatus.PASS, "Clicked on Submit button " );
								
								Thread.sleep(2000);
								driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();  
								test.log(LogStatus.PASS, "Selected the radio button" );
								driver.findElement(locator(prop.getProperty("go_button"))).click();
								test.log(LogStatus.PASS, "Clicked on Go button "  );
								
				
								driver.findElement(locator(prop.getProperty("applicatino_status_selection"))).sendKeys(ApplicationStatus);
								test.log(LogStatus.INFO, "PAM Action page is displayed");
								//test.log(LogStatus.PASS, "Selected Application status as " +application_status );
								test.log(LogStatus.PASS, "Selected Application status as " +ApplicationStatus);

								
								driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
								test.log(LogStatus.PASS, "Given comments as  " +comments );
								
								driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
								test.log(LogStatus.PASS, "Clicked on Continue button "  );
								Thread.sleep(2000);
								
								
								
							    Thread.sleep(1000);
							    String text=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td")).getText();
							    test.log(LogStatus.PASS, text  );
							    test.log(LogStatus.PASS, "Cash At Store "  );
							    driver.close();
							  
							    break;
						  }	
						else if(ReceiveType.equalsIgnoreCase("DEBIT CARD")){
							
						     // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator)("topFrame"));
						       
						        driver.switchTo().frame("topFrame");
							    wait.until(ExpectedConditions.elementToBeClickable((driver.findElement(locator(prop.getProperty("borrower_tab"))))));

								driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
								Thread.sleep(3000);
								driver.findElement(locator(prop.getProperty("borrower_tab"))).click();			
								test.log(LogStatus.PASS, "Clicked on Borrower tab");
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								
								driver.findElement(locator(prop.getProperty("pam_link"))).click();			
								//driver.switchTo().defaultContent();

								driver.switchTo().frame("main");

								//driver.findElement(By.cssSelector("li[id='955190406']")).click();			
								test.log(LogStatus.PASS, "Clicked on PAM");	
								//test.log(LogStatus.INFO, "Applicant Search page is displayed");	
								test.log(LogStatus.INFO, "Applicant Search page is displayed");

								driver.findElement(By.xpath("//*[@id='loanType2']/select")).sendKeys(Product_Type);
								test.log(LogStatus.INFO, "producttype is entered as :" +Product_Type);
						        //loan_number="10788581";
								driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
								//driver.findElement(locator(prop.getProperty("loan_number_field"))).sendKeys(loan_number);
								
								test.log(LogStatus.PASS, "Entered Loan number : " +loan_number );
								Thread.sleep(4000);
								
								
								driver.findElement(By.name("requestBean.applicationStatus")).sendKeys(ApplicationStatus);
								test.log(LogStatus.PASS, "Selected Application status as " +ApplicationStatus);
								
								driver.findElement(locator(prop.getProperty("submit_button_pam"))).click();
								test.log(LogStatus.PASS, "Clicked on Submit button " );
								
								Thread.sleep(2000);
								driver.findElement(locator(prop.getProperty("radio_button_of_search"))).click();  
								test.log(LogStatus.PASS, "Selected the radio button" );
								
								driver.findElement(locator(prop.getProperty("go_button"))).click();
								test.log(LogStatus.PASS, "Clicked on Go button ");
								
								driver.findElement(locator(prop.getProperty("comment_section"))).sendKeys(comments);
								test.log(LogStatus.PASS, "Given comments as  " +comments );
								Thread.sleep(3000);
								driver.findElement(By.id("verificationActionId")).sendKeys("Loan Approved");
								test.log(LogStatus.PASS, "Selected loan status as  " +ApplicationStatus );
								
								driver.findElement(locator(prop.getProperty("continue_button_loan"))).click();
								test.log(LogStatus.PASS, "Clicked on Continue button "  );
								
								Thread.sleep(3000);
									
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
								
								}

						
						
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

