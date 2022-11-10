package lpoo2_t4_2;

public class Circunferencia implements Superficie{
    private double raio;
    
    public Circunferencia(double raio){
        this.setRaio(raio);
    }
    
    public void setRaio(double raio){
        if (raio > 0) this.raio = raio;
    }
    
    @Override
    public double area(){
        return this.raio * this.raio * Math.PI;
    }
}
