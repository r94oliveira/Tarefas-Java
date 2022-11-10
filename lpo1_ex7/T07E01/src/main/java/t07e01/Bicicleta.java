package t07e01;

class Bicicleta {
    private int RPM = 0;
    private int velocidade = 0;
    private int marcha = 1;
    
    public Bicicleta(int RPM, int velocidade, int marcha) 
                     throws RPMNegativoException, VelocidadeException, MarchaException {
        setRPM(RPM);
        setVelocidade(velocidade);
        setMarcha(marcha);
    }
    
    public void setRPM(int novoValor) throws RPMNegativoException {
        if (novoValor >= 0) {
            RPM = novoValor;
        } else {
            throw new RPMNegativoException();
        }
    }
    
    public void setVelocidade(int novoValor) throws VelocidadeException {
        if (novoValor >= 0 && novoValor <= 100) {
            velocidade = novoValor;
        } else {
            throw new VelocidadeException();
        }
    }
    
    public void setMarcha(int novoValor) throws MarchaException {
        if (novoValor >= 0 && novoValor <= 24) {
            marcha = novoValor;
        } else {
            throw new MarchaException();
        }
    }
    
    public void aumentarVelocidade(int incremento){
        velocidade = velocidade + incremento;
    }
    
    public void aplicarFreios(int decremento){
        velocidade = velocidade - decremento;
    }
    
    public void printStates(){
        System.out.printf("\nCadencia: %d, Velocidade: %d, Marcha = %d\n", RPM, velocidade, marcha);
    }
}
