package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCommunication extends UnicastRemoteObject implements ClientCommunicationInterface {

	private static final long serialVersionUID = 7411535434063155289L;

	public ClientCommunication() throws RemoteException {
        super();
    }

    @Override
    public void receiveReservationStatus(String status) throws RemoteException {
        //Todo
    }
}
