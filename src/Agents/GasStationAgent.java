package Agents;

import java.util.ArrayList;
import java.util.List;
import jade.core.Agent;
import Behaviours.CustomerChangePrices;
import Behaviours.PCustomerReadPrices;

@SuppressWarnings("serial")
public class GasStationAgent extends Agent {

	String price;
	List<String>feedbackList=new ArrayList<String>();
	
	protected void setup() { 

		
		// Printout a welcome message 
		System.out.println("HELLO! GAS_STATION-AGENT "+getAID().getLocalName()+" IS READY.");

		Object[] args = getArguments();  
		if (args != null && args.length > 0){

			price = (String) args[0];

			System.out.println("PRICE "+getAID().getLocalName()+" IS: "+price);

			//add a WakerBehaviour that sends the measurement to the .... Agent

			

			addBehaviour(new CustomerChangePrices(price, this));

			addBehaviour(new PCustomerReadPrices(this, 3000, price));

		}
		else {
			System.out.println("NO PRICE HAS BEEN ASSIGNED");
			doDelete();
		}  
	}
	
	
	
	protected void takeDown(){
		System.out.println("GAS_STATION-AGENT "+getAID().getLocalName()+" HAS TERMINATED");
	}
}
