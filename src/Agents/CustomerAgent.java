package Agents;

import jade.core.Agent;
import Behaviours.CustomerChangePrices;
import Behaviours.PCustomerReadPrices;

@SuppressWarnings("serial")
public class CustomerAgent extends Agent {
	
	String location = "";


	protected void setup() { 

		
		// Printout a welcome message 
		System.out.println("HELLO! CUSTOMER-AGENT "+getAID().getLocalName()+" IS READY.");

		Object[] args = getArguments();  
		if (args != null && args.length > 0){

			location = (String) args[0];

			System.out.println("PRICE "+getAID().getLocalName()+" IS: "+location);

			//add a WakerBehaviour that sends the measurement to the .... Agent

			

			addBehaviour(new CustomerChangePrices(location, this));
			String price;

			addBehaviour(new PCustomerReadPrices(this, 3000, location));

		}
		else {
			System.out.println("NO PRICE HAS BEEN ASSIGNED");
			doDelete();
		}  
	}
	
	
	
	protected void takeDown(){
		System.out.println("CUSTOMER-AGENT "+getAID().getLocalName()+" HAS TERMINATED");
	}
}
