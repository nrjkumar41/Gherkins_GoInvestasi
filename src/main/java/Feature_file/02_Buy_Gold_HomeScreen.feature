Feature: Buy_Gold 
Scenario: TC_002 Able to Purchase Gold 


	Given User Is On Buy_Page 
	When Title is GoInvestasi - Gold Transaction 
	Then Validate The Page 
	Then Enter Gold Gram to Purchase
	Then Assert The Amount Pay
	Then Assert The Review Transaction 
	Then Approve GoPay
	Then Assert Transaction Details