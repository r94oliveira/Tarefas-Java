package t07e02;

public class UsaForma {
    
    public static void main (String args[]){
        try {
            Retangulo r = new Retangulo(-1, -3);
        } catch(IllegalArgumentException e) {
            System.out.println("Exceção: " + e);
        }
    }
    
}
