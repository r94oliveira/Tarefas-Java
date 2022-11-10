package t06e04;

public class UsaForma {
    
    public static void main (String args[]){
        Superficie c = new Circunferencia(3);
        System.out.println(c.toString());
        System.out.println("Area: " + c.area());
        
        System.out.println("");
        
        Superficie q = new Quadrado(2, 4);
        System.out.println(q.toString());
        System.out.println ("Area: " + q.area());
    }
    
}
