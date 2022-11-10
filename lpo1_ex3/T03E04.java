import java.util.*;

public class T03E04 {
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		String nome;
		int numeroFuncionarios = 0;
		double media = 0.0, soma = 0.0;
		
		while (true) {
			try {
				System.out.printf("\nDigite quantos funcionarios existem na empresa: ");
				numeroFuncionarios = sc.nextInt();
				
				break;
			} catch (InputMismatchException e) {
				System.out.printf("\nDigite um valor valido!\n\n");
			} finally {
				clearBuffer(sc);
			}
		}
		
		String arrayNomes[] = new String[numeroFuncionarios];
		double arraySalarios[] = new double[numeroFuncionarios];
		
		for (int i = 0; i < numeroFuncionarios; i++) {
			try {
				System.out.printf("\n\nDigite o nome do funcionario [%d/%d]: ", i + 1, numeroFuncionarios);
				nome = sc.nextLine();
				
				if (nome.length() >= 3)
					arrayNomes[i] = nome;
				else
					throw new InputMismatchException();
				
				System.out.printf("\nDigite o salario do funcionario [%d/%d]: ", i + 1, numeroFuncionarios);
				arraySalarios[i] = sc.nextDouble();
				
				System.out.println();
				
			} catch (InputMismatchException e) {
				i--;
				System.out.printf("\nDigite um valor valido!\n\n");
			} finally {
				clearBuffer(sc);
			}
		}
		
		for (double salario: arraySalarios) {
			soma += salario;
		}
		
		media = soma / numeroFuncionarios;
		
		System.out.printf("\n---------------------------------------------");
		System.out.printf("\nOs funcionarios com salarios acima da media de R$%.2f sao: ", media);
		System.out.printf("\n---------------------------------------------");
		for (int i = 0; i < numeroFuncionarios; i++) {
			if (arraySalarios[i] > media) {
				System.out.printf("\nNome: %s", arrayNomes[i]);
				System.out.printf("\nSalario: R$%.2f\n", arraySalarios[i]);
			}
		}
		System.out.printf("---------------------------------------------\n\n");
	}
}
