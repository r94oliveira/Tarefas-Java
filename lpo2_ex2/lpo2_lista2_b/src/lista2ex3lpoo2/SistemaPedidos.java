/***************************************************************************************************************
3. (Tarefa 4) Crie um sistema de carrinho de compras com as seguintes classes:
a. Escreva a estrutura de uma classe (atributos e métodos) para representar um ItemDePedido (nome(String), 
preço(double), quantidade(int)). Crie o construtor com validação para preço negativo, descrição nula ou vazia 
e quantidade 0 ou negativa. Crie os gets e sets (com as devidas validações).
b. Crie uma classe Pedido com o nome do cliente(String) e uma lista de ItemDePedido (List<ItemDePedido>) como 
atributo. Crie o construtor passando o valor total permitido (double) e o nome do cliente(String). Para essa 
classe crie os métodos:
i. String getCliente(): retorna o nome do cliente
ii. List<ItemDePedido> getItens(): retorna a lista de Itens de Pedido.
iii. void acrescentaItem(ItemDePedido): acrescentar o Item de Pedido na lista. Não aceitar nulo nesse atributo e 
Levantar exceção nesse caso. Se o valor do Pedido foi excedido, lenvantar a exceção com a seguinte mensagem: 
“Item de Pedido não incluído. Valor do pedido excedido.” Se o valor total permitido para o pedido for 0, levantar 
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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Clau
 * @author Erica
 * @author Robson
 * 
 */

public class SistemaPedidos {
    //lista de pedido que armazena os pedidos criados
    protected List<Pedido> pedidos = new ArrayList<Pedido>();
    
    public void incluiPedido(Pedido p){
        this.pedidos.add(p);
    }
    
    public void excluiPedido(String nome){
        for (int i = 0; i < this.pedidos.size(); i++){
            if(this.pedidos.get(i).getNome().equals(nome)){
                this.pedidos.remove(i);
                return;
            }
        }
        throw new RuntimeException ("\n Cliente não encontrado!");
    }
    
    public String ListarPedidos() {
        if(this.pedidos.size() == 0)
            return ("\n Lista de pedidos vazia!");
        String texto = "";
        for (int i = 0; i < this.pedidos.size(); i++){
            texto = texto.concat(this.pedidos.get(i).toString());
        }
            texto = texto.concat("\n ----------------------------------------------------------------");
            return texto;
    }
    
    public Pedido buscaPedido(String nome){
        for (int i = 0; i<pedidos.size(); i++){
            if(pedidos.get(i).getNome().equals(nome))
                return pedidos.get(i);
        }
        return null;
    }
    
   public void insereItemDePedidoEmPedido(String nome, ItemDePedido item){
        for(int i = 0; i < this.pedidos.size(); i++){
            if (pedidos.get(i).getNome().equals(nome)){
                pedidos.get(i).insereItem(item);
                return;
            }
        }
        throw new RuntimeException("\n Pedido não encontrado!");
    }
    
    public void removeItemDePedidoEmPedido(String pedido, String nomeItem){
        Pedido p = this.buscaPedido(pedido);
        if (p != null) p.removeItem(nomeItem);
        else throw new RuntimeException("\n Pedido não encontrado!");
    }
}