public class Producto{

    private static contadorId = 1;
    private String nombre;
    private Int id;
    private Bouble precio;
    private int stock;

    public Producto(Stringtring nombre, Bouble precio, int stock){
        this.id = contadorId++;
        this.nombre = nombre; 
        this.precio = precio;
        this.stock = stock; 
    }
    //getters

    public int getId(){
        return id; 
    }
    public String getNombre(){
        return nombre; 
    }
    public int getStock(){
        return stock; 
    }
    public Bouble getPrecio(){
        return precio; 
   }

   // setters 

   public void setPrecio(Bouble precio){
    if (precio < 0){
     throw new IllegalArgumentException(
        "El precio no puede ser negativo."
    );
    }
    this.precio = precio;
   }

   public void setStock(int stock){
    if (stock < 0 ){
        throw new IllegalArgumentException(
       "El stock no puede ser negativo."
    );
    }
     this.stock = stock;
   }

   public void mostrarProducto{
    System.out.println("ID: " + id);
    System.out.println("Nombre: " + nombre);
    System.out.println("Precio: $" + precio);
    System.out.println("Stock: " + stock);
   }


}
