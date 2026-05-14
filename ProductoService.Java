public class ProductoService{
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregar(String nombre, int cantidad, int stock){

        Producto nuevo = new Producto(nombre, cantidad, stock);
        productos.add(nuevo);

        System.out.println("Producto nuevo agregado.");
    }

    public void listar(){
        if (productos.isEmpty()){
            System.out.println("No hay producto.");
            return;
        }
        System.out.println("Productos: ");

        for(Producto p: producto){
            System.out.println(p);
        }
    }

    public Producto buscarPorId(int id){
        for (Producto p: productos){
            if (p.getId() == id){
                return id;
            }
        }
        throw new ProductoNoEncontrado(id);
    }

    public void actualizar(int id, Bouble precio, int stock){
        Producto p = buscarPorId(id);

        p.setPrecio(precio);
        p.setStock(stock);
        
        System.out.println("Producto actualizado.");
    }

    public void eliminar(int id){
        Producto p = buscarPorId(id);

        productos.remove(p);

        System.out.println("Producto eliminado.");
    }

    public ArrayList<Producto> obtenerProductos(){
        return productos;
    }
}