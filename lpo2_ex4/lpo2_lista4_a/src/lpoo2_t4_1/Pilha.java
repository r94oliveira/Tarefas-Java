package lpoo2_t4_1;

public class Pilha<T> {
    private int tamanho = 0;
    private Node topo = null;
    
    public Pilha(){}
    
    private class Node<T>{
        private Node next = null;

        private T valor;

        public Node(T valor) {
            this.valor = valor;
        }

        public void setNext(Node next){
            this.next = next;

        }

        public Node getNext(){ return this.next; }

        public T getValor(){ return this.valor; }
    }
    
    public void empilha(T valor){
        if (valor != null) { 
            Node node = new Node(valor); 
            if (topo == null) topo = node;
            else {
                node.setNext(topo);
                topo = node;
            }
            this.tamanho++;
        }
        else throw new RuntimeException ("Valor não pode ser nulo!");
    }
    
    public T desempilha(){
        T result = null;
        if (topo == null) throw new RuntimeException("A pilha está vazia!");
        else{
            result = (T) topo.getValor();
            topo = topo.getNext();
            this.tamanho--;
        }
        return result;
    }
    
    @Override
    public String toString(){
        Node tempNode;
        StringBuilder result = new StringBuilder();
        result.append("[");
        
        if (topo != null){
            for (tempNode = topo; tempNode != null; tempNode = tempNode.getNext()){
                if (tempNode.getNext() == null) result.append(tempNode.getValor());
                else result.append(tempNode.getValor() + ", ");
            }
        }
        
        result.append("]");
        return result.toString();
    }
}
