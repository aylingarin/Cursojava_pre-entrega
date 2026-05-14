public class ProductoNoEncontrado extends RuntimeException{
    public ProductoNoEncontrado(int id){
        super("No existe producto con el siguiente ID: " + id);
    }

}