package t06e05;

public class Barco extends VeiculoAquatico {
    private int qtdBote;
    
    public Barco() {
        super();
        setBote(0);
    }
    
    public Barco(String marca, 
                 String modelo, 
                 String cor, 
                 String porte, 
                 float velocidade, 
                 boolean temLeme, 
                 boolean temVela, 
                 boolean estaSubmerso, 
                 int qtdBote) {
        super(marca, modelo, cor, porte, velocidade, temLeme, temVela, estaSubmerso);
        setBote(qtdBote);
    }
    
    public void setBote(int qtdBote) { this.qtdBote = qtdBote; }
    public int getBote() { return qtdBote; }
    
    public void andar() {
        System.out.println("\nPoooooommmm! Todos à bordo do barco!");
    }
}
