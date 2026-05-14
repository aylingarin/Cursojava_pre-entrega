public class Producto{

    private static int contadorId = 1;
    private String nombre;
    private int id;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock){
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
    public double getPrecio(){
        return precio; 
   }

   // setters 

   public void setPrecio(double precio){
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

   public String toString(){

        return "ID: " + id
            + "Nombre: " + nombre
            + "Precio: $" + precio
            + "Stock: " + stock;
   }


}
