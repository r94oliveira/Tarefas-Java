package t06e04;

public class Forma {
    private double medida[];
    
    public Forma(int numMedidas) {
        medida = new double[numMedidas];
    }
    
    public double getMedida(int i) {
        if ((i > 0) || (i < medida.length)) {
            return medida[i];
        } else {
            return -1;
        }
    }
    
    protected void setMedida(int i, double m) {
        if ((i > 0) || (i < medida.length) || (m < 0)) {
            medida[i] = m;
        }
    }
    
    public String toString() {
        String bf = getClass().getSimpleName();
        
        bf = bf + "\nmedidas: ";
        for (int i = 0; i < medida.length - 1; i++) {
            bf = bf + medida[i] + ", ";
        }
        bf = bf + medida[medida.length - 1];
        
        return bf;
    }
    
    public int getNumMedidas() {
        return medida.length;
    }
}
