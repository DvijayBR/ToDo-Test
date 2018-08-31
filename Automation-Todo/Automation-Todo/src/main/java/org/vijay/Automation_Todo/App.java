package org.vijay.Automation_Todo;

import org.openqa.selenium.chrome.ChromeDriver;

public class App  {
	
	
    public static void main(String[] args) {


        ToDoTester tester = new ToDoTester();
        tester.setDriver(new ChromeDriver());
        tester.run();
        tester.stop();
        
    }
    
  
}