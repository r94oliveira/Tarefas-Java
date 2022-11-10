package lpoo2_t4_2;

public class SomaArea<T> {
    public <T extends Superficie> double calculaArea (T array[]){
        double total = 0;
        for (T array1 : array) { total += array1.area(); }
        return total;
    }
    
    public double calculaAreaPolimorfismo (Superficie array[]){
        double total = 0;
        for (Superficie array1 : array) { total+= array1.area(); }
        return total;
    }
} 
