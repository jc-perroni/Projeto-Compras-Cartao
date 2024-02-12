import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private int clientId;
    private double creditLimit;
    private double availableLimit;
    private List<CarrinhoDeCompras> compras;

    public CreditCard(double limit) {
        this.creditLimit = limit;
        this.availableLimit = limit;
        this.compras = new ArrayList<>();
    }

    public double getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(double availableLimit) {
        this.availableLimit = availableLimit;
    }

    public List<CarrinhoDeCompras> getCompras() {
        return compras;
    }

    public void setCompras(List<CarrinhoDeCompras> compras) {
        this.compras = compras;
    }
}