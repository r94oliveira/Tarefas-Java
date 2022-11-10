import java.lang.*;
import java.util.Scanner;

public class T02E03 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a posicao do ponto A(x1): ");
		double pAx1 = sc.nextDouble();
		
		System.out.println("Informe a posicao do ponto A(y1): ");	
		double pAy1 = sc.nextDouble();
		
		System.out.println("Informe a posicao do ponto B(x2): ");	
		double pBx2 = sc.nextDouble();
		
		System.out.println("Informe a posicao do ponto B(y2): ");	
		double pBy2 = sc.nextDouble();
		
		double distancia = Math.hypot(pAx1 - pBx2, pAy1 - pBy2);
		
		System.out.printf("A distancia entre o ponto A e o ponto B eh de: %.2f", distancia);
	}
}
