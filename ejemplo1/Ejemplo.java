
/**
 * Main
 */
public class Ejemplo {
    public Ejemplo() {
        // MOSTRAMOS LOS DATOS DEL THREAD MAIN
        System.out.println("Main");
        
        System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Nombre: " + Thread.currentThread().getName());
        System.out.println("Prioridad: " + Thread.currentThread().getPriority());
        System.out.println("Estado: " + Thread.currentThread().getState());  
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("  ");
        // MOSTRAMOS LOS DATOS DEL THREAD Proc1
        System.out.println("Proc1");
        
        Proceso proc1 = new Proceso();
        proc1.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("  ");
        // MOSTRAMOS LOS DATOS DEL THREAD Proc2
        System.out.println("Proc2");

        Proceso proc2 = new Proceso("Proceso con nombre");
        proc2.start();
    }
    public static void main(String[] args) {
        Ejemplo v = new Ejemplo();
    }
}

class Proceso extends Thread {

    public Proceso() {
        super();
    }

    public Proceso(String nombre) {
        super(nombre);
    }

    public void run() {

        System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Nombre: " + Thread.currentThread().getName());
        System.out.println("Prioridad: " + Thread.currentThread().getPriority());
        System.out.println("Estado: " + Thread.currentThread().getState());
        try {

            sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}