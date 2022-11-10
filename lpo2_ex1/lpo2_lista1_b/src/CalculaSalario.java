public class CalculaSalario {    
    public static double calcularSalarioBruto(double valorHora, double qtHora){
        if (valorHora <= 0 || qtHora <= 0) return -1;
        else return valorHora * qtHora;
    }
    
    public static double calcularSalarioLiquido(double salBruto, double pDesconto){
        if (salBruto <= 0 || pDesconto <=0) return -1;
        return salBruto - ((salBruto * pDesconto) / (double)100);
    }
    
    public static String imprimirSalario(double vHora, double qtHora, double salBruto, double salLiquido){
       return "\nExtrato de Salário\nValor Hora: R$ " + vHora + "\nHoras Trabalhadas: " + qtHora + 
               "\nSalário Bruto: R$ " + salBruto + "\nSalário Líquido: R$ " + salLiquido;
    }
}
