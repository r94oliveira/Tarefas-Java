package t06e04;

public class Circunferencia extends Forma implements Superficie {
    public Circunferencia(double raio) {
        super(1);
        setMedida(0, raio);
    }
    
    public double area() {
        return Math.PI * Math.pow(getMedida(0), 2);
    }
}
