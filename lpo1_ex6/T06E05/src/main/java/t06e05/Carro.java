package t06e05;

public class Carro extends VeiculoTerrestre {
    private int qtdPorta;
    
    public Carro() {
        super();
        setPorta(1);
    }
    
    public Carro(String marca, 
                 String modelo, 
                 String cor, 
                 String porte, 
                 float velocidade, 
                 String placa, 
                 int qtdRoda, 
                 int qtdPorta) {
        super(marca, modelo, cor, porte, velocidade, placa, qtdRoda);
        setPorta(qtdPorta);
    }
    
    public void setPorta(int qtdPorta) { this.qtdPorta = qtdPorta; }
    public int getPorta() { return qtdPorta; }
    
    public void andar() {
        System.out.println("\nVrumm! Carro andando!");
    }
}
