import java.util.*;

public class T03E07 {
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	
	public static void preencherMatriz(int[][] m) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("\n\n---------------------------------------------");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				try {
					System.out.printf("\nDigite o valor da linha %d na coluna %d: ", i + 1, j + 1);
					m[i][j] = sc.nextInt();
				} catch (InputMismatchException e) {
					j--;
					System.out.printf("\nDigite um valor valido!\n");
				} finally {
					clearBuffer(sc);
				}
			}
		}
		System.out.printf("\n---------------------------------------------\n\n");
	}
	
	public static int somaPrincipal(int[][] m) {
		int soma = 0;
		
		for (int i = 0; i < m.length; i++) {
			soma += m[i][i];
		}
		
		return soma;
	}
	
	public static int somaSecundaria(int[][] m) {
		int soma = 0, colunaMatriz = m[0].length - 1;
		
		for (int linha = 0; linha < m.length; linha++) {
			soma += m[linha][colunaMatriz];
			
			colunaMatriz--;
			
			if (colunaMatriz < 0)
				break;
		}
		
		return soma;
	}

    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int determinante = 0, linhasMatriz = 0, colunasMatriz = 0;
		
		while (true) {
			try {
				System.out.printf("\nDigite a quantidade de linhas da matriz: ");
				linhasMatriz = sc.nextInt();
				
				System.out.printf("\nDigite a quantidade de colunas da matriz: ");
				colunasMatriz = sc.nextInt();
				
				break;
			} catch (InputMismatchException e) {
				System.out.printf("\nDigite um valor valido!\n\n");
			} finally {
				clearBuffer(sc);
			}
		}
		
		int m[][] = new int[linhasMatriz][colunasMatriz];
		
		preencherMatriz(m);
		
		if (linhasMatriz == colunasMatriz && linhasMatriz >= 2) {
			int diagonalPrincipal = somaPrincipal(m);
			int diagonalSecundaria = somaSecundaria(m);
			
			System.out.printf("---------------------------------------------");
			System.out.printf("\nA soma da diagonal principal eh: %d\nEnquanto a soma da diagonal secundaria eh: %d\n", diagonalPrincipal, diagonalSecundaria);
			System.out.printf("---------------------------------------------\n\n");
		} else {
			System.out.printf("---------------------------------------------");
			System.out.printf("\nO numero de linhas e colunas nao eh o mesmo ou ha apenas um elemento!\nInforme uma matriz quadratica de ordem 2 ou superior!\n");
			System.out.printf("---------------------------------------------\n\n");
		}
	}
}
