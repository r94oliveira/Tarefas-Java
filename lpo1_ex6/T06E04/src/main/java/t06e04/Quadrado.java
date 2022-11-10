package t06e04;

public class Quadrado extends Forma implements Superficie {
    public Quadrado(double altura, double largura) {
        super (2);
        setMedida(0, altura); 
        setMedida(1, largura);
    }

    public double area(){
        return getMedida(0) * getMedida(1);
    }
}