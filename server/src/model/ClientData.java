package model;

import java.io.Serializable;
import java.rmi.RemoteException;

public class ClientData implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3526046263276619197L;
	private long cpf;
    private String name;

    public ClientData(long cpf, String name) throws RemoteException{
        super();
        this.cpf = cpf;
        this.setName(name);
    }

    @Override
    public boolean equals(Object obj) {
        ClientData other = (ClientData)obj;
        return this.cpf==other.cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
