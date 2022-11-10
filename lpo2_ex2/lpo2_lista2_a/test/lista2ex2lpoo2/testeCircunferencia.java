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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Clau
 */
public class testeCircunferencia {
    
    public testeCircunferencia() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testeAreaCircunferencia(){
        Circunferencia cir = new Circunferencia(10);
        assertEquals(Math.pow(10.0, 2)*Math.PI, cir.area(), 0.0);
    }
}