package lpoo2_t4_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPilha {
    
    public TestPilha() {
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
    public void testEmpilhaDesempilha(){
        Pilha pilha = new Pilha();
        pilha.empilha(new Double(1));
        Double d = (Double) pilha.desempilha();
        assertEquals(d, 1, 0);
    }
    
    @Test
    public void testEmpilhaDesempilhaShouldThrowException(){
        try{
            Pilha pilha = new Pilha();
            pilha.empilha(1);
            pilha.empilha(2);
            pilha.desempilha();
            pilha.desempilha();
            pilha.desempilha();
            fail();
        }
        catch(RuntimeException re){
            assertEquals("A pilha está vazia!", re.getMessage());
        }
    }
    
    @Test
    public void testDesempilhaPilhaVaziaShouldThrowException(){
        try{
            Pilha p = new Pilha();
            p.desempilha();
            fail();
        }
        catch(RuntimeException re){
            assertEquals("A pilha está vazia!", re.getMessage());
        }
    }
}
