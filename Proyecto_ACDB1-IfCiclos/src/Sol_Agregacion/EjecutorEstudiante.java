package Sol_Agregacion;

import java.util.Random;
import java.util.Scanner;

class Asignatura{
    public String nombreAsignatura;  public double nota1;  public double nota2;
    public double promedio;  public double suple;  public boolean estado;
    public Asignatura(String nombreAsignatura, double nota1, double nota2) {
        this.nombreAsignatura = nombreAsignatura; this.nota1 = nota1; this.nota2 = nota2; }
    public void setSuple(double suple) {
        this.suple = suple;    }
    public boolean isEstado() {
        return estado;    }
    public void calcularPromedio(){
        this.promedio = (this.nota1 + this.nota2) /2; }
    public void determinarEstado(double nota){
        this.estado = (nota>7) ? true : false ; }
    @Override
    public String toString() {
        return String.format("Asignatura{nombreAsignatura=%s, nota1=%.2f, nota2=%.2f, "
                           + "promedio=%.2f, suple=%.2f, estado=%s}", 
                            this.nombreAsignatura, this.nota1, this.nota2, 
                            this.promedio, this.suple, this.estado); }    
}
class Estudiante{
    public String nombreEst;
    public Asignatura asignatura;
    public Estudiante(String nombreEst, Asignatura asignatura) {
        this.nombreEst = nombreEst;
        this.asignatura = asignatura; }
    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", asignatura=" + asignatura + '}'; }
}
public class EjecutorEstudiante {
    public static void main(String[] args) {
        Random ale = new Random();
        Scanner tcl = new Scanner(System.in);
        String nombreAsignatura, nombreEst;
        double nota1, nota2, suple;
        while(true){
            System.out.print("Nomb.Asig: ");
            nombreAsignatura = tcl.nextLine();
            nota1 = ale.nextDouble(10);
            nota2 = ale.nextDouble(10);
            Asignatura asignatura = new Asignatura(nombreAsignatura, nota1, nota2);
            System.out.print("Nomb.Est: ");
            nombreEst = tcl.nextLine();
            Estudiante est1 = new Estudiante(nombreEst, asignatura);
            asignatura.calcularPromedio();
            asignatura.determinarEstado(est1.asignatura.promedio);
            System.out.println(est1);
            if (!est1.asignatura.isEstado()) {
                suple = ale.nextDouble(10);
                est1.asignatura.setSuple(suple);
                est1.asignatura.determinarEstado(suple);
                System.out.println(est1);
            }
        }
    }
}
