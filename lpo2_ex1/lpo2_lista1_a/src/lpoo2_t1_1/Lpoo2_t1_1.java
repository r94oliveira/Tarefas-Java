package lpoo2_t1_1;

import java.util.Scanner;

public class Lpoo2_t1_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double result = 0;
        int opt;
        do{
            System.out.println("\n Digite a opção desejada:\n 1 - Área de Retângulo");
            System.out.println(" 2 - Área do Círculo\n 3 - Área do triângulo\n 0 - Sair");
            opt = s.nextInt();
            switch(opt){
                case 1:
                    System.out.println("\n Digite o valor do primeiro lado: ");
                    double l1 = s.nextDouble();
                    System.out.println("\n Digite o valor do segundo lado: ");
                    double l2 = s.nextDouble();
                    try{
                        result = Calculator.calculaAreaRetangulo(l1, l2);
                        System.out.println("\n Resultado: " + result);
                    }
                    catch(RuntimeException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\n Digite o valor do raio: ");
                    double r = s.nextDouble();
                    try{
                        result = Calculator.calculaAreaCircunferencia(r);
                        System.out.println("\n Resultado: " + result);
                    }
                    catch(RuntimeException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\n Digite o valor da base: ");
                    double b = s.nextDouble();
                    System.out.println("\n Digite o valor da altura: ");
                    double h = s.nextDouble();
                    try{
                        result = Calculator.calculaAreaTriangulo(b, h);
                        System.out.println("\n Resultado: " + result);
                    }
                    catch(RuntimeException ex){
                       System.out.println(ex.getMessage());
                    }
                    break;
                case 0: 
                    System.out.println("\n Fim...");
                    break;
                default: 
                    System.out.println("\n Opção Inválida!");
            }
        }while(opt != 0);
    }    
}