import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
class Asignatura{
    public String nombreAsignatura;    public double nota1;     public double nota2;
    public double promedio;            public double suple;     public boolean estado;
    public Asignatura(String nombreAsignatura, double nota1, double nota2) {
        this.nombreAsignatura = nombreAsignatura; this.nota1 = nota1; this.nota2 = nota2;  }
    public void setSuple(double suple) {
        this.suple = suple;            }
    public double getSuple() {
        return suple;        }
    public double getPromedio() {
        return promedio;        }
    public boolean isEstado() {
        return estado;        }
    public void calcularPromedio(){
        this.promedio = (this.nota1 + this.nota2) /2;     }
    public void determinarEstado(double nota){
        this.estado = (nota>7) ? true : false ;           }
    @Override
    public String toString() {
        return String.format("Asignatura{nombreAsignatura = %s, nota1 = %.2f, nota2 = %.2f, "
                           + "promedio = %.2f, suple = %.2f, estado = %s}", 
                            this.nombreAsignatura, this.nota1, this.nota2, 
                            this.promedio, this.suple, this.estado);      }    
}
class Estudiante{
    public String nombreEst;
    //public Asignatura asignaturas[];         //ARREGLO ESTATICO DE TIPOS POR REFERENCIA = OBJS
    public ArrayList<Asignatura> asignaturas;  //ARREGLO DINAMICOS 
    public Estudiante(String nombreEst, ArrayList<Asignatura> asignaturas) {
        this.nombreEst = nombreEst;
        this.asignaturas = asignaturas;}
    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", asignaturas=" + asignaturas + '}';}
}
public class EjecutorEstudiante_ArregloDINAMICOS {
    public static void main(String[] args) {
        
    }
}
