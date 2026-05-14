import java.util.Scanner;  

public class SistemaProductos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductoService productoService = new ProductoService();
        PedidoService PedidoService = new PedidoService();
        
        int opcion;

        do{
            System.out.println("\n===== MENU =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar/Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Crear pedido");
            System.out.println("6. Listar pedido");
            System.out.println("7. Salir");

            System.out.println("Seleccione opcion: ");
            opcion = scanner.nextInt();

            switch(opcion){

                case 1:
                    scanner.nextLine();

                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Precio: ");
                    int precio = scanner.nextInt();

                System.out.println("Stock: ");
                int stock = scanner.nextInt();

                try{
                    productoService.agregar(nombre, precio, stock);

                }catch(IllegalArgumentException e){
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 2:
                    productoService.listar();

                    break;

                    case 3: 

                    try{

                    System.out.println("Ingrese ID: ");
                    int id = scanner.nextInt();

                    Producto p = productoService.buscarPorId(id);

                    System.out.println(p);

                    System.out.println("Desea actualizar? (1=SI / 0=NO)");
                    int actualizar = scanner.nextInt();

                    if(actualizar == 1){
                        
                        System.out.println("Nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();

                        System.out.println("Nuevo stock: ");
                        int nuevoStock = scanner.nextInt();

                        productoService.actualizar(id, nuevoPrecio, nuevoStock);   
                    }


                  } catch (ProductoNoEncontrado | IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
                      }
                      break;

            case 4: 
            try{
                System.out.println("Ingrese ID a eliminar: ");
                int idEliminar = scanner.nextInt();

                productoService.eliminar(idEliminar);

            }catch(ProductoNoEncontrado e){
                System.out.println("Error: " + e.getMessage());
            }
            break;

            case 5:
                PedidoService.crearPedido(scanner, productoService);
                break;
            
                case 6:
                    PedidoService.listarPedido();
                    break;
                    
                    case 7:
                        System.out.println("Saliendo del sistema.");
                        break;
                        
                        default:
                             System.out.println("opcion invalida.");
            }
        }while(opcion != 7);
        
        scanner.close();

        
    }
}