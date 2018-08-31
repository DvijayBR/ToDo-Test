package org.vijay.Automation_Todo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ToDoTester{

	private WebDriver driver = null;

	
	public void run(){
		driver.get("http://localhost:80");
		
		//addToList("Doc Appt","Doctor","12/Mar/2019");
		//removeFromList("Doc Appt");
		getToDoListMissing("");
	}
	
	public void addToList(String data,String cat,String dueDate){
		
		if(data.isEmpty() || data == null) return;
		
		int before = getToDoList().size();
		WebElement element = driver.findElement(By.name("data"));
		element.sendKeys(data);
		
		if(!cat.isEmpty() || cat != null){

			Select Category= new Select(driver.findElement(By.name("category")));
			Category.selectByVisibleText(cat);
			
		}
		
		if(!dueDate.isEmpty() || dueDate != null){
			String[] date = dueDate.split("/");
			Select day= new Select(driver.findElement(By.name("due_day")));
			day.selectByVisibleText(date[0]);
			
			Select month= new Select(driver.findElement(By.name("due_month")));
			month.selectByVisibleText(date[1]);
			
			Select year= new Select(driver.findElement(By.name("due_year")));
			year.selectByVisibleText(date[2]);
		}
		
		WebElement add_todo_submit = driver.findElement(By.xpath("//input[@name='data']/following-sibling::input[@name='submit']"));
		add_todo_submit.click();
		
		int after = getToDoList().size();
		assert(after == before+1);
		
	}
	
	public void removeFromList(String data){
		int before = getToDoList().size();
		List<WebElement> elements = getToDoList();
		elements.forEach(we ->{
			if(we.getText().contains(data)){
				we.findElement(By.cssSelector("input[name^='todo']")).click();
			}
		});
		
		driver.findElement(By.cssSelector("input[value='Remove']")).click();
		int after = getToDoList().size();
		assert(after == before-1);
	}
	
	//Not Finished
	public List<WebElement> getToDoListMissing(String type){
		
		List<WebElement> listWE = getToDoList();
		System.out.println(listWE.get(1).getText());
		System.out.println(listWE.get(0).findElement(By.cssSelector("input[name^='todo']")));
		return null;
	}
	
	public List<WebElement> getToDoList(){
		
		return driver.findElements(By.xpath("//form[@name='todo']/ul/li"));
	}
	
	
	public void stop(){
		driver.quit();
	}
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
}
