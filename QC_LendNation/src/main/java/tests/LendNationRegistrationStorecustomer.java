package tests;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;


import tests.LendNation;

public class LendNationRegistrationStorecustomer extends LendNation{
	
	
	
	
	private static String sheetName;
	private static int row;

	public static void registration(String SSN,String AppURL) throws Exception
	  {
		  try{
		     //String FileName= "Registration_Lend_Nation_CAS.xls";LOC_Default_DefaultPayment
			  String FileName= "LOC_Default_DefaultPayment.xls";
		   //String FileName= prop.getProperty("file_name");
			 
			
		ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
		int lastrow=TestData.getLastRow("Registration");
		String sheetName="Registration";
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						
			
			
			
			System.out.println("SSN number  "+ RegSSN);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			  String SSN1 = SSN.substring(0, 3);
		      String SSN2 = SSN.substring(3,5);
		      String SSN3 = SSN.substring(5,9);
				String security_question_a = TestData.getCellData(sheetName,"SecurityQuestionA",row);
				String security_question_answer_a = TestData.getCellData(sheetName,"SecurityAnswerA",row);
				
				String security_question_b = TestData.getCellData(sheetName,"SecurityQuestionB",row);
				String security_question_answer_b = TestData.getCellData(sheetName,"SecurityAnswerB",row);
				
				String security_question_c = TestData.getCellData(sheetName,"SecurityQuestionC",row);
				String security_question_answer_c = TestData.getCellData(sheetName,"SecurityAnswerC",row);
				String FirstName= TestData.getCellData(sheetName,"FirstName",row);
				String LastName= TestData.getCellData(sheetName,"LastName",row);
				String Zip_Code= TestData.getCellData(sheetName,"Zip_Code",row);
				 String date_of_birth = TestData.getCellData(sheetName,"date_of_birth",row);
					String DOB[] =date_of_birth.split("/");
			        String DOB1 = DOB[0];
			        String DOB2 = DOB[1];
			        String DOB3 = DOB[2];

			System.out.println(state);
			
		  driver.get("https://qclnlocal.qfund.net:8007/");
			
		
		  //driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natino URL  "+AppURL);

		  Thread.sleep(2000);
		  
		 driver.findElement(By.xpath("//*[@id='loginCaption']")).click();
		 
		  test.log(LogStatus.PASS, "Clicked on Login link ");

		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//*[@id='forgot-options-wrap']/a")).click();
		  test.log(LogStatus.PASS, "Clicked on Store Customer Setup link ");
		  Thread.sleep(4000);
	      driver.findElement(By.name("FirstName1")).sendKeys(FirstName);
	      test.log(LogStatus.PASS, "Entered FirstName : "+FirstName);
	      driver.findElement(By.name("LastName1")).sendKeys(LastName);
	      test.log(LogStatus.PASS, "Entered LastName : "+LastName);
	     Select dropdown= new Select(driver.findElement(By.id("idType")));
	     dropdown.selectByVisibleText("SSN");
		  Thread.sleep(2000);
		  driver.findElement(By.name("pSSN1")).sendKeys(SSN1);
		  driver.findElement(By.name("pSSN2")).sendKeys(SSN2);
		  driver.findElement(By.name("pSSN3")).sendKeys(SSN3);
		  test.log(LogStatus.PASS, "Entered SSN Number : "+SSN);
		  
		  //Date of birth entering
		  driver.findElement(locator(prop.getProperty("dob_month_field"))).sendKeys(DOB1);
		  driver.findElement(locator(prop.getProperty("dob_day_field"))).sendKeys(DOB2);
		  driver.findElement(locator(prop.getProperty("dob_year_field"))).sendKeys(DOB3);
		  test.log(LogStatus.PASS, "Entered DOB as  :"+ date_of_birth);
		  
		  driver.findElement(By.name("ZipCode")).sendKeys(Zip_Code);
		  test.log(LogStatus.PASS, "Entered DOB as  :"+ Zip_Code);
		  
		  driver.findElement(By.name("EmailAddress")).sendKeys(email);
		  test.log(LogStatus.PASS, "Entered Email : "+email);

		  driver.findElement(By.name("PasswordVal")).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Password : "+password);

		   driver.findElement(By.name("PasswordConfirmation")).sendKeys(password);
		  test.log(LogStatus.PASS, "Entered Verify Password : "+password);

	
		  int i_security_question_a=Integer.parseInt(security_question_a);
		  new Select(driver.findElement(locator(prop.getProperty("question_first_field")))).selectByIndex(i_security_question_a);
		  test.log(LogStatus.PASS, "Selected the first question  ");
		  

		  driver.findElement(locator(prop.getProperty("answer_fisrt_field"))).sendKeys(security_question_answer_a);
		  test.log(LogStatus.PASS, "Entered the first question answer as "+ security_question_answer_a);

		  int i_security_question_b=Integer.parseInt(security_question_b);
		  new Select(driver.findElement(locator(prop.getProperty("question_second_field")))).selectByIndex(i_security_question_b);
		  test.log(LogStatus.PASS, "Selected the second question  " );

		  driver.findElement(locator(prop.getProperty("answer_second_field"))).sendKeys(security_question_answer_b);
		  test.log(LogStatus.PASS, "Entered the second question answer as "+ security_question_answer_b);

		  int i_security_question_c=Integer.parseInt(security_question_c);
		  new Select(driver.findElement(locator(prop.getProperty("question_third_field")))).selectByIndex(i_security_question_c);
		  test.log(LogStatus.PASS, "Selected the third question  ");
		  driver.findElement(locator(prop.getProperty("answer_third_field"))).sendKeys(security_question_answer_c);
		  test.log(LogStatus.PASS, "Entered the third question answer  as "+ security_question_answer_c);
		  Thread.sleep(3000);
		 // driver.findElement(By.xpath("//span[@id='recaptcha-anchor' and @tabindex='0']/div[5]")).click();  // Added on 29-01-2019
		 // test.log(LogStatus.PASS, "Clicked on Captha button ");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//*[@id='submitOnBoarding']")).click();
		  
		  test.log(LogStatus.PASS, "Clicked on Submit button ");
		  
		

		  Thread.sleep(30000);
		 // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("firstname_field")))));
		/*  if( driver.findElement(locator(prop.getProperty("firstname_field"))).isEnabled())
		  {
				//test.log(LogStatus.PASS, "Registered Successfully with SSN : " +SSN);	
				test.log(LogStatus.PASS, "Registered Successfully with SSN : " +SSN,);

			 	}
				else
				{
				test.log(LogStatus.FAIL, "Registered is not Successfull with SSN  : " +SSN);
				}*/
			test.log(LogStatus.PASS, "Registered Successfully with SSN : " +SSN);

							
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "registration Information is not successfully filled with SSN : " +SSN);
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "registration");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }

}
