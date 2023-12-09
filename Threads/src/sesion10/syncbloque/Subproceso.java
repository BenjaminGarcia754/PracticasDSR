
package sesion10.syncbloque;


public class Subproceso implements Runnable {
    
    public void run(){
        
        System.out.println("Pulse \"enter\" para detener la espera de "
                +Thread.currentThread().getName());
        try{
           System.in.read();
        }catch(java.io.IOException e){}
        
        synchronized (this) {
            this.notifyAll();
        }
        
    }
    
}
