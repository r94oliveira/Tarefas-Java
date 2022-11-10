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

/**
 *
 * @author Clau
 * @author Erica
 * @author Robson
 * 
 */

public class Circunferencia {

    double raio;
    
    Circunferencia(double raio) throws RuntimeException{
        if(raio <= 0)
        throw new RuntimeException("O raio da circunferencia deve ser positivo e diferente de zero");
        else{
            this.raio = raio;
        }
    }

    double area() {
        return Math.PI*Math.pow(this.raio, 2);
    }
}
