package t07e03;
import java.util.*;

public class Media {
    
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    public static boolean isInt(String str) {
        boolean isInteger = true;
        try {
          int i = Integer.parseInt(str);
        } catch(NumberFormatException nfe) {
           isInteger = false;
        }
        return isInteger;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String numeroDigitado;
        float soma = 0, media = 0;
        int i = 0;
        
        while (true) {
            System.out.println("\nNumero " + (i+1) + ": ");
            numeroDigitado = sc.next();

            if (numeroDigitado.equalsIgnoreCase("s")) {
                break;
            }
                
            try {
                if (isInt(numeroDigitado)) {
                    int numero = Integer.parseInt(numeroDigitado);
                    
                    soma += numero;
                    i++;
                } else {
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException e) {
                System.out.println("\nErro de entrada.\n" 
                                    + numeroDigitado + 
                                    " não é um numérico válido. Tente novamente ou digite S para sair.\n");
            } finally {
                clearBuffer(sc);	
            }
        }
        
        media = soma / i;
        
        System.out.printf("\nA soma dos números digitados é: %.2f\n", soma);
        System.out.printf("A média dos números digitados é: %.2f\n", media);
    }
    
}
