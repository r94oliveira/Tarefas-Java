import java.util.Scanner;

public class T02E06 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int numero = 0, atual = 0, anterior = 0;
		
		System.out.printf("\nInforme o numero: ");
		numero = sc.nextInt();
		
		for (int i = 0; i < numero; i++) {
            for (int j = 1; j <= i; j++) {
				if (j == 1) {
					atual = 1;
					anterior = 0;
				} else {
					atual += anterior;
					anterior = atual - anterior;
				}
			}
			
			System.out.printf("\n(%d): %d\n", i, atual);
        }
	}
}
