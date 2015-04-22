package Behaviours;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class CustomerLeaveFeedback extends OneShotBehaviour{
	
	AID [] priceList;
	String price;

	@Override
	public void action() {

		
		
		//Prepare message to be sent to the list
				ACLMessage cfp= new ACLMessage(ACLMessage.CFP);
				
				cfp.setContent(price);
				cfp.setConversationId("CHECK PRICES");
				myAgent.send(cfp);

	}

	
}
