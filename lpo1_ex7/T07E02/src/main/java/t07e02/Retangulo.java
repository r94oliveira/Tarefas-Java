package t07e02;

public class Retangulo {
    private double altura;
    private double largura;
    
    public Retangulo(double altura, double largura) throws IllegalArgumentException {
        setTamanho(altura, largura);
    }

    public void setTamanho(double altura, double largura) throws IllegalArgumentException {
        if(altura > 0.0 && largura > 0.0) {
            this.altura = altura;
            this.largura = largura;
        } else {
            throw new IllegalArgumentException();
        }
    }
}