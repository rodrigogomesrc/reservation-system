package model;

public class ClientRestaurant {
	private ClientData clientData;
	private ClientCommunicationInterface clientCommunication;
	
	public ClientRestaurant(ClientData clientData, ClientCommunicationInterface clientCommunication) {
		super();
		this.clientData = clientData;
		this.clientCommunication = clientCommunication;
	}
	public ClientData getClientData() {
		return clientData;
	}
	public void setClientData(ClientData clientData) {
		this.clientData = clientData;
	}
	public ClientCommunicationInterface getClientCommunication() {
		return clientCommunication;
	}
	public void setClientCommunication(ClientCommunicationInterface clientCommunication) {
		this.clientCommunication = clientCommunication;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return clientData.equals(obj);
	}
}
