import java.util.*;

public class T03E02 {
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		double numero = 0.0, soma = 0.0;
		
		while (true) {
			try {
				for (int i = 0; i < 20; i++) {
					System.out.printf("\nDigite um numero [%d/20]: ", i + 1);
					numero = sc.nextDouble();
					
					if (numero % 2 == 0)
						soma += numero;
				}
				
				break;
			} catch (InputMismatchException e) {
				System.out.printf("\nDigite um valor valido!\n\n");
				soma = 0.0;
			} finally {
				clearBuffer(sc);
			}
		}
		
		System.out.printf("\n---------------------------------------------");
		System.out.printf("\nA soma dos numeros pares informados eh: %.2f\n", soma);
		System.out.printf("---------------------------------------------\n\n");
	}
}
