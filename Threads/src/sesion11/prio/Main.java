
package sesion11.prio;


public class Main {
    
    public static void main(String[] args) {
        Proceso p1 = new Proceso("Prioridad Alta");
        Proceso p2 = new Proceso("Prioridad Baja");
        Proceso p3 = new Proceso("Prioridad Normal#1");
        Proceso p4 = new Proceso("Prioridad Normal#2");
        Proceso p5 = new Proceso("Prioridad Normal#3");
        
        p1.hilo.setPriority(Thread.MAX_PRIORITY);
        p2.hilo.setPriority(Thread.MIN_PRIORITY);
        
        p1.hilo.start();
        p2.hilo.start();
        p3.hilo.start();
        p4.hilo.start();
        p5.hilo.start();
        try{
            p1.hilo.join();
            p2.hilo.join();
            p3.hilo.join();
            p4.hilo.join();
            p5.hilo.join();
        }catch(InterruptedException e){}
        
        System.out.println("\nHilo de alta prioridad contó hasta "+p1.getContar());
        System.out.println("Hilo de baja prioridad contó hasta "+p2.getContar());
        System.out.println("Hilo de normal prioridad #1 contó hasta "+p3.getContar());
        System.out.println("Hilo de normal prioridad #2 contó hasta "+p4.getContar());
        System.out.println("Hilo de normal prioridad #3 contó hasta "+p5.getContar());
    }
    
}
