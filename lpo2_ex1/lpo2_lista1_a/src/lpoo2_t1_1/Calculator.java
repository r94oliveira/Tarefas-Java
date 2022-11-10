package lpoo2_t1_1;

public class Calculator{
    public static double calculaAreaRetangulo(double lado1, double lado2) throws RuntimeException{
        if (lado1 <= 0 || lado2 <= 0) 
            throw new RuntimeException("Base e altura devem ser valores positivos e diferentes de zero!");
        return lado1 * lado2;
    }
    
    public static double calculaAreaCircunferencia(double raio) throws RuntimeException{
        if(raio <= 0) 
            throw new RuntimeException("Raio deve ser positivo e diferente de zero!");
        return Math.PI * Math.pow(raio, 2);
    }
    
    public static double calculaAreaTriangulo(double base, double altura){
        if (base <= 0 || altura <= 0) 
            throw new RuntimeException("Base e Altura devem ser positivos e diferentes de zero!");
        return (base * altura)/(double)2;
    }
}