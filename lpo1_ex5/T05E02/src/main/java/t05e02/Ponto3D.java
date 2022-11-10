package t05e02;
import java.util.*;

public class Ponto3D {
    private double x;
    private double y;
    private double z;
    private String cor;
    private String intensidade;
    
    public Ponto3D(double px, double py, double pz, String pCor, String pIntensidade) {
        this.setX(px);
        this.setY(py);
        this.setZ(pz);
        this.setCor(pCor);
        this.setIntensidade(pIntensidade);
    }
    
    public double getX() { return this.x; }
    
    public double getY() { return this.y; }
    
    public double getZ() { return this.z; }
    
    public String getCor() { return this.cor; }
    
    public String getIntensidade() { return this.intensidade; }
    
    public void setX(double px) { this.x = px; }
    
    public void setY(double py) { this.y = py; }
    
    public void setZ(double pz) { this.z = pz; }
    
    public void setCor(String pCor) { this.cor = pCor; }
    
    public void setIntensidade(String pIntensidade) {
        if (pIntensidade == "baixa" || pIntensidade == "media" || pIntensidade == "alta") {
            this.intensidade = pIntensidade;
        }
    }
    
    public double calculaDistancia(Ponto3D p) {
        double Dx = p.getX() - this.x;
        Dx = Math.pow(Dx, 2);
        
        double Dy = p.getY() - this.y;
        Dy = Math.pow(Dy, 2);
        
        double Dz = p.getZ() - this.z;
        Dz = Math.pow(Dz, 2);
        
        double Dab = Dx + Dy + Dz;
        return Dab = Math.sqrt(Dab);
    }
    
    public void imprime() {
        if (this.intensidade == null) {
            System.out.println("\n#ERRO#\nA intensidade deve ser baixa, média ou alta! Informe um valor válido!\n\n");
        } else {
            System.out.printf("\nX = %.2f\nY = %.2f\nZ = %.2f\nCor = %s\nIntensidade = %s\n\n", this.x, this.y, this.z, this.cor, this.intensidade);
        }        
    }
}
