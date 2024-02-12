import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int option = 0;

        ArrayList<Client> clients = new ArrayList<Client>();

        while (option >= 0 && option <= 3) {
            System.out.println("Deseja: \n1 - Cadastrar um novo cliente\n2 - Realizar uma compra\n3 - Sair");
            option = reader.nextInt();

            if (option == 3) {
                System.out.println("Saindo...");
                break;
            }

            switch (option) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    reader.nextLine();
                    String name = reader.nextLine();
                    Client newClient = new Client(name);
                    CreditCard newCreditCard = new CreditCard(1000);
                    clients.add(newClient);

                    System.out.println("Clientes cadastrados:");
                    newClient.setIdClient(clients.indexOf(newClient));
                    newClient.listarClientes(clients);

                    break;
                case 2:
                    System.out.println("Nova compra identificada.\nDigite o id do cliente que está realizando a compra conforme lista abaixo: \n-------------------------------");
                    try {
                        clients.get(0).listarClientes(clients);  // Exemplo usando o primeiro cliente, ajuste conforme necessário
                        int id = reader.nextInt();
                        System.out.println("Cliente " + clients.get(id).getName() + " selecionado.");
                        System.out.println("Digite a descrição do item comprado. Ex. Tênis, camiseta, etc.");
                        reader.nextLine();
                        String descricaoItem = reader.nextLine();
                        System.out.println("Digite o valor do item comprado: ");
                        double valorItem = reader.nextDouble();
                        System.out.println("O cliente " + clients.get(id).getName() + " está comprando um(a) " + descricaoItem + " no valor de R$" + valorItem + " reais. Confirma? (S/N)");
                        reader.nextLine();
                        String confirmacao = reader.nextLine();
                        if (confirmacao.equals("S")) {
                            /// Incluir a lógica da compra aqui
                            double limite = clients.get(id).getCreditCard().getAvailableLimit();
                            if (limite >= valorItem) {
                                limite -= valorItem;
                                clients.get(id).getCreditCard().setAvailableLimit(limite);
                                clients.get(id).getCreditCard().getCompras().add(new CarrinhoDeCompras(descricaoItem, valorItem));
                                System.out.println("Compras realizadas no cartão de " + clients.get(id).getName() + ":");
                                Collections.sort(clients.get(id).getCreditCard().getCompras());
                                System.out.println(clients.get(id).getCreditCard().getCompras());
                                System.out.println("Compra realizada com sucesso!");
                            } else {
                                System.out.println("Compra cancelada. Limite insuficiente.");
                            }
                            System.out.println("Limite disponível no cartão: " + limite);
                            }
                    }
                    catch(IndexOutOfBoundsException e)  {
                        System.out.println("Nenhum cliente cadastrado ainda! Cadastre antes de prosseguir à compra!");
                    }

                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }}
        }
    }

