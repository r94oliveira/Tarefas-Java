import java.util.*;

public class T03E06 {
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int m[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int determinante = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				try {
					System.out.printf("\nDigite o valor da linha %d na coluna %d: ", i + 1, j + 1);
					m[i][j] = sc.nextInt();
				} catch (InputMismatchException e) {
					j--;
					System.out.printf("\nDigite um valor valido!\n\n");
				} finally {
					clearBuffer(sc);
				}
			}
		}
     
		determinante = ((m[0][0] * m[1][1] * m[2][2])
						 + ( m[0][1] * m[1][2] * m[2][0]) 
						 + ( m[0][2] * m[1][0] * m[2][1])) 
						 - ((m[2][0] * m[1][1] * m[0][2]) 
						 + ( m[2][1] * m[1][2] * m[0][0]) 
						 + ( m[2][2] * m[1][0] * m[0][1]));
		
		System.out.printf("\n\n---------------------------------------------");
		System.out.printf("\nO determinante da matriz eh: %d\n", determinante);
        System.out.printf("---------------------------------------------\n\n");
    }
}
