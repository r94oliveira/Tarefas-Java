package lpoo2_t3_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {
    private final String sqlInsere = "INSERT INTO cliente (nome, email, endereco, dataNasc) VALUES (?, ?, ?, ?);";
    private final String sqlAltera = "UPDATE contato SET nome = ?, email = ?, "
            + "endereco = ?, dataNasc = ? WHERE id = ?;";
    private final String sqlRemove = "DELETE FROM contato WHERE id = ?;";
    private final String sqlLista = "SELECT * FROM contato";
    private final String sqlById = "SELECT * FROM contato WHERE id = ?;";
    
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    
    public ContatoDao(){}
    
    public void insere(Contato contato) throws SQLException{
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sqlInsere, PreparedStatement.RETURN_GENERATED_KEYS);
        
        st.setString(1, contato.getNome());
        st.setString(2, contato.getEmail());
        st.setString(3, contato.getEndereco());
        st.setDate(4, (Date) contato.getDataNasc());
                
        st.executeUpdate();
        
        rs = st.getGeneratedKeys();
        rs.next();
        
        contato.setId(rs.getInt(1));
        
        rs.close();
        st.close();
        con.close();
    }
    
    public void altera(Contato contato) throws SQLException{
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sqlAltera);
        
        st.setString(1, contato.getNome());
        st.setString(2, contato.getEmail());
        st.setString(3, contato.getEndereco());
        st.setDate(4, (Date) contato.getDataNasc());
        st.setInt(5, contato.getId());
        
        st.executeUpdate();
        
        st.close();
        con.close();
    }
    
    public void remove(Contato contato) throws SQLException{
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sqlRemove);
        st.setInt(1, contato.getId());
        st.executeUpdate();
        
        st.close();
        con.close();
    }
    
    public List<Contato> lista() throws SQLException{
        List<Contato> lista = new ArrayList<Contato>();
        
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sqlLista);
        rs = st.executeQuery();
        
        while (rs.next()){
            Contato contato = new Contato();
            contato.setId(rs.getInt(1));
            contato.setNome(rs.getString(2));
            contato.setEmail(rs.getString(3));
            contato.setEndereco(rs.getString(4));
            contato.setDataNasc(rs.getDate(5));
            lista.add(contato);
        }
        
        rs.close();
        st.close();
        con.close();
        
        return lista;
    }
    
    public Contato selecionaById(int id) throws SQLException{
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sqlById);
        st.setInt(1, id);
        rs = st.executeQuery();
        
        if(rs.next()){
            Contato contato = new Contato();
            contato.setId(rs.getInt(1));
            contato.setNome(rs.getString(2));
            contato.setEmail(rs.getString(3));
            contato.setEndereco(rs.getString(4));
            contato.setDataNasc(rs.getDate(5));
            
            rs.close();
            st.close();
            con.close();
            
            return contato;
        }
        
        return null;
    }
}