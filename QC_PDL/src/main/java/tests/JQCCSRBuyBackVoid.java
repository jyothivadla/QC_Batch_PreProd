package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;

//public class QCCSRDueDate extends QCStore {

//}
public class JQCCSRBuyBackVoid extends QCStore{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	


public static void buybackvoid(String SSN,String AppURL)
	{
		 
		try{
			int lastrow=TestData.getLastRow("BuyBack_Void");
			String sheetName="BuyBack_Void";

				for(int row=2;row<=lastrow;row++)
				{	
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String DisbType = TestData.getCellData(sheetName,"DisbType",row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					if(SSN.equals(RegSSN))
					{		
						State = TestData.getCellData(sheetName,"StateID",row);

		
						 SSN1 = SSN.substring(0, 3);
						 SSN2 = SSN.substring(3,5);
						 SSN3 = SSN.substring(5,9);
						
						 
						Thread.sleep(3000);
						test.log(LogStatus.INFO,"Buy Void BuyBack started");
					   driver.switchTo().frame("topFrame");
						driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();			
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						
						driver.findElement(locator(Jprop.getProperty("csr_transaction_link"))).click();			
						test.log(LogStatus.PASS, "Clicked on Transaction");		
						driver.switchTo().frame("main");	
						Thread.sleep(500);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
						driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
						driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");		
						for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);				
					    driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");					    					   					     
					    driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
					    test.log(LogStatus.PASS, "Clicked on GO Button");
					    Thread.sleep(5000);					  			
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						
						 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 test.log(LogStatus.PASS, "Clicked on GO Button");
						 Thread.sleep(5000);
						 driver.findElement(By.name("transactionList")).sendKeys("Void");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Void");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button");
						 Thread.sleep(500);	
						 driver.findElement(By.name("transactionDataBean.disbursementType")).sendKeys(DisbType);
						 test.log(LogStatus.PASS, "Tender Type is :"+DisbType);						 						 
						
						 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
						 test.log(LogStatus.PASS, "Pin is entered");
						 driver.findElement(By.name("Submit22")).click();
						 test.log(LogStatus.PASS, "Clicked on Finish Void Buyback");
						 Thread.sleep(5000);
						
						 driver.findElement(By.name("checkno")).click();
						 test.log(LogStatus.PASS,"Void BuyBack Completed Successfully");
						 Thread.sleep(500);
						 driver.close();
					
						}
					}
				}
		
		}
		               

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL,"New Loan is failed");

			}
	
}
	
}

