
import java.util.ArrayList;
import java.util.Arrays;

class Producto {

    public String nombPrd;
    public double precio;
    public int cantidad;

    public Producto(String nombPrd, double precio, int cantidad) {
        this.nombPrd = nombPrd;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String nombPrd, int cantidad) {
        this.nombPrd = nombPrd;
        this.cantidad = cantidad;
    }

    public Producto() {
    }
    
    public String getNombPrd() {
        return nombPrd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombPrd=" + nombPrd + ", precio=" + precio + ", cantidad=" + cantidad + "}\n";
    }
}

class Carrito {

    public ArrayList<Producto> productosStop;
    public ArrayList<Producto> productosCarrito;
    public double descuento, total;

    public Carrito(ArrayList<Producto> productosStop, double descuento) {
        this.productosStop = productosStop;
        this.descuento = descuento;
        productosCarrito = new ArrayList();
    }
    
    public String agregarProducto(Producto producto) {
        boolean existeProd = false, cantSufi = false;
        String msj = producto.nombPrd + " no se agrego xq no existe!!!";
        //Verifica si existe el producto y si hay cantidad suficiente
        for (int i = 0; i < productosStop.size(); i++) {
            if (this.productosStop.get(i).getNombPrd().equals(producto.nombPrd)){
                existeProd = true;
                cantSufi = (this.productosStop.get(i).getCantidad() >= producto.cantidad);
                break;
            }
        }
        if (existeProd && cantSufi){
            productosCarrito.add(producto);
            msj = producto.nombPrd + " se agrego al carrito!!!";
        }
        return msj;
    }

    public double calcularTotal() {
        for (int i = 0; i < productosCarrito.size(); i++) 
            this.total += (this.productosStop.get(i).getPrecio() * this.productosCarrito.get(i).getCantidad());
        return this.total;
    }

    public String realizarPago(double dinero) {
        String msj = "Compra exitosa. ";
        if (dinero >= this.total) {
           for (int i = 0; i < productosCarrito.size(); i++) {
               for (int j = 0; j < productosStop.size(); j++) {
                   if(this.productosStop.get(j).getNombPrd().equals(this.productosCarrito.get(i).getNombPrd())){
                       this.productosStop.get(j).setCantidad(this.productosStop.get(j).getCantidad() - this.productosCarrito.get(i).getCantidad()); 
                       break;
                   }
               }
           }
           if(this.total > 1000){
               msj += "Descuento: " + (this.total * (this.descuento / 100) );
               total -= (this.total * (this.descuento / 100) );
           }
           msj += ". Factura total: " + total;
        }
        else
            msj = "Dinero insuficiente!!!";
        return msj;
    }
    
    @Override
    public String toString() {
        return "Carrito{" + "productosStop=" + productosStop + ", productosCarrito=" + productosCarrito + ", descuento=" + descuento + ", total=" + total + '}';
    }
}

public class Problema_1_Carrito_pdirene {
    public static void main(String[] args) {
        ArrayList<Producto> productosStop = new ArrayList<>(Arrays.asList(
                                                               new Producto("iPhone18", 1500, 3),
                                                               new Producto("iPad", 1200, 5),
                                                               new Producto("Audifono", 200, 14)
                                                           ));
        Carrito carrito1 = new Carrito(productosStop, 10);
        System.out.println("************ STOP ************");
        System.out.println(carrito1.productosStop);
        
        System.out.println("************ CARRITO CON PRODUCTOS ************");
        System.out.println("Agregar producto: " + carrito1.agregarProducto(new Producto("iPhone18", 2)));
        System.out.println(carrito1.productosCarrito);
        System.out.println("Agregar producto: " + carrito1.agregarProducto(new Producto("Lapiz", 2)));
        System.out.println("Total compra: "+ carrito1.calcularTotal());
        System.out.println(carrito1.realizarPago(3000));
    }
}
