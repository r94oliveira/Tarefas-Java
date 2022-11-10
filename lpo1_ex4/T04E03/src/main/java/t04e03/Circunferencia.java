package t04e03;

public class Circunferencia {
    private final static double PI = 3.141516;
    private double raio;
    
    public void setRaio(double raio) { this.raio = raio; }
    
    public double area() {
        double area = (this.raio * this.raio) * this.PI;
        return area;
    }
}
