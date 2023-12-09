
package sesion9;

/**
 *
 * @author sauld
 */
public class H2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Subproceso H2 esta corriendo...");
    }
    
    public static void main(String[] args) {
        H2 h2 = new H2();
        h2.run();
        
        Thread t = new Thread(h2);
        t.start();
    }
    
}
