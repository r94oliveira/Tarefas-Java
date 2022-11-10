package t06e03;

public abstract class C {
    private String atributo1;
    private float atributo2;
    
    public C() {
        atributo1 = "VAZIO";
        atributo2 = -999.99f;
    }
    
    public C(String p1, float p2) {
        atributo1 = p1;
        atributo2 = p2;
    }
    
    public String getAtributo1() { return this.atributo1; }
    
    public float getAtributo2() { return this.atributo2; }
}
