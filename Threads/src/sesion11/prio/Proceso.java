
package sesion11.prio;

public class Proceso implements Runnable {
    
    private int contar;
    Thread hilo;
    static boolean stop = false;
    static String actualNombre;

    public Proceso(String nombre) {
        hilo = new Thread(this, nombre);
        contar = 0;
        actualNombre=nombre;
    }

    @Override
    public void run(){
        System.out.println(hilo.getName()+" iniciando.");
        do{
            contar++;
            if(actualNombre.compareTo(hilo.getName())!=0){
                actualNombre=hilo.getName();
                System.out.println("En "+actualNombre);
            }
        }while(!stop && contar < 10000000);
        stop = true;
        System.out.println("\n"+hilo.getName()+" terminado.");
    }
    
    public int getContar(){
        return contar;
    }
    
}
