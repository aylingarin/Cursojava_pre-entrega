public class Pedido{
    private static int contador = 1;
    private int idPedido;
    private ArrayList<LineaPedido> lineas;
     
    public Pedido(){
        this.idPedido = contador++;
        this.lineas = ArrayList<>();
    }

    public Bouble calcularTotal(){
        
        Bouble total; 

        for (LineaPedido l: lineas){
            total += l.calcularSubTotal();
        }
        return total;
       }

    public void mostrarPedido(){
        System.out.println("Pedido: " + idPedido)
        for(LineaPedido l: lineas){
            System.out.println(
                l.getProducto().getNombre()
                        + "Cantidad: "
                        + l.getCantidad()
                        + "Subtotal: "
                        +l.calcularSubTotal()
            );
        }
        System.out.println("TOTAL: " + l.calcularTotal());
    }
}