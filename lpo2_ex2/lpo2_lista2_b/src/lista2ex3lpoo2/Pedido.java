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

public class Pedido {
    private String nomeCliente;
    private List<ItemDePedido> itens = new ArrayList<ItemDePedido>();
    private double valoMaxP;    
    
    public Pedido(String nome, double valoMaxP){
        this.nomeCliente = nome;
        this.valoMaxP = valoMaxP;
    }

    public String getNome() throws RuntimeException{
        if(this.nomeCliente == null)
            throw new RuntimeException("Esse campo não pode ser nulo");
        return this.nomeCliente;
    }
    
    public List<ItemDePedido> getItens() {
        return itens;
    }
    
    public double getTotal(){
        double total = 0;
        for(int i = 0; i < itens.size(); i++){
            total +=itens.get(i).getPreco()*itens.get(i).getQuantidade();
        }
        return total;
    }

    public void removeItem(String nome) {
        for(int i = 0; i <itens.size(); i++){
            ItemDePedido iP = itens.get(i);
            if(iP.getNome().equals(nome)){
            itens.remove(iP);
            return;
            }
        }
        throw new RuntimeException("\n Item não encontrado no pedido.");
    }

    public void insereItem (ItemDePedido item) throws RuntimeException{
        if (item == null)
            throw new RuntimeException("\n Item não pode ser nulo!");
        else if(this.getTotal()+(item.getPreco()*item.getQuantidade()) > this.valoMaxP)
                throw new RuntimeException("\n Item de Pedido não incluído. Valor do pedido excedido.");       
        else if (this.valoMaxP == 0)
            throw new RuntimeException("\n Cliente não tem nenhum crédito.");
        else{
            for (int i =0; i < itens.size(); i++){
                if(itens.get(i).getNome().equals(item.getNome())){
                    itens.get(i).setQuantidade(itens.get(i).getQuantidade()+item.getQuantidade());
                    return;
                }
            }
            itens.add(item);
        }
    }
            
    @Override
    
    public String toString(){
        String texto = null;
        texto = ("\n ********************************************************************************");
        texto = texto.concat("\n Nome do cliente: " +this.getNome());
        texto = texto.concat("\n Total do pedido: R$ " + this.getTotal());
        texto = texto.concat("\n Item                                              | Preço (R$)\n ");
        for(int i=0; i<itens.size(); i++){
            String nome = this.itens.get(i).getNome();
            nome = nome.concat(" x 6"
                    + "" + this.itens.get(i).getQuantidade());
            if(nome.length() < 50){ for (; nome.length() < 50;) nome = nome.concat("."); }
            texto = texto.concat(nome + "| " + itens.get(i).getPreco() + "\n ");
        }
        return texto;
    }
}
