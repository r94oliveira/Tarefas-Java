package t06e03;

public class C1_2 extends C implements I1, I2 {
    private float[][] atributo3;
    
    public C1_2() {
        super();
        atributo3 = new float[2][2];
        
        for(int i = 0; i < atributo3.length; i++) {
            for(int j = 0; j < atributo3[i].length; j++) {
                atributo3[i][j] = 0;
            }
        }
    }
    
    public C1_2(String atributo1, float atributo2) {
        super(atributo1, atributo2);
        atributo3 = new float[3][3];
        
        for(int i = 0; i < atributo3.length; i++) {
            for(int j = 0; j < atributo3[i].length; j++) {
                atributo3[i][j] = 1;
            }
        }
    }
    
    public void operacao1() {
        System.out.printf("\nPassei pelo método Operação1!");
        System.out.printf("\nAtributo 1: %s", super.getAtributo1());
        System.out.printf("\nAtributo 2: %.2f", super.getAtributo2());
        
        for(int i = 0; i < atributo3.length; i++) {
            for(int j = 0; j < atributo3[i].length; j++) {
                System.out.printf("\nAtributo 3[%d][%d]: %.2f", i + 1, j + 1, atributo3[i][j]);
            }
        }
    }
    
    public void operacao2() {
        System.out.println("\nPassei pelo método Operação2!");
    }
}
