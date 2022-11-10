package t07e01;

public class UsaBicicleta {

    public static void main(String[] args) {
        try {
            Bicicleta bc = new Bicicleta(-1, 101, 25);
        } catch(RPMNegativoException exRPM) {
            System.out.println("\nExceção: \n" + exRPM);
        } catch(VelocidadeException exVelocidade) {
            System.out.println("\nExceção: \n" + exVelocidade);
        } catch(MarchaException exMarcha) {
            System.out.println("\nExceção: \n" + exMarcha);
        }
    }
    
}
