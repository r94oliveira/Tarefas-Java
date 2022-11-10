
package lpoo2_t3_1;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestContatoDao {
    
    public TestContatoDao() {
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
    public void testInsereRemove() throws ParseException, SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Contato contato = new Contato("Teste", "teste@teste.teste", "rua teste", 
                new java.sql.Date(sdf.parse("1997-03-25").getTime()));
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.insere(contato);
        assertTrue(contato.getId() != 0);
        contatoDao.remove(contato);
        assertTrue(contatoDao.selecionaById(contato.getId()) == null);
    }
    
    @Test
    public void testInsereAlteraRemove() throws ParseException, SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Contato contato = new Contato("Teste", "teste@teste.teste", "rua teste", 
                new java.sql.Date(sdf.parse("1997-03-25").getTime()));
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.insere(contato);
        contato.setNome("TesteTeste");
        contatoDao.altera(contato);
        assertTrue(contatoDao.selecionaById(contato.getId()).getNome().equals(contato.getNome()));
        contatoDao.remove(contato);
    }
    
    @Test 
    public void testLista() throws SQLException{
        ContatoDao contatoDao = new ContatoDao();
        List<Contato> contatos = contatoDao.lista();
        assertTrue(contatos.size() > 0);
        assertTrue(contatos.get(0).getNome().equals("Matheus Ribeiro"));
    }
}
