package notepad++.semana02;

import java.util.Scanner;

public class T02E02 {
	/**
	* @author Robson Mariano Euzébio de Oliveira
	*/
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a quantidade total de DVDs: ");
		double quantidadeDVD = sc.nextDouble();
		//salva a quantidade total de DVDs presente na locadora.
		
		System.out.println("Informe o valor de aluguel por cada DVD: ");	
		double valorAluguel = sc.nextDouble();
		//salva o valor de aluguel para cada DVD
		
		double faturamentoAnual = ((quantidadeDVD / 3) * valorAluguel) * 12;
		/**
		* primeiro é calculado quantos DVDs são alugados por mês, depois quanto
		* é o aluguel por mês, e então é multiplicado por 12 para saber o faturamento anual
		*/
		
		double lucroMultas = ((quantidadeDVD / 3) / 10) * (valorAluguel * 0.1);
		/**
		* um décimo dos DVDs alugados são devolvidos com atraso, logo são um décimo dos um terço
		* de DVDs alugados por mês, e a cobrança disso é de dez por cento o valor do aluguel, assim
		* é apenas questão de multiplicar a quantidade de DVDs atrasados pelo seu preço
		*/
		
		System.out.printf("O faturamento anual da locadora eh: R$%.2f\nO lucro ganho por mes pelas multas eh: R$%.2f\n", faturamentoAnual, lucroMultas);
	}
}
