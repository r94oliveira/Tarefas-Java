package t06e01;

public class SistemaRH {

    public static void main(String[] args) {
        String[] Departamentos = new String[3];
        Departamentos[0] = "Departamento de Desenvolvimento";
        Departamentos[1] = "Departamento de Design";
        Departamentos[2] = "Departamento de Segurança";
        
        String[] Funcionarios = {"Carlos", 
                                "Luiz", 
                                "Pedro", 
                                "Henrique", 
                                "Gustavo", 
                                "Maria"};
        
        Funcionario[] listaFuncionarios = new Funcionario[3];
        Diretor diretor = new Diretor("Ricardo Silva", "Rua das Gracieiras", 54, 147896145, 9000, Departamentos);
        Gerente gerente = new Gerente("Luiza Neto", "Rua Me Da Nota Alta Por Favor", 47, 78966893, 7000, Funcionarios);
        Analista analista = new Analista("Pietro Silva", "Rua Florinda", 24, 654563212, 4000);
        
        listaFuncionarios[0] = diretor;
        listaFuncionarios[1] = gerente;
        listaFuncionarios[2] = analista;
        
        imprimeRelatorio(listaFuncionarios);
    }
    
    public static void imprimeRelatorio(Funcionario[] listaFuncionarios) {
        for(int i = 0; i < listaFuncionarios.length; i++) {
            System.out.printf("\nFuncionário[%d]: %s", i + 1, listaFuncionarios[i].getNome());
            System.out.printf("\nBônus do funcionário[%d]: R$%.2f", i + 1, listaFuncionarios[i].getBonus());
            
            System.out.println("");
        }
    }
    
}
