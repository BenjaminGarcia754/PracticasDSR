package sesion9.ejemplo;

/**
 *
 * @author sauld
 */
public class Runner implements Runnable{
    
    private String avance;
    private long latencia;
    private char c;

    public Runner(char c) {
        this.avance = "";
        this.latencia = (long) (Math.random()*100+50);
        this.c = c;
    }
    
    

    @Override
    public void run() {
        for(int i = 0; i < 70; i++){
            avance = avance + c;
            System.out.println(avance);
            try {
                Thread.sleep(latencia);
            } catch (InterruptedException ex) { }
        }
        avance = avance + " terminé!!! ";
        System.out.println(avance);
    }
    
    
    
    
}
