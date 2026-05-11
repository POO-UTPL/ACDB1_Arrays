import java.util.ArrayList;
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
        this.nombreAsignatura = nombreAsignatura; this.nota1 = nota1; this.nota2 = nota2;     }
    public void setSuple(double suple) {
        this.suple = suple;            }
    public double getSuple() {
        return suple;        }
    public double getPromedio() {
        return promedio;        }
    public boolean isEstado() {
        return estado;        }
    public void calcularPromedio(){
        this.promedio = (this.nota1 + this.nota2) /2;  }
    public void determinarEstado(double nota){
        this.estado = (nota>7) ? true : false ;   }
    @Override
    public String toString() {
        return String.format("Asignatura{nombreAsignatura = %s, nota1 = %.2f, nota2 = %.2f, "
                           + "promedio = %.2f, suple = %.2f, estado = %s} \n", 
                            this.nombreAsignatura, this.nota1, this.nota2, 
                            this.promedio, this.suple, this.estado);    }    
}
class Estudiante{
    public String nombreEst;
    public ArrayList<Asignatura> asignaturas;
    public Estudiante(String nombreEst, ArrayList<Asignatura> asignaturas) {
        this.nombreEst = nombreEst;
        this.asignaturas = asignaturas;                                    }
    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", asignaturas=" + asignaturas + '}';     }
}
public class EjecutorEstudiante_ArregloDinamico {
    public static void main(String[] args) {
        Random ale = new Random();
        ArrayList<Asignatura> asignaturas = new ArrayList();
        String nombAsig [] = {"POO", "EstDatos", "Mate", "DB", "Algeb", "Estatis"};
        int numAsigAle = ale.nextInt(3) + 1, cont = 0;
        
        while(cont < numAsigAle) {
            String nombreAsignatura = nombAsig[cont];
            double nota1 = ale.nextDouble(10);
            double nota2 = ale.nextDouble(10);
            asignaturas.add(new Asignatura(nombreAsignatura, nota1, nota2));
            asignaturas.get(cont).calcularPromedio();
            asignaturas.get(cont).determinarEstado(asignaturas.get(cont).getPromedio());
            if (!asignaturas.get(cont).isEstado()){
                asignaturas.get(cont).setSuple(ale.nextDouble(10));
                asignaturas.get(cont).determinarEstado(asignaturas.get(cont).getSuple());
            }
            cont++;
        }
        System.out.println(asignaturas);
        
    }
}
