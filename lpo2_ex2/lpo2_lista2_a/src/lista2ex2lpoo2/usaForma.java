/***************************************************************************************************
 2.(Tarefa  3)Crie  três  classes:  Circunferencia,  Retangulo  e  Triangulo.  
Para cada classe crie os seus construtores, sendo:
a.public Circunferencia(double raio)
b.public Retangulo(double lado1, double lado2)
c.public Triangulo(double base, double altura)
* Se  qualquer  construtor  receber  parâmetros negativos,  deve-se  levantar  a exceção 
* RuntimeException com uma mensagem específica para caso. Em cada classe crie o método área 
* com a seguinte assinatura:public double area() Para o Retangulo, incluir o método public 
* double perimetro()Antes da criação da classe, crie uma classe de teste unitário, com pelo 
* menos dois testes para cada classe e método. Criar  uma  outra  classe  UsaFormas, com  um  método
* main.  Esse  método deve  ter  um  laço  que  colete  informações  sobre  as  formas  que  o  
* usuário deseja criar.Antes de iniciar o laço, o usuário deve informar quantas formas deseja  criar.
* Deve-se  ter  uma  maneira  de  interromper  o  laço  quando  o usuário  não desejar  incluir  mais
* valores.  Depois  de  interrompido  o  laço  o sistema deve imprimir as áreas de todas as formas.
* ****************************************************************************************************
 */

package lista2ex2lpoo2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Clau
 * @author Erica
 * @author Robson
 * 
 */

public class usaForma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de formas deseja criar:\n");
        
        int f = s.nextInt();
        double[] formas = new double[f]; 
        
        for(int i=0; i < f; i++){
            
            System.out.println("*******MENU*******");
            System.out.println("1. Retangulo");
            System.out.println("2. Circunferencia");
            System.out.println("3. Triangulo");
            System.out.println("4. SAIR");
            System.out.println("******************");
            
            int op = s.nextInt();
            
            
            switch (op) {
                case(1):
                    System.out.println("Insira o valor do primeiro lado:");
                    double lado1 = s.nextDouble();
                    System.out.println("Insira o valor do segundo lado:");
                    double lado2 = s.nextDouble();
                    try{
                        Retangulo ret = new Retangulo(lado1, lado2);
                        formas[i] = ret.area();
                    }
                    catch (RuntimeException e){
                        i--;
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Insira o valor do raio: ");
                    double raio = s.nextDouble();
                    try{
                        Circunferencia cir = new Circunferencia(raio);
                        formas[i] = cir.area();
                    }
                    catch(RuntimeException e){
                        i--;
                        System.out.println(e.getMessage());
                    }
                    break;
                case(3):
                    System.out.println("Insira o valor da base:");
                    double base = s.nextDouble();
                    System.out.println("Insira o valor da altura:");
                    double altura = s.nextDouble();
                    try{
                        Triangulo tri = new Triangulo(base, altura);
                        formas[i] = tri.area();
                    }
                    catch (RuntimeException e){
                        i--;
                        System.out.println(e.getMessage());
                    }
                    break;
                case (4):
                    break;
                default:
                    System.out.println("Esse valor não é válido, selecione uma das opções do MENU");
                    i--;
                    break;
             
            }
        }
            System.out.println("\n As informações das formas selecionadas seguem abaixo: ");
            
            for (int j = 0; j < formas.length; j++){
                System.out.println("\n FORMA " + (j+1) + ", Área = " + formas[j]);
        }
    }
}
            
    