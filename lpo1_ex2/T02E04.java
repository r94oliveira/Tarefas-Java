import java.util.Scanner;

public class T02E04 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		double primeiraRaiz = 0, segundaRaiz = 0;

		System.out.printf("\n\nInforme o valor de a: ");
		double a = sc.nextDouble();

		System.out.printf("\nInforme o valor de b: ");
		double b = sc.nextDouble();

		System.out.printf("\nInforme o valor de c: ");
		double c = sc.nextDouble();

		double delta = (b * b) - (4 * a * c);
		double sqrt = Math.sqrt(delta);

		if (delta > 0) {
			primeiraRaiz = (-b + sqrt) / (2 * a);
			segundaRaiz = (-b - sqrt) / (2 * a);
		 
			System.out.printf("\n\nResultado: x = %.2f e x = %.2f\n\n\n", primeiraRaiz, segundaRaiz);
		} else if (delta == 0) {
			double resultado = +(-b + sqrt) / (2 * a);
			
			System.out.printf("\n\nResultado: x = %.2f\n\n\n", resultado);
		} else {
			System.out.printf("\n\nO delta eh menor que zero, reveja seus valores!\n\n\n");
		}
	}
}
