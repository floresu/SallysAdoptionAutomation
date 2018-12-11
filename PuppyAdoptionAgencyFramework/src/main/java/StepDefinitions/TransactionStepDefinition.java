package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then; 

public class TransactionStepDefinition {
	
	WebDriver driver;
	
	@Given("^I navigate to the home page.$")
	public void goToNavigation() {
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver", "/Users/urielflores/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://puppies.herokuapp.com./");
	}
	
	@Then("^I click on the puppy adoption section of the page.$")
	public void clickOnSection() {
		//Select 'Adopt a Puppy' from the left hand-side table
		driver.findElement(By.linkText("Adopt a Puppy")).click();
	}
	
	@And("^I select a puppy from the Puppy List section and view details.$")
	public void selectFromList() {
		//Calls method from random puppy
		selectRandomPuppy();
	}
	
	private void selectRandomPuppy() {
		//Select a random puppy from the Puppy List and select 'View Details' button
		//After selecting random puppy
		List<WebElement> allPuppies = driver.findElements(By.xpath("//*[@id='content']/div[2]/div/div[4]/form/div/input"));
		Random rand = new Random();
		int randomPuppy = rand.nextInt(allPuppies.size());
		allPuppies.get(randomPuppy).click();
	}

	@And("^I click on the adoption button.$")
	public void clickOnAdoption() throws Exception {
		//Use xpath to click on 'Adopt me' element
		driver.findElement(By.xpath("//*[@id='content']/div[2]/form[1]/div/input")).click();
	}
	
	@Then("^I click on the button to complete my puppy adoption.$")
	public void completeAdoption() {
		//Verify that no additional products and services are not selected
		try {
			//Assert checkboxes are unchecked
		} catch (NoSuchElementException e) {
			// Do nothing		
		}
		//Click on complete adoption
		driver.findElement(By.xpath("//*[@id='content']/div[2]/form[1]/div/input")).click();	
	}
	
	@And("^I enter my information for the adoption.$")
	public void infromationDetails() {
		//Locate element by if in form
		driver.findElement(By.id("order_name")).sendKeys("John Doe");
		driver.findElement(By.id("order_address")).sendKeys("123 Main Street, City, State 00000");
		driver.findElement(By.id("order_email")).sendKeys("johndoe@gmail.com");
	}
	
	@And("^I select the form of payment.$")
	public void formOfPayment() {
		//Select form of payment. Test all forms of payment
		//Assuming we select Credit card as form of payment for now
		//Can have an example outline/table
		Select drpPayment = new Select(driver.findElement(By.id("order_pay_type")));
		drpPayment.selectByVisibleText("Credit card");	
	}
	
	@And("^I click on the place order button.$")
	public void placeOrder() {
		//Click on Place Order button
		driver.findElement(By.name("commit")).click();
	}
	
	@Then("^I should see my adoption confirmation message.$")
	public void confirmationButton() {
		//Assert the confirmation text
		String confirmationMessage = driver.findElement(By.xpath("")).getText();
		assertTrue(confirmationMessage.contains("Thank you for adopting a puppy!"));
	}
	
	@Then("^I click to adopt another puppy.$")
	public void anotherPuppy() {
		//Select on 'Adopt another puppy' button 
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/form[2]/div/input[1]")).click();
	}
	
	@And("^I confirm that I have two puppies in my cart and total base cost.$")
	public void twoPuppiesInCart() {
		//Checks if both items are in cart twice
		//Could also check by name or picture?
		//Can only check for elements in the existing page
		//Try to add total_cell =+ item_price?
		try {
			driver.findElement(By.className("item_price"));
			driver.findElement(By.className("item_price"));
			driver.findElement(By.className("total_cell"));
		} catch (NoSuchElementException e) {
			// Do nothing		
		}
	}
	
	@And("^I click on the first two additional products and services.$")
	public void additionalProductsAndServices() {
		//Clicks/selects the first two products and services by id
		driver.findElement(By.id("collar")).click();
		driver.findElement(By.id("toy")).click();
	}
}
