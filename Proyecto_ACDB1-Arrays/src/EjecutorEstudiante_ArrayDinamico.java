
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Asignatura {

    public String nombreAsignatura;
    public double nota1;
    public double nota2;
    public double promedio;
    public double suple;
    public boolean estado;

    public Asignatura(String nombreAsignatura, double nota1, double nota2) {
        this.nombreAsignatura = nombreAsignatura;
        this.nota1 = nota1;
        this.nota2 = nota2;
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

    public void calcularPromedio() {
        this.promedio = (this.nota1 + this.nota2) / 2;
    }

    public void determinarEstado(double nota) {
        this.estado = (nota > 7) ? true : false;
    }

    @Override
    public String toString() {
        return String.format("\nAsignatura{nombreAsignatura = %s, nota1 = %.2f, nota2 = %.2f, "
                + "promedio = %.2f, suple = %.2f, estado = %s}\n",
                this.nombreAsignatura, this.nota1, this.nota2,
                this.promedio, this.suple, this.estado);
    }
}

class Estudiante {

    public String nombreEst;
    //public Asignatura asignaturas[];         //ARREGLO ESTATICO DE TIPOS POR REFERENCIA = OBJS
    public ArrayList<Asignatura> asignaturas;  //ARREGLO DINAMICOS 

    public Estudiante(String nombreEst, ArrayList<Asignatura> asignaturas) {
        this.nombreEst = nombreEst;
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", asignaturas=" + asignaturas + '}';
    }
}

public class EjecutorEstudiante_ArrayDinamico {

    public static void main(String[] args) {
        Random ale = new Random();
        int cantAsig = ale.nextInt(6) + 1;
        String nombAsig[] = {"POO", "EstDat", "Mate", "Estadis", "Algebra", "DB"};
        ArrayList<Asignatura> asignaturas = new ArrayList();
        
        //GENERACION DE DATOS DE ENTRADA
        for (int i = 0; i < cantAsig; i++) {
            String nombreAsignatura = nombAsig[i];
            double notas1 = ale.nextDouble(10);
            double notas2 = ale.nextDouble(10);
            asignaturas.add(new Asignatura(nombreAsignatura, notas1, notas2));
        }
        Estudiante est1 = new Estudiante("Junior", asignaturas);
        
        System.out.println("******** DATOS DE ENTRADA GENERADOS ********");
        System.out.println(est1);
        //PROCESAMIENTO DE LOS DATOS
        for (int i = 0; i < asignaturas.size(); i++) {
            est1.asignaturas.get(i).calcularPromedio();
            est1.asignaturas.get(i).determinarEstado(est1.asignaturas.get(i).getPromedio());
            if (!est1.asignaturas.get(i).isEstado()){
                est1.asignaturas.get(i).setSuple(ale.nextDouble(10));
                est1.asignaturas.get(i).determinarEstado(est1.asignaturas.get(i).getSuple());
            }
        }
        System.out.println("******** DATOS SALIDA / RESULTADOS ********");
        System.out.println(est1);
        
        System.out.println("******** CUANTAS Y CUALES SON LAS MATERIAS APROBADAS ********");
        int cantApro = 0;
        for (int i = 0; i < asignaturas.size(); i++) {
            if (est1.asignaturas.get(i).isEstado()){
                cantApro++;
                System.out.println(est1.asignaturas.get(i).nombreAsignatura);
            }
        }
        System.out.println("Cantidad de aprobadas: " + cantApro);
    }
}
