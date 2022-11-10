package t06e05;

public abstract class VeiculoTerrestre extends Veiculo {
    private String placa;
    private int qtdRoda;
    
    public VeiculoTerrestre() {
        super();
        setPlaca("indefinida");
        setRoda(1);
    }
    
    public VeiculoTerrestre(String marca, 
                            String modelo, 
                            String cor, 
                            String porte, 
                            float velocidade, 
                            String placa, 
                            int qtdRoda) {
        super(marca, modelo, cor, porte, velocidade);
        setPlaca(placa);
        setRoda(qtdRoda);
    }
    
    public void setPlaca(String placa) { this.placa = placa; }
    public String getPlaca() { return placa; }
    
    public void setRoda(int qtdRoda) { this.qtdRoda = qtdRoda; }
    public int getRoda() { return qtdRoda; }
    
    public abstract void andar();
}
