import java.util.ArrayList;
import java.util.Scanner;
public class PedidoService {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void crearPedido(
            Scanner scanner,
            ProductoService productoService
    ) {

        Pedido pedido = new Pedido();

        int continuar;

        do {

            productoService.listar();

            System.out.println("Ingrese ID del producto:");
            int id = scanner.nextInt();

            try {

                Producto producto =
                        productoService.buscarPorId(id);

                System.out.println("Cantidad:");
                int cantidad = scanner.nextInt();

                if (cantidad <= 0) {

                    throw new IllegalArgumentException(
                            "Cantidad invalida."
                    );
                }

                if (cantidad > producto.getStock()) {

                    throw new IllegalArgumentException(
                            "Stock insuficiente."
                    );
                }

                producto.setStock(
                        producto.getStock() - cantidad
                );

                LineaPedido linea = new LineaPedido(producto, cantidad);

                pedido.agregarLinea(linea);

                System.out.println(
                        "Producto agregado al pedido."
                );

            } catch (
                    ProductoNoEncontrado
                            | IllegalArgumentException e
            ) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }

            System.out.println(
                    "Agregar otro producto? (1=SI / 0=NO)"
            );

            continuar = scanner.nextInt();

        } while (continuar == 1);

        pedidos.add(pedido);

        System.out.println(
                "Pedido creado. Total: $"
                        + pedido.calcularTotal()
        );
    }

    public void listarPedido() {

        if (pedidos.isEmpty()) {

            System.out.println("No hay pedidos.");
            return;
        }

        for (Pedido p : pedidos) {

            p.mostrarPedido();
        }
    }
}