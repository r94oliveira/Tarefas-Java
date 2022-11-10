package lpoo2_t1_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculator {
    
    public TestCalculator() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAreaRetangulo(){
        double res = Calculator.calculaAreaRetangulo(1.0, 2.0);
        assertEquals(2.0, res, 0.0);
    }
    
    @Test
    public void testAreaRetanguloException(){
        try{
            double res = Calculator.calculaAreaRetangulo(1.0, 0);
            fail("Teste falhou!");
        }
        catch(RuntimeException ex){
            assertEquals("Base e altura devem ser valores positivos e diferentes de zero!", ex.getMessage());
        }
    }
    
    @Test
    public void testAreaCircunferencia(){
        double res = Calculator.calculaAreaCircunferencia(1.0);
        assertEquals(Math.PI * Math.pow(1.0, 2), res, 0.0);
    }
    
    @Test
    public void testAreaCircunferenciaException(){
        try{
            double res = Calculator.calculaAreaCircunferencia(0);
        }
        catch(RuntimeException ex){
            assertEquals("Raio deve ser positivo e diferente de zero!", ex.getMessage());
        }       
    }
    
    @Test
    public void testAreaTriangulo(){
        double res = Calculator.calculaAreaTriangulo(3.0, 5.0);
        assertEquals(7.5, res, 0.0);
    }
    
    @Test
    public void testAreaTrianguloException(){
        try{
            double res = Calculator.calculaAreaTriangulo(-1.0, 0);
            fail("Teste falhou!");
        }
        catch(RuntimeException ex){
            assertEquals("Base e Altura devem ser positivos e diferentes de zero!", ex.getMessage());
        }    
    }
}
