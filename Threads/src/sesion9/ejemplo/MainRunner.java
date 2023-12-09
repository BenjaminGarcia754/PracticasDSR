/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesion9.ejemplo;

/**
 *
 * @author sauld
 */
public class MainRunner {
    
    public static void main(String[] args) throws InterruptedException {
        Runner corredor1 = new Runner('+');
        Runner corredor2 = new Runner('*');
        Runner corredor3 = new Runner('$');
        
        Thread p1 = new Thread(corredor1);
        Thread p2 = new Thread(corredor2);
        Thread p3 = new Thread(corredor3);
        
        /**
        p1.start();
        p2.start();
        p3.start();
        * **/
        
        
        //p3.setPriority(10);
        
        p1.start();
        p1.join();
        p2.start();
        p2.join();
        p3.start();
        p3.join();
        
    }
    
}
