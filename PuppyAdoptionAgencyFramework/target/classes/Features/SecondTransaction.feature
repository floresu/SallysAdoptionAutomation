Feature: Second Transaction 
	Adding two puppies to the cart and confirming the total base cost is accurate.
	
Scenario: Visit the site to adopt two puppies without additional products and services, and confirming the base cost.
	Given I navigate to the home page.
 	Then I click on the puppy adoption section of the page.
 	And I select a puppy from the Puppy List section and view details.
 	And I click on the adoption button.
 	Then I click to adopt another puppy.
 	And I select a puppy from the Puppy List section and view details.
 	Then I click on the adoption button.
 	And I confirm that I have two puppies in my cart and total base cost.
 	Then I click on the button to complete my puppy adoption.
 	And I enter my information for the adoption.
 	And I select the form of payment.
 	And I click on the place order button.
 	Then I should see my adoption confirmation message. 