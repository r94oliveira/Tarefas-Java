package t06e05;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private String cor;
    private String porte;
    private float velocidade;
    
    public Veiculo() {
        setMarca("indefinida");
        setModelo("indefinido");
        setCor("indefinida");
        setPorte("indefinido");
        setVelocidade(0);
    }
    
    public Veiculo(String marca, 
                   String modelo, 
                   String cor, 
                   String porte, 
                   float velocidade) {
        setMarca(marca);
        setModelo(modelo);
        setCor(cor);
        setPorte(porte);
        setVelocidade(velocidade);
    }
    
    public void setMarca(String marca) { this.marca = marca; }
    public String getMarca() { return marca; }
    
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getModelo() { return modelo; }
    
    public void setCor(String cor) { this.cor = cor; }
    public String getCor() { return cor; }
    
    public void setPorte(String porte) { 
        if (porte.equalsIgnoreCase("pequeno") || porte.equalsIgnoreCase("médio") || porte.equalsIgnoreCase("grande")) {
            this.porte = porte; 
        } else {
            this.porte = "indefinido";
        }
    }
    public String getPorte() { return porte; }
    
    public void setVelocidade(float velocidade) { this.velocidade = velocidade; }
    public float getVelocidade() { return velocidade; }
    
    public abstract void andar();
}
