package Behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class PCustomerReadPrices extends TickerBehaviour {

	private String price;

	public PCustomerReadPrices(Agent a, long period, String l) {
		super(a, period);
		price = "1.2";	
		}

	
	
	@Override
	protected void onTick() {


		ACLMessage request = myAgent.blockingReceive();
		if (request != null){

			String msg = request.getContent();
			AID patientID = request.getSender();
			System.out.println("MESSAGE RECEIVED BY "+ myAgent.getAID().getLocalName()+" FROM "+patientID.getLocalName()+": "+msg);

			
			//Creating a reply message
			ACLMessage reply = request.createReply();
			reply.setPerformative(ACLMessage.INFORM);
			
			myAgent.send(reply);
		}
		
		
	}

}
