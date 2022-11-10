package t05e03;

public class Bicicleta {
    private int cadencia;
    private int velocidade;
    private int marcha;
    private int numeroMaximoMarchas;
    
    public Bicicleta() {
        numeroMaximoMarchas = 18;
        velocidade = 0;
    }
    
    public Bicicleta(int maximoMarchas) {
        numeroMaximoMarchas = maximoMarchas;
        velocidade = 0;
    }
    
    public int getCadencia() {
        return cadencia;
    }
    
    public int getVelocidade() {
        return velocidade;
    }
    
    public int getMarcha() {
        return marcha;
    }
    
    public void mudarCadencia(int novoValor){
        cadencia = novoValor;
    }
    
    public void mudarMarcha(int novoValor){
        if (novoValor <= numeroMaximoMarchas) {
            marcha = novoValor;
        } else {
            System.out.println("\nNúmero máximo de marchas atingido!");
        }
    }
    
    public void aumentarVelocidade(int incremento){
        velocidade = velocidade + incremento;
    }
    
    public void aplicarFreios(int decremento){
        velocidade = velocidade - decremento;
    }
    
    public void printStates(){
        System.out.printf("\nCadencia: %d, Velocidade: %d, Marcha = %d\n", cadencia, velocidade, marcha);
    }
}
