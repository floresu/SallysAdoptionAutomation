 Feature: Third Transaction
 	Simulating and confirming the adoption of two puppies with two additional products and services for each puppy.
 
Scenario: Visit the site to adopt two puppies with the first two additional products and services, and confirming the base cost.
	Given I navigate to the home page.
 	Then I click on the puppy adoption section of the page.
 	And I select a puppy from the Puppy List section and view details.
 	And I click on the adoption button.
 	Then I click to adopt another puppy.
 	And I select a puppy from the Puppy List section and view details.
 	Then I click on the adoption button.
 	And I click on the first two additional products and services.
 	And I confirm that I have two puppies in my cart and total base cost.
 	Then I click on the button to complete my puppy adoption.
 	And I enter my information for the adoption.
 	And I select the form of payment.
 	And I click on the place order button.
 	Then I should see my adoption confirmation message.