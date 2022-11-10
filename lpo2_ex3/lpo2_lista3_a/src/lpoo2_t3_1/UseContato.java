package lpoo2_t3_1;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class UseContato {
    private ContatoDao contatoDao;
    
    public UseContato(){
        contatoDao = new ContatoDao();
    }
    
    public static void main(String args[]) throws SQLException, ParseException{
        UseContato main = new UseContato();
        Scanner scan = new Scanner(System.in);
        int opt;
        do{
            System.out.println("\n Escolha uma das opções:\n 1 - Inserir Contato\n 2 - Alterar Contato" +
                    "\n 3 - Remover Contato\n 4 - Listar Contatos\n 0 - Sair\n ");
            opt = scan.nextInt();
            switch(opt){
                case 0: break;
                case 1:
                    main.inserirContato();
                    break;
                case 2:
                    main.alterarContato();
                    break;
                case 3:
                    main.removerContato();
                    break;
                case 4:
                    main.listarContatos();
                    break;
                default: System.out.println("\n Opção inválida!");
                           
            }   
        }
        while(opt != 0);
    }
    
    public void inserirContato(){
        Scanner s = new Scanner(System.in);
        Contato contato = new Contato();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            System.out.println("\n Digite o nome do Contato: ");
            contato.setNome(s.nextLine());
            System.out.println("\n Digite o email do Contato: ");
            contato.setEmail(s.nextLine());
            System.out.println("\n Digite o endereço do Contato: ");
            contato.setEndereco(s.nextLine());
            System.out.println("\n Digite a data de nascimento do Contato (formato YYYY-MM-DD): ");
            contato.setDataNasc(new java.sql.Date(sdf.parse(s.nextLine()).getTime()));
            contatoDao.insere(contato);
        }
        catch(Exception ex){ System.out.println(ex.getMessage()); }
    }
    
    public void alterarContato(){
        Scanner s = new Scanner(System.in);
        Contato contato;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int id;
        String novo;
        try{
            System.out.println("\n Digite o ID do contato: ");
            id = s.nextInt();
            s.nextLine();
            contato = contatoDao.selecionaById(id);
            if (contato != null){
                System.out.println("\n Digite o novo Nome (Digite -1 para manter " + contato.getNome() + "): ");
                novo = s.nextLine();
                if (!novo.equals("-1")) contato.setNome(novo);
                System.out.println("\n Digite o novo Email (Digite -1 para manter " + contato.getEmail() + "): ");
                novo = s.nextLine();
                if (!novo.equals("-1")) contato.setEmail(novo);
                System.out.println("\n Digite o novo Endereço (Digite -1 para manter " + contato.getEndereco() + "): ");
                novo = s.nextLine();
                if (!novo.equals("-1")) contato.setEndereco(novo);
                System.out.println("\n Digite a nova Data de Nascimento (Digite -1 para manter " +
                        contato.getDataNasc().toString() + "): ");
                novo = s.nextLine();
                if (!novo.equals("-1")) contato.setDataNasc(new java.sql.Date(sdf.parse(novo).getTime()));
                
                contatoDao.altera(contato);
            }
            else System.out.println("\n ID inválido, contato não encontrado!");
        }
        catch(Exception ex){ System.out.println(ex.getMessage()); }
    }
    
    public void removerContato(){
        Scanner s = new Scanner(System.in);
        int id;
        try{
            System.out.println("\n Digite o ID do contato a ser removido: ");
            id = s.nextInt();
            s.nextLine();
            Contato contato = contatoDao.selecionaById(id);
            if (contato != null){
                contatoDao.remove(contato);
            }
            else System.out.println("\n Contato não encontrado!");
        }
        catch (Exception ex){ System.out.println(ex.getMessage()); }
    }
    
    public void listarContatos(){
        List<Contato> lista;
        try{
            lista = contatoDao.lista();
            System.out.println("\n Lista de Contatos: ");
            for (int i = 0; i < lista.size(); i++)
                System.out.println(lista.get(i).toString());
        }
        catch(Exception ex){ System.out.println(ex.getMessage()); }
    }
}

