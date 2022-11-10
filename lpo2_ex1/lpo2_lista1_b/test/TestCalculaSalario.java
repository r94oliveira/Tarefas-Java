import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculaSalario {
    
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
    public void testaCalcularSalarioBruto(){
        double res = CalculaSalario.calcularSalarioBruto(25, 240);
        assertEquals(6000.0, res, 0.0);
    }
    
    @Test
    public void testaCalcularSalarioBrutoError(){
        double res = CalculaSalario.calcularSalarioBruto(0.0, 0.0);
        assertEquals(-1, res, 0.0);
    }
    
    @Test
    public void testaCalcularSalarioLiquido(){
        double res = CalculaSalario.calcularSalarioLiquido(6000.0, 10);
        assertEquals(5400.00, res, 0.0);
    }
    
    @Test
    public void testaCalcularSalarioLiquidoError(){
        double res = CalculaSalario.calcularSalarioLiquido(0.0, 0.0);
        assertEquals(-1, res, 0.0);
    }
}