package lpoo2_t5_2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.math.RoundingMode.HALF_UP;
import java.util.Scanner;

public class Lpoo2_t5_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("\n Digite o tempo gasto na viagem, em Horas:");
        Double tempo = s.nextDouble();
        BigDecimal bdTempo = new BigDecimal(tempo).setScale(3, HALF_UP);;
        
        System.out.println("\nDigite a distância percorrida, em km:");
        Double dist = s.nextDouble();
        BigDecimal bdDist = new BigDecimal(dist).setScale(3, HALF_UP);
        
        System.out.println("Velocidade média: " + bdDist.
                divide(bdTempo,2,RoundingMode.UP) + " km/h");
    }
    
}
