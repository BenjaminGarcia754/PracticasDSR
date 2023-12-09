
package sesion10.memshared;

public class Cajero implements Runnable{
    
    Cuenta cta;
    
    public Cajero(){
        cta = new Cuenta();
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            retirarDinero(10);
            if(cta.getSaldoActual()<0){
                System.out.println("Su cuenta tiene saldo negativo");
            }
            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){}
        }
    }
    
    private synchronized void retirarDinero(int valorRetiro){
        if(cta.getSaldoActual()>=valorRetiro){
        System.out.println("Saldo actual: "+cta.getSaldoActual());
        System.out.println("El usuario "+Thread.currentThread().getName()+
                " está retirando $"+valorRetiro);
        cta.retiroCuenta(valorRetiro);
        System.out.println("Retiro exitoso!");
        System.out.println("El nuevo saldo es: $"+cta.getSaldoActual());
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
    
    
    
}
