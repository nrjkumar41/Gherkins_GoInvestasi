Feature: Buy_Gold 
Scenario: TC_003 Able to Sell Gold 


	Given User Is On Buy_Page 
	When Title is GoInvestasi - Gold Transaction 
	Then Validate The Page 
	Then Enter Gold Gram to Purchase
	Then Assert The Amount Sell_Cashout
	Then Assert Transaction Details
	Then Open Admin Panel
	Then Navigate To CashOut
	Then Assert Casshout Status
	Then Change Cashout_Status via API
	Then Close the Admin_Panel
	