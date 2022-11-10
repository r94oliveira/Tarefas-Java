package t04e03;

public class UsaCircunferencia {

    public static void main(String[] args) {
        Circunferencia c = new Circunferencia();
        
        c.setRaio(4);
        double area = c.area();
        
        System.out.println(area);
    }
    
}
