import java.util.Scanner;

public class T02E05 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		String cargo;
		double salario = 0.0, bonusAnual = 0.0;
		
		System.out.printf("\n\nInforme o seu cargo: ");
		cargo = sc.nextLine();

		System.out.printf("\nInforme o salario atual: ");
		salario = sc.nextDouble();
		
		if (cargo.equals("diretor")) {
			System.out.printf("\n\nInforme a quantidade de departamentos gerenciados: ");
			double quantidadeDepartamentos = sc.nextDouble();
			
			bonusAnual = (4 * salario) + (3000 * quantidadeDepartamentos);
		}
		
		if (cargo.equals("gerente")) {
			System.out.printf("\n\nInforme a quantidade de pessoas gerenciadas: ");
			double quantidadePessoas = sc.nextDouble();
			
			bonusAnual = (2 * salario) + (100 * quantidadePessoas);
		}
		
		if (cargo.equals("analista")) {
			bonusAnual = salario;
		}
		
		if (cargo.equals("programador")) {
			bonusAnual = (0.8 * salario);
		}
		
		if (cargo.equals("auxiliar de limpeza")) {
			bonusAnual = (0.5 * salario);
		}
		
		System.out.printf("\n\nSeu bonus anual eh de: %.2f\n\n\n", bonusAnual);
	}
}
