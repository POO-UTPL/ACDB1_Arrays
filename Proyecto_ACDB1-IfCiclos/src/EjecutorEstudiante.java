import java.util.Random;
import java.util.Scanner;
class Estudiante{
    public String nombre;
    public double nota1;
    public double nota2;
    public double promedio;
    public double suple; //sobre 10pts.
    public boolean estado;
    public Estudiante(String nombre, double nota1, double nota2) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;  
    }
    public void calcularPromedio(){
        this.promedio = (this.nota1 + this.nota2) / 2;    
    }
    public void determinarEstado(double nota){
        this.estado = (nota > 7) ? true : false ;    
    }
    public double getPromedio() {
        return promedio;
    }
    public void setSuple(double suple) {
        this.suple = suple;
    }
    public boolean isEstado() {
        return estado;
    }
    @Override
    public String toString() {
        return String.format("Estudiante{nombre=%s, nota1=%.2f, nota2=%.2f, promedio=%.2f, suple=%.2f, estado=%s}",
                              nombre, nota1, nota2, promedio, suple, estado
    );
}
}
public class EjecutorEstudiante {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Random ale = new Random();
        String nombre; 
        double nota1, nota2, suple;
        while(true) {
            System.out.print("Nombre Est: ");
            nombre = tcl.nextLine();
            nota1 = ale.nextDouble(10);
            nota2 = ale.nextDouble(10);
            Estudiante est1 = new Estudiante(nombre, nota1, nota2);
            est1.calcularPromedio();
            est1.determinarEstado(est1.getPromedio());
            if (!est1.isEstado()){
                suple = ale.nextDouble(10);
                est1.setSuple(suple);
                est1.determinarEstado(suple);
            }
            System.out.println(est1);
        }
    }
}
