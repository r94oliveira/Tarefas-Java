import java.util.*;

public class T03E03 {
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		double indice = 0.0, media = 0.0, soma = 0.0, minima = 0.0, maxima = 0.0;
		int diaMin = 0, diaMax = 0;
		
		while (true) {
			try {
				for (int i = 0; i < 7; i++) {
					System.out.printf("\nDigite o indice pluviometrico do dia [%d/7]: ", i + 1);
					indice = sc.nextDouble();
					
					soma += indice;
					
					if (i == 0) {
						media = indice;
						
						minima = indice;
						maxima = indice;
						
						diaMin = 1;
						diaMax = 1;
					} else {
						if (indice < minima) {
							minima = indice;
							diaMin = i + 1;
						}
						
						if (indice > maxima) {
							maxima = indice;
							diaMax = i + 1;
						}
					}
				}
				
				break;
			} catch (InputMismatchException e) {
				System.out.printf("\nDigite um valor valido!\n\n");
				soma = 0.0;
			} finally {
				clearBuffer(sc);
			}
		}
		
		media = soma / 7;
		
		System.out.printf("\n---------------------------------------------");
		System.out.printf("\nO indice pluviometrico medio eh igual a: %.2f\n", media);
		System.out.printf("\nO indice pluviometrico minimo eh igual a: %.2f no dia %d\n", minima, diaMin);
		System.out.printf("\nO indice pluviometrico maximo eh igual a: %.2f no dia %d\n", maxima, diaMax);
		System.out.printf("---------------------------------------------\n\n");
	}
}
