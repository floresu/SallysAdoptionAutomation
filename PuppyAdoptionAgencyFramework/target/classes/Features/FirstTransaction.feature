 Feature: First Transaction
 	Simulating and confirming the adoption of one puppy.
 
 Scenario: Visit the site to adopt one puppy without additional products and services.
 	Given I navigate to the home page.
 	Then I click on the puppy adoption section of the page.
 	And I select a puppy from the Puppy List section and view details.
 	And I click on the adoption button.
 	Then I click on the button to complete my puppy adoption.
 	And I enter my information for the adoption.
 	And I select the form of payment.
 	And I click on the place order button.
 	Then I should see my adoption confirmation message. 
 	
 	
 	