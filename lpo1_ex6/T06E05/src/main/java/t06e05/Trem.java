package t06e05;

public class Trem extends VeiculoTerrestre {
    private int qtdVagao;
    
    public Trem() {
        super();
        setVagao(1);
    }
    
    public Trem(String marca, 
                String modelo, 
                String cor, 
                String porte, 
                float velocidade, 
                String placa, 
                int qtdRoda, 
                int qtdVagao) {
        super(marca, modelo, cor, porte, velocidade, placa, qtdRoda);
        setVagao(qtdVagao);
    }
    
    public void setVagao(int qtdVagao) { this.qtdVagao = qtdVagao; }
    public int getVagao() { return qtdVagao; }
    
    public void andar() {
        System.out.println("\nPeewiee! Trem saindo!");
    }
}
