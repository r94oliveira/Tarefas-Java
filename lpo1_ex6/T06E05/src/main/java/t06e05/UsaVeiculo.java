package t06e05;
import java.util.*;

public class UsaVeiculo {
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Veiculo[] listaVeiculos;
        String tipoVeiculo, marca, modelo, cor, porte, placa, classe, msgCaixaPreta;
        int qtdVeiculos, qtdRoda, qtdPorta, qtdVagao, qtdTurbina, qtdHelice, qtdBote;
        float velocidade, tamanhoAsas;
        boolean temLeme, temVela, estaSubmerso;

        System.out.println("Digite quantos veículos deseja criar: ");
        qtdVeiculos = sc.nextInt();
        clearBuffer(sc);
        
        listaVeiculos = new Veiculo[qtdVeiculos];
        
        for (int i = 0; i < qtdVeiculos; i++) {
            System.out.println("\n\nQual tipo de veículo deseja criar? Temos Carro, Trem, Avião e Barco: ");
            tipoVeiculo = sc.nextLine();
            
            tipoVeiculo.toLowerCase();
            
            if (tipoVeiculo.equals("carro") || 
                tipoVeiculo.equals("trem")  || 
                tipoVeiculo.equals("aviao") || 
                tipoVeiculo.equals("barco")) {
                System.out.println("Digite a marca do " + tipoVeiculo + ": ");
                marca = sc.nextLine();

                System.out.println("Digite o modelo do " + tipoVeiculo + ": ");
                modelo = sc.nextLine();

                System.out.println("Digite a cor do " + tipoVeiculo + ": ");
                cor = sc.nextLine();

                System.out.println("Digite o porte do " + tipoVeiculo + " (pequeno/médio/grande): ");
                porte = sc.nextLine();

                System.out.println("Digite a velocidade atual do " + tipoVeiculo + ": ");
                velocidade = sc.nextFloat();
                
                switch(tipoVeiculo) {
                    case "carro":
                        clearBuffer(sc);
                        System.out.println("Digite a placa do carro: ");
                        placa = sc.nextLine();

                        System.out.println("Digite a quantidade de rodas do carro: ");
                        qtdRoda = sc.nextInt();

                        System.out.println("Digite a quantidade de portas do carro: ");
                        qtdPorta = sc.nextInt();
                        clearBuffer(sc);
                        
                        listaVeiculos[i] = new Carro(marca, 
                                                     modelo,
                                                     cor, 
                                                     porte, 
                                                     velocidade, 
                                                     placa, 
                                                     qtdRoda, 
                                                     qtdPorta
                                                );

                        break;
                    case "trem":
                        clearBuffer(sc);
                        System.out.println("Digite a placa do trem: ");
                        placa = sc.nextLine();

                        System.out.println("Digite a quantidade de rodas do trem: ");
                        qtdRoda = sc.nextInt();
                        clearBuffer(sc);

                        System.out.println("Digite a quantidade de vagões do trem: ");
                        qtdVagao = sc.nextInt();
                        clearBuffer(sc);

                        listaVeiculos[i] = new Trem(marca, 
                                                    modelo,
                                                    cor, 
                                                    porte, 
                                                    velocidade, 
                                                    placa, 
                                                    qtdRoda,
                                                    qtdVagao
                                                );

                        break;
                    case "aviao":
                        clearBuffer(sc);
                        System.out.println("Digite a classe do avião (primeira/econômica/executiva): ");
                        classe = sc.nextLine();

                        System.out.println("Digite a quantidade de turbinas do avião: ");
                        qtdTurbina = sc.nextInt();
                        clearBuffer(sc);
                        
                        System.out.println("Digite a quantidade de hélices do avião: ");
                        qtdHelice = sc.nextInt();
                        clearBuffer(sc);
                        
                        System.out.println("Digite a mensagem contida na caixa preta do avião): ");
                        msgCaixaPreta = sc.nextLine();

                        System.out.println("Digite o tamanho da asa do avião: ");
                        tamanhoAsas = sc.nextFloat();
                        clearBuffer(sc);
                        
                        listaVeiculos[i] = new Aviao(marca, 
                                                     modelo,
                                                     cor, 
                                                     porte, 
                                                     velocidade,
                                                     classe, 
                                                     qtdTurbina, 
                                                     qtdHelice, 
                                                     msgCaixaPreta, 
                                                     tamanhoAsas
                                                );

                        break;
                    case "barco":
                        clearBuffer(sc);
                        System.out.println("Digite se o barco tem leme: ");
                        temLeme = sc.nextBoolean();
                        clearBuffer(sc);
                        
                        System.out.println("Digite se o barco tem vela: ");
                        temVela = sc.nextBoolean();
                        clearBuffer(sc);

                        System.out.println("Digite se o barco está submerso: ");
                        estaSubmerso = sc.nextBoolean();
                        clearBuffer(sc);

                        System.out.println("Digite a quantidade de botes no barco: ");
                        qtdBote = sc.nextInt();
                        clearBuffer(sc);

                        listaVeiculos[i] = new Barco(marca, 
                                                     modelo,
                                                     cor, 
                                                     porte, 
                                                     velocidade, 
                                                     temLeme, 
                                                     temVela,
                                                     estaSubmerso, 
                                                     qtdBote
                                                );

                        break;
                }
            } else {
                System.out.println("ERRO! Verifique o veículo digitado e não coloque acentos!");
            }
        }
        
        for (int i = 0; i < qtdVeiculos; i++) {
            listaVeiculos[i].andar();
        }
    }
    
}
