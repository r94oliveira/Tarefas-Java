import java.util.Scanner;

public class T01E01 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Digite o primeiro numero: ");	
		double primeiroNumero = sc.nextDouble();
		
		System.out.println("Digite o segundo numero: ");
		double segundoNumero = sc.nextDouble();
		
		System.out.println("Digite a operacao: ");	
		char operacao = sc.next().charAt(0);

		switch (operacao) {
			case '+':
				double soma = primeiroNumero + segundoNumero;
				System.out.printf("%.2f %c %.2f = %.2f\n", primeiroNumero, operacao, segundoNumero, soma);
				
				break;
			case '-':
				double sub = primeiroNumero - segundoNumero;
				System.out.printf("%.2f %c %.2f = %.2f\n", primeiroNumero, operacao, segundoNumero, sub);
				
				break;
			case '*':
				double vezes = primeiroNumero * segundoNumero;
				System.out.printf("%.2f %c %.2f = %.2f\n", primeiroNumero, operacao, segundoNumero, vezes);
				
				break;
			case '/':
				double divisao = primeiroNumero / segundoNumero;
				System.out.printf("%.2f %c %.2f = %.2f\n", primeiroNumero, operacao, segundoNumero, divisao);
				
				break;
			default:
				System.out.println("Operacao invalida!");
		}
	}
}