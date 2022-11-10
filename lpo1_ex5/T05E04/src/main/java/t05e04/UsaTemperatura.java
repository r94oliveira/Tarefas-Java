package t05e04;
import java.util.Scanner;

public class UsaTemperatura {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float C, K, F;
        boolean condicao = true;
        
        while (condicao == true) {
            System.out.println("\n==========================MENU===========================");
            System.out.println("1) Converter de Celsius para Kelvin");
            System.out.println("2) Converter de Celsius para Farenheit");
            System.out.println("3) Converter de Kelvin para Celsius");
            System.out.println("4) Converter de Kelvin para Farenheit");
            System.out.println("5) Converter de Farenheit para Celsius");
            System.out.println("6) Converter de Farenheit para Kelvin");
            System.out.println("7) Sair");
            System.out.println("===========================================================");
            System.out.println("\nOpção: ");
            int entrada = sc.nextInt();
            
            switch (entrada) {
                case 1: 
                    System.out.println("\nDigite a temperatura em Celsius: ");
                    C = sc.nextFloat();
                    
                    K = Temperatura.celsiusParaKelvin(C);
                    
                    System.out.printf("\nA temperatura convertida em Kelvin é: %.2fK\n", K);
                    
                    break;
                case 2: 
                    System.out.println("\nDigite a temperatura em Celsius: ");
                    C = sc.nextFloat();
                    
                    F = Temperatura.celsiusParaFarenheit(C);
                    
                    System.out.printf("\nA temperatura convertida em Farenheit é: %.2fF\n", F);
                    
                    break;
                case 3: 
                    System.out.println("\nDigite a temperatura em Kelvin: ");
                    K = sc.nextFloat();
                    
                    C = Temperatura.kelvinParaCelsius(K);
                    
                    System.out.printf("\nA temperatura convertida em Celsius é: %.2fºC\n", C);
                    
                    break;
                case 4: 
                    System.out.println("\nDigite a temperatura em Kelvin: ");
                    K = sc.nextFloat();
                    
                    F = Temperatura.kelvinParaFarenheit(K);
                    
                    System.out.printf("\nA temperatura convertida em Farenheit é: %.2fF\n", F);
                    
                    break;
                case 5: 
                    System.out.println("\nDigite a temperatura em Farenheit: ");
                    F = sc.nextFloat();
                    
                    C = Temperatura.farenheitParaCelsius(F);
                    
                    System.out.printf("\nA temperatura convertida em Celsius é: %.2fºC\n", C);
                    
                    break;
                case 6: 
                    System.out.println("\nDigite a temperatura em Farenheit: ");
                    F = sc.nextFloat();
                    
                    K = Temperatura.farenheitParaKelvin(F);
                    
                    System.out.printf("\nA temperatura convertida em Kelvin é: %.2fK\n", K);
                    
                    break;
                case 7: ;
                    condicao = false;

                    break;
                default:
                    System.out.println("\n###ERRO!Opção de menu invalida.");
            }
        }
    }
    
}
