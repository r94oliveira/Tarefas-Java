import java.util.*;

public class T03E01 {
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		double numero = 0.0, media = 0.0, soma = 0.0, contador = 0.0;
		char sair;
		
		while (true) {
			try {
				System.out.printf("\nDigite um numero: ");
				numero = sc.nextDouble();
				
				soma += numero;
				contador++;
				
				System.out.printf("\nO numero digitado eh: %.2f\n\n", numero);
				
				System.out.printf("Digite \"s\" para sair ou outra tecla para continuar: ");
				sair = sc.next().charAt(0);
				
				if (sair == 'S' | sair == 's') {
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.printf("\nDigite um valor valido!\n\n");
			} finally {
				clearBuffer(sc);
			}
		}
		
		media = soma / contador;
		
		System.out.printf("\n---------------------------------------------");
		System.out.printf("\nA media dos numeros informados eh: %.2f\n", media);
		System.out.printf("---------------------------------------------\n\n");
	}
}
