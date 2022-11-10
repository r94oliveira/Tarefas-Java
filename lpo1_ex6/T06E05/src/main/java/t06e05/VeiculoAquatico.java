package t06e05;

public abstract class VeiculoAquatico extends Veiculo {
    private boolean temLeme;
    private boolean temVela;
    private boolean estaSubmerso;
    
    public VeiculoAquatico() {
        super();
        setLeme(false);
        setVela(false);
        setSubmerso(false);
    }
    
    public VeiculoAquatico(String marca, 
                           String modelo, 
                           String cor, 
                           String porte, 
                           float velocidade, 
                           boolean temLeme, 
                           boolean temVela, 
                           boolean estaSubmerso) {
        super(marca, modelo, cor, porte, velocidade);
        setLeme(temLeme);
        setVela(temVela);
        setSubmerso(estaSubmerso);
    }
    
    public void setLeme(boolean temLeme) { this.temLeme = temLeme; }
    public boolean getLeme() { return temLeme; }
    
    public void setVela(boolean temVela) { this.temVela = temVela; }
    public boolean getVela() { return temVela; }
    
    public void setSubmerso(boolean estaSubmerso) { this.estaSubmerso = estaSubmerso; }
    public boolean getSubmerso() { return estaSubmerso; }
    
    public abstract void andar();
}
