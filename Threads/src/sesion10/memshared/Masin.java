package sesion10.memshared;


public class Masin {
    
    public static void main(String[] args) {
        Cajero cajero = new Cajero();
    
        Thread us1 = new Thread(cajero,"Felipe");
        Thread us2 = new Thread(cajero,"Pedro");
    
        us1.start();
        us2.start();
    }
}
