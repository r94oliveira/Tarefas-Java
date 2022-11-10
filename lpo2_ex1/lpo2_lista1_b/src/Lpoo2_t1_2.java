import java.util.Scanner;

public class Lpoo2_t1_2 {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        System.out.println(" Digite o valor da hora trabalhada: ");
        double vHora = s.nextDouble();
        System.out.println("\n Digite o número de horas trabalhadas por mês: ");
        double qtHora = s.nextDouble();
        System.out.println("\n Digite o percentual de desconto do INSS: ");
        double percDesc = s.nextDouble();
        double bruto = CalculaSalario.calcularSalarioBruto(vHora, qtHora);
        double liq = CalculaSalario.calcularSalarioLiquido(bruto, percDesc);
        System.out.println(CalculaSalario.imprimirSalario(vHora, qtHora, bruto, liq));
    }
    
}
