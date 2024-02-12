import java.util.ArrayList;
public class Client {

    private String name;
    private int idClient;

    private CreditCard creditCard;

    public Client(String name) {
        this.name = name;
        this.creditCard = new CreditCard(1000);
    }

    public java.lang.String getName() {
        return name;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString(){
        return "Nomes: " + this.name +"\nId: " + this.idClient + "\n";
    }

    public void listarClientes(ArrayList<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i));
        }

}
}


