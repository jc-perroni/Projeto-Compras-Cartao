import java.util.Scanner;
public class CarrinhoDeCompras implements Comparable<CarrinhoDeCompras> {
    private String descricaoItem;
    private double valorItem;

    public CarrinhoDeCompras(String descricaoItem, double valorItem) {
        this.descricaoItem = descricaoItem;
        this.valorItem = valorItem;
    }

    public java.lang.String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(java.lang.String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public String toString(){
        return "Descrição: " + this.descricaoItem + " --- Valor: " + this.valorItem + "\n";
    }

    @Override
    public int compareTo(CarrinhoDeCompras outroItem) {
        return Double.valueOf(this.valorItem).compareTo(outroItem.getValorItem());
    }
}
