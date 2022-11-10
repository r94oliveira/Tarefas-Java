package t06e05;

public class Aviao extends VeiculoAereo {
    private String msgCaixaPreta;
    private float tamanhoAsas;
    
    public Aviao() {
        super();
        setCaixaPreta("indefinida");
        setAsas(1);
    }
    
    public Aviao(String marca, 
                 String modelo, 
                 String cor, 
                 String porte, 
                 float velocidade, 
                 String classe, 
                 int qtdTurbina, 
                 int qtdHelice, 
                 String msgCaixaPreta, 
                 float tamanhoAsas) {
        super(marca, modelo, cor, porte, velocidade, classe, qtdTurbina, qtdHelice);
        setCaixaPreta(msgCaixaPreta);
        setAsas(tamanhoAsas);
    }
    
    public void setCaixaPreta(String msgCaixaPreta) { this.msgCaixaPreta = msgCaixaPreta; }
    public String getCaixaPreta() { return msgCaixaPreta; }
    
    public void setAsas(float tamanhoAsas) { this.tamanhoAsas = tamanhoAsas; }
    public float getAsas() { return tamanhoAsas; }
    
    public void andar() {
        System.out.println("\nWoosshh! Avião decolando!");
    }
}
