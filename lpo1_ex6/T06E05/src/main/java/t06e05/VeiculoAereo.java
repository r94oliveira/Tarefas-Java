package t06e05;

public abstract class VeiculoAereo extends Veiculo {
    private String classe;
    private int qtdTurbina;
    private int qtdHelice;
    
    public VeiculoAereo() {
        super();
        setClasse("indefinida");
        setTurbina(0);
        setHelice(0);
    }
    
    public VeiculoAereo(String marca, 
                        String modelo, 
                        String cor, 
                        String porte, 
                        float velocidade, 
                        String classe, 
                        int qtdTurbina, 
                        int qtdHelice) {
        super(marca, modelo, cor, porte, velocidade);
        setClasse(classe);
        setTurbina(qtdTurbina);
        setHelice(qtdHelice);
    }
    
    public void setClasse(String classe) { 
        if (classe.equalsIgnoreCase("primeira") || classe.equalsIgnoreCase("econômica") || classe.equalsIgnoreCase("executiva")) {
            this.classe = classe; 
        } else {
            this.classe = "indefinida";
        }
    }
    public String getClasse() { return classe; }
    
    public void setTurbina(int qtdTurbina) { this.qtdTurbina = qtdTurbina; }
    public int getTurbina() { return qtdTurbina; }
    
    public void setHelice(int qtdHelice) { this.qtdHelice = qtdHelice; }
    public int getHelice() { return qtdHelice; }
    
    public abstract void andar();
}
