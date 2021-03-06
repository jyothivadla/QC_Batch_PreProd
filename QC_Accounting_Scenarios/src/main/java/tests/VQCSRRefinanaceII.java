package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;


import com.relevantcodes.extentreports.LogStatus;

public class VQCSRRefinanaceII extends QCStore {
	public static String last4cheknum;
	public static String No_of_checks;
	public static void payment (String SSN,String AppURL) throws Exception
	{	
		test.log(LogStatus.INFO, "******************Performing  payment ******************");
		  	
		int lastrow=TestData.getLastRow("Refinance");
		String sheetName="Refinance";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))

			{	
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				//String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String CouponNbr= TestData.getCellData(sheetName,"CouponNbr",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);
				String ESign_CourtesyCallConsent= TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
				ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
				ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
				ESign_CheckNbr=SSN.substring(SSN.length() - 6);
				last4cheknum= SSN.substring(SSN.length() - 4);
				No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"Refinance started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Vprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Vprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Vprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
				for( String winHandle1 : driver.getWindowHandles())
				{
					driver.switchTo().window(winHandle1);
				}			
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(500);	

				
				if (ESign_CollateralType.equals("ACH")) {
				driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
				test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as " + last4cheknum);
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on Qualify button");
				Thread.sleep(2000);
				driver.findElement(By.name("transactionDataBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
                test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
				}
				/*if (ESign_CollateralType.equals("ACH")) {
					driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
					test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as " + last4cheknum);
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on Qualify button");
					
					driver.findElement(By.name("transactionDataBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
	                test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
					}*/
				/*driver.findElement(By.name("allowPromotion")).click();
				test.log(LogStatus.PASS, "Clicked on Allow Coupons button");*/
				/*driver.findElement(By.name("transactionDataBean.couponNbr")).sendKeys(CouponNbr);
				test.log(LogStatus.PASS, "Entered the coupon number as "+ CouponNbr);*/
				

			if (ESign_CollateralType.equals("CHECK")) {
				driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
				test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as " + last4cheknum);
				driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on Qualify button");
				Thread.sleep(2000);
				driver.findElement(By.name("transactionDataBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
                test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
                driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(No_of_checks);
    			test.log(LogStatus.PASS, "Selected no of checks as " + No_of_checks);
    			driver.findElement(By.name("requestBean.noOfChecks")).sendKeys(Keys.ENTER);
    			Thread.sleep(2000);
    			driver.findElement(By.name("chkNbr0")).sendKeys(ESign_CheckNbr);
    			test.log(LogStatus.PASS, "Check number is " + ESign_CheckNbr);
    			// driver.findElement(By.name("chkBoxNbr0")).click();
    			// test.log(LogStatus.PASS, "Selected the Check option radio
    			// button");
    			driver.findElement(By.name("Print0")).click();
    			test.log(LogStatus.PASS, "Clicked on Print button");
    			
				}
			
			String PaymentAmount= driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
			
			//driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PaymentAmount);
			test.log(LogStatus.PASS, "PaymentAmount entered :"+PaymentAmount);
			driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
			test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
			driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(PaymentAmount);
			test.log(LogStatus.PASS, "TenderAmount is :"+PaymentAmount);	
			driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
			test.log(LogStatus.PASS, "Pin is entered");
			driver.findElement(By.name("cashAgain")).click();
			test.log(LogStatus.PASS, "Clicked on Finish Refinance");
			
			//driver.findElement(By.name("finish")).click();
			//test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");

			Thread.sleep(5000);
			try { 
				Alert alert = driver.switchTo().alert();

				alert.accept();
				test.log(LogStatus.PASS, "Alert Handeld");
																		
			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}
			Thread.sleep(6000);
			driver.findElement(By.name("OKBut")).click();
			test.log(LogStatus.PASS, "Clicked on Yes button");
			
			driver.findElement(By.name("checkyes")).click();

			test.log(LogStatus.PASS,"Refinance Completed Successfully");
			
		}
			}
			
		}
	}



	




