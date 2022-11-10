import java.util.Scanner;

public class T02E01 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Informe a distancia percorrida em km: ");	
		double distanciaPercorrida = sc.nextDouble();
		
		System.out.println("Informe o tempo gasto na viagem em horas: ");	
		double tempoGasto = sc.nextDouble();
	
		double velocidade = distanciaPercorrida / tempoGasto;

		System.out.printf("A velocidade atingida foi de: %.2fkm/h", velocidade);
	}
}
