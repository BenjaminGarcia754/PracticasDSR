
package sesion12.group;

import java.io.IOException;


public class DemoGroup  implements Runnable{
    
    public void run(){
        while(true){
            Thread.yield();
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        ThreadGroup padre = new ThreadGroup("PADRE");
        
        ThreadGroup subgrupo = new ThreadGroup(padre, "SUBGRUPO");
        
        Thread t1 = new Thread(padre, new DemoGroup());
        Thread t2 = new Thread(padre, new DemoGroup());
        Thread t3 = new Thread(subgrupo, new DemoGroup());
        
        t1.start();
        t2.start();
        t3.start();
        
        padre.list();
        
        System.out.println("Listado del subgrupo");
        subgrupo.list();
        
        System.out.println("Presione enter para continuar");
        System.in.read();
        System.exit(0);
        
        
        
    }
    
}
