
package dsrArchivos;

import java.io.File;
import java.util.Date;


public class Demo {
    
    public static void main(String[] args) {
        File directorio = new File("C:/workspace/datos");
        if(directorio.isDirectory()){
            File[] misArchivos = directorio.listFiles();
            int numeroArchivos = misArchivos.length;
            
            System.out.println("En el directorio "+
                    directorio.getName()+ " hay "+
                    numeroArchivos+" archivos");
            
            for(File archivo : misArchivos){
                Date fechamodif = new Date(archivo.lastModified());
                System.out.println("\nNombre: "+archivo.getName());
                System.out.println("Ruta absoluta: "+archivo.getAbsolutePath());
                System.out.println("Fecha modif: "+fechamodif);
                System.out.println("Tamaño: "+archivo.length()+ "bytes");
            }
        }
    }
    
}
