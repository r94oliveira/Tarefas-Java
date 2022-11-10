import java.util.*;

public class T03E08 {
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static double somaDesvio(double[] m) {
		double soma = 0.0;
		
		for (int i = 0; i < m.length; i++) {
			soma += m[i];
		}
		
		return soma;
	}
	
	public static double mediaDesvio(double[] m) {
		try {
			return somaDesvio(m) / m.length;
		} catch (NullPointerException e) {
			throw new IllegalArgumentException("\nA lista possui valores nulos!\n\n");
		}
	}
	
	public static double desvioPadrao(double[] m) {
		double media = mediaDesvio(m), desvPadrao = 0.0;
		int tamanho = m.length;
		
		for (double valor: m) {
			double aux = valor - media;
			desvPadrao += aux * aux;
		}
		
		return Math.sqrt(desvPadrao / (tamanho - 1));
	}

    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int numeroAmostras = 0;
		double desvPadrao = 0.0;
		
		while (true) {
			try {
				System.out.printf("\nDigite o numero de amostras: ");
				numeroAmostras = sc.nextInt();
				
				break;
			} catch (InputMismatchException e) {
				System.out.printf("\nDigite um valor valido!\n");
			} finally {
				clearBuffer(sc);	
			}
		}
		
		double m[] = new double[numeroAmostras];
		
		System.out.printf("\n\n---------------------------------------------");
		for (int i = 0; i < m.length; i++) {
			try {
				System.out.printf("\nDigite o valor da %da amostra: ", i + 1);
				m[i] = sc.nextDouble();
			} catch (InputMismatchException e) {
				i--;
				System.out.printf("\nDigite um valor valido!");
			} finally {
				clearBuffer(sc);
			}
		}
		System.out.printf("--------------------------------------------\n\n");
		
		desvPadrao = desvioPadrao(m);
		
		System.out.printf("---------------------------------------------");
		System.out.printf("\nO desvio padrao das amostras informadas eh: %.2f", desvPadrao);
		System.out.printf("\n---------------------------------------------\n\n");
	}
}
