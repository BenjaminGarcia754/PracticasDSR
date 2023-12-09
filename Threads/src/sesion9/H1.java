/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesion9;

/**
 *
 * @author sauld
 */
public class H1 implements Runnable{
    
    @Override
    public void run(){
        System.out.println(
                Thread.currentThread().getName()+
                " subproceso corriendo...");
    }
    
    public static void main(String[] args) {
        Thread miH = new Thread(new H1(), "Hilo1");
        miH.start();
        
        
    }
    
}
