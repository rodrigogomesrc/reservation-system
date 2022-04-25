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
        System.out.println(status);
        System.out.println("");
        System.out.println("Digite uma das opções: ");
        System.out.println("1 para ver o menu");
        System.out.println("2 para fazer uma reserva");
        System.out.println("3 para cancelar uma reserva");
        System.out.println("Digite outro número para sair do programa");
    }
}
