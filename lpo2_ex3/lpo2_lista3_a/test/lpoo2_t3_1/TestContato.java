package lpoo2_t3_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestContato {
    
    public TestContato() {
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
    public void testSetIdGetId(){
        Contato contato = new Contato();
        contato.setId(5);
        assertEquals(contato.getId(), 5);
    }
    
    @Test
    public void testSetIdInvalidShouldThrowException(){
        Contato contato = new Contato();
        try{
            contato.setId(0);
            fail("Erro!");
        }
        catch(RuntimeException re){
            assertEquals(re.getMessage(), "Id inválido!");
        }
    }
    
    @Test
    public void testSetNomeGetNome(){
        Contato contato = new Contato();
        contato.setNome("Teste");
        assertEquals(contato.getNome(), "Teste");
    }
    
    @Test
    public void testSetNomeInvalidShouldThrowException(){
        Contato contato = new Contato();
        try{
            contato.setNome(null);
            fail("Erro!");
        }
        catch(RuntimeException re){
            assertEquals(re.getMessage(), "Nome não pode estar vazio!");
        }
    }
    
    @Test
    public void testSetEmailGetNome(){
        Contato contato = new Contato();
        contato.setEmail("Teste@Teste.com");
        assertEquals(contato.getEmail(), "Teste@Teste.com");
    }
    
    @Test
    public void testSetEmailInvalidShouldThrowException(){
        Contato contato = new Contato();
        try{
            contato.setEmail(null);
            fail("Erro!");
        }
        catch(RuntimeException re){
            assertEquals(re.getMessage(), "Email não pode estar vazio!");
        }
    }
    
    @Test
    public void testSetEnderecoGetNome(){
        Contato contato = new Contato();
        contato.setEndereco("Rua teste");
        assertEquals(contato.getEndereco(), "Rua teste");
    }
    
    @Test
    public void testSetEnderecoInvalidShouldThrowException(){
        Contato contato = new Contato();
        try{
            contato.setEndereco(null);
            fail("Erro!");
        }
        catch(RuntimeException re){
            assertEquals(re.getMessage(), "Endereco não pode ser vazio!");
        }
    }
    
    @Test
    public void testSetDataNascGetDataNasc() throws ParseException{
        Contato contato = new Contato();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new java.sql.Date(sdf.parse("1997-03-25").getTime());
        contato.setDataNasc(data);
        assertEquals(contato.getDataNasc().toString(), "1997-03-25");
    }
    
    @Test
    public void testSetDataNascInvalidShouldThrowException(){
        Contato contato = new Contato();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = new java.sql.Date(new Date().getTime());
        try{
            contato.setDataNasc(data);
            fail("Erro!");
        }
        catch (RuntimeException re){
            assertEquals(re.getMessage(), "Data inválida!");
        }
    }
}
