package tests;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
public class StringMethods{

	public static void substring() throws Exception {
		// TODO Auto-generated method stub
		
  
        String str="Selenium is based on Java Programme";
          int beginIndex =2;
          int endIndex=5;
		
        String sub=str.substring(beginIndex,endIndex);           
        System.out.println(sub);
        	
        }

	
public static void subchar() throws Exception {
	// TODO Auto-generated method stub
	

     String str="Selenium is based on Java Programme";
      
	
	  char ch1= str.charAt(4);
	
    System.out.println(ch1);
    	
    }
}





	
