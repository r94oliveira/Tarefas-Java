package lpoo2_t5_1;

public class UsaBicicleta {
    public static void main(String args[]){
        
        Bicicleta caloi = new Bicicleta(){
            @Override
            public void aplicarFreios(int decremento){
                velocidade -= 2 * decremento;
            }
        };
        
        caloi.aumentarVelocidade(10);
        caloi.printStates();
        
        caloi.aplicarFreios(5);
        caloi.printStates();
    }
   
}
