package t07e04;

public class SistemaRH {

    public static void main(String[] args) {
        String[] Departamentos = {"Departamento de Desenvolvimento","Departamento de Producao"};
        
        String[] Funcionarios = {"Carlos", 
                                "Luiz"};
        
        Funcionario[] listaFuncionarios = new Funcionario[3];
        
        try {
        Diretor diretor = new Diretor("Ricardo Silva", "Rua das Gracieiras", 54, 147896145, 9000, Departamentos);
        Gerente gerente = new Gerente("Luiza Neto", "Rua Me Da Nota Alta Por Favor", 47, 78966893, 7000, Funcionarios);
        Analista analista = new Analista("Pietro Silva", "Rua Florinda", 24, 654563212, 4000);

            listaFuncionarios[0] = diretor;
            listaFuncionarios[1] = gerente;
            listaFuncionarios[2] = analista;

            imprimeRelatorio(listaFuncionarios);
        } catch(DiretorException exDir) {
            System.out.println("Exceção: \n" + exDir);
        } catch(GerenteException exGer) {
            System.out.println("Exceção: \n" + exGer);
        }
    }
    
    public static void imprimeRelatorio(Funcionario[] listaFuncionarios) {
        for(int i = 0; i < listaFuncionarios.length; i++) {
            System.out.printf("\nFuncionário[%d]: %s", i + 1, listaFuncionarios[i].getNome());
            System.out.printf("\nBônus do funcionário[%d]: R$%.2f", i + 1, listaFuncionarios[i].getBonus());
            
            System.out.println("");
        }
    }
    
}
