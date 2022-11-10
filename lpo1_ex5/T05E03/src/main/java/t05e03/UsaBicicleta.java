package t05e03;

public class UsaBicicleta {

    public static void main(String[] args) {
        Bicicleta bc = new Bicicleta(3);
        
        bc.aumentarVelocidade(4);
        bc.mudarCadencia(4);
        bc.mudarMarcha(3);
        bc.printStates();
        
        bc.mudarMarcha(4);
        bc.printStates();
    }
    
}
