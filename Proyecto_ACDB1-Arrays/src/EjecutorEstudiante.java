import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Asignatura{
    public String nombreAsignatura;  
    public double nota1;  
    public double nota2;
    public double promedio;  
    public double suple;  
    public boolean estado;
    public Asignatura(String nombreAsignatura, double nota1, double nota2) {
        this.nombreAsignatura = nombreAsignatura; this.nota1 = nota1; this.nota2 = nota2; 
    }
    public void setSuple(double suple) {
        this.suple = suple;    
    }

    public double getSuple() {
        return suple;
    }
    
    public double getPromedio() {
        return promedio;
    }
    public boolean isEstado() {
        return estado;    
    }
    public void calcularPromedio(){
        this.promedio = (this.nota1 + this.nota2) /2; 
    }
    public void determinarEstado(double nota){
        this.estado = (nota>7) ? true : false ; 
    }
    @Override
    public String toString() {
        return String.format("Asignatura{nombreAsignatura = %s, nota1 = %.2f, nota2 = %.2f, "
                           + "promedio = %.2f, suple = %.2f, estado = %s}", 
                            this.nombreAsignatura, this.nota1, this.nota2, 
                            this.promedio, this.suple, this.estado); 
    }    
}
class Estudiante{
    public String nombreEst;
    public Asignatura asignaturas[];
    public Estudiante(String nombreEst, Asignatura[] asignaturas) {
        this.nombreEst = nombreEst;
        this.asignaturas = asignaturas;
    }
    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", asignaturas=" + Arrays.toString(asignaturas) + '}';
    }
}
public class EjecutorEstudiante {
    public static void main(String[] args) {
        Random ale = new Random();
        Scanner tcl = new Scanner(System.in);
        String nombreEst = "Jorge";
        //SINTAXIS DE ARREGLO DE OBJETOS:
        //TIPO_DATO nombArr [ ] = new TIPO_DATO[tamanioArreglo]; ejemplo:
        //Asignatura asignaturas[] = new Asignatura[2];
        //TIPO_DATO nombArr [ ] = {new TIPO_DATO(), new TIPO_DATO(), .., ..};
        Asignatura asignaturas[] = { new Asignatura( "POO",      ale.nextDouble(10), ale.nextDouble(10) ), 
                                     new Asignatura( "Est.Dist", ale.nextDouble(10), ale.nextDouble(10) )}; 
        Estudiante est1 = new Estudiante(nombreEst, asignaturas);
        System.out.println("Est1: " + est1);
        for (Asignatura asignatura : asignaturas)
        {
            asignatura.calcularPromedio();
            asignatura.determinarEstado(asignatura.getPromedio());
            if(!asignatura.isEstado())
            {
                asignatura.setSuple(ale.nextDouble(10));
                asignatura.determinarEstado(asignatura.getSuple());
                       
            }
        }
        System.out.println("Est1: " + est1);
    }
}
