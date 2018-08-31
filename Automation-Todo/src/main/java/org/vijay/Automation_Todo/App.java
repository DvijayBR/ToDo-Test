package org.vijay.Automation_Todo;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	
	
   public static void main (String[] args) {

    	
    		//System.setProperty("webdriver.chrome.driver","C:\\Users\\PraiseTheLord\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	
	//	WebDriver driver = new ChromeDriver();
        ToDoTester tester = new ToDoTester();
        tester.setDriver(new ChromeDriver());
        tester.run();
        tester.stop();
    	
  
    }
    
  
}