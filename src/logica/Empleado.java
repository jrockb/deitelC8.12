package logica;

/**
 *
 * @author jcd
 */
public class Empleado {
    
    private final String primerNombre; // las variables de instancia finales pueden inicializarse en un constructor
    private final String apellidoPaterno;
    private static int cuenta = 0; // número de objetos en memoría
    
    // inicializar empleado, sumar 1 a la cuenta estática y mostrar String
    // indicando que se llamó al constructor
    public Empleado(String nombre, String apellido){
        this.primerNombre = nombre;
        this.apellidoPaterno = apellido;
        ++cuenta; // incrementar cuenta estática de empleados
        System.out.println("Constructor de empleado: "+ primerNombre 
                + " "+ apellidoPaterno);
    }
    
    // restar 1 de la cuenta estática cuando el recolector de basura llama a
    // finalize para limpiar el objeto y mostrar String indicando que se llamó
    // a finalize
    @Override
    protected void finalize(){
        --cuenta; // decrementar cuenta estática de empleados
        System.out.println("Finalizador de empleado: "+ primerNombre +" "
                + apellidoPaterno + "; cuenta = "+ cuenta );
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    
    // método estático para obtener el valor de la cuenta estática
    public static int obtenerCuenta(){
        return cuenta;
    }
    
    
}
