package model;

public class ClientData {

    private long cpf;
    private String name;

    public ClientData(long cpf, String name){
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
