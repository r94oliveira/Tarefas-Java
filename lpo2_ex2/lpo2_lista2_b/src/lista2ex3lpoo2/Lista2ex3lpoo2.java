/**************************************************************************************************************
3. (Tarefa 4) Crie um sistema de carrinho de compras com as seguintes classes:
a. Escreva a estrutura de uma classe (atributos e métodos) para representar um ItemDePedido (nome(String), 
preço(double), quantidade(int)). Crie o construtor com validação para preço negativo, descrição nula ou vazia 
e quantidade 0 ou negativa. Crie os gets e sets (com as devidas validações).
b. Crie uma classe Pedido com o nome do cliente(String) e uma lista de ItemDePedido (List<ItemDePedido>) como 
atributo. Crie o construtor passando o valor total permitido (double) e o nome do cliente(String). Para essa 
classe crie os métodos:
i. String getCliente(): retorna o nome do cliente
ii. List<ItemDePedido> getItens(): retorna a lista de Itens de Pedido.
iii. void acrescentaItem(ItemDePedido): acrescentar o Item de Pedido na lista. 
Não aceitar nulo nesse atributo e Levantar exceção nesse caso. Se o valor do Pedido foi excedido, lenvantar a 
exceção com a seguinte mensagem: “Item de Pedido não incluído. Valor do pedido excedido.” Se o valor total permitido para o pedido for 0, levantar 
a exceção: “Cliente não tem nenhum crédito.” Se o item já existir na lista, somar a sua quantidade.
iv. void retiraItem(String nome): Retira o item do pedido da lista. Se não encontrar, levantar a exceção “Item 
não encontrado no pedido.”
v. double getTotal(): retorna o total do pedido (soma dos preços dos Itens.
vi. String toString(): método que retorna uma String de forma legível para o pedido:
-----------------------------------
Nome do Cliente: Rafael
Total do Pedido: R$800,00
Item |Preço
TV LED 22 |R$590,00
Celular Ching-Ling |R$210,00
-----------------------------------
c. Crie uma outra classe (SistemaPedidos) que utilize objetos do tipo Pedido. Nessa classe instancie uma lista 
de Pedidos que armazene os pedidos criados. Crie um menu com as seguintes opções: 1 – Incluir Pedido, 
2 – Excluir pedido por nome do cliente, 3 – Listar Pedidos, 4 – Incluir Item de Pedido em Pedido, 
5 – Excluir Item de Pedido em Pedido, 6 – Imprimir a lista de Pedidos. Cada um destes itens do menu deve ter um
método associado
****************************************************************************************************************/

package lista2ex3lpoo2;

import java.util.Scanner;

/**
 *
 * @author Clau
 * @author Erica
 * @author Robson
 * 
 */

public class Lista2ex3lpoo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        int op;
        SistemaPedidos sistema = new SistemaPedidos();
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("\n Escolha uma opção:\n"
                    + " 0 - Sair\n"
                    + " 1 - Incluir Pedido\n"
                    + " 2 - Excluir pedido por nome do cliente\n"
                    + " 3 - Listar Pedidos\n"
                    + " 4 - Incluir item de Pedido em Pedido\n"
                    + " 5 - Excluir item de Pedido em Pedido\n"
                    + " 6 - Imprimir lista de Pedidos");
            op = s.nextInt();
            s.nextLine();
            switch(op){
                case 0: break;
                case 1:
                    System.out.println(" Digite o nome do cliente: ");
                    String nome = s.nextLine();
                    System.out.println(" Digite o valor limite do pedido: ");
                    double max = s.nextDouble();
                    s.nextLine();
                    try{ sistema.incluiPedido(new Pedido(nome, max)); }
                    catch (RuntimeException e){ 
                        System.out.println(e.getMessage()); }
                    break;
                case 2:
                    System.out.println(" Digite o nome do cliente: ");
                    nome = s.nextLine();
                    try { sistema.excluiPedido(nome); }
                    catch(RuntimeException e){ 
                        System.out.println(e.getMessage()); 
                    }
                    break;
                case 3:
                    System.out.println(sistema.ListarPedidos());
                    break;
                case 4:
                    System.out.println(" Digite o nome do cliente do Pedido: ");
                    nome = s.nextLine();
                    System.out.println(" Digite o nome do Item do pedido: ");
                    String nomeItem = s.nextLine();
                    System.out.println(" Digite o valor do Item do pedido: ");
                    double valorItem = s.nextDouble();
                    s.nextLine();
                    System.out.println(" Digite a quantidade do Item do pedido: ");
                    int quantidadeItem = s.nextInt();
                    s.nextLine();
                    try{ 
                        ItemDePedido item = new ItemDePedido(nomeItem, valorItem, quantidadeItem);
                        sistema.insereItemDePedidoEmPedido(nome, item);
                    }
                    catch(RuntimeException e){ 
                        System.out.println(e.getMessage()); 
                    }
                    break;
                case 5: 
                    System.out.println(" Digite o nome do cliente do Pedido: ");
                    nome = s.nextLine();
                    System.out.println(" Digite o nome do Item do Pedido:");
                    String nomeAux = s.nextLine();
                    try{ sistema.removeItemDePedidoEmPedido(nome, nomeAux); }
                    catch(RuntimeException e) { 
                        System.out.println(e.getMessage()); 
                    }
                    break;
                case 6:
                    System.out.println(sistema.ListarPedidos());
                    break;
                default:
                    System.out.println("\n Selecione uma opção válida!");
                    break;
            }
        }while(op != 0);
    }
}