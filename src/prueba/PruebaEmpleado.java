package prueba;

import javax.swing.JOptionPane;
import logica.Empleado;

/**
 *
 * @author jcd
 */
public class PruebaEmpleado {
    
    public static void main(String[] args) {
        // demostrar que cuenta es 0 antes de crear Empleados
        String salida = "Empleados antes de instanciar: "
                + Empleado.obtenerCuenta();
        // crear dos empleados; la cuenta debe ser 2
        Empleado e1 = new Empleado("Maria", "Flores");
        Empleado e2 = new Empleado("Juan", "Perez");
        // demostrar que la cuenta es 2 despues de crear dos empleados
        salida += "\nEmpleados despues de instanciar: "
                + "\nvia e1.obtenerCuenta() "+ e1.obtenerCuenta()
                + "\nvia e2.obtenerCuenta() "+ e2.obtenerCuenta()
                + "\nvia Empleado.obtenerCuenta() "+ Empleado.obtenerCuenta();
        // obtener nombres de Empleados
        salida += "\n\nEmpleado1: "+e1.getPrimerNombre()+" "+ e1.getApellidoPaterno()
                +"\nEmpleado2: "+e2.getPrimerNombre()+" "+e2.getApellidoPaterno();
        // decrementar la cuenta de referencia para cada objeto Empleado; en este
        // ejemplo, hay solo una referencia a cada Empleado, por lo que estas 
        // instrucciones marcan a objeto Empleado para la recolección de basura
        e1 = null;
        e2 = null;
        
        System.gc(); // sugerir una llamada al recolector de basura
        
        // mostrar cuenta de objetos Empleado después de llamar al recolector
        // basura; la cuenta mostrada puede ser 0, 1 o 2 dependiendo de si el 
        // recolector de basura se ejecuta o no y del número de objetos Empleado
        // recolectados
        salida += "\n\nEmpleados después de System.gc(): "+Empleado.obtenerCuenta();
        
        JOptionPane.showMessageDialog(null, salida, "Miembros estáticos", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
