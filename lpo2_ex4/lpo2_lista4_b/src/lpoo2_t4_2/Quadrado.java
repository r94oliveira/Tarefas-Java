package lpoo2_t4_2;

public class Quadrado implements Superficie{
    private double lado;
    
    public Quadrado(double lado){
        this.setLado(lado);
    }

    @Override
    public double area() {
        return this.lado * this.lado;
    }

    private void setLado(double lado) {
        if (lado > 0) this.lado = lado;
    }
}
