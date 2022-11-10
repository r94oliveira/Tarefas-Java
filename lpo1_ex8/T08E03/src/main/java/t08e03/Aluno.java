package t08e03;

public class Aluno extends Pessoa {
    private String matricula;
    private String curso;
    private int periodo;
    private Disciplina[] disciplinasMatriculadas;
    private int quantidade = 0;
    
    public Aluno(String nome,
                 int idade,
                 String endereco,
                 String matricula, 
                 String curso, 
                 int periodo, 
                 int quantidadeDisciplinasPermitidas) {
        super(nome, idade, endereco);
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.setQuantidadeDisciplinasPermitidas(quantidadeDisciplinasPermitidas);
    }
    
    public String getNome() {
        return super.getNome();
    }
    
    public int getquantidadeDisciplinasMatriculadas() {
        return this.quantidade;
    }
    
    public void setQuantidadeDisciplinasPermitidas(int quantidadeDisciplinasPermitidas) {
        this.disciplinasMatriculadas = new Disciplina[quantidadeDisciplinasPermitidas];
    }
    
    public String fazMatricula(Disciplina disciplina) {
        String informe;
        
        if (this.disciplinasMatriculadas.length == 0) {
            informe = "\nEste aluno não pode ser matriculado em nenhuma disciplina, por favor, fale com a secretaria.\n\n";
            return informe;
        }
        
        if (this.quantidade >= this.disciplinasMatriculadas.length) {
            informe = "\nQuantidade de disciplinas excedida.\nO limite de disciplinas para este aluno é de " 
                    + disciplinasMatriculadas.length 
                    + " disciplina(s).\nSe desejar, cancele a matrícula de uma das disciplinas e faça a nova matrícula.\n\n";
            return informe;
        }
        
        this.disciplinasMatriculadas[this.quantidade] = disciplina;
        this.quantidade++;
        
        informe = "\nMatrícula na disciplina " + disciplina.getNome() + " executada.\n\n";
        return informe;
    }
    
    public String cancelarMatricula(String disciplina) {
        String informe;
        
        int j, i = 0;
        while (i < this.quantidade && !disciplina.equals(disciplinasMatriculadas[i].getNome())) {
            i++;
        }
        
        if (i == this.quantidade) {
            informe = "\nAluno não está matriculado na disciplina " 
                    + disciplina 
                    + ", portanto não é possível cancelar esta matrícula.\n\n";
            return informe;
        }
        
        for (j = i; j < this.quantidade; j++) {
            if (j == this.quantidade - 1) {
                disciplinasMatriculadas[j] = null;
                break;
            }
            
            disciplinasMatriculadas[j] = disciplinasMatriculadas[j + 1];
        }
        
        this.quantidade--;
        
        informe = "\nCancelamento da matrícula da disciplina " + disciplina + " executado com sucesso.\n\n";
        return informe;
    }
    
    public String imprime() {
        String alunoAtributos = "", disciplinas = "";
        
        int i;
        for (i = 0; i < this.quantidade; i++) {
            disciplinas += disciplinasMatriculadas[i].getNome() + "; ";
        }
        
        if (disciplinas == null || disciplinas == "") {
            disciplinas = "Nenhuma";
        }
        
        alunoAtributos = "\n-----------------------------------------------------------------\n" + 
                         "Nome do Aluno: "              + super.getNome() + 
                         "\nMatrícula: "                + this.matricula  + 
                         "\nCurso: "                    + this.curso      +
                         "\nPeríodo: "                  + this.periodo    + 
                         "\nDisciplinas Matriculadas: " + disciplinas     + 
                         "\n-----------------------------------------------------------------\n";
        return alunoAtributos;
    }
}
